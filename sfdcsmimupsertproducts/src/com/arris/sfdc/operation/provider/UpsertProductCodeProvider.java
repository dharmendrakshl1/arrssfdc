package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductCodeInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.pojo.UpsertProductOutput.UpsertProductCodeOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Product_Code__c;
import com.sforce.ws.ConnectionException;

public class UpsertProductCodeProvider {
	
	static Logger logger = Logger.getLogger(UpsertProductCodeProvider.class);
	
	public static UpsertProductOutput upsertProductCode(EnterpriseConnection connection, UpsertProductCodeInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpsertProductCodeProvider.upsertProductCode(EnterpriseConnection, UpsertProductCodeInput) : "+input);
		
		UpsertProductOutput upsertProductOutput = new UpsertProductOutput();
		UpsertProductCodeOutput output = upsertProductOutput.getUpsertProductCodeOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new UpsertProductCodeOutput();
			upsertProductOutput.setUpsertProductCodeOutput(output);
		}
		
		String nameC = input.getNameC().trim();
		logger.info("nameC : "+nameC);
		
		String name = input.getName();
		logger.info("name : "+name);
		
		Product_Code__c records[] = new Product_Code__c[1];
		
		Product_Code__c record = new Product_Code__c();
		record.setName__c(nameC);
		record.setName(name);
		
		records[0] = record;
		
		UpsertResult upsertResult[] = connection.upsert("Id", records);
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
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpsertProductCodeProvider.upsertProductCode(EnterpriseConnection, UpsertProductCodeInput) - upsertProductOutput :  "+upsertProductOutput);
		return upsertProductOutput;
	}
}
