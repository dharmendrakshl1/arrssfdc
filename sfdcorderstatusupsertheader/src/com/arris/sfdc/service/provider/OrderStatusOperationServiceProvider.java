package com.arris.sfdc.service.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import com.arris.sfdc.pojo.HeaderInput;
import com.arris.sfdc.pojo.HeaderOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Order_Header__c;

public class OrderStatusOperationServiceProvider {
	Logger logger = Logger.getLogger(OrderStatusOperationServiceProvider.class);

	public HeaderOutput PerformUpsertHeader(HeaderInput headerInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ headerInput);
		
		Order_Header__c[] orderObj = new Order_Header__c[1];
		Order_Header__c order = new Order_Header__c();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input

		HeaderOutput headerOutput = new HeaderOutput();
		// UpsertAccountInput upsertAccount =
		// customerMasterInput.getUpsertAccountInput();
		// logger.info("currencyTypeInputElement Input = " +
		// customerMasterInput);

		order.setName(headerInput.getName());
		order.setCurrencyIsoCode(headerInput.getCurrencyIsoCode());
		order.setOracle_Order_Number__c(headerInput.getOracleOrderNumberC());

		String orderCreated = headerInput.getOrderCreatedDateC();
		if (orderCreated != null && orderCreated.trim().length() != 0) {
			Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(orderCreated.trim());
			System.out.println(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			order.setOrder_Created_Date__c(calendar);
		}

		String orderEntered = headerInput.getOrderEnteredDateC();
		if (orderEntered != null && orderEntered.trim().length() != 0) {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(orderEntered.trim());
			System.out.println(date);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			order.setOrder_Entered_Date__c(calendar);
		}

		order.setOrganization_Code__c(headerInput.getOrganizationCodeC());
		
		String poDate = headerInput.getPODateC();
		if (poDate != null && poDate.trim().length() != 0) {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(poDate.trim());
    	System.out.println(date);
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
		order.setPO_Date__c(calendar);
		}
		
		order.setPO_Number__c(headerInput.getPONumberC());
		order.setPayment_Terms__c(headerInput.getPaymentTermsC());
		order.setPrice_List_Name__c(headerInput.getPriceListNameC());
		order.setRegion__c(headerInput.getRegionC());
		order.setSales_Rep__c(headerInput.getSalesRepC());
		order.setUltimate_Ship_To_Address__c(headerInput.getUltimateShipToAddressC());
		order.setOpportunity__c(headerInput.getOpportunityC());
		order.setPO_Received_Date__c(headerInput.getPOReceivedDateC());
		order.setOracle_Order_Status__c(headerInput.getOracleOrderStatusC());
		order.setOra_SFDC_Opportunity_Number__c(headerInput.getOraSFDCOpportunityNumberC());
		order.setHas_Line_Level_Holds__c(headerInput.getHasLineLevelHoldsC());
		order.setHas_Order_Holds__c(headerInput.getHasOrderHoldsC());
		order.setOrder_Type__c(headerInput.getOrderTypeC());
		order.setShipment_Terms__c(headerInput.getShipmentTermsC());
		order.setCM_Prime__c(headerInput.getCMPrimeC());
		order.setCustomer_Request_date__c(headerInput.getCustomerRequestDateC());
		order.setCustomer_Service_Rep__c(headerInput.getCustomerServiceRepC());
		order.setFreight_Forwarder__c(headerInput.getFreightForwarderC());
		
		String lastUpdate = headerInput.getLastUpdateDateC();
		if (lastUpdate != null && lastUpdate.trim().length() != 0) {
		Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(lastUpdate.trim());
    	System.out.println(date);
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
		order.setLast_Update_Date__c(calendar);
		}
		
		order.setNamed_Place__c(headerInput.getNamedPlaceC());
		order.setProduct_Family__c(headerInput.getProductFamilyC());
		order.setSOA_Email__c(headerInput.getSOAEmailC());
		order.setSOA_Name__c(headerInput.getSOANameC());
		order.setSales_Rep_Name__c(headerInput.getSalesRepNameC());
		order.setSource__c(headerInput.getSourceC());
		
		String stagedAmt = headerInput.getStagedAmountC();
		if (stagedAmt != null && stagedAmt.trim().length() != 0) {
		double doub = Double.parseDouble(stagedAmt.trim());
        order.setStaged_Amount__c(doub);
		}
		
		order.setTrial_and_IR__c(headerInput.getTrialAndIRC());
		order.setOffer__c(headerInput.getOfferC());
		order.setVMI_PO_Header__c(headerInput.getVMIPOHeaderC());
		order.setRequest_Date_Type__c(headerInput.getRequestDateTypeC());
		order.setQuote__c(headerInput.getQuoteC());
		order.setBill_To_Address__c(headerInput.getBillToAddressC());

		Account acc = new Account();
		acc.setCustomer_Number_HnM__c(headerInput.getCustomerNumberHnMC());
		order.setAccount__r(acc);

		order.setShip_To_Address__c(headerInput.getShipToAddressC());

		orderObj[0] = order;
		// Below code is for to update in SFDC using connection
		
		try {
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		logger.info("connection = " + connection);
		
		if (connection != null) {
			
				logger.info("SFDC Upsert Begins");

				UpsertResult[] upsertResult = connection.upsert("Oracle_Order_Number__c", orderObj);
				if (upsertResult != null) {
					for (int j = 0; j < upsertResult.length; j++) {
						// UpsertAccountOutput UpsertAccountOutput =
						// customerMasterOutput.getUpsertAccountOutput();
						if (upsertResult[j].getId() != null) {
							headerOutput.setId(upsertResult[j].getId());
						} else {
							headerOutput.setId("");
						}

						headerOutput.setSuccess(String.valueOf(upsertResult[j].getSuccess()));

						if (upsertResult[j].getErrors().length > 0) {
							headerOutput.setErrors(upsertResult[j].getErrors()[0].getMessage());
						} else {
							headerOutput.setErrors("false");
						}

						logger.info("UpsertPartnumberOutput = " + headerOutput);
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
						+ headerOutput);
		return headerOutput;
	}

}