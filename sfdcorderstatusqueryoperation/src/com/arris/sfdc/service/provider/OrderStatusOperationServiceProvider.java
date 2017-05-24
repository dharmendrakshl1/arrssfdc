package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;
import com.arris.sfdc.constant.OrderStatusOperationConstants;
import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Attachment;
import com.sforce.soap.enterprise.sobject.Bill_To_Ship_To__c;
import com.sforce.soap.enterprise.sobject.Carrier_Codes__c;
import com.sforce.soap.enterprise.sobject.Corporate_Contract__c;
import com.sforce.soap.enterprise.sobject.Note;
import com.sforce.soap.enterprise.sobject.Offer__c;
import com.sforce.soap.enterprise.sobject.Opportunity;
import com.sforce.soap.enterprise.sobject.Order_Header__c;
import com.sforce.soap.enterprise.sobject.Order_Line__c;
import com.sforce.soap.enterprise.sobject.Product2;
import com.sforce.soap.enterprise.sobject.Pse__Proj__c;
import com.sforce.soap.enterprise.sobject.Quotes__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.soap.enterprise.sobject.Trials__c;
import com.sforce.ws.ConnectionException;

public class OrderStatusOperationServiceProvider {
	Logger logger = Logger.getLogger(OrderStatusOperationServiceProvider.class);

	public OutputElement orderStatusOperation(InputElement orderStatusInput) throws Exception {
		logger.info(
				"Logging in- com.arris.sfdc.service.provider.VMIOrderOperationServiceProvider.vmiOrderOperation(OrderImportInput) : ");

		String operation = orderStatusInput.getOperationName().trim();
		logger.info("Operation : " + operation);

		OutputElement orderStatusOutput = new OutputElement();
		try {
			if (operation != null) {
				EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
				if (connection != null) {

					if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryHeaderBillTo)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryHeaderBillTo condition Matched");

						String headerSITEINVUSE = orderStatusInput.getHeaderSITEINVUSE();
						logger.info("headerSITEINVUSE : " + headerSITEINVUSE);

						orderStatusOutput = performQueryHeaderBillTo(connection, headerSITEINVUSE);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					}

					else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryHeaderShipTo)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryHeaderShipTo condition Matched");

						String header_SITE_SHIP_USE = orderStatusInput.getHeaderSITESHIPUSE();
						logger.info("header_SITE_SHIP_USE : " + header_SITE_SHIP_USE);

						orderStatusOutput = PerformQueryHeaderShipTo(connection, header_SITE_SHIP_USE);
						logger.info("customerMasterOutput : " + orderStatusOutput);
					}

					else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryTrialIR)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryTrialIR condition Matched");

						String queryReplaceOpportunity = orderStatusInput.getHeaderQueryReplaceOpportunity();
						logger.info("queryReplaceOpportunity : " + queryReplaceOpportunity);

						orderStatusOutput = PerformQueryReplaceOpportunityIR(connection, queryReplaceOpportunity);
						logger.info("orderImportOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryTrialwIR)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryTrialwIR condition Matched");

						String headerQueryReplaceOpportunity = orderStatusInput.getHeaderQueryReplaceOpportunity();
						
						logger.info("headerQueryReplaceOpportunity : " + headerQueryReplaceOpportunity);

						orderStatusOutput = PerformQueryReplaceOpportunitywIR(connection,
								headerQueryReplaceOpportunity);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryOffer)) {
						logger.info("OrderStatusOperationConstants.OrderStatus_OPERATION_QueryOffer condition Matched");

						String headerOpportunityOffer = orderStatusInput.getHeaderOpportunityOffer();
						logger.info("headerOpportunityOffer : " + headerOpportunityOffer);

						orderStatusOutput = PerformQueryheaderOpportunityOffer(connection, headerOpportunityOffer);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryQuotes)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryQuotes condition Matched");

						String headerQueryReplaceOpportunity = orderStatusInput.getHeaderQueryReplaceOpportunity();
						logger.info("headerQueryReplaceOpportunity : " + headerQueryReplaceOpportunity);

						orderStatusOutput = PerformQueryQuotes(connection, headerQueryReplaceOpportunity);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryOpportunity)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryOpportunity condition Matched");

						String headerQueryReplaceOpportunity = orderStatusInput.getHeaderQueryReplaceOpportunity();
						logger.info("headerQueryReplaceOpportunity : " + headerQueryReplaceOpportunity);

						orderStatusOutput = PerformQueryOpportunity(connection, headerQueryReplaceOpportunity);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryLineBillTo)) {
						logger.info("OrderStatusOperationConstants.OrderStatus_OPERATION_QueryOffer condition Matched");

						String lineBillUSEID = orderStatusInput.getLineBillUSEID();
						logger.info("headerOpportunityOffer : " + lineBillUSEID);

						orderStatusOutput = PerformQueryLineBillUSEID(connection, lineBillUSEID);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryLineShipTo)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryLineShipTo condition Matched");

						String lineSHIPUSEID = orderStatusInput.getLineSHIPUSEID();
						logger.info("lineSHIPUSEID : " + lineSHIPUSEID);

						orderStatusOutput = PerformQueryLineShipTo(connection, lineSHIPUSEID);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation.equalsIgnoreCase(
							OrderStatusOperationConstants.OrderStatus_OPERATION_QueryShippingMethod)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryShippingMethod condition Matched");

						String lineSHIPVIACD = orderStatusInput.getLineSHIPVIACD();
						logger.info("lineSHIPVIACD : " + lineSHIPVIACD);

						orderStatusOutput = PerformQueryShippingMethod(connection, lineSHIPVIACD);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryProduct)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryProduct condition Matched");

						String linePartNumber = orderStatusInput.getLineParNumber();
						logger.info("lineSHIPVIACD : " + linePartNumber);

						orderStatusOutput = PerformQueryProduct(connection, linePartNumber);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryHeaderId)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryHeaderId condition Matched");

						String hdOrderNumber = orderStatusInput.getHDOrderNumber();
						logger.info("lineSHIPVIACD : " + hdOrderNumber);

						orderStatusOutput = PerformQueryHeaderId(connection, hdOrderNumber);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryAttachment)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryAttachment condition Matched");

						String dAttachmentId = orderStatusInput.getDAttachmentId();
						String dAttachmentName = orderStatusInput.getDAttachmentName();
						logger.info("dAttachmentId : " + dAttachmentId);
						logger.info("dAttachmentName : " + dAttachmentName);

						orderStatusOutput = PerformQueryAttachment(connection, dAttachmentId, dAttachmentName);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryNote)) {
						logger.info("OrderStatusOperationConstants.OrderStatus_OPERATION_QueryNote condition Matched");

						String dNoteId = orderStatusInput.getDNoteId();
						String dNoteName = orderStatusInput.getDNoteName();
						logger.info("dNoteId : " + dNoteId);
						logger.info("dNoteName : " + dNoteName);

						orderStatusOutput = PerformQueryNote(connection, dNoteId, dNoteName);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					} else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryLineId)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryLineId condition Matched");

						String ldOrderNumber = orderStatusInput.getLDOrderNumber();

						logger.info("ldOrderNumber : " + ldOrderNumber);

						orderStatusOutput = PerformQueryLineId(connection, ldOrderNumber);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					}
					else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryCorporateContract)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryCorporateContract condition Matched");

						String headerQueryReplaceOpportunity = orderStatusInput.getHeaderQueryReplaceOpportunity();

						logger.info("headerQueryReplaceOpportunity : " + headerQueryReplaceOpportunity);

						orderStatusOutput = PerformQueryCoporateContract(connection, headerQueryReplaceOpportunity);
						logger.info("orderStatusOutput : " + orderStatusOutput);
					}
					else if (operation
							.equalsIgnoreCase(OrderStatusOperationConstants.OrderStatus_OPERATION_QueryProject)) {
						logger.info(
								"OrderStatusOperationConstants.OrderStatus_OPERATION_QueryProject condition Matched");

						String headerQueryReplaceOpportunity = orderStatusInput.getHeaderQueryReplaceOpportunity();

						logger.info("headerQueryReplaceOpportunity : " + headerQueryReplaceOpportunity);

						orderStatusOutput = PerformQueryProject(connection, headerQueryReplaceOpportunity);
						logger.info("orderStatusOutput : " + orderStatusOutput);
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
						+ orderStatusOutput);
		return orderStatusOutput;
	}

	public OutputElement performQueryHeaderBillTo(EnterpriseConnection connection, String headerSITEINVUSE)
			throws ConnectionException {

		logger.info("Entering -");

		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Bill_To_Ship_To__c where Site_use_id__c = '" + headerSITEINVUSE + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Bill_To_Ship_To__c bill_To_Ship_To__c = (Bill_To_Ship_To__c) sObject;
					orderStatusOutput.setIDHeaderQueryBillTo(bill_To_Ship_To__c.getId());
					logger.info("bill_To_Ship_To__c = " + bill_To_Ship_To__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in Selecting sfdcqueryflexsalautomation : " + e.getMessage());
			e.printStackTrace();
		}
		return orderStatusOutput;

	}

	public OutputElement PerformQueryHeaderShipTo(EnterpriseConnection connection, String header_SITE_SHIP_USE) {
		logger.info("Entering --" + header_SITE_SHIP_USE);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Bill_To_Ship_To__c where Site_use_id__c = '" + header_SITE_SHIP_USE + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Bill_To_Ship_To__c bill_To_Ship_To__c = (Bill_To_Ship_To__c) sObject;
					orderStatusOutput.setIDHeaderQueryShipTo(bill_To_Ship_To__c.getId());
					logger.info("bill_To_Ship_To__c = " + bill_To_Ship_To__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryReplaceOpportunityIR(EnterpriseConnection connection,
			String queryReplaceOpportunity) {
		logger.info("Entering --" + queryReplaceOpportunity);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("select Id from Trials__c where IR__c = '" + queryReplaceOpportunity + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Trials__c trials__c = (Trials__c) sObject;
					orderStatusOutput.setIDHeaderQueryTrialIR(trials__c.getId());
					logger.info("Trials__c = " + trials__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryReplaceOpportunitywIR(EnterpriseConnection connection,
			String queryReplaceOpportunity) {
		logger.info("Entering --" + queryReplaceOpportunity);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("select Id, Opportunity__c from Trials__c where Trial__c = '" + queryReplaceOpportunity + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Trials__c trials__c = (Trials__c) sObject;
					orderStatusOutput.setIDHeaderQueryTrialwIR(trials__c.getId());
					orderStatusOutput.setIDHeaderQueryOpportunity(trials__c.getOpportunity__c());
					logger.info("Trials__c = " + trials__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryheaderOpportunityOffer(EnterpriseConnection connection,
			String headerOpportunityOffer) {
		logger.info("Entering --" + headerOpportunityOffer);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("select Id, Opportunity__c from Offer__c where Name = '" + headerOpportunityOffer + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Offer__c offer__c = (Offer__c) sObject;
					orderStatusOutput.setIDHeaderQueryOffer(offer__c.getId());
					orderStatusOutput.setIDHeaderQueryQuotesOpportunityC(offer__c.getOpportunity__c());
					logger.info("Offer__c = " + offer__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryQuotes(EnterpriseConnection connection, String headerQueryReplaceOpportunity) {
		logger.info("Entering --" + headerQueryReplaceOpportunity);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection.query(
					"select Id,Opportunity__c from Quotes__c where Name = '" + headerQueryReplaceOpportunity + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Quotes__c quotes__c = (Quotes__c) sObject;
					orderStatusOutput.setIDHeaderQueryQuotes(quotes__c.getId());
					orderStatusOutput.setIDHeaderQueryQuotesOpportunityC(quotes__c.getOpportunity__c());
					logger.info("quotes__c = " + quotes__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryOpportunity(EnterpriseConnection connection,
			String headerQueryReplaceOpportunity) {
		logger.info("Entering --" + headerQueryReplaceOpportunity);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("select Id from Opportunity where Opportunity__c = '" + headerQueryReplaceOpportunity + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Opportunity opportunity = (Opportunity) sObject;
					orderStatusOutput.setIDHeaderQueryOpportunity(opportunity.getId());
					logger.info("opportunity = " + opportunity);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryLineBillUSEID(EnterpriseConnection connection, String lineBillUSEID) {
		logger.info("Entering --" + lineBillUSEID);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Bill_To_Ship_To__c where Site_use_id__c = '" + lineBillUSEID + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Bill_To_Ship_To__c bill_To_Ship_To__c = (Bill_To_Ship_To__c) sObject;
					orderStatusOutput.setIDLineQueryBillTo(bill_To_Ship_To__c.getId());
					logger.info("Bill_To_Ship_To__c = " + bill_To_Ship_To__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryLineShipTo(EnterpriseConnection connection, String lineSHIPUSEID) {
		logger.info("Entering --" + lineSHIPUSEID);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Bill_To_Ship_To__c where Site_use_id__c ='" + lineSHIPUSEID + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Bill_To_Ship_To__c bill_To_Ship_To__c = (Bill_To_Ship_To__c) sObject;
					orderStatusOutput.setIDLineQueryShipTo(bill_To_Ship_To__c.getId());
					logger.info("Bill_To_Ship_To__c = " + bill_To_Ship_To__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryProduct(EnterpriseConnection connection, String linePartNumber) {
		logger.info("Entering --" + linePartNumber);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection.query("Select Id from Product2 where Name ='" + linePartNumber + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Product2 Product2 = (Product2) sObject;
					orderStatusOutput.setIDLinePartNumber2(Product2.getId());
					logger.info("Product2 = " + Product2);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryHeaderId(EnterpriseConnection connection, String hdOrderNumber) {
		logger.info("Entering --" + hdOrderNumber);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Order_Header__c where Oracle_Order_Number__c ='" + hdOrderNumber + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Order_Header__c Order_Header__c = (Order_Header__c) sObject;
					orderStatusOutput.setIDHDSFDCHeader(Order_Header__c.getId());
					logger.info("Order_Header__c = " + Order_Header__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryShippingMethod(EnterpriseConnection connection, String lineSHIPVIACD) {
		logger.info("Entering --" + lineSHIPVIACD);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Carrier_Codes__c where Carrier_Code__c ='" + lineSHIPVIACD + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Carrier_Codes__c Carrier_Codes__c = (Carrier_Codes__c) sObject;
					orderStatusOutput.setIDLineQueryShipment(Carrier_Codes__c.getId());
					logger.info("Carrier_Codes__c = " + Carrier_Codes__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryAttachment(EnterpriseConnection connection, String dAttachmentId,
			String dAttachmentName) {
		logger.info("Entering --" + dAttachmentId);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection.query("Select Id from Attachment where ParentId ='" + dAttachmentId
					+ "' AND Name ='" + dAttachmentName + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Attachment Attachment = (Attachment) sObject;
					orderStatusOutput.setIDAttachment(Attachment.getId());
					logger.info("Attachment = " + Attachment);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryNote(EnterpriseConnection connection, String dNoteId, String dNoteName) {
		logger.info("Entering --" + dNoteId);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Note where ParentId =  '" + dNoteId + "' AND Title = '" + dNoteName + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Note Note = (Note) sObject;
					orderStatusOutput.setIDNote(Note.getId());
					logger.info("Note = " + Note);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}

	public OutputElement PerformQueryLineId(EnterpriseConnection connection, String ldOrderNumber) {
		logger.info("Entering --" + ldOrderNumber);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("Select Id from Order_Line__c where External_ID__c ='" + ldOrderNumber + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Order_Line__c Order_Line__c = (Order_Line__c) sObject;
					orderStatusOutput.setIDLDSFDCLine(Order_Line__c.getId());
					logger.info("Order_Line__c = " + Order_Line__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}
	
	public OutputElement PerformQueryCoporateContract(EnterpriseConnection connection,
			String headerQueryReplaceOpportunity) {
		logger.info("Entering --" + headerQueryReplaceOpportunity);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("SELECT Id FROM Corporate_Contract__c WHERE Contract_Number__c = '" + headerQueryReplaceOpportunity + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Corporate_Contract__c corporate = (Corporate_Contract__c) sObject;
					
					orderStatusOutput.setIDHeaderQueryOpportunity(corporate.getId());
					logger.info("corporate = " + corporate);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class"
						+ orderStatusOutput);
		return orderStatusOutput;

	}
	
	
	public OutputElement PerformQueryProject(EnterpriseConnection connection,
			String headerQueryReplaceOpportunity) {
		logger.info("Entering --" + headerQueryReplaceOpportunity);
		// Below code is for to Select in SFDC using connection
		OutputElement orderStatusOutput = new OutputElement();
		// String queryIDHeaderQueryBillToOutput =
		// orderStatusOutput.getIDHeaderQueryBillTo();
		try {
			logger.info("SFDC Select Begins");
			// String customerNumber =
			// queryAccountInput.getCustomerNumberHnMC();
			// System.out.println("customer number is :" + customerNumber);
			QueryResult queryResult = connection
					.query("SELECT Id, pse__Opportunity__c FROM pse__Proj__c WHERE PS_Project__c =  '" + headerQueryReplaceOpportunity + "'");

			if (null != queryResult) {
				for (SObject sObject : queryResult.getRecords()) {
					Pse__Proj__c pse__Proj__c = (Pse__Proj__c) sObject;
					orderStatusOutput.setIDHeaderQueryOpportunity(pse__Proj__c.getId());
					orderStatusOutput.setIDHeaderPSEOpportunityC(pse__Proj__c.getPse__Opportunity__c());
					logger.info("pse__Proj__c = " + pse__Proj__c);
				}
			}

		} catch (Exception e) {
			logger.error("Error in querying : " + e.getMessage());
			e.printStackTrace();
		}

		logger.info(
				"Leaving - Provider Class "
						+ orderStatusOutput);
		return orderStatusOutput;

	}
	
	
	

}