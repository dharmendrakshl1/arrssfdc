package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;
import com.arris.sfdc.pojo.InputElement_Update;
import com.arris.sfdc.pojo.OutputElement_Update;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Contact;

public class SalAutomationServiceProvider_Update {
	Logger logger = Logger.getLogger(SalAutomationServiceProvider_Update.class);

	OutputElement_Update salUpdateOutputElement = new OutputElement_Update();
	// List<Result> results = currencyTypeOutputElement.get;

	public OutputElement_Update updateSalAutomation(InputElement_Update salUpdateInputElement) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.soap.provider.CurrencyTypeSoapProvider.updateCurrencyType(CurrencyTypeInputElement) : "
						+ salUpdateInputElement);

		Contact records[] = new Contact[1];
		try {
		// Below code is for to update in SFDC using connection
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		logger.info("connection = " + connection);
		if (connection != null) {
			
				logger.info("SFDC Update Begins");
				String finance1stLevel = salUpdateInputElement.getFinance1StLevelC();
				String id = salUpdateInputElement.getId();

				Contact contact = new Contact();
				contact.setFinance_1st_Level__c(finance1stLevel);
				contact.setId(id);
				contact.toString();

				records[0] = contact;

				OutputElement_Update output = new OutputElement_Update();
				SaveResult saveResult[] = connection.update(records);
				if (saveResult != null) {
					for (int j = 0; j < saveResult.length; j++) {

						if (saveResult[j].getId() != null) {
							output.setId(saveResult[j].getId());

						} else {
							output.setId(records[j].getId());
						}

						output.setSuccess(String.valueOf(saveResult[j].getSuccess()));

						if (saveResult[j].getErrors().length > 0) {
							output.setErrors(saveResult[j].getErrors()[0].getMessage());
						} else {
							output.setErrors("false");
						}
						return output;

					}
				}
				logger.info("output = " + output);
			
		}
		} catch (Exception e) {
			logger.error("Error in updating CurrencyType : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}

		logger.info(
				"Leaving - com.arris.sfdc.soap.provider.CurrencyTypeSoapProvider.updateCurrencyType(CurrencyTypeInputElement) - currencyTypeOutputElement : "
						+ salUpdateOutputElement);
		return salUpdateOutputElement;
	}
}
