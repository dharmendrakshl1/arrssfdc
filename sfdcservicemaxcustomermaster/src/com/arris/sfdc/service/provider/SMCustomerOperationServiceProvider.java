package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;
import com.arris.sfdc.constant.SMCustomerOperationConstants;
import com.arris.sfdc.pojo.CustomerOperationsInput;
import com.arris.sfdc.pojo.CustomerOperationsInput.QueryAccountInput;
import com.arris.sfdc.pojo.CustomerOperationsInput.UpsertAccountInput;
import com.arris.sfdc.pojo.CustomerOperationsInput.UpsertBillToShipToInput;
import com.arris.sfdc.pojo.CustomerOperationsInput.UpsertPriceListInput;
import com.arris.sfdc.pojo.CustomerOperationsOutput;
import com.arris.sfdc.pojo.CustomerOperationsOutput.QueryAccountOutput;
import com.arris.sfdc.pojo.CustomerOperationsOutput.UpsertAccountOutput;
import com.arris.sfdc.pojo.CustomerOperationsOutput.UpsertBillToShipToOutput;
import com.arris.sfdc.pojo.CustomerOperationsOutput.UpsertPriceListOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Bill_To_Ship_To__c;
import com.sforce.soap.enterprise.sobject.Price_List__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class SMCustomerOperationServiceProvider {
	Logger logger = Logger.getLogger(SMCustomerOperationServiceProvider.class);

	public CustomerOperationsOutput smCustomerOperation(CustomerOperationsInput customerMasterInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.service.provider.VMIOrderOperationServiceProvider.vmiOrderOperation(OrderImportInput) : ");

		String operation = customerMasterInput.getOperation().trim();
		logger.info("Operation : " + operation);

		CustomerOperationsOutput customerMasterOutput = new CustomerOperationsOutput();
		try {
		if (operation != null) {
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if (connection != null) {
				
					if (operation.equalsIgnoreCase(SMCustomerOperationConstants.QUERY_ACCOUNT)) {
						logger.info(
								"SMCustomerOperationConstants.SM_Customer_OPERATION_Query_Account condition Matched");

						QueryAccountInput queryAccountInput = customerMasterInput.getQueryAccountInput();
						logger.info("queryAccountInput : " + queryAccountInput);

						customerMasterOutput = performQueryAccount(connection, queryAccountInput);
						logger.info("customerMasterOutput : " + customerMasterOutput);
					}

					else if (operation.equalsIgnoreCase(SMCustomerOperationConstants.UPSERT_ACCOUNT)) {
						logger.info(
								"SMCustomerOperationConstants.SM_Customer_OPERATION_Upsert_Account condition Matched");

						UpsertAccountInput upsertAccountInput = customerMasterInput.getUpsertAccountInput();
						logger.info("upsertAccountInput : " + upsertAccountInput);

						customerMasterOutput = PerformUpsertAccount(connection, upsertAccountInput);
						logger.info("customerMasterOutput : " + customerMasterOutput);
					}

					else if (operation.equalsIgnoreCase(SMCustomerOperationConstants.UPSERT_BILL_TO_SHIP)) {
						logger.info(
								"SMCustomerOperationConstants.SM_Customer_OPERATION_Upsert_BillToShip condition Matched");

						UpsertBillToShipToInput upsertBillToShipToInput = customerMasterInput
								.getUpsertBillToShipToInput();
						logger.info("upsertBillToShipToInput : " + upsertBillToShipToInput);

						customerMasterOutput = PerformUpsertBillToShip(connection, upsertBillToShipToInput);
						logger.info("orderImportOutput : " + customerMasterOutput);
					} else if (operation.equalsIgnoreCase(SMCustomerOperationConstants.UPSERT_PRICE_LIST)) {
						logger.info(
								"SMCustomerOperationConstants.SM_Customer_OPERATION_Upsert_PriceList condition Matched");

						UpsertPriceListInput upsertPriceListInput = customerMasterInput.getUpsertPriceListInput();
						logger.info("upsertPriceListInput : " + upsertPriceListInput);

						customerMasterOutput = performUpsertPriceList(connection, upsertPriceListInput);
						logger.info("customerMasterOutput : " + customerMasterOutput);
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
						+ customerMasterOutput);
		return customerMasterOutput;
	}

	public CustomerOperationsOutput performQueryAccount(EnterpriseConnection connection,
			QueryAccountInput queryAccountInput) throws ConnectionException {

		logger.info("Entering -");

		// Below code is for to Select in SFDC using connection
		CustomerOperationsOutput customerOutput = new CustomerOperationsOutput();
		QueryAccountOutput queryAccountOutput = customerOutput.getQueryAccountOutput();

		if (queryAccountOutput == null) {
			logger.info("upsertPriceListOutput is null....Create a new instance of it.");

			queryAccountOutput = new QueryAccountOutput();
			customerOutput.setQueryAccountOutput(queryAccountOutput);
		}
		try {
			logger.info("SFDC Select Begins");
			String customerNumber = queryAccountInput.getCustomerNumberHnMC();
			System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("select Id from Account where Customer_Number_HnM__c = '" + customerNumber + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Account account = (Account) sObject;
					queryAccountOutput.setId(account.getId());
					logger.info("account = " + account);
				}
			}

			return customerOutput;
		} catch (Exception e) {
			logger.error("Error in Selecting sfdcqueryflexsalautomation : " + e.getMessage());
			e.printStackTrace();
		}

		return customerOutput;
	}

	public CustomerOperationsOutput PerformUpsertAccount(EnterpriseConnection connection,
			UpsertAccountInput upsertAccountInput) {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ upsertAccountInput);

		Account[] AccountObj = new Account[1];
		Account Account = new Account();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		CustomerOperationsOutput customerMasterOutput = new CustomerOperationsOutput();
		UpsertAccountOutput UpsertAccountOutput = customerMasterOutput.getUpsertAccountOutput();
		if (UpsertAccountOutput == null) {
			logger.info("upsertPriceListOutput is null....Create a new instance of it.");

			UpsertAccountOutput = new UpsertAccountOutput();
			customerMasterOutput.setUpsertAccountOutput(UpsertAccountOutput);
		}
		// UpsertAccountInput upsertAccount =
		// customerMasterInput.getUpsertAccountInput();
		// logger.info("currencyTypeInputElement Input = " +
		// customerMasterInput);

		Account.setASN_Contact_Email__c(upsertAccountInput.getASNContactEmailC());
		Account.setASN_Contact_Name__c(upsertAccountInput.getASNContactNameC());
		Account.setCAR_Fax__c(upsertAccountInput.getCARFaxC());
		Account.setCAR_Mailbox__c(upsertAccountInput.getCARMailboxC());
		Account.setCustomer_Account_Rep__c(upsertAccountInput.getCustomerAccountRepC());
		Account.setCustomer_Freight_Terms__c(upsertAccountInput.getCustomerFreightTermsC());
		Account.setCustomer_Inco_Terms__c(upsertAccountInput.getCustomerIncoTermsC());
		Account.setCustomer_Number__c(upsertAccountInput.getCustomerNumberC());
		Account.setCustomer_Number_HnM__c(upsertAccountInput.getCustomerNumberHnMC());
		Account.setCustomer_Payment_Terms__c(upsertAccountInput.getCustomerPaymentTermsC());
		Account.setCustomer_Shipment_Method__c(upsertAccountInput.getCustomerShipmentMethodC());
		Account.setIntercompany__c(upsertAccountInput.getIntercompanyC());
		Account.setName(upsertAccountInput.getName());
		Account.setOracle_OSR__c(upsertAccountInput.getOracleOSRC());
		Account.setPrice_List_Name__c(upsertAccountInput.getPriceListNameC());
		Account.setPrice_List__c(upsertAccountInput.getPriceListC());
		Account.setRecordTypeId(upsertAccountInput.getRecordTypeId());
		Account.setReporting_Country__c(upsertAccountInput.getReportingCountryC());
		Account.setSales_Channel__c(upsertAccountInput.getSalesChannelC());
		Account.setSegment__c(upsertAccountInput.getSegmentC());
		Account.setStatus__c(upsertAccountInput.getStatusC());
		Account.setType(upsertAccountInput.getType());

		AccountObj[0] = Account;
		// Below code is for to update in SFDC using connection

		logger.info("connection = " + connection);

		if (connection != null) {
			try {
				logger.info("SFDC Upsert Begins");

				UpsertResult[] upsertResult = connection.upsert("Customer_Number_HnM__c", AccountObj);
				if (upsertResult != null) {
					for (int j = 0; j < upsertResult.length; j++) {

						if (upsertResult[j].getId() != null) {
							UpsertAccountOutput.setId(upsertResult[j].getId());
						} else {
							UpsertAccountOutput.setId("");
						}

						UpsertAccountOutput.setSuccess(String.valueOf(upsertResult[j].getSuccess()));

						if (upsertResult[j].getErrors().length > 0) {
							UpsertAccountOutput.setErrors(upsertResult[j].getErrors()[0].getMessage());
						} else {
							UpsertAccountOutput.setErrors("false");
						}

						logger.info("UpsertPartnumberOutput = " + UpsertAccountOutput);
					}
				}

			} catch (Exception e) {
				logger.error("Error in upserting : " + e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info(
				"Leaving - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) :  updateOutputElement : "
						+ customerMasterOutput);
		return customerMasterOutput;
	}

	public CustomerOperationsOutput PerformUpsertBillToShip(EnterpriseConnection connection,
			UpsertBillToShipToInput upsertBillToShipToInput) {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ upsertBillToShipToInput);

		Bill_To_Ship_To__c[] Bill_To_Ship_To__cObj = new Bill_To_Ship_To__c[1];
		Bill_To_Ship_To__c Bill_To_Ship_To__c = new Bill_To_Ship_To__c();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		CustomerOperationsOutput customerMasterOutput = new CustomerOperationsOutput();
		UpsertBillToShipToOutput UpsertBillToShipOutput = customerMasterOutput.getUpsertBillToShipToOutput();
		if (UpsertBillToShipOutput == null) {
			logger.info("upsertPriceListOutput is null....Create a new instance of it.");

			UpsertBillToShipOutput = new UpsertBillToShipToOutput();
			customerMasterOutput.setUpsertBillToShipToOutput(UpsertBillToShipOutput);
		}

		Bill_To_Ship_To__c.setAccount__c(upsertBillToShipToInput.getAccountC());
		Bill_To_Ship_To__c.setBillingCity__c(upsertBillToShipToInput.getBillingCityC());
		Bill_To_Ship_To__c.setBillingCountry__c(upsertBillToShipToInput.getBillingCountryC());
		Bill_To_Ship_To__c.setBillingState__c(upsertBillToShipToInput.getBillingStateC());
		Bill_To_Ship_To__c.setBillingStreet__c(upsertBillToShipToInput.getBillingStreetC());
		Bill_To_Ship_To__c.setBilling_Address_Line_1__c(upsertBillToShipToInput.getBillingAddressLine1C());
		Bill_To_Ship_To__c.setBilling_Address_Line_2__c(upsertBillToShipToInput.getBillingAddressLine2C());
		Bill_To_Ship_To__c.setBilling_Address_Line_3__c(upsertBillToShipToInput.getBillingAddressLine3C());
		Bill_To_Ship_To__c.setBilling_Address_Line_4__c(upsertBillToShipToInput.getBillingAddressLine4C());
		Bill_To_Ship_To__c.setBilling_Postal_Code__c(upsertBillToShipToInput.getBillingPostalCodeC());
		Bill_To_Ship_To__c.setCAR_Email__c(upsertBillToShipToInput.getCAREmailC());
		Bill_To_Ship_To__c.setCAR_Name__c(upsertBillToShipToInput.getCARNameC());
		Bill_To_Ship_To__c.setCAR_Phone__c(upsertBillToShipToInput.getCARPhoneC());
		Bill_To_Ship_To__c.setCAR_User_ID__c(upsertBillToShipToInput.getCARUserIDC());
		Bill_To_Ship_To__c.setClass__c(upsertBillToShipToInput.getClassC());
		Bill_To_Ship_To__c.setCustomer_Freight_Terms__c(upsertBillToShipToInput.getCustomerFreightTermsC());
		Bill_To_Ship_To__c.setCustomer_Inco_Terms__c(upsertBillToShipToInput.getCustomerIncoTermsC());
		Bill_To_Ship_To__c.setCustomer_Shipment_Method__c(upsertBillToShipToInput.getCustomerShipmentMethodC());
		Bill_To_Ship_To__c.setEDI_ID__c(upsertBillToShipToInput.getEDIIDC());
		Bill_To_Ship_To__c.setIntl_dom__c(upsertBillToShipToInput.getIntlDomC());
		Bill_To_Ship_To__c.setIsActive__c(upsertBillToShipToInput.getIsActiveC());
		Bill_To_Ship_To__c.setLegal_Entity__c(upsertBillToShipToInput.getLegalEntityC());
		Bill_To_Ship_To__c.setName(upsertBillToShipToInput.getName());
		Bill_To_Ship_To__c.setOperating_Unit_ID__c(upsertBillToShipToInput.getOperatingUnitIDC());
		Bill_To_Ship_To__c.setOperating_Unit_Name__c(upsertBillToShipToInput.getOperatingUnitNameC());
		Bill_To_Ship_To__c.setOracle_Price_List_Number__c(upsertBillToShipToInput.getOraclePriceListNumberC());
		Bill_To_Ship_To__c.setPrice_List_Name__c(upsertBillToShipToInput.getPriceListNameC());
		Bill_To_Ship_To__c.setPrimary_Bill_Address__c(upsertBillToShipToInput.getPrimaryBillAddressC());
		Bill_To_Ship_To__c.setSales_Executive__c(upsertBillToShipToInput.getSalesExecutiveC());
		Bill_To_Ship_To__c.setShipping_Address_Line_1__c(upsertBillToShipToInput.getShippingAddressLine1C());
		Bill_To_Ship_To__c.setShipping_Address_Line_2__c(upsertBillToShipToInput.getShippingAddressLine2C());
		Bill_To_Ship_To__c.setShipping_Address_Line_3__c(upsertBillToShipToInput.getShippingAddressLine3C());
		Bill_To_Ship_To__c.setShipping_Address_Line_4__c(upsertBillToShipToInput.getShippingAddressLine4C());
		Bill_To_Ship_To__c.setShipping_Country__c(upsertBillToShipToInput.getShippingCountryC());
		Bill_To_Ship_To__c.setShippingCity__c(upsertBillToShipToInput.getShippingCityC());
		Bill_To_Ship_To__c.setShippingState__c(upsertBillToShipToInput.getShippingStateC());
		Bill_To_Ship_To__c.setShippingStreet__c(upsertBillToShipToInput.getShippingStreetC());
		Bill_To_Ship_To__c.setShippingZipCode__c(upsertBillToShipToInput.getShippingZipCodeC());
		Bill_To_Ship_To__c.setSite_Number__c(upsertBillToShipToInput.getSiteNumberC());
		Bill_To_Ship_To__c.setSite_Use_Code__c(upsertBillToShipToInput.getSiteUseCodeC());
		Bill_To_Ship_To__c.setSite_Use_id__c(upsertBillToShipToInput.getSiteUseCodeC());
		Bill_To_Ship_To__c.setTax_Code__c(upsertBillToShipToInput.getTaxCodeC());
		Bill_To_Ship_To__c.setTerritory__c(upsertBillToShipToInput.getTerritoryC());

		Bill_To_Ship_To__cObj[0] = Bill_To_Ship_To__c;
		// Below code is for to update in SFDC using connection

		if (connection != null) {
			try {
				logger.info("SFDC Upsert Begins");

				UpsertResult[] upsertResult = connection.upsert("Site_Use_id__c", Bill_To_Ship_To__cObj);
				if (upsertResult != null) {
					for (int j = 0; j < upsertResult.length; j++) {

						if (upsertResult[j].getId() != null) {
							UpsertBillToShipOutput.setId(upsertResult[j].getId());
						} else {
							UpsertBillToShipOutput.setId("");
						}

						UpsertBillToShipOutput.setSuccess(String.valueOf(upsertResult[j].getSuccess()));

						if (upsertResult[j].getErrors().length > 0) {
							UpsertBillToShipOutput.setErrors(upsertResult[j].getErrors()[0].getMessage());
						} else {
							UpsertBillToShipOutput.setErrors("false");
						}

						logger.info("UpsertPartnumberOutput = " + UpsertBillToShipOutput);
					}
				}

			} catch (Exception e) {
				logger.error("Error in upserting : " + e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info(
				"Leaving - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) :  updateOutputElement : "
						+ customerMasterOutput);
		return customerMasterOutput;
	}

	public CustomerOperationsOutput performUpsertPriceList(EnterpriseConnection connection,
			UpsertPriceListInput upsertPriceListInput) {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ upsertPriceListInput);

		Price_List__c[] Price_List__cObj = new Price_List__c[1];
		Price_List__c Price_List__c = new Price_List__c();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		CustomerOperationsOutput customerMasterOutput = new CustomerOperationsOutput();
		UpsertPriceListOutput upsertPriceListOutput = customerMasterOutput.getUpsertPriceListOutput();
		if (upsertPriceListOutput == null) {
			logger.info("upsertPriceListOutput is null....Create a new instance of it.");

			upsertPriceListOutput = new UpsertPriceListOutput();
			customerMasterOutput.setUpsertPriceListOutput(upsertPriceListOutput);
		}
		// UpsertAccountInput upsertAccount =
		// customerMasterInput.getUpsertAccountInput();
		// logger.info("currencyTypeInputElement Input = " +
		// customerMasterInput);
		Price_List__c.setActive__c(upsertPriceListInput.getActiveC());
		logger.info("price_list active data is :- " + Price_List__c.getActive__c());
		Price_List__c.setCurrency__c(upsertPriceListInput.getCurrencyC());
		Price_List__c.setName(upsertPriceListInput.getName());
		Price_List__c.setPrice_List_Number__c(upsertPriceListInput.getPriceListNumberC());

		Price_List__cObj[0] = Price_List__c;
		// Below code is for to update in SFDC using connection

		logger.info("connection = " + connection);

		if (connection != null) {
			try {
				logger.info("SFDC Upsert Begins");

				UpsertResult[] upsertResult = connection.upsert("Price_List_Number__c", Price_List__cObj);
				logger.info("length is upsertResult is :" + upsertResult.length);
				if (upsertResult != null) {

					for (int j = 0; j < upsertResult.length; j++) {

						if (upsertResult[j].getId() != null) {
							logger.info("upsertResult's Setting ID is :" + upsertResult[j].getId());
							upsertPriceListOutput.setId(upsertResult[j].getId());
							logger.info("UpsertPriceListOutput's getting ID is :" + upsertPriceListOutput.getId());
						} else {
							upsertPriceListOutput.setId("");
						}
						logger.info("upsertResult's Setting Success is :" + upsertResult[j].getSuccess());
						upsertPriceListOutput.setSuccess((String.valueOf(upsertResult[j].getSuccess())));
						logger.info(
								"UpsertPriceListOutput's getting Success is :" + upsertPriceListOutput.getSuccess());

						if (upsertResult[j].getErrors().length > 0) {
							upsertPriceListOutput.setErrors(upsertResult[j].getErrors()[0].getMessage());
						} else {
							upsertPriceListOutput.setErrors("false");
						}
						logger.info("UpsertPartnumberOutput = " + upsertPriceListOutput);
					}
				}

			} catch (Exception e) {
				logger.error("Error in upserting : " + e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info(
				"Leaving - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) :  updateOutputElement : "
						+ customerMasterOutput);
		return customerMasterOutput;
	}

}