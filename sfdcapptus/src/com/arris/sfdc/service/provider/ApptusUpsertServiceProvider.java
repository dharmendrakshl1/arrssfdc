package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Account;

public class ApptusUpsertServiceProvider {
	Logger logger = Logger.getLogger(ApptusUpsertServiceProvider.class);
	
	public OutputElement apptusUpsert(InputElement inputElement) throws Exception{
		logger.info("Entering - com.arris.sfdc.service.provider.ApptusUpsertServiceProvider.apptusUpsert(InputElement inputElement) : "+inputElement);
		
		OutputElement outputElement = new OutputElement();
		Account records[] = new Account[1];
		Account account =  new Account();
		
		try{
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
			
				account.setName(inputElement.getName());
				account.setType(inputElement.getType());
				account.setRecordTypeId(inputElement.getRecordTypeId());
				account.setCustomer_Number_HnM__c(inputElement.getCustomerNumberHnMC());
				account.setCustomer_Number__c(inputElement.getCustomerNumberC());
				account.setRegion__c(inputElement.getRegionC());
				account.setStatus__c(inputElement.getStatusC());
				account.setActive__c(Boolean.parseBoolean(inputElement.getActiveC()));
				account.setSource_System__c(inputElement.getSourceSystemC());
				
				records[0] = account;
				
				UpsertResult upsertResult[] = connection.upsert("Customer_Number_HnM__c", records);
				if(upsertResult != null){
					for(int i = 0; i < upsertResult.length; i++){
						
						if(upsertResult[i].getId() != null){
							outputElement.setId(upsertResult[i].getId());
						}else{
							outputElement.setId("");
						}
						outputElement.setSuccess(String.valueOf(upsertResult[i].getSuccess()));
						
						if(upsertResult[i].getErrors().length > 0){
							outputElement.setErrors(upsertResult[i].getErrors()[0].getMessage());
						}else{
							outputElement.setErrors(String.valueOf(false));
						}
						logger.info("outputElement : "+outputElement);
					}
				}
			}
		}catch(Exception e){
			logger.error("Error in Upserting a Object in Account Object : "+e);
			e.printStackTrace();
			throw e;
		}/*finally{
			if(connection != null){
				try {
					logger.info("Session Logging Out... ");
					connection.logout();
					logger.info("connection : "+connection);
				} catch (ConnectionException e) {
					logger.error("Error in Releaseing Connection : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}*/
		
		logger.info("Leaving - com.arris.sfdc.service.provider.ApptusUpsertServiceProvider.apptusUpsert(InputElement inputElement) - outputProjectAssignments : "+outputElement);
		return outputElement;
	}
}
