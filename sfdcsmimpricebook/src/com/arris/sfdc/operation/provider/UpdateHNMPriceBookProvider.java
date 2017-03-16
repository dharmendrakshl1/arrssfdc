package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.PriceBookInput.UpdateHNMPriceBookInput;
import com.arris.sfdc.pojo.PriceBookOutput;
import com.arris.sfdc.pojo.PriceBookOutput.UpdateHNMPriceBookOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.PricebookEntry;
import com.sforce.ws.ConnectionException;

public class UpdateHNMPriceBookProvider {
	
	static Logger logger = Logger.getLogger(UpdateHNMPriceBookProvider.class);
	
	public static PriceBookOutput updateHNMPriceBook(EnterpriseConnection connection, UpdateHNMPriceBookInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpdateHNMPriceBookProvider.updateHNMPriceBook(EnterpriseConnection, UpdateHNMPriceBookInput) : "+input);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		UpdateHNMPriceBookOutput output = priceBookOutput.getUpdateHNMPriceBookOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new UpdateHNMPriceBookOutput();
			priceBookOutput.setUpdateHNMPriceBookOutput(output);
		}
		
		PricebookEntry records[] =  new PricebookEntry[1];
		PricebookEntry record = new PricebookEntry();
		
		record.setId(input.getId());
		
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
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpdateHNMPriceBookProvider.updateHNMPriceBook(EnterpriseConnection, UpdateHNMPriceBookInput) - priceBookOutput :  "+priceBookOutput);
		return priceBookOutput;
	}
}
