package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.PriceBookInput.UpdateStandardPriceBookInput;
import com.arris.sfdc.pojo.PriceBookOutput;
import com.arris.sfdc.pojo.PriceBookOutput.UpdateStandardPriceBookOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.PricebookEntry;
import com.sforce.ws.ConnectionException;

public class UpdateStandardPriceBookProvider {
	
	static Logger logger = Logger.getLogger(UpdateStandardPriceBookProvider.class);
	
	public static PriceBookOutput updateStandardPriceBook(EnterpriseConnection connection, UpdateStandardPriceBookInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpdateStandardPriceBookProvider.updateStandardPriceBook(EnterpriseConnection, UpdateStandardPriceBookInput) : "+input);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		UpdateStandardPriceBookOutput output = priceBookOutput.getUpdateStandardPriceBookOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new UpdateStandardPriceBookOutput();
			priceBookOutput.setUpdateStandardPriceBookOutput(output);
		}
		
		PricebookEntry records[] =  new PricebookEntry[1];
		PricebookEntry record = new PricebookEntry();
		
		record.setId(input.getId());
		
		String isActive = input.getIsActive();
		if(isActive != null && isActive.length() != 0){
			record.setIsActive(Boolean.parseBoolean(input.getIsActive()));
		}
		
		String unitPrice = input.getUnitPrice();
		if(unitPrice != null && unitPrice.length() != 0){
			record.setUnitPrice(Double.valueOf(unitPrice));
		}
		
		records[0] = record;
		
		SaveResult saveResult[] = connection.update(records);
		if(saveResult != null){
			for(int i = 0; i < saveResult.length; i++){
				
				if(saveResult[i].getId() != null){
					output.setId(saveResult[i].getId());
				}else{
					output.setId(input.getId());
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
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpdateStandardPriceBookProvider.updateStandardPriceBook(EnterpriseConnection, UpdateStandardPriceBookInput) - priceBookOutput :  "+priceBookOutput);
		return priceBookOutput;
	}
}
