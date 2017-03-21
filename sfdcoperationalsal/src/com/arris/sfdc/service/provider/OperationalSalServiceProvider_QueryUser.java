package com.arris.sfdc.service.provider;

import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement_QueryUser;
import com.arris.sfdc.pojo.OutputElemenet_QueryUser;
import com.arris.sfdc.pojo.OutputElemenet_QueryUser.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;

import com.sforce.soap.enterprise.sobject.SObject;

public class OperationalSalServiceProvider_QueryUser {

	Logger logger = Logger.getLogger(OperationalSalServiceProvider_QueryUser.class);

	OutputElemenet_QueryUser salQueryApprovalOutputElement = new OutputElemenet_QueryUser();
	List<Results> results = salQueryApprovalOutputElement.getResults();

	public OutputElemenet_QueryUser QueryUserOpertionalSal(InputElement_QueryUser userInputElement) throws Exception {

		logger.info(
				"Entering - com.arris.sfdc.soap.provider.SalAutomationServiceProvider2.QueryFlexSalAutomation(InputElement salInputElement): "
						+ userInputElement);

		// Below code is for to Select in SFDC using connection
		try {
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			logger.info("connection = " + connection);
			if (connection != null) {

				logger.info("SFDC Select Begins");
				String userName = userInputElement.getUSERNAME();
				System.out.println("dateTime value is :" + userName);
				QueryResult queryResult = connection
						.query("select Id from Contact where FederationIdentifier__c ='" + userName + "'");

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
						+ salQueryApprovalOutputElement);
		return salQueryApprovalOutputElement;

	}

}
