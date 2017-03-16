package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.ServiceMaxPriceBookOperationConstants;
import com.arris.sfdc.operation.provider.CreatePriceBookEntryProvider;
import com.arris.sfdc.operation.provider.UpdateHNMPriceBookProvider;
import com.arris.sfdc.operation.provider.UpdateStandardPriceBookProvider;
import com.arris.sfdc.pojo.PriceBookInput;
import com.arris.sfdc.pojo.PriceBookInput.CreatePriceBookEntryInput;
import com.arris.sfdc.pojo.PriceBookInput.UpdateHNMPriceBookInput;
import com.arris.sfdc.pojo.PriceBookInput.UpdateStandardPriceBookInput;
import com.arris.sfdc.pojo.PriceBookOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;

public class ServiceMaxPriceBookOperationServiceProvider {
	Logger logger = Logger.getLogger(ServiceMaxPriceBookOperationServiceProvider.class);
	
	public PriceBookOutput performPriceBookOperation(PriceBookInput priceBookInput){
		logger.info("Entering - com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider.performPriceBookOperation(PriceBookInput) : "+priceBookInput);
		
		String operation = priceBookInput.getOperation().trim();
		logger.info("Operation : "+operation);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		
		if(operation != null){
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
				try{
					if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.CREATE_PRICE_BOOK_ENTRY)){
						logger.info("ServiceMaxPriceBookOperationConstants.CREATE_PRICE_BOOK_ENTRY condition Matched");
						
						CreatePriceBookEntryInput createPriceBookEntryInput = priceBookInput.getCreatePriceBookEntryInput();
						logger.info("createPriceBookEntryInput : "+createPriceBookEntryInput);
						
						if(createPriceBookEntryInput != null){
							priceBookOutput = CreatePriceBookEntryProvider.createPriceBookEntry(connection, createPriceBookEntryInput);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.UPDATE_STANDARD_PRICE_BOOK)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPDATE_STANDARD_PRICE_BOOK condition Matched");
						
						UpdateStandardPriceBookInput updateStandardPriceBookInput = priceBookInput.getUpdateStandardPriceBookInput();
						logger.info("updateStandardPriceBookInput : "+updateStandardPriceBookInput);
						
						if(updateStandardPriceBookInput != null){
							priceBookOutput = UpdateStandardPriceBookProvider.updateStandardPriceBook(connection, updateStandardPriceBookInput);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.UPDATE_HNM_PRICE_BOOK)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPDATE_HNM_PRICE_BOOK condition Matched");
						
						UpdateHNMPriceBookInput updateHNMPriceBookInput = priceBookInput.getUpdateHNMPriceBookInput();
						logger.info("updateHNMPriceBookInput : "+updateHNMPriceBookInput);
						
						if(updateHNMPriceBookInput != null){
							priceBookOutput = UpdateHNMPriceBookProvider.updateHNMPriceBook(connection, updateHNMPriceBookInput);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
					
				}catch(Exception e){
					logger.error("Error in performing Operation : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		logger.info("Leaving - com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider.performPriceBookOperation(PriceBookInput) - priceBookOutput : "+priceBookOutput);
		return priceBookOutput;
	}
}
