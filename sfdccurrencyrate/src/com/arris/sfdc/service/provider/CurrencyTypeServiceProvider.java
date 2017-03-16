package com.arris.sfdc.service.provider;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.InputElement.CurrencyDetails;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.pojo.OutputElement.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.CurrencyType;

public class CurrencyTypeServiceProvider {
	
	Logger logger = Logger.getLogger(CurrencyTypeServiceProvider.class);
	
	OutputElement outputElement = new OutputElement();
	List<Results> results = outputElement.getResults();
	
	public OutputElement updateCurrencyType(InputElement inputElement){
		logger.info("Entering - com.arris.sfdc.soap.provider.CurrencyTypeSoapProvider.updateCurrencyType(InputElement) : "+inputElement);
		
		List<CurrencyDetails> listCurrencyDetails = inputElement.getCurrencyDetails();
		logger.info("lisctCurrencyDetails Size : "+listCurrencyDetails.size());
		
		CurrencyType []currencyType = new CurrencyType[listCurrencyDetails.size()];
		int i = 0;
		
		//Below code is for Iterate through and set it in CurrencyType for All Input
		Iterator<CurrencyDetails> currencyDetailsIterator = listCurrencyDetails.iterator();
		while(currencyDetailsIterator.hasNext()){
			CurrencyDetails currencyDetails = currencyDetailsIterator.next();
			logger.info("currencyDetails = "+currencyDetails);
			currencyType[i] = new CurrencyType();
			currencyType[i].setId(currencyDetails.getId());
			currencyType[i].setConversionRate(currencyDetails.getConversionRate());
			i++;
		}
		
		//Below code is for to update in SFDC using connection
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		logger.info("connection = "+connection);
		if(connection != null){
			try{
				logger.info("SFDC Update Begins");
				SaveResult saveResult[] = connection.update(currencyType);
				if(saveResult != null){
					for(int j = 0; j < saveResult.length; j++){
						Results rs = new Results();
						
						if(saveResult[j].getId() != null){
							rs.setId(saveResult[j].getId());
						}else{
							rs.setId(listCurrencyDetails.get(j).getId());
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
			catch(Exception e){
				logger.error("Error in updating CurrencyType : "+e.getMessage());
				e.printStackTrace();
			}/*finally{
				if(connection != null){
					try {
						connection.logout();
					} catch (ConnectionException e) {
						logger.error("Error in Releasing Connection : "+e.getMessage());
						e.printStackTrace();
					}
				}
			}*/
		}
		
		logger.info("Leaving - com.arris.sfdc.soap.provider.CurrencyTypeSoapProvider.updateCurrencyType(InputElement) - outputElement : "+outputElement);
		return outputElement;
	}
}
