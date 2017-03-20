package com.arris.sfdc.service.provider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.InputElement.PseMiscellaneousAdjustmentC;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.pojo.OutputElement.CreateResults;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Pse__Miscellaneous_Adjustment__c;
import com.sforce.soap.enterprise.sobject.Pse__Proj__c;
import com.sforce.soap.enterprise.sobject.Pse__Time_Period__c;

public class PSAInDirectExpensesCreateServiceProvider {
	Logger logger = Logger.getLogger(PSAInDirectExpensesCreateServiceProvider.class);
	
	public OutputElement psaInDirectExpensesCreate(InputElement inputElement) throws Exception{
		logger.info("Entering - com.arris.sfdc.service.provider.PSAInDirectExpensesCreateServiceProvider.psaInDirectExpensesCreate(InputElement) : "+inputElement);
		
		OutputElement outputElement = new OutputElement();
		List<CreateResults> createResults = outputElement.getCreateResults();
		
		try{
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
			
				List<PseMiscellaneousAdjustmentC> listPseMiscellaneousAdjustmentC = inputElement.getPseMiscellaneousAdjustmentC();
				logger.info("listPSAExpenses Size : "+listPseMiscellaneousAdjustmentC.size());
				
				Pse__Miscellaneous_Adjustment__c []records = new Pse__Miscellaneous_Adjustment__c[listPseMiscellaneousAdjustmentC.size()];
				
				int i = 0;
				Iterator<PseMiscellaneousAdjustmentC> psaExpensesIterator = listPseMiscellaneousAdjustmentC.iterator();
				while(psaExpensesIterator.hasNext()){
					PseMiscellaneousAdjustmentC pseMiscellaneousAdjustmentC = psaExpensesIterator.next();
					logger.info("pseMiscellaneousAdjustmentC = "+pseMiscellaneousAdjustmentC);
					
					Pse__Miscellaneous_Adjustment__c pmac = new Pse__Miscellaneous_Adjustment__c();
					
					pmac.setMisc_Adjustment_PS_Key__c(pseMiscellaneousAdjustmentC.getMiscAdjustmentPSKeyC());
					pmac.setSource_Type__c(pseMiscellaneousAdjustmentC.getSourceTypeC());
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date formattedDate = null;
					
					String pseEffectiveDateC = pseMiscellaneousAdjustmentC.getPseEffectiveDateC();
					if(pseEffectiveDateC != null && pseEffectiveDateC.length() != 0){
						formattedDate = sdf.parse(pseEffectiveDateC.trim());
						logger.info("Formatted Date For EffectiveDateC : "+formattedDate);
						pmac.setPse__Effective_Date__c(sdf.getCalendar());
					}
					
					String effectiveDateIntegrationC = pseMiscellaneousAdjustmentC.getEffectiveDateIntegrationC();
					if(effectiveDateIntegrationC != null && effectiveDateIntegrationC.length() != 0){
						formattedDate = null;
						formattedDate = sdf.parse(effectiveDateIntegrationC.trim());
						logger.info("Formatted Date For EffectiveDateIntegrationC : "+formattedDate);
						pmac.setEffective_Date_Integration__c(sdf.getCalendar());
					}
					
					pmac.setPO_Number__c(pseMiscellaneousAdjustmentC.getPONumberC());
					pmac.setPse__Description__c(pseMiscellaneousAdjustmentC.getPseDescriptionC());
					pmac.setPse__Invoice_Number__c(pseMiscellaneousAdjustmentC.getPseInvoiceNumberC());
					
					String pseInvoiceDateC = pseMiscellaneousAdjustmentC.getPseInvoiceDateC();
					if(pseInvoiceDateC != null && pseInvoiceDateC.length() != 0){
						formattedDate = null;
						formattedDate = sdf.parse(pseInvoiceDateC.trim());
						logger.info("Formatted Date For PseInvoiceDateC : "+formattedDate);
						pmac.setPse__Invoice_Date__c(sdf.getCalendar());
					}
					
					pmac.setCurrencyIsoCode(pseMiscellaneousAdjustmentC.getCurrencyIsoCode());
					
					String pseAmountC = pseMiscellaneousAdjustmentC.getPseAmountC();
					if(pseAmountC != null && pseAmountC.length() != 0){
						pmac.setPse__Amount__c(Double.parseDouble(pseAmountC.trim()));
					}
					
					pmac.setName(pseMiscellaneousAdjustmentC.getName());
					pmac.setPse__Status__c(pseMiscellaneousAdjustmentC.getPseStatusC());
					pmac.setPse__Approved__c(Boolean.parseBoolean(pseMiscellaneousAdjustmentC.getPseApprovedC()));
					pmac.setPse__Include_In_Financials__c(Boolean.parseBoolean(pseMiscellaneousAdjustmentC.getPseIncludeInFinancialsC()));
					pmac.setPse__Transaction_Category__c(pseMiscellaneousAdjustmentC.getPseTransactionCategoryC());
					pmac.setPse__Invoiced__c(Boolean.parseBoolean(pseMiscellaneousAdjustmentC.getPseInvoicedC()));
					pmac.setPse__Billed__c(Boolean.parseBoolean(pseMiscellaneousAdjustmentC.getPseBilledC()));
					pmac.setEstimate_Category__c(pseMiscellaneousAdjustmentC.getEstimateCategoryC());
					
					Pse__Time_Period__c ptpc = new Pse__Time_Period__c();
					ptpc.setExternal_Id__c(pseMiscellaneousAdjustmentC.getTimePeriodR());
					pmac.setTime_Period__r(ptpc);
					
					Pse__Proj__c ppc = new Pse__Proj__c();
					ppc.setPS_Project__c(pseMiscellaneousAdjustmentC.getPseProjectR());
					pmac.setPse__Project__r(ppc);
					
					Account account = new Account();
					account.setCustomer_Number_HnM__c(pseMiscellaneousAdjustmentC.getPseVendorAccountR());
					pmac.setPse__Vendor_Account__r(account);
					
					records[i] = pmac;
					
					i++;
				}

				logger.info("Pse__Miscellaneous_Adjustment__c create Begins");
				SaveResult saveResult[] = connection.create(records);
				logger.info("saveResult Length : "+saveResult.length);
				
				if(saveResult != null){
					logger.info("Executed Create Object Operation");
					for(int j = 0; j < saveResult.length; j++){
						CreateResults rs = new CreateResults();
						
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
						
						createResults.add(rs);
						
						logger.info("rs = "+rs);
					}
				}
				
			}
		}catch(Exception e){
			logger.error("Error in Creating Object in Pse__Miscellaneous_Adjustment__c Object : "+e.getMessage());
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
		
		logger.info("Leaving - com.arris.sfdc.service.provider.PSAInDirectExpensesCreateServiceProvider.psaInDirectExpensesCreate(InputElement) - outputElement : "+outputElement);
		return outputElement;
	}
}
