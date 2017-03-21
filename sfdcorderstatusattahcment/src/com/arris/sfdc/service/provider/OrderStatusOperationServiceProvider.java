package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;
import com.arris.sfdc.constant.OrderstatusAttachmentConstants;
import com.arris.sfdc.pojo.AttachmentInput;
import com.arris.sfdc.pojo.AttachmentOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Attachment;

public class OrderStatusOperationServiceProvider {
	Logger logger = Logger.getLogger(OrderStatusOperationServiceProvider.class);

	public AttachmentOutput orderstatusattachmentOperation(AttachmentInput attachmentInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.service.provider.OrderStatusOperationServiceProvider.attachmentOperation(AttachmentInput attachmentInput): ");

		String operation = attachmentInput.getOperation().toString();
		logger.info("Operation : " + operation);

		AttachmentOutput attachmentOutput = new AttachmentOutput();
		try {
		if (operation != null) {
			
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			
			if (connection != null) {
				
					if (operation.equalsIgnoreCase(OrderstatusAttachmentConstants.CREATE_ATTACHMENT)) {
						logger.info("OrderstatusAttachmentConstants.CREATE_ATTACHMENT condition Matched");

						attachmentOutput = performCreateAttachment(connection, attachmentInput);
						logger.info("attachmentOutput : " + attachmentOutput);
					}

					else if (operation.equalsIgnoreCase(OrderstatusAttachmentConstants.UPDATE_ATTACHMENT)) {
						logger.info("OrderstatusAttachmentConstants.UPDATE_ATTACHMENT condition Matched");

						attachmentOutput = PerformUpdateAttachment(connection, attachmentInput);
						logger.info("attachmentOutput : " + attachmentOutput);
					}

				
			}
		}
		} catch (Exception e) {
			logger.error("Error in performing Operation in Object Order_Staging__c Object : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		logger.info(
				"Leaving - com.arris.sfdc.service.provider.OrderStatusOperationServiceProvider.attachmentOperation(AttachmentInput attachmentInput): "
						+ attachmentOutput);
		return attachmentOutput;
	}

	public AttachmentOutput performCreateAttachment(EnterpriseConnection connection, AttachmentInput attachmentInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.OrderStatusOperationServiceProvider.performCreateAttachment(EnterpriseConnection connection,AttachmentInput attachmentInput) "
						+ attachmentInput);

		Attachment[] AttachmentObj = new Attachment[1];
		Attachment Attachment = new Attachment();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		AttachmentOutput attachmentOutput = new AttachmentOutput();
		// if (attachmentOutput == null) {
		// logger.info("upsertPriceListOutput is null....Create a new instance
		// of it.");
		//
		// attachmentOutput = new attachmentOutput();
		// attachmentOutput.setattachmentOutput(attachmentOutput);
		// }
		// attachmentInput upsertAccount =
		// customerMasterInput.getattachmentInput();
		// logger.info("currencyTypeInputElement Input = " +
		// customerMasterInput);

		Attachment.setParentId(attachmentInput.getParentIdCreate());
		Attachment.setName(attachmentInput.getName());
		Attachment.setContentType(attachmentInput.getContentType());
		Attachment.setBody(attachmentInput.getBody().getBytes());
		Attachment.setDescription(attachmentInput.getDescription());

		AttachmentObj[0] = Attachment;
		// Below code is for to update in SFDC using connection

		logger.info("connection = " + connection);

		if (connection != null) {
			try {
				logger.info("SFDC Upsert Begins");

				SaveResult[] saveResult = connection.create(AttachmentObj);
				if (saveResult != null) {
					for (int j = 0; j < saveResult.length; j++) {

						if (saveResult[j].getId() != null) {
							attachmentOutput.setId(saveResult[j].getId());
						} else {
							attachmentOutput.setId("");
						}

						attachmentOutput.setSuccess(String.valueOf(saveResult[j].getSuccess()));

						if (saveResult[j].getErrors().length > 0) {
							attachmentOutput.setErrors(saveResult[j].getErrors()[0].getMessage());
						} else {
							attachmentOutput.setErrors("false");
						}

						logger.info("attachmentOutput = " + attachmentOutput);
					}
				}

			} catch (Exception e) {
				logger.error("Error in upserting : " + e.getMessage());
				e.printStackTrace();
				throw e;
			}
		}

		logger.info("Leaving - com.arris.sfdc.api.rest.Attachment " + attachmentOutput);
		return attachmentOutput;
	}

	public AttachmentOutput PerformUpdateAttachment(EnterpriseConnection connection, AttachmentInput attachmentInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.performCreateAttachment(EnterpriseConnection connection,AttachmentInput attachmentInput) "
						+ attachmentInput);

		Attachment[] attachmentObj = new Attachment[1];
		Attachment Attachment = new Attachment();

		// Below code is for Iterate through and set it in CurrencyType for All
		// Input
		AttachmentOutput attachmentOutput = new AttachmentOutput();

		// UpsertAccountInput upsertAccount =
		// customerMasterInput.getUpsertAccountInput();
		// logger.info("currencyTypeInputElement Input = " +
		// customerMasterInput);
		Attachment.setId(attachmentInput.getIdUpdate());
		Attachment.setContentType(attachmentInput.getContentType());
		Attachment.setBody(attachmentInput.getBody().getBytes());
		Attachment.setDescription(attachmentInput.getDescription());

		attachmentObj[0] = Attachment;
		// Below code is for to update in SFDC using connection

		logger.info("connection = " + connection);

		if (connection != null) {
			try {
				logger.info("SFDC Upsert Begins");

				SaveResult[] saveResult = connection.update(attachmentObj);
				logger.info("length is upsertResult is :" + saveResult.length);
				if (saveResult != null) {

					for (int j = 0; j < saveResult.length; j++) {

						if (saveResult[j].getId() != null) {
							logger.info("upsertResult's Setting ID is :" + saveResult[j].getId());
							attachmentOutput.setId(saveResult[j].getId());
							logger.info("UpsertPriceListOutput's getting ID is :" + attachmentOutput.getId());
						} else {
							attachmentOutput.setId("");
						}
						logger.info("upsertResult's Setting Success is :" + saveResult[j].getSuccess());
						attachmentOutput.setSuccess((String.valueOf(saveResult[j].getSuccess())));
						logger.info("UpsertPriceListOutput's getting Success is :" + attachmentOutput.getSuccess());

						if (saveResult[j].getErrors().length > 0) {
							attachmentOutput.setErrors(saveResult[j].getErrors()[0].getMessage());
						} else {
							attachmentOutput.setErrors("false");
						}
						logger.info("UpsertPartnumberOutput = " + attachmentOutput);
					}
				}

			} catch (Exception e) {
				logger.error("Error in upserting : " + e.getMessage());
				e.printStackTrace();
				throw e;
			}
		}

		logger.info(
				"Leaving - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) :  updateOutputElement : "
						+ attachmentOutput);
		return attachmentOutput;
	}

}