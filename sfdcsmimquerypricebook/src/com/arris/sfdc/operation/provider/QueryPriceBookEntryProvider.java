package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryPriceBookInput.PriceBookEntryInput;
import com.arris.sfdc.pojo.QueryPriceBookOutput;
import com.arris.sfdc.pojo.QueryPriceBookOutput.PriceBookEntryOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.PricebookEntry;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryPriceBookEntryProvider {
	
	static Logger logger = Logger.getLogger(QueryPriceBookEntryProvider.class);
	
	public static QueryPriceBookOutput queryPriceBookEntry(EnterpriseConnection connection, PriceBookEntryInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryPriceBookEntryProvider.queryPriceBookEntry(EnterpriseConnection, PriceBookEntryInput) : "+input);
		
		QueryPriceBookOutput queryPriceBookOutput = new QueryPriceBookOutput();
		PriceBookEntryOutput output = queryPriceBookOutput.getPriceBookEntryOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new PriceBookEntryOutput();
			queryPriceBookOutput.setPriceBookEntryOutput(output);
		}
		
		String product2Id = input.getProduct2Id();
		logger.info("product2Id : "+product2Id);
		
		String priceBook2Id = input.getPricebook2Id();
		logger.info("priceBook2Id : "+priceBook2Id);
		
		String query = "select Id from PricebookEntry where Product2Id ='"+product2Id+"' AND Pricebook2Id = '"+priceBook2Id+"' AND CurrencyIsoCode='USD'";
		logger.info("Query : "+query);
		
		QueryResult queryResult = connection.query(query);
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				logger.info("Inside for loop....");
				PricebookEntry pfc = (PricebookEntry) records;
				
				output.setId(pfc.getId());
			}
			logger.info("output : "+output);
		}
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryPriceBookEntryProvider.queryPriceBookEntry(EnterpriseConnection, PriceBookEntryInput) - queryPriceBookOutput :  "+queryPriceBookOutput);
		return queryPriceBookOutput;
	}
}
