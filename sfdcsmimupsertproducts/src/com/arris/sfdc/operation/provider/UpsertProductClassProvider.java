package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductClassInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.pojo.UpsertProductOutput.UpsertProductClassOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Product_Class__c;
import com.sforce.ws.ConnectionException;

public class UpsertProductClassProvider {
	
	static Logger logger = Logger.getLogger(UpsertProductClassProvider.class);
	
	public static UpsertProductOutput upsertProductClass(EnterpriseConnection connection, UpsertProductClassInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpsertProductClassProvider.upsertProductClass(EnterpriseConnection, UpsertProductClassInput) : "+input);
		
		UpsertProductOutput upsertProductOutput = new UpsertProductOutput();
		UpsertProductClassOutput output = upsertProductOutput.getUpsertProductClassOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new UpsertProductClassOutput();
			upsertProductOutput.setUpsertProductClassOutput(output);
		}
		
		String nameC = input.getNameC().trim();
		logger.info("nameC : "+nameC);
		
		Product_Class__c records[] = new Product_Class__c[1];
		
		Product_Class__c record = new Product_Class__c();
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
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpsertProductClassProvider.upsertProductClass(EnterpriseConnection, UpsertProductClassInput) - upsertProductOutput :  "+upsertProductOutput);
		return upsertProductOutput;
	}
}
