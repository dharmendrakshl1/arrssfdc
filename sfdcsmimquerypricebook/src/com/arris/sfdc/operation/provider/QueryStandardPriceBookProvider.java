package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryPriceBookInput.StandardPriceBookInput;
import com.arris.sfdc.pojo.QueryPriceBookOutput;
import com.arris.sfdc.pojo.QueryPriceBookOutput.StandardPriceBookOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Pricebook2;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryStandardPriceBookProvider {
	
	static Logger logger = Logger.getLogger(QueryStandardPriceBookProvider.class);
	
	public static QueryPriceBookOutput queryStandardPriceBook(EnterpriseConnection connection, StandardPriceBookInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryStandardPriceBookProvider.queryStandardPriceBook(EnterpriseConnection, StandardPriceBookInput) : "+input);
		
		QueryPriceBookOutput queryPriceBookOutput = new QueryPriceBookOutput();
		StandardPriceBookOutput output = queryPriceBookOutput.getStandardPriceBookOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new StandardPriceBookOutput();
			queryPriceBookOutput.setStandardPriceBookOutput(output);
		}
		
		String optionalInput = input.getOptionalInput();
		logger.info("optionalInput : "+optionalInput);
		
		QueryResult queryResult = connection.query("select Id from Pricebook2 where isStandard = true");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				Pricebook2 pac = (Pricebook2) records;
				
				output.setId(pac.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryStandardPriceBookProvider.queryStandardPriceBook(EnterpriseConnection, StandardPriceBookInput) - queryPriceBookOutput :  "+queryPriceBookOutput);
		return queryPriceBookOutput;
	}
}
