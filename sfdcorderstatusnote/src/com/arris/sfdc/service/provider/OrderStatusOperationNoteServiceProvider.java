package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;
import com.arris.sfdc.constant.OrderstatusNoteConstants;
import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Note;

public class OrderStatusOperationNoteServiceProvider {
	Logger logger = Logger.getLogger(OrderStatusOperationNoteServiceProvider.class);

	public OutputElement inputNoteOperation(InputElement inputElement) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.service.provider.OrderStatusOperationServiceProvider.inputOperation(inputElement inputElement): ");

		String operation = inputElement.getOperation().toString();
		logger.info("Operation : " + operation);

		OutputElement outputElement = new OutputElement();
		try {
		if (operation != null) {
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if (connection != null) {
				logger.info("If connection is successful.....");
				
					if (operation.equalsIgnoreCase(OrderstatusNoteConstants.CREATE_NOTE)) {
						logger.info("OrderstatusNoteConstants.CREATE_NOTE condition Matched");

						outputElement = performCreateNote(connection, inputElement);
						logger.info("outputElement : " + outputElement);
					}
					else if (operation.equalsIgnoreCase(OrderstatusNoteConstants.UPDATE_NOTE)) {
						logger.info("OrderstatusNoteConstants.UPDATE_NOTE condition Matched");

						outputElement = PerformUpdateNote(connection, inputElement);
						logger.info("outputElement : " + outputElement);
					}
					else if (operation.equalsIgnoreCase(OrderstatusNoteConstants.INSERT_NOTE)) {
						logger.info("OrderstatusNoteConstants.INSERT_NOTE condition Matched");

						outputElement = performCreateNote(connection, inputElement);
						logger.info("outputElement : " + outputElement);
					}

					

				
			}
		}
		} catch (Exception e) {
			logger.error("Error in performing Operation in Object Order_Staging__c Object : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		logger.info(
				"Leaving - com.arris.sfdc.service.provider.OrderStatusOperationServiceProvider.noteOperation(inputElement inputElement): "
						+ outputElement);
		return outputElement;
	}

	public OutputElement performCreateNote(EnterpriseConnection connection, InputElement inputElement) {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.OrderStatusOperationServiceProvider.performCreatenote(EnterpriseConnection connection,inputElement inputElement) "
						+ inputElement);

		Note[] noteObj = new Note[1];
		Note note = new Note();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		OutputElement outputElement = new OutputElement();
		// if (attachmentOutput == null) {
		// logger.info("updatePriceListOutput is null....Create a new instance
		// of it.");
		//
		// attachmentOutput = new attachmentOutput();
		// attachmentOutput.setattachmentOutput(attachmentOutput);
		// }
		// inputElement updateAccount =
		// customerMasterInput.getinputElement();
		// logger.info("currencyTypeInputElement Input = " +
		// customerMasterInput);

		note.setParentId(inputElement.getParentId());
		note.setBody(inputElement.getBody());
		note.setTitle(inputElement.getTitle());
		

		noteObj[0] = note;
		// Below code is for to update in SFDC using connection

		logger.info("connection = " + connection);

		if (connection != null) {
			try {
				logger.info("SFDC create Begins");
				
				SaveResult[] saveResult = connection.create(noteObj);
				if (saveResult != null) {
					for (int j = 0; j < saveResult.length; j++) {

						if (saveResult[j].getId() != null) {
							outputElement.setId(saveResult[j].getId());
						} else {
							outputElement.setId("");
						}

						outputElement.setSuccess(String.valueOf(saveResult[j].getSuccess()));

						if (saveResult[j].getErrors().length > 0) {
							outputElement.setErrors(saveResult[j].getErrors()[0].getMessage());
						} else {
							outputElement.setErrors("false");
						}

						logger.info("outputElement = " + outputElement);
					}
				}

			} catch (Exception e) {
				logger.error("Error in creating : " + e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info("Leaving - com.arris.sfdc.api.rest.note " + outputElement);
		return outputElement;
	}

	public OutputElement PerformUpdateNote(EnterpriseConnection connection, InputElement inputElement) {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.performCreatenote(EnterpriseConnection connection,inputElement inputElement) "
						+ inputElement);

		Note[] noteObj = new Note[1];
		Note note = new Note();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		OutputElement outputElement = new OutputElement();

		// updateAccountInput updateAccount =
		// customerMasterInput.getupdateAccountInput();
		// logger.info("currencyTypeInputElement Input = " +
		// customerMasterInput);

		note.setParentId(inputElement.getParentId());
		note.setBody(inputElement.getBody());
		note.setTitle(inputElement.getTitle());

		noteObj[0] = note;
		// Below code is for to update in SFDC using connection

		logger.info("connection = " + connection);

		if (connection != null) {
			try {
				logger.info("SFDC Update Begins");

				SaveResult[] saveResult = connection.update(noteObj);
				logger.info("length in updateResult is :" + saveResult.length);
				if (saveResult != null) {

					for (int j = 0; j < saveResult.length; j++) {

						if (saveResult[j].getId() != null) {
							logger.info("updateResult's Setting ID is :" + saveResult[j].getId());
							outputElement.setId(saveResult[j].getId());
							logger.info("updatePriceListOutput's getting ID is :" + outputElement.getId());
						} else {
							outputElement.setId(" ");
						}
						logger.info("updateResult's Setting Success is :" + saveResult[j].getSuccess());
						outputElement.setSuccess((String.valueOf(saveResult[j].getSuccess())));
						logger.info("updatePriceListOutput's getting Success is :" + outputElement.getSuccess());

						if (saveResult[j].getErrors().length > 0) {
							outputElement.setErrors(saveResult[j].getErrors()[0].getMessage());
						} else {
							outputElement.setErrors("false");
						}
						logger.info("updatePartnumberOutput = " + outputElement);
					}
				}

			} catch (Exception e) {
				logger.error("Error in updateing : " + e.getMessage());
				e.printStackTrace();
			}
		}

		logger.info(
				"Leaving - com.arris.sfdc.api.rest.CustomerServicePart_update.updatePartNumber(PartNumberInput approvalInputElement) :  updateOutputElement : "
						+ outputElement);
		return outputElement;
	}

}