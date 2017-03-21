package com.arris.sfdc.service.provider;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.LineHoldsInput;
import com.arris.sfdc.pojo.LineHoldsInput.LineHolds;
import com.arris.sfdc.pojo.LineHoldsOutput;
import com.arris.sfdc.pojo.LineHoldsOutput.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Order_Line_Hold__c;

public class OrderStatusOperationServiceProvider {
	Logger logger = Logger.getLogger(OrderStatusOperationServiceProvider.class);
	LineHoldsOutput LineHoldsOutput = new LineHoldsOutput();

	public LineHoldsOutput performUpsertLineHolds(LineHoldsInput LineHoldsInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ LineHoldsInput);
		try {
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();

			List<Results> results = LineHoldsOutput.getResults();

			List<LineHolds> listInputs = LineHoldsInput.getLineHolds();
			logger.info("lisctCurrencyDetails Size : " + listInputs.size());

			Order_Line_Hold__c[] orderObj = new Order_Line_Hold__c[listInputs.size()];
			int i = 0;

			Iterator<LineHolds> LineHoldIterator = listInputs.iterator();
			while (LineHoldIterator.hasNext()) {
				LineHolds LineHold = LineHoldIterator.next();
				logger.info("Line hold loop conatins :- " + LineHold);
				orderObj[i] = new Order_Line_Hold__c();

				orderObj[i].setReleased_flag__c(LineHold.getReleasedFlagC());

				String releaseDate = LineHold.getReleasedDateC();

				if (releaseDate != null && releaseDate.trim().length() != 0) {

					Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(releaseDate.trim());
					System.out.println(date);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					orderObj[i].setReleased_Date__c(calendar);

				}

				orderObj[i].setReleased_By__c(LineHold.getReleasedByC());
				orderObj[i].setReleased_By_Details__c(LineHold.getReleasedByDetailsC());
				orderObj[i].setRelease_Reason_Code__c(LineHold.getReleaseReasonCodeC());
				orderObj[i].setRelease_Comment__c(LineHold.getReleaseCommentC());

				String creationDate = LineHold.getHoldCreationDateC();

				if (releaseDate != null && releaseDate.trim().length() != 0) {

					Date dateCreation = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(creationDate.trim());

					System.out.println("creation date is " + dateCreation);
					Calendar calendarCreation = Calendar.getInstance();
					calendarCreation.setTime(dateCreation);
					orderObj[i].setHold_Creation_Date__c(calendarCreation);
				}
				orderObj[i].setHold_Description__c(LineHold.getHoldDescriptionC());
				orderObj[i].setHold_Created_By__c(LineHold.getHoldCreatedByC());
				orderObj[i].setHold_Created_By_Details__c(LineHold.getHoldCreatedByDetailsC());
				orderObj[i].setHold_Comment__c(LineHold.getHoldCommentC());

				String externalIdc = LineHold.getExternalIDC();
				if (externalIdc != null && externalIdc.trim().length() != 0) {
					double doub = Double.parseDouble(externalIdc.trim());
					orderObj[i].setExternal_ID__c(doub);
				}
				orderObj[i].setActivity_Name__c(LineHold.getActivityNameC());
				orderObj[i].setOrder_Line__c(LineHold.getOrderLineC());

				orderObj[i].setName(LineHold.getName());
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
						logger.info("LineHoldsOutput = " + LineHoldsOutput);
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
						+ LineHoldsOutput);
		return LineHoldsOutput;
	}

}