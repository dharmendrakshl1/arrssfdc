package com.arris.sfdc.service.provider;

import java.util.List;
import org.apache.log4j.Logger;
import com.arris.sfdc.pojo.OutputElement_QueryApproval;
import com.arris.sfdc.pojo.OutputElement_QueryApproval.Results;
import com.arris.sfdc.pojo.InputElement_QueryApproval;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Contact;

import com.sforce.soap.enterprise.sobject.SObject;


public class OperationalSalServiceProvider_QueryApproval {

	Logger logger = Logger.getLogger(OperationalSalServiceProvider_QueryApproval.class);

	OutputElement_QueryApproval salQueryApprovalOutputElement = new OutputElement_QueryApproval();
	List<Results> results = salQueryApprovalOutputElement.getResults();

	public OutputElement_QueryApproval QueryApprovalOperationalSal(
			InputElement_QueryApproval salQueryApprovalInputElement) throws Exception {

		logger.info(
				"Entering - com.arris.sfdc.soap.provider.SalAutomationServiceProvider2.QueryFlexSalAutomation(InputElement salInputElement): "
						+ salQueryApprovalInputElement);

		// Below code is for to Select in SFDC using connection
		try {
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		logger.info("connection = " + connection);
		if (connection != null) {
			
				logger.info("SFDC Select Begins");
				String dateTime = salQueryApprovalInputElement.getCurrentLoadDateTime();
				System.out.println("dateTime value is :" + dateTime);
				QueryResult queryResult = connection
						.query("select Id from Contact where Source_Code__c = 'Directory Load' and Approval_Limit__c > 0 and  LastModifiedDate <"+dateTime);
				logger.info("Query size :" + queryResult.getSize());
				if (null != queryResult) {
					for (SObject sObject : queryResult.getRecords()) {
						Contact contact = (Contact) sObject;
						
						Results rs = new Results();
						
						rs.setId(contact.getId());
						results.add(rs);
						
						logger.info("rs = " + rs);
					}
				}
			

		}}
			 catch (Exception e) {
					logger.error("Error in Selecting sfdcqueryflexsalautomation : " + e.getMessage());
					e.printStackTrace();
					throw e;
				}
		
		
	
		logger.info(
				"Leaving - com.arris.sfdc.soap.provider.SalAutomationServiceProvider2.QueryFlexSalAutomation(InputElement salQueryFlexInputElement) : "+ salQueryApprovalOutputElement);
		return salQueryApprovalOutputElement;

	}

}
