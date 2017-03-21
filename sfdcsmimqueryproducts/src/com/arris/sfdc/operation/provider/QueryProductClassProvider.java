package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductInput.QueryProductClassInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.pojo.QueryProductOutput.QueryProductClassOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Product_Class__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryProductClassProvider {
	
	static Logger logger = Logger.getLogger(QueryProductClassProvider.class);
	
	public static QueryProductOutput queryProductClass(EnterpriseConnection connection, QueryProductClassInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryProductClassProvider.queryProductClass(EnterpriseConnection, QueryProductClassInput) : "+input);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		QueryProductClassOutput output = queryProductOutput.getQueryProductClassOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new QueryProductClassOutput();
			queryProductOutput.setQueryProductClassOutput(output);
		}
		
		String nameC = input.getNameC();
		logger.info("nameC : "+nameC);
				
		QueryResult queryResult = connection.query("select Id from Product_Class__c where Name__c = '"+nameC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Product_Class__c pfc = (Product_Class__c) records;
				
				output.setId(pfc.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryProductClassProvider.queryProductClass(EnterpriseConnection, QueryProductClassInput) - queryProductOutput :  "+queryProductOutput);
		return queryProductOutput;
	}
}
