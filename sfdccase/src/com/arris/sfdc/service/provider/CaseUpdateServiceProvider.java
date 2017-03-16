package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Case;
import com.sforce.soap.enterprise.sobject.SObject;

public class CaseUpdateServiceProvider {
	Logger logger = Logger.getLogger(CaseUpdateServiceProvider.class);
	
	public OutputElement caseUpdate(InputElement inputElement){
		logger.info("Entering - com.arris.sfdc.service.provider.CaseUpdateServiceProvider.caseUpdate(InputElement) : "+inputElement);
		
		OutputElement outputElement = new OutputElement();
		
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		if(connection != null){
			try{
				SObject sObject[] = new SObject[1];
				Case case1 = new Case();
				case1.setId(inputElement.getId());
				case1.setStatus(inputElement.getStatus());
				case1.setAttachment_Id__c(inputElement.getAttachmentIdC());
								
				sObject[0] = case1;
				SaveResult saveResult[] = connection.update(sObject);
				if(saveResult != null){
					for(int i = 0; i < saveResult.length; i++){
						
						if(saveResult[i].getId() != null){
							outputElement.setId(saveResult[i].getId());
						}else{
							outputElement.setId(inputElement.getId());
						}
						
						outputElement.setSuccess(String.valueOf(saveResult[i].getSuccess()));
						
						if(saveResult[i].getErrors().length > 0){
							outputElement.setErrors(saveResult[i].getErrors()[0].getMessage());
						}else{
							outputElement.setErrors(String.valueOf(false));
						}
						logger.info("outputElement : "+outputElement);
						
					}
				}
			}catch(Exception e){
				logger.error("Error in Updating Object in Case Object : "+e.getMessage());
				e.printStackTrace();
			}/*finally{
				if(connection != null){
					try {
						connection.logout();
					} catch (ConnectionException e) {
						logger.error("Error in Releaseing Connection : "+e.getMessage());
						e.printStackTrace();
					}
				}
			}*/
		}
		
		logger.info("Leaving - com.arris.sfdc.service.provider.CaseUpdateServiceProvider.caseUpdate(InputElement) - outputElement : "+outputElement);
		return outputElement;
	}
}
