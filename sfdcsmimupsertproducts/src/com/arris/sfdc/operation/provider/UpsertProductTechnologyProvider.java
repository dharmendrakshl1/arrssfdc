package com.arris.sfdc.operation.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductTechnologyInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.pojo.UpsertProductOutput.UpsertProductTechnologyOutput;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Product_Technology__c;
import com.sforce.ws.ConnectionException;

public class UpsertProductTechnologyProvider {
	
	static Logger logger = Logger.getLogger(UpsertProductTechnologyProvider.class);
	
	public static UpsertProductOutput upsertProductTechnology(EnterpriseConnection connection, UpsertProductTechnologyInput input) throws ConnectionException{
		logger.info("Entering - com.arris.sfdc.operation.provider.UpsertProductTechnologyProvider.upsertProductTechnology(EnterpriseConnection, UpsertProductTechnologyInput) : "+input);
		
		UpsertProductOutput upsertProductOutput = new UpsertProductOutput();
		UpsertProductTechnologyOutput output = upsertProductOutput.getUpsertProductTechnologyOutput();
		if(output == null){
			logger.info("output is null... Create a new instance of it.");
			output = new UpsertProductTechnologyOutput();
			upsertProductOutput.setUpsertProductTechnologyOutput(output);
		}
		
		String nameC = input.getNameC();
		logger.info("nameC : "+nameC);
		
		Product_Technology__c records[] = new Product_Technology__c[1];
		
		Product_Technology__c record = new Product_Technology__c();
		record.setName__c(nameC);
		
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
		
		logger.info("Leaving - com.arris.sfdc.operation.provider.UpsertProductTechnologyProvider.upsertProductTechnology(EnterpriseConnection, UpsertProductTechnologyInput) - upsertProductOutput :  "+upsertProductOutput);
		return upsertProductOutput;
	}
}
