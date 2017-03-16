package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductInput.QueryProductCodeInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.pojo.QueryProductOutput.QueryProductCodeOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Product_Code__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryProductCodeProvider {
	
	static Logger logger = Logger.getLogger(QueryProductCodeProvider.class);
	
	public static QueryProductOutput queryProductCode(EnterpriseConnection connection, QueryProductCodeInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryProductCodeProvider.queryProductCode(EnterpriseConnection, QueryProductCodeInput) : "+input);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		QueryProductCodeOutput output = queryProductOutput.getQueryProductCodeOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new QueryProductCodeOutput();
			queryProductOutput.setQueryProductCodeOutput(output);
		}
		
		String nameC = input.getNameC().trim();
		logger.info("nameC : "+nameC);
				
		QueryResult queryResult = connection.query("select Id from Product_Code__c where Name__c = '"+nameC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Product_Code__c pfc = (Product_Code__c) records;
				
				output.setId(pfc.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryProductCodeProvider.queryProductCode(EnterpriseConnection, QueryProductCodeInput) - queryProductOutput :  "+queryProductOutput);
		return queryProductOutput;
	}
}
