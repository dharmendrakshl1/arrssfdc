package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Attachment;
import com.sforce.soap.enterprise.sobject.SObject;

public class AttachmentCreateServiceProvider {
	Logger logger = Logger.getLogger(AttachmentCreateServiceProvider.class);
	
	public OutputElement attachmentCreate(InputElement inputElement){
		logger.info("Entering - com.arris.sfdc.service.provider.AttachmentCreateServiceProvider.attachmentCreate(InputElement) : "+inputElement);
		
		OutputElement outputElement = new OutputElement();
		
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		if(connection != null){
			try{
				SObject sObject[] = new SObject[1];
				Attachment attachment = new Attachment();
				attachment.setParentId(inputElement.getParentId());
				attachment.setName(inputElement.getName());
				attachment.setBody(inputElement.getBody().getBytes());
								
				sObject[0] = attachment;
				SaveResult saveResult[] = connection.create(sObject);
				if(saveResult != null){
					for(int i = 0; i < saveResult.length; i++){
						
						if(saveResult[i].getId() != null){
							outputElement.setId(saveResult[i].getId());
						}else{
							outputElement.setId("");
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
				logger.error("Error in creating Object in Attachment Object : "+e.getMessage());
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
		
		logger.info("Leaving - com.arris.sfdc.service.provider.AttachmentCreateServiceProvider.attachmentCreate(InputElement) - outputElement : "+outputElement);
		return outputElement;
	}
}
