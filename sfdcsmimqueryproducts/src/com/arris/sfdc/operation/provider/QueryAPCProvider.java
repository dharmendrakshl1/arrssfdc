package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.pojo.QueryProductInput.QueryAPCInput;
import com.arris.sfdc.pojo.QueryProductOutput.QueryAPCOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Product_APC__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryAPCProvider {
	
	static Logger logger = Logger.getLogger(QueryAPCProvider.class);
	
	public static QueryProductOutput queryAPC(EnterpriseConnection connection, QueryAPCInput queryAPCInput) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryAPCProvider.queryAPC(EnterpriseConnection, QueryAPCInput) : "+queryAPCInput);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		QueryAPCOutput queryAPCOutput = queryProductOutput.getQueryAPCOutput();
		if(queryAPCOutput == null){
			logger.info("queryAPCOutput is null... Create a new instance of it.");
			queryAPCOutput = new QueryAPCOutput();
			queryProductOutput.setQueryAPCOutput(queryAPCOutput);
		}
		
		String nameC = queryAPCInput.getNameC().trim();
		logger.info("nameC : "+nameC);
		
		String descriptionC = queryAPCInput.getDescriptionC().trim();
		logger.info("descriptionC : "+descriptionC);
		
		QueryResult queryResult = connection.query("select Id from Product_APC__c where Name__c = '"+nameC+"' and Description__c = '"+descriptionC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Product_APC__c pac = (Product_APC__c) records;
				
				queryAPCOutput.setId(pac.getId());
			}
			logger.info("queryAPCOutput : "+queryAPCOutput);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryAPCProvider.queryAPC(EnterpriseConnection, QueryAPCInput) - queryProductOutput :  "+queryProductOutput);
		return queryProductOutput;
	}
}
