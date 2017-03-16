package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductInput.QueryProductLineInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.pojo.QueryProductOutput.QueryProductLineOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Product_Line__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryProductLineProvider {
	
	static Logger logger = Logger.getLogger(QueryProductLineProvider.class);
	
	public static QueryProductOutput queryProductLine(EnterpriseConnection connection, QueryProductLineInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryProductLineProvider.queryProductLine(EnterpriseConnection, QueryProductLineInput) : "+input);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		QueryProductLineOutput output = queryProductOutput.getQueryProductLineOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new QueryProductLineOutput();
			queryProductOutput.setQueryProductLineOutput(output);
		}
		
		String nameC = input.getNameC().trim();
		logger.info("nameC : "+nameC);
				
		QueryResult queryResult = connection.query("select Id from Product_Line__c where Name__c = '"+nameC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Product_Line__c pfc = (Product_Line__c) records;
				
				output.setId(pfc.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryProductLineProvider.queryProductLine(EnterpriseConnection, QueryProductLineInput) - queryProductOutput :  "+queryProductOutput);
		return queryProductOutput;
	}
}
