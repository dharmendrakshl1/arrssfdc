package com.arris.sfdc.service.provider;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import com.arris.sfdc.constant.SMCustomerPartOperationConstants;
import com.arris.sfdc.pojo.PartNumberInput;
import com.arris.sfdc.pojo.PartNumberOutput;
import com.arris.sfdc.pojo.QueryPartnumberInput;
import com.arris.sfdc.pojo.QueryPartnumberOutput;
import com.arris.sfdc.pojo.PartNumberInput.UpsertPartnumberInput;
import com.arris.sfdc.pojo.PartNumberOutput.UpsertPartnumberOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Customer_Part_Number__c;
import com.sforce.soap.enterprise.sobject.Product2;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class SMCustomerOperationServiceProvider {
	Logger logger = Logger.getLogger(SMCustomerOperationServiceProvider.class);

	public QueryPartnumberOutput smCustomerQueryOperation(QueryPartnumberInput customerQueryInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.service.provider.VMIOrderOperationServiceProvider.vmiOrderOperation(OrderImportInput) : ");

		String operation = customerQueryInput.getOperations().trim();
		logger.info("Operation : " + operation);

		QueryPartnumberOutput customerPartOutput = new QueryPartnumberOutput();
		try {
			if (operation != null) {
				EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
				if (connection != null) {

					if (operation.equalsIgnoreCase(
							SMCustomerPartOperationConstants.SM_Customer_Part_OPERATION_QueryCustomer)) {
						logger.info("SMCustomerPartOperationConstants.SM_Customer_Part_OPERATION_QueryCustomer");

						String customerNumber = customerQueryInput.getCustomerNumber();
						logger.info("customerNumber : " + customerNumber);

						customerPartOutput = performQueryCustomer(connection, customerNumber);
						logger.info("queryCustomerPartOutput : " + customerPartOutput);
					}

					else if (operation
							.equalsIgnoreCase(SMCustomerPartOperationConstants.SM_Customer_Part_OPERATION_QueryItem)) {
						logger.info("SMCustomerPartOperationConstants.SM_Customer_Part_OPERATION_QueryItem");

						String itemNumber = customerQueryInput.getItemNumber();
						logger.info("itemNumber : " + itemNumber);

						customerPartOutput = PerformQueryItem(connection, itemNumber);
						logger.info("customerMasterOutput : " + customerPartOutput);
					}

				}
			}
		} catch (Exception e) {
			logger.error("Error in performing Operation in Object Order_Staging__c Object : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		logger.info(
				"Leaving - com.arris.sfdc.service.provider.VMIOrderOperationServiceProvider.vmiOrderOperation(OrderImportInput) - orderImportOutput : "
						+ customerPartOutput);
		return customerPartOutput;

	}

	public PartNumberOutput smCustomerUpsertOperation(PartNumberInput customerUpsertInput) throws Exception {

		PartNumberOutput upsertOutputElement = new PartNumberOutput();
		List<UpsertPartnumberOutput> results = upsertOutputElement.getUpsertPartnumberOutput();
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ customerUpsertInput);

		List<UpsertPartnumberInput> listInputs = customerUpsertInput.getUpsertPartnumberInput();
		logger.info("lisctCurrencyDetails Size : " + listInputs.size());

		Customer_Part_Number__c[] Customer_Part_Number = new Customer_Part_Number__c[listInputs.size()];
		int i = 0;

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		Iterator<UpsertPartnumberInput> upsertPartNumberIterator = listInputs.iterator();
		while (upsertPartNumberIterator.hasNext()) {
			UpsertPartnumberInput inputs = upsertPartNumberIterator.next();
			logger.info("UpsertPartNumber Input = " + inputs);

			Customer_Part_Number[i] = new Customer_Part_Number__c();
			Customer_Part_Number[i].setAccount__c(inputs.getAccountC());
			Customer_Part_Number[i].setIsActive__c(inputs.getIsActiveC());
			Customer_Part_Number[i].setName(inputs.getName());
			Customer_Part_Number[i].setProduct__c(inputs.getProductC());
			Customer_Part_Number[i].setExternal_ID__c(inputs.getExternalIDC());
			i++;
		}

		try {
			// Below code is for to update in SFDC using connection
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			logger.info("connection = " + connection);

			if (connection != null) {

				logger.info("SFDC Upsert Begins");

				UpsertResult[] upsertResult = connection.upsert("External_ID__c", Customer_Part_Number);
				if (upsertResult != null) {
					for (int j = 0; j < upsertResult.length; j++) {
						UpsertPartnumberOutput UpsertPartnumberOutput = new UpsertPartnumberOutput();
						if (upsertResult[j].getId() != null) {
							UpsertPartnumberOutput.setId(upsertResult[j].getId());
						} else {
							UpsertPartnumberOutput.setId("");
						}

						UpsertPartnumberOutput.setSuccess(String.valueOf(upsertResult[j].getSuccess()));

						if (upsertResult[j].getErrors().length > 0) {
							UpsertPartnumberOutput.setErrors(upsertResult[j].getErrors()[0].getMessage());
						} else {
							UpsertPartnumberOutput.setErrors("false");
						}
						results.add(UpsertPartnumberOutput);

						logger.info("UpsertPartnumberOutput = " + UpsertPartnumberOutput);
					}
				}

			}
		} catch (Exception e) {
			logger.error("Error in upserting : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}

		logger.info(
				"Leaving - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) :  updateOutputElement : "
						+ upsertOutputElement);
		return upsertOutputElement;
	}

	public QueryPartnumberOutput performQueryCustomer(EnterpriseConnection connection, String customerNumber)
			throws ConnectionException {

		logger.info("Entering -");

		// Below code is for to Select in SFDC using connection
		QueryPartnumberOutput customerOutput = new QueryPartnumberOutput();
		// QueryAccountOutput queryAccountOutput =
		// customerOutput.getQueryAccountOutput();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("select Id from Account where Customer_Number_HnM__c ='" + customerNumber + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Account account = (Account) sObject;
					customerOutput.setId(account.getId());
					logger.info("account = " + account);
				}
			}

		} catch (Exception e) {
			logger.error("Error in Selecting sfdcqueryflexsalautomation : " + e.getMessage());
			e.printStackTrace();
		}

		return customerOutput;
	}

	public QueryPartnumberOutput PerformQueryItem(EnterpriseConnection connection, String itemNumber)
			throws ConnectionException {

		logger.info("Entering -");

		// Below code is for to Select in SFDC using connection
		QueryPartnumberOutput customerOutput = new QueryPartnumberOutput();
		// QueryAccountOutput queryAccountOutput =
		// customerOutput.getQueryAccountOutput();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("select Id from Product2 where BigMachines_Part_Number__c  ='" + itemNumber + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Product2 Product2 = (Product2) sObject;
					customerOutput.setId(Product2.getId());
					logger.info("Product2 = " + Product2);
				}
			}

		} catch (Exception e) {
			logger.error("Error in Selecting sfdcqueryflexsalautomation : " + e.getMessage());
			e.printStackTrace();
		}

		return customerOutput;
	}
}