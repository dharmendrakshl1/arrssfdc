package com.arris.sfdc.service.provider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import com.arris.sfdc.pojo.ApprovalLimitInput;
import com.arris.sfdc.pojo.ApprovalLimitInput.Inputs;
import com.arris.sfdc.pojo.ApprovalLimitOutput;
import com.arris.sfdc.pojo.ApprovalLimitOutput.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.GetServerTimestampResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.ws.ConnectionException;


public class OperationalSalServiceProvider_Update {
	
	Logger logger = Logger.getLogger(OperationalSalServiceProvider_Update.class);
	
	ApprovalLimitOutput updateOutputElement = new ApprovalLimitOutput();
	List<Results> results = updateOutputElement.getResults();
	
	public ApprovalLimitOutput updateCurrencyType(ApprovalLimitInput currencyTypeInputElement) throws Exception{
		logger.info("Entering - com.arris.sfdc.soap.provider.CurrencyTypeSoapProvider.updateCurrencyType(CurrencyTypeInputElement) : "+currencyTypeInputElement);
		
		List<Inputs> listInputs = currencyTypeInputElement.getInputs();
		logger.info("lisctCurrencyDetails Size : "+listInputs.size());
		
		Contact []contact= new Contact[listInputs.size()];
		int i = 0;
		
		//Below code is for Iterate through and set it in CurrencyType for All Input
		Iterator<Inputs> currencyDetailsIterator = listInputs.iterator();
		while(currencyDetailsIterator.hasNext()){
			Inputs inputs = currencyDetailsIterator.next();
			logger.info("Contacts Input = "+inputs);
			double approvalLimit = Double.parseDouble(inputs.getApprovalLimitC());
			contact[i] = new Contact();
			contact[i].setId(inputs.getId());
			contact[i].setApproval_Limit__c(approvalLimit);
			i++;
		}
		try {
		//Below code is for to update in SFDC using connection
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		logger.info("connection = "+connection);
			System.out.println("datetime stamp :-" + connection.getServerTimestamp());
			System.out.println(".....timestamp :- "+ connection.getServerTimestamp().getTimestamp());
			System.out.println("datetime stamp.." + connection.getServerTimestamp().getTimestamp().getInstance());
			
			GetServerTimestampResult result = connection.getServerTimestamp();
			

		      Calendar serverTime = result.getTimestamp();

		      System.out.println("Server time is: "

		            + serverTime.getTime().toString());
			
			
			
		
		if(connection != null){
			
				logger.info("SFDC Update Begins");
				SaveResult saveResult[] = connection.update(contact);
				if(saveResult != null){
					for(int j = 0; j < saveResult.length; j++){
						Results rs = new Results();
						if(saveResult[j].getId() != null){
							rs.setId(saveResult[j].getId());
						}else{
							rs.setId(listInputs.get(j).getId());
						}
						
						rs.setSuccess(String.valueOf(saveResult[j].getSuccess()));
						
						if(saveResult[j].getErrors().length > 0){
							rs.setErrors(saveResult[j].getErrors()[0].getMessage());
						}
						else{
							rs.setErrors("false");
						}
						results.add(rs);
						
						logger.info("rs = "+rs);
					}
				}
			
		}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw e1;
		}
		
		logger.info("Leaving - com.arris.sfdc.soap.provider.CurrencyTypeSoapProvider.updateCurrencyType(CurrencyTypeInputElement) - updateOutputElement : "+updateOutputElement);
		return updateOutputElement;
	}
}
