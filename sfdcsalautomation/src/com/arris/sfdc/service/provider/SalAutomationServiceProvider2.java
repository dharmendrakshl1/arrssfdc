package com.arris.sfdc.service.provider;

import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.FlexValues;
import com.arris.sfdc.pojo.FlexValues.Results;
import com.arris.sfdc.pojo.InputElement_QueryFlex;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;

import com.sforce.soap.enterprise.sobject.SObject;

public class SalAutomationServiceProvider2 {
	Logger logger = Logger.getLogger(SalAutomationServiceProvider2.class);

	FlexValues salQueryFlexOutputElement = new FlexValues();
	List<Results> results = salQueryFlexOutputElement.getResults();

	public FlexValues QueryFlexSalAutomation(InputElement_QueryFlex salQueryFlexInputElement) throws Exception {

		logger.info(
				"Entering - com.arris.sfdc.soap.provider.SalAutomationServiceProvider2.QueryFlexSalAutomation(InputElement salInputElement): "
						+ salQueryFlexInputElement);
		try {
			// Below code is for to Select in SFDC using connection
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			logger.info("connection = " + connection);
			if (connection != null) {

				logger.info("SFDC Select Begins");
				String flexvalue = salQueryFlexInputElement.getFlexValue();
				System.out.println("flec value is :" + flexvalue);
				QueryResult queryResult = connection.query("select Id from Contact where Financial_Code__c ='"
						+ flexvalue + "' AND FederationIdentifier__c <> '' AND Source_code__c = 'Directory Load' ");

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
			logger.error("Error in Selecting sfdcqueryflexsalautomation : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		logger.info(
				"Leaving - com.arris.sfdc.soap.provider.SalAutomationServiceProvider2.QueryFlexSalAutomation(InputElement salQueryFlexInputElement) : "
						+ salQueryFlexOutputElement);
		return salQueryFlexOutputElement;

	}
}
