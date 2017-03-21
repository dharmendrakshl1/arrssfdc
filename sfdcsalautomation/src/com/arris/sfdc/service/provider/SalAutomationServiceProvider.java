package com.arris.sfdc.service.provider;

import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.Attribute1Results;
import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.Attribute1Results.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;

import com.sforce.soap.enterprise.sobject.SObject;

public class SalAutomationServiceProvider {
	Logger logger = Logger.getLogger(SalAutomationServiceProvider.class);

	Attribute1Results salOutputElement = new Attribute1Results();
	List<Results> results = salOutputElement.getResults();

	public Attribute1Results QuerySalAutomation(InputElement salInputElement) throws Exception {

		logger.info(
				"Entering - com.arris.sfdc.soap.provider.SalAutomationServiceProvider.QuerySalAutomation(InputElement salInputElement): "
						+ salInputElement);
		try {
			// Below code is for to Select in SFDC using connection
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			logger.info("connection = " + connection);
			if (connection != null) {

				logger.info("SFDC Select Begins");
				String attribute1 = salInputElement.getATTRIBUTE1();
				QueryResult queryResult = connection
						.query("select Id from Contact where FederationIdentifier__c = '" + attribute1 + "'");

				Results rs = new Results();
				if (null != queryResult) {
					for (SObject sObject : queryResult.getRecords()) {
						Contact contact = (Contact) sObject;
						rs.setId(contact.getId());
						results.add(rs);
						logger.info("rs = " + rs);
					}
				}

			}
		} catch (Exception e) {
			logger.error("Error in Selecting sfdcsalautomation : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}

		logger.info(
				"Leaving - com.arris.sfdc.soap.provider.SalAutomationServiceProvider.QuerySalAutomation(InputElement salInputElement) : "
						+ salOutputElement);
		return salOutputElement;

	}
}
