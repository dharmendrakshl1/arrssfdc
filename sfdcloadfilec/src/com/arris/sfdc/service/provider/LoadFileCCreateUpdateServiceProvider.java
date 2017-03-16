package com.arris.sfdc.service.provider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.LoadFileCOperationConstants;
import com.arris.sfdc.pojo.LoadFileCRequest;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Load_File__c;

public class LoadFileCCreateUpdateServiceProvider {
	Logger logger = Logger.getLogger(LoadFileCCreateUpdateServiceProvider.class);
	
	public OutputElement loadFileCCreateOrUpdate(LoadFileCRequest loadFileCRequest){
		logger.info("Entering - com.arris.sfdc.service.provider.LoadFileCCreateUpdateServiceProvider.loadFileCCreateOrUpdate(LoadFileCRequest) : "+loadFileCRequest);
		logger.info("Operation : "+loadFileCRequest.getOperation());
		
		OutputElement outputElement = new OutputElement();
		Load_File__c records[] = new Load_File__c[1];
		Load_File__c load_File__c = new Load_File__c();
		
		if(loadFileCRequest.getOperation().trim().equalsIgnoreCase(LoadFileCOperationConstants.LOAD_FILE_C_OPERATION_CREATE)){
			logger.info("Entering for Create Operation");
						
			load_File__c.setName__c(loadFileCRequest.getNameC());
			load_File__c.setType__c(loadFileCRequest.getTypeC());
			load_File__c.setSource__c(loadFileCRequest.getSourceC());
			load_File__c.setStatus__c(loadFileCRequest.getStatusC());
			load_File__c.setRecords__c(loadFileCRequest.getRecordsC());
			load_File__c.setErrors__c(loadFileCRequest.getErrorsC());
			load_File__c.setSuccesses__c(loadFileCRequest.getSuccessesC());
			
			Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			String formatedDate = sdf.format(calendar.getTime());
			System.out.println("Formated Date : "+formatedDate);
			
			load_File__c.setLoad_Time__c(sdf.getCalendar()); //Sample 2017-02-09T04:17:48.495-05:00
						
			records[0] = load_File__c;
			
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
				try{
					SaveResult saveResult[] = connection.create(records);
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
					logger.error("Error in creating Object in Load_File__c Object : "+e.getMessage());
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
			
		}
		if(loadFileCRequest.getOperation().trim().equalsIgnoreCase(LoadFileCOperationConstants.LOAD_FILE_C_OPERATION_UPDATE)){
			logger.info("Entering for Update Operation");
			
			load_File__c.setId(loadFileCRequest.getId());
			load_File__c.setStatus__c(loadFileCRequest.getStatusC());
			load_File__c.setRecords__c(loadFileCRequest.getRecordsC());
			load_File__c.setErrors__c(loadFileCRequest.getErrorsC());
			load_File__c.setSuccesses__c(loadFileCRequest.getSuccessesC());
			
			Calendar calendar = new GregorianCalendar(TimeZone.getDefault());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			String formatedDate = sdf.format(calendar.getTime());
			System.out.println("Formated Date : "+formatedDate);
			
			load_File__c.setLoad_Time__c(sdf.getCalendar()); //Sample 2017-02-09T04:17:48.495-05:00
			
			records[0] = load_File__c;
			
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
				try{
					SaveResult saveResult[] = connection.update(records);
					if(saveResult != null){
						for(int i = 0; i < saveResult.length; i++){
							
							if(saveResult[i].getId() != null){
								outputElement.setId(saveResult[i].getId());
							}else{
								outputElement.setId(loadFileCRequest.getId());
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
					logger.error("Error in creating Object in Load_File__c Object : "+e.getMessage());
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
		}
		
		logger.info("Leaving - com.arris.sfdc.service.provider.LoadFileCCreateUpdateServiceProvider.loadFileCCreateOrUpdate(LoadFileCRequest) - outputElement : "+outputElement);
		return outputElement;
	}
}
