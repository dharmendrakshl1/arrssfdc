package com.arris.sfdc.service.provider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.InputElement.PSAExpenses;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.pojo.OutputElement.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Pse__Expense__c;
import com.sforce.soap.enterprise.sobject.Pse__Proj__c;

public class PSADirectExpensesCreateServiceProvider {
	Logger logger = Logger.getLogger(PSADirectExpensesCreateServiceProvider.class);
	
	public OutputElement psaDirectExpensesCreate(InputElement inputElement) throws Exception{
		logger.info("Entering - com.arris.sfdc.service.provider.PSADirectExpensesCreateServiceProvider.psaDirectExpensesCreate(InputElement) : "+inputElement);
		
		OutputElement outputElement = new OutputElement();
		List<Results> results = outputElement.getResults();
		
		try{
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
			
				List<PSAExpenses> listPSAExpenses = inputElement.getPSAExpenses();
				logger.info("listPSAExpenses Size : "+listPSAExpenses.size());
				
				Pse__Expense__c []records = new Pse__Expense__c[listPSAExpenses.size()];
				
				int i = 0;
				Iterator<PSAExpenses> psaExpensesIterator = listPSAExpenses.iterator();
				while(psaExpensesIterator.hasNext()){
					PSAExpenses psaExpenses = psaExpensesIterator.next();
					logger.info("psaExpenses = "+psaExpenses);
					
					Pse__Expense__c pse__Expense__c = new Pse__Expense__c();
					
					//Mapping PS_Project__c to Pse__Project__r
					Pse__Proj__c pse__Proj__c = new Pse__Proj__c();
					pse__Proj__c.setPS_Project__c(psaExpenses.getPSProjectC());
					pse__Expense__c.setPse__Project__r(pse__Proj__c);
					
					pse__Expense__c.setEmployee_ID__c(psaExpenses.getEmployeeIDC());
					
					String pseExpenseDateC = psaExpenses.getPseExpenseDateC();
					if(pseExpenseDateC != null && pseExpenseDateC.trim().length() != 0){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date formattedDate = sdf.parse(pseExpenseDateC.trim());
						logger.info("Formatted Date : "+formattedDate);
						pse__Expense__c.setPse__Expense_Date__c(sdf.getCalendar());
					}
					
					pse__Expense__c.setPse__Type__c(psaExpenses.getPseTypeC());
					
					String pseAmountC = psaExpenses.getPseAmountC();
					if(pseAmountC != null && pseAmountC.trim().length() != 0){
						pse__Expense__c.setPse__Amount__c(Double.parseDouble(pseAmountC.trim()));
					}
					
					pse__Expense__c.setCurrencyIsoCode(psaExpenses.getCurrencyIsoCode());
					pse__Expense__c.setPS_Expense_Id__c(psaExpenses.getPSExpenseIdC());
					pse__Expense__c.setPse__Status__c(psaExpenses.getPseStatusC());
					
					pse__Expense__c.setPse__Include_In_Financials__c(Boolean.parseBoolean(psaExpenses.getPseIncludeInFinancialsC()));
					pse__Expense__c.setPse__Approved__c(Boolean.parseBoolean(psaExpenses.getPseApprovedC()));
					pse__Expense__c.setPse__Billable__c(Boolean.parseBoolean(psaExpenses.getPseBillableC()));
					pse__Expense__c.setIs_Integration_Updated__c(Boolean.parseBoolean(psaExpenses.getIsIntegrationUpdatedC()));
					
					pse__Expense__c.setExternal_Report_Name__c(psaExpenses.getExternalReportNameC());
					
					records[i] = pse__Expense__c;
					
					i++;
				}

				logger.info("pse__Expense__c create Begins");
				SaveResult saveResult[] = connection.create(records);
				
				if(saveResult != null){
					logger.info("Executed Create Object Operation");
					for(int j = 0; j < saveResult.length; j++){
						Results rs = new Results();
						
						if(saveResult[j].getId() != null){
							rs.setId(saveResult[j].getId());
						}else{
							rs.setId("");
						}
						
						rs.setSuccess(String.valueOf(saveResult[j].getSuccess()));
						
						if(saveResult[j].getErrors().length > 0){
							rs.setErrors(saveResult[j].getErrors()[0].getMessage());
						}
						else{
							rs.setErrors(String.valueOf(false));
						}
						results.add(rs);
						
						logger.info("rs = "+rs);
					}
				}
				
			}
		}catch(Exception e){
			logger.error("Error in Creating Object in pse__Expense__c Object : "+e.getMessage());
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
		
		logger.info("Leaving - com.arris.sfdc.service.provider.PSADirectExpensesCreateServiceProvider.psaDirectExpensesCreate(InputElement) - outputElement : "+outputElement);
		return outputElement;
	}
}
