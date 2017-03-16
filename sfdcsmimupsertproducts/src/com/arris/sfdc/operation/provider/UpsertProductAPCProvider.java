package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductAPCInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.pojo.UpsertProductOutput.UpsertProductAPCOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Product_APC__c;
import com.sforce.ws.ConnectionException;

public class UpsertProductAPCProvider {
	
	static Logger logger = Logger.getLogger(UpsertProductAPCProvider.class);
	
	public static UpsertProductOutput upsertProductAPC(EnterpriseConnection connection, UpsertProductAPCInput upsertProductAPCInput) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpsertProductAPCProvider.upsertProductAPC(EnterpriseConnection, UpsertProductAPCInput) : "+upsertProductAPCInput);
		
		UpsertProductOutput upsertProductOutput = new UpsertProductOutput();
		UpsertProductAPCOutput upsertProductAPCOutput = upsertProductOutput.getUpsertProductAPCOutput();
		if(upsertProductAPCOutput == null){
			logger.info("upsertProductAPCOutput is null... Create a new instance of it.");
			upsertProductAPCOutput = new UpsertProductAPCOutput();
			upsertProductOutput.setUpsertProductAPCOutput(upsertProductAPCOutput);
		}
		
		String nameC = upsertProductAPCInput.getNameC().trim();
		logger.info("nameC : "+nameC);
		
		String descriptionC = upsertProductAPCInput.getDescriptionC().trim();
		logger.info("descriptionC : "+descriptionC);
		
		Product_APC__c records[] = new Product_APC__c[1];
		
		Product_APC__c record = new Product_APC__c();
		record.setName__c(nameC);
		record.setDescription__c(descriptionC);
		
		records[0] = record;
		
		UpsertResult upsertResult[] = connection.upsert("Name__c", records);
		if(upsertResult != null){
			for(int i = 0; i < upsertResult.length; i++){
				
				if(upsertResult[i].getId() != null){
					upsertProductAPCOutput.setId(upsertResult[i].getId());
				}else{
					upsertProductAPCOutput.setId("");
				}
				upsertProductAPCOutput.setSuccess(String.valueOf(upsertResult[i].getSuccess()));
				
				if(upsertResult[i].getErrors().length > 0){
					upsertProductAPCOutput.setErrors(upsertResult[i].getErrors()[0].getMessage());
				}else{
					upsertProductAPCOutput.setErrors(String.valueOf(false));
				}
				logger.info("upsertProductAPCOutput : "+upsertProductAPCOutput);
			}
		}
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpsertProductAPCProvider.upsertProductAPC(EnterpriseConnection, UpsertProductAPCInput) - queryProductOutput :  "+upsertProductOutput);
		return upsertProductOutput;
	}
}
