package com.arris.sfdc.service.provider;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import com.arris.sfdc.pojo.HeaderHoldsInput;
import com.arris.sfdc.pojo.HeaderHoldsInput.HeaderHolds;
import com.arris.sfdc.pojo.HeaderHoldsOutput;
import com.arris.sfdc.pojo.HeaderHoldsOutput.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Order_Header_Hold__c;

public class OrderStatusOperationServiceProvider {
	Logger logger = Logger.getLogger(OrderStatusOperationServiceProvider.class);
	HeaderHoldsOutput HeaderHoldsOutput = new HeaderHoldsOutput();

	public HeaderHoldsOutput PerformUpsertHeader(HeaderHoldsInput HeaderHoldsInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ HeaderHoldsInput);
		try {
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();

			List<Results> results = HeaderHoldsOutput.getResults();

			List<HeaderHolds> listInputs = HeaderHoldsInput.getHeaderHolds();
			logger.info("lisctCurrencyDetails Size : " + listInputs.size());

			Order_Header_Hold__c[] orderObj = new Order_Header_Hold__c[listInputs.size()];
			int i = 0;

			Iterator<HeaderHolds> headerHoldIterator = listInputs.iterator();
			while (headerHoldIterator.hasNext()) {
				HeaderHolds headerHold = headerHoldIterator.next();
				logger.info("header hold loop conatins :- " + headerHold);
				orderObj[i] = new Order_Header_Hold__c();

				orderObj[i].setCurrencyIsoCode(headerHold.getCurrencyIsoCode());
				orderObj[i].setOrder_Header__c(headerHold.getOrderHeaderC());
				orderObj[i].setActivity_Name__c(headerHold.getActivityNameC());

				String externId = headerHold.getExternalIDC();
				if (externId != null && externId.trim().length() != 0) {
					double doub = Double.parseDouble(externId.trim());
					orderObj[i].setExternal_ID__c(doub);
				}
				orderObj[i].setHold_Comment__c(headerHold.getHoldCommentC());
				orderObj[i].setHold_Created_By__c(headerHold.getHoldCreatedByC());
				orderObj[i].setHold_Created_By_Details__c(headerHold.getHoldCreatedByDetailsC());

				String createDate = headerHold.getHoldCreationDateC();
				if (createDate != null && createDate.trim().length() != 0) {
					Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(createDate.trim());
					System.out.println(date);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					orderObj[i].setHold_Creation_Date__c(calendar);
				}

				orderObj[i].setHold_Description__c(headerHold.getHoldDescriptionC());
				orderObj[i].setRelease_Comment__c(headerHold.getReleaseCommentC());
				orderObj[i].setRelease_Reason_Code__c(headerHold.getReleaseReasonCodeC());
				orderObj[i].setReleased_By_Details__c(headerHold.getReleasedByDetailsC());
				orderObj[i].setReleased_By__c(headerHold.getReleasedByC());

				String releasedDate = headerHold.getReleasedDateC();
				if (releasedDate != null && releasedDate.trim().length() != 0) {
					Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(releasedDate.trim());
					//2017-02-28 08:04:32.0
					System.out.println(date);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					orderObj[i].setReleased_Date__c(calendar);
				}

				orderObj[i].setReleased_Flag__c(headerHold.getReleasedFlagC());
				orderObj[i].setName(headerHold.getName());
				i++;
			}
			// Below code is for to update in SFDC using connection

			logger.info("connection = " + connection);

			if (connection != null) {

				logger.info("SFDC Upsert Begins");
				Results results1 = new Results();
				UpsertResult[] upsertResult = connection.upsert("External_ID__c", orderObj);
				if (upsertResult != null) {
					for (int j = 0; j < upsertResult.length; j++) {
						// UpsertAccountOutput UpsertAccountOutput =
						// customerMasterOutput.getUpsertAccountOutput();
						if (upsertResult[j].getId() != null) {
							results1.setId(upsertResult[j].getId());
						} else {
							results1.setId("");
						}

						results1.setSuccess(String.valueOf(upsertResult[j].getSuccess()));

						if (upsertResult[j].getErrors().length > 0) {
							results1.setErrors(upsertResult[j].getErrors()[0].getMessage());
						} else {
							results1.setErrors("false");
						}
						results.add(results1);
						logger.info("HeaderHoldsOutput = " + HeaderHoldsOutput);
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
						+ HeaderHoldsOutput);
		return HeaderHoldsOutput;
	}

}