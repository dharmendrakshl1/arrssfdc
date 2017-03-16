package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductFamilyInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.pojo.UpsertProductOutput.UpsertProductFamilyOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Product_Family__c;
import com.sforce.ws.ConnectionException;

public class UpsertProductFamilyProvider {
	
	static Logger logger = Logger.getLogger(UpsertProductFamilyProvider.class);
	
	public static UpsertProductOutput upsertProductFamily(EnterpriseConnection connection, UpsertProductFamilyInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpsertProductFamilyProvider.upsertProductFamily(EnterpriseConnection, UpsertProductFamilyInput) : "+input);
		
		UpsertProductOutput upsertProductOutput = new UpsertProductOutput();
		UpsertProductFamilyOutput output = upsertProductOutput.getUpsertProductFamilyOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new UpsertProductFamilyOutput();
			upsertProductOutput.setUpsertProductFamilyOutput(output);
		}
		
		String nameC = input.getNameC().trim();
		logger.info("nameC : "+nameC);
		
		Product_Family__c records[] = new Product_Family__c[1];
		
		Product_Family__c record = new Product_Family__c();
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
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpsertProductFamilyProvider.upsertProductFamily(EnterpriseConnection, UpsertProductFamilyInput) - upsertProductOutput :  "+upsertProductOutput);
		return upsertProductOutput;
	}
}
