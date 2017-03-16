package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductInput.QueryProductTechnologyInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.pojo.QueryProductOutput.QueryProductTechnologyOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Product_Technology__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryProductTechnologyProvider {
	
	static Logger logger = Logger.getLogger(QueryProductTechnologyProvider.class);
	
	public static QueryProductOutput queryProductTechnology(EnterpriseConnection connection, QueryProductTechnologyInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryProductTechnologyProvider.queryProductTechnology(EnterpriseConnection, QueryProductTechnologyInput) : "+input);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		QueryProductTechnologyOutput output = queryProductOutput.getQueryProductTechnologyOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new QueryProductTechnologyOutput();
			queryProductOutput.setQueryProductTechnologyOutput(output);
		}
		
		String nameC = input.getNameC().trim();
		logger.info("nameC : "+nameC);
				
		QueryResult queryResult = connection.query("select Id from Product_Technology__c where Name__c = '"+nameC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Product_Technology__c ptc = (Product_Technology__c) records;
				
				output.setId(ptc.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryProductTechnologyProvider.queryProductTechnology(EnterpriseConnection, QueryProductTechnologyInput) - queryProductOutput :  "+queryProductOutput);
		return queryProductOutput;
	}
}
