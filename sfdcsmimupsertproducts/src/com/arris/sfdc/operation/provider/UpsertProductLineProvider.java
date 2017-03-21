package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductLineInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.pojo.UpsertProductOutput.UpsertProductLineOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Product_Line__c;
import com.sforce.ws.ConnectionException;

public class UpsertProductLineProvider {
	
	static Logger logger = Logger.getLogger(UpsertProductLineProvider.class);
	
	public static UpsertProductOutput upsertProductLine(EnterpriseConnection connection, UpsertProductLineInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpsertProductLineProvider.upsertProductLine(EnterpriseConnection, UpsertProductLineInput) : "+input);
		
		UpsertProductOutput upsertProductOutput = new UpsertProductOutput();
		UpsertProductLineOutput output = upsertProductOutput.getUpsertProductLineOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new UpsertProductLineOutput();
			upsertProductOutput.setUpsertProductLineOutput(output);
		}
		
		String nameC = input.getNameC();
		logger.info("nameC : "+nameC);
		
		Product_Line__c records[] = new Product_Line__c[1];
		
		Product_Line__c record = new Product_Line__c();
		record.setName__c(nameC);
		
		records[0] = record;
		
		UpsertResult upsertResult[] = connection.upsert("Name__c", records);
		if(upsertResult != null){
			for(int i = 0; i < upsertResult.length; i++){
				
				if(upsertResult[i].getId() != null){
					output.setId(upsertResult[i].getId());
				}else{
					output.setId("");
				}
				output.setSuccess(String.valueOf(upsertResult[i].getSuccess()));
				
				if(upsertResult[i].getErrors().length > 0){
					output.setErrors(upsertResult[i].getErrors()[0].getMessage());
				}else{
					output.setErrors(String.valueOf(false));
				}
				logger.info("output : "+output);
			}
		}
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpsertProductLineProvider.upsertProductLine(EnterpriseConnection, UpsertProductLineInput) - upsertProductOutput :  "+upsertProductOutput);
		return upsertProductOutput;
	}
}
