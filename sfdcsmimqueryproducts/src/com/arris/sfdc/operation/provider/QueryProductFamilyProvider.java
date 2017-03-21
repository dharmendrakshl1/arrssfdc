package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductInput.QueryProductFamilyInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.pojo.QueryProductOutput.QueryProductFamilyOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Product_Family__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryProductFamilyProvider {
	
	static Logger logger = Logger.getLogger(QueryProductFamilyProvider.class);
	
	public static QueryProductOutput queryProductFamily(EnterpriseConnection connection, QueryProductFamilyInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryProductFamilyProvider.queryProductFamily(EnterpriseConnection, QueryProductFamilyInput) : "+input);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		QueryProductFamilyOutput output = queryProductOutput.getQueryProductFamilyOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new QueryProductFamilyOutput();
			queryProductOutput.setQueryProductFamilyOutput(output);
		}
		
		String nameC = input.getNameC();
		logger.info("nameC : "+nameC);
				
		QueryResult queryResult = connection.query("select Id from Product_Family__c where Name__c = '"+nameC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Product_Family__c pfc = (Product_Family__c) records;
				
				output.setId(pfc.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryProductFamilyProvider.queryProductFamily(EnterpriseConnection, QueryProductFamilyInput) - queryProductOutput :  "+queryProductOutput);
		return queryProductOutput;
	}
}
