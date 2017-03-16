package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductInput.QueryProductSBUInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.pojo.QueryProductOutput.QueryProductSBUOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Product_SBU__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryProductSBUProvider {
	
	static Logger logger = Logger.getLogger(QueryProductSBUProvider.class);
	
	public static QueryProductOutput queryProductSBU(EnterpriseConnection connection, QueryProductSBUInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryProductSBUProvider.queryProductSBU(EnterpriseConnection, QueryProductSBUInput) : "+input);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		QueryProductSBUOutput output = queryProductOutput.getQueryProductSBUOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new QueryProductSBUOutput();
			queryProductOutput.setQueryProductSBUOutput(output);
		}
		
		String nameC = input.getNameC().trim();
		logger.info("nameC : "+nameC);
				
		QueryResult queryResult = connection.query("select Id from Product_SBU__c where Name__c = '"+nameC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Product_SBU__c psc = (Product_SBU__c) records;
				
				output.setId(psc.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryProductSBUProvider.queryProductSBU(EnterpriseConnection, QueryProductSBUInput) - queryProductOutput :  "+queryProductOutput);
		return queryProductOutput;
	}
}
