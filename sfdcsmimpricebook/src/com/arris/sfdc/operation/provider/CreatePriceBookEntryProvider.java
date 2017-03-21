package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.PriceBookInput.CreatePriceBookEntryInput;
import com.arris.sfdc.pojo.PriceBookOutput;
import com.arris.sfdc.pojo.PriceBookOutput.CreatePriceBookEntryOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.PricebookEntry;
import com.sforce.ws.ConnectionException;

public class CreatePriceBookEntryProvider {
	
	static Logger logger = Logger.getLogger(CreatePriceBookEntryProvider.class);
	
	public static PriceBookOutput createPriceBookEntry(EnterpriseConnection connection, CreatePriceBookEntryInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.CreatePriceBookEntryProvider.createPriceBookEntry(EnterpriseConnection, CreatePriceBookEntryInput) : "+input);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		CreatePriceBookEntryOutput output = priceBookOutput.getCreatePriceBookEntryOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new CreatePriceBookEntryOutput();
			priceBookOutput.setCreatePriceBookEntryOutput(output);
		}
		
		PricebookEntry records[] =  new PricebookEntry[1];
		PricebookEntry record = new PricebookEntry();
		
		record.setCurrencyIsoCode(input.getCurrencyIsoCode());
		
		String isActive = input.getIsActive();
		if(isActive != null && isActive.trim().length() != 0){
			record.setIsActive(Boolean.parseBoolean(isActive.trim()));
		}
		
		record.setPricebook2Id(input.getPricebook2Id());
		record.setProduct2Id(input.getProduct2Id());
		
		String unitPrice = input.getUnitPrice();
		if(unitPrice != null && unitPrice.trim().length() != 0){
			record.setUnitPrice(Double.valueOf(unitPrice.trim()));
		}
		
		records[0] = record;
		
		SaveResult saveResult[] = connection.create(records);
		if(saveResult != null){
			for(int i = 0; i < saveResult.length; i++){
				
				if(saveResult[i].getId() != null){
					output.setId(saveResult[i].getId());
				}else{
					output.setId("");
				}
				
				output.setSuccess(String.valueOf(saveResult[i].getSuccess()));
				
				if(saveResult[i].getErrors().length > 0){
					output.setErrors(saveResult[i].getErrors()[0].getMessage());
				}else{
					output.setErrors(String.valueOf(false));
				}
				logger.info("output : "+output);
				
			}
		}
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.CreatePriceBookEntryProvider.createPriceBookEntry(EnterpriseConnection, CreatePriceBookEntryInput) - priceBookOutput :  "+priceBookOutput);
		return priceBookOutput;
	}
}
