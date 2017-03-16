package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryPriceBookInput.HNMPriceBookEntryInput;
import com.arris.sfdc.pojo.QueryPriceBookOutput;
import com.arris.sfdc.pojo.QueryPriceBookOutput.HNMPriceBookEntryOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.PricebookEntry;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class QueryHNMPriceBookEntryProvider {
	
	static Logger logger = Logger.getLogger(QueryHNMPriceBookEntryProvider.class);
	
	public static QueryPriceBookOutput queryHNMPriceBookEntry(EnterpriseConnection connection, HNMPriceBookEntryInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.QueryHNMPriceBookEntryProvider.queryHNMPriceBookEntry(EnterpriseConnection, HNMPriceBookEntryInput) : "+input);
		
		QueryPriceBookOutput queryPriceBookOutput = new QueryPriceBookOutput();
		HNMPriceBookEntryOutput output = queryPriceBookOutput.getHNMPriceBookEntryOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new HNMPriceBookEntryOutput();
			queryPriceBookOutput.setHNMPriceBookEntryOutput(output);
		}
		
		String product2Id = input.getProductID();
		logger.info("product2Id : "+product2Id);
		
		String hnmPriceBook2Id = input.getHNMPriceBookID();
		logger.info("hnmPriceBook2Id : "+hnmPriceBook2Id);
				
		QueryResult queryResult = connection.query("select Id from PricebookEntry where Product2Id = '"+product2Id+"' AND Pricebook2Id = '"+hnmPriceBook2Id+"' AND CurrencyIsoCode = 'USD'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getRecords().length);
			
			for(SObject records : queryResult.getRecords()){
				PricebookEntry pfc = (PricebookEntry) records;
				
				output.setId(pfc.getId());
			}
			logger.info("output : "+output);
		}
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.QueryHNMPriceBookEntryProvider.queryHNMPriceBookEntry(EnterpriseConnection, HNMPriceBookEntryInput) - queryPriceBookOutput :  "+queryPriceBookOutput);
		return queryPriceBookOutput;
	}
}
