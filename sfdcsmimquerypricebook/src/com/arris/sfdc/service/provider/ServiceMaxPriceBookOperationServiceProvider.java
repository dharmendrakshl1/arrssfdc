package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.ServiceMaxPriceBookOperationConstants;
import com.arris.sfdc.operation.provider.QueryHNMPriceBookEntryProvider;
import com.arris.sfdc.operation.provider.QueryPriceBookEntryProvider;
import com.arris.sfdc.operation.provider.QueryStandardPriceBookProvider;
import com.arris.sfdc.pojo.QueryPriceBookInput;
import com.arris.sfdc.pojo.QueryPriceBookInput.HNMPriceBookEntryInput;
import com.arris.sfdc.pojo.QueryPriceBookInput.PriceBookEntryInput;
import com.arris.sfdc.pojo.QueryPriceBookInput.StandardPriceBookInput;
import com.arris.sfdc.pojo.QueryPriceBookOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;

public class ServiceMaxPriceBookOperationServiceProvider {
	Logger logger = Logger.getLogger(ServiceMaxPriceBookOperationServiceProvider.class);
	
	public QueryPriceBookOutput performPriceBookOperation(QueryPriceBookInput queryPriceBookInput){
		logger.info("Entering - com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider.performPriceBookOperation(QueryPriceBookInput) : "+queryPriceBookInput);
		
		String operation = queryPriceBookInput.getOperation().trim();
		logger.info("Operation : "+operation);
		
		QueryPriceBookOutput queryPriceBookOutput = new QueryPriceBookOutput();
		
		if(operation != null){
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
				try{
					if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.QUERY_STANDARD_PRICE_BOOK)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_STANDARD_PRICE_BOOK condition Matched");
						
						StandardPriceBookInput standardPriceBookInput = queryPriceBookInput.getStandardPriceBookInput();
						logger.info("standardPriceBookInput : "+standardPriceBookInput);
						
						if(standardPriceBookInput != null){
							queryPriceBookOutput = QueryStandardPriceBookProvider.queryStandardPriceBook(connection, standardPriceBookInput);
						}
						logger.info("queryPriceBookOutput : "+queryPriceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.QUERY_PRICE_BOOK_ENTRY)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRICE_BOOK_ENTRY condition Matched");
						
						PriceBookEntryInput priceBookEntryInput = queryPriceBookInput.getPriceBookEntryInput();
						logger.info("priceBookEntryInput : "+priceBookEntryInput);
						
						if(priceBookEntryInput != null){
							queryPriceBookOutput = QueryPriceBookEntryProvider.queryPriceBookEntry(connection, priceBookEntryInput);
						}
						logger.info("queryPriceBookOutput : "+queryPriceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.QUERY_HNM_PRICE_BOOK_ENTRY)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_HNM_PRICE_BOOK_ENTRY condition Matched");
						
						HNMPriceBookEntryInput hnmPriceBookEntryInput = queryPriceBookInput.getHNMPriceBookEntryInput();
						logger.info("hnmPriceBookEntryInput : "+hnmPriceBookEntryInput);
						
						if(hnmPriceBookEntryInput != null){
							queryPriceBookOutput = QueryHNMPriceBookEntryProvider.queryHNMPriceBookEntry(connection, hnmPriceBookEntryInput);
						}
						logger.info("queryPriceBookOutput : "+queryPriceBookOutput);
					}
					
				}catch(Exception e){
					logger.error("Error in performing Operation : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		logger.info("Leaving - com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider.performPriceBookOperation(QueryPriceBookInput) - queryPriceBookOutput : "+queryPriceBookOutput);
		return queryPriceBookOutput;
	}
}
