package com.arris.sfdc.service.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import com.arris.sfdc.pojo.LineInput;
import com.arris.sfdc.pojo.LineOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.soap.enterprise.sobject.Order_Header__c;
import com.sforce.soap.enterprise.sobject.Order_Line__c;

public class OrderStatusOperationLineServiceProvider {
	Logger logger = Logger.getLogger(OrderStatusOperationLineServiceProvider.class);
	LineOutput lineOutput = new LineOutput();

	public LineOutput PerformUpsertLine(LineInput lineInput) throws Exception {
		logger.info(
				"Entering - com.arris.sfdc.api.rest.CustomerServicePart_Upsert.upsertPartNumber(PartNumberInput approvalInputElement) "
						+ lineInput);

		try {
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();

			Order_Line__c[] orderObj = new Order_Line__c[1];
			Order_Line__c order = new Order_Line__c();

			// Below code is for Iterate through and set it in CurrencyType for
			// All
			// Input

			order.setAPC__c(lineInput.getAPCC());
			order.setName(lineInput.getName());
			order.setCurrencyIsoCode(lineInput.getCurrencyIsoCode());

			String cancelledQuantity = lineInput.getCancelledQuantityC();
			if (cancelledQuantity != null && cancelledQuantity.trim().length() != 0) {
				double doub = Double.parseDouble(cancelledQuantity.trim());
				order.setCancelled_Quantity__c(doub);
			}

			String customerDate = lineInput.getCustomerRequestedShipDateC();
			if (customerDate != null && customerDate.trim().length() != 0) {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(customerDate.trim());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				order.setCustomer_Requested_Ship_Date__c(calendar);
			}

			order.setExternal_ID__c(lineInput.getExternalIDC());

			String externalIDC = lineInput.getInvoiceDateC();
			if (externalIDC != null && externalIDC.trim().length() != 0) {
				Date dateIDC = new SimpleDateFormat("yyyy-MM-dd").parse(externalIDC.trim());
				System.out.println(dateIDC);
				Calendar calendarIDC = Calendar.getInstance();
				calendarIDC.setTime(dateIDC);
				order.setInvoice_Date__c(calendarIDC);
			}

			order.setInvoice_Number__c(lineInput.getInvoiceNumberC());
			order.setLine_Number__c(lineInput.getLineNumberC());

			String doubP = lineInput.getListPriceC();
			if (doubP != null && doubP.trim().length() != 0) {
				double doubPrice = Double.parseDouble(doubP.trim());
				order.setList_Price__c(doubPrice);
			}

			String reservedQuantity = lineInput.getReservedQuantityC();
			if (reservedQuantity != null && reservedQuantity.trim().length() != 0) {
				double doubQty = Double.parseDouble(reservedQuantity.trim());
				order.setReserved_Quantity__c(doubQty);
			}

			String orderedQuantity = lineInput.getOrderedQuantityC();
			if (orderedQuantity != null && orderedQuantity.trim().length() != 0) {
				double doubOrder = Double.parseDouble(orderedQuantity.trim());
				order.setOrdered_Quantity__c(doubOrder);
			}

			order.setPart_Description__c(lineInput.getPartDescriptionC());
			order.setPart_Number__c(lineInput.getPartNumberC());

			String revisedShipDateC = lineInput.getRevisedShipDateC();
			if (revisedShipDateC != null && revisedShipDateC.trim().length() != 0) {
				Date dateRevised = new SimpleDateFormat("yyyy-MM-dd").parse(revisedShipDateC.trim());
				System.out.println(dateRevised);
				Calendar calendarRevised = Calendar.getInstance();
				calendarRevised.setTime(dateRevised);
				order.setRevised_Ship_Date__c(calendarRevised);
			}

			String scheduledShipDateC = lineInput.getScheduledShipDateC();
			if (scheduledShipDateC != null && scheduledShipDateC.trim().length() != 0) {
				Date dateScheduled = new SimpleDateFormat("yyyy-MM-dd").parse(scheduledShipDateC.trim());
				System.out.println(dateScheduled);
				Calendar calendarScheduled = Calendar.getInstance();
				calendarScheduled.setTime(dateScheduled);
				order.setScheduled_Ship_Date__c(calendarScheduled);
			}

			String orderedSelling = lineInput.getSellingPriceC();
			if (orderedSelling != null && orderedSelling.trim().length() != 0) {
				double doubSelling = Double.parseDouble(orderedSelling.trim());
				order.setSelling_Price__c(doubSelling);
			}
			order.setShip_Via__c(lineInput.getShipViaC());
			order.setFulfillment_center__c(lineInput.getFulfillmentCenterC());
			order.setCarrier__c(lineInput.getCarrierC());
			order.setAPC_Description__c(lineInput.getAPCDescriptionC());

			String Fulfilled = lineInput.getFulfilledQuantityC();
			if (Fulfilled != null && Fulfilled.trim().length() != 0) {
				double doubFulfilled = Double.parseDouble(Fulfilled.trim());
				order.setFulfilled_Quantity__c(doubFulfilled);
			}

			String orderedLineHolds = lineInput.getHasLineHoldsC();
			if (orderedLineHolds != null && orderedLineHolds.trim().length() != 0) {
				boolean doubLineHolds = Boolean.getBoolean(orderedLineHolds.trim());
				order.setHas_Line_Holds__c(doubLineHolds);
			}

			order.setCustomer_PO_Line_Number__c(lineInput.getCustomerPOLineNumberC());
			order.setLine_Status__c(lineInput.getLineStatusC());
			order.setLine_Type__c(lineInput.getLineTypeC());
			order.setPacking_Slip_Number__c(lineInput.getPackingSlipNumberC());
			order.setProduct_Class__c(lineInput.getProductClassC());
			order.setProduct_Family__c(lineInput.getProductFamilyC());
			order.setProduct_Line__c(lineInput.getProductLineC());

			String promiseShipDateC = lineInput.getPromiseShipDateC();
			if (promiseShipDateC != null && promiseShipDateC.trim().length() != 0) {
				Date datePromised = new SimpleDateFormat("yyyy-MM-dd").parse(promiseShipDateC.trim());
				System.out.println(datePromised);
				Calendar calendarPromise = Calendar.getInstance();
				calendarPromise.setTime(datePromised);
				order.setPromise_Ship_date__c(calendarPromise);
			}

			order.setSBU__c(lineInput.getSBUC());

			String shippedNewDate = lineInput.getShippedDateNewC();
			if (shippedNewDate != null && shippedNewDate.trim().length() != 0) {
				Date dateShipped = new SimpleDateFormat("yyyy-MM-dd").parse(shippedNewDate.trim());
				System.out.println(dateShipped);
				Calendar calendarShipped = Calendar.getInstance();
				calendarShipped.setTime(dateShipped);
				order.setShipped_Date_new__c(calendarShipped);
			}

			String shippedQuantity = lineInput.getShippedQuantityC();
			if (shippedQuantity != null && shippedQuantity.trim().length() != 0) {
				double doubShipped = Double.parseDouble(shippedQuantity.trim());
				order.setShipped_Quantity__c(doubShipped);
			}
			order.setShipping_Status__c(lineInput.getShippingStatusC());
			order.setTechnology__c(lineInput.getTechnologyC());
			order.setCustomer_Specific_PO_Number__c(lineInput.getCustomerSpecificPONumberC());
			order.setTracking_Number__c(lineInput.getTrackingNumberC());
			order.setLine_Type_Name__c(lineInput.getLineTypeNameC());
			order.setFulfillment_Set__c(lineInput.getFulfillmentSetC());
			order.setInspection_Instructions__c(lineInput.getInspectionInstructionsC());
			order.setPart_Number2__c(lineInput.getPartNumber2C());

			String planningPriority = lineInput.getPlanningPriorityC();
			if (planningPriority != null && planningPriority.trim().length() != 0) {
				double doubPlanning = Double.parseDouble(planningPriority.trim());
				order.setPlanning_Priority__c(doubPlanning);
			}

			order.setReturn_Reason_Code__c(lineInput.getReturnReasonCodeC());
			order.setShip_Set__c(lineInput.getShipSetC());
			order.setShipping_Instructions__c(lineInput.getShippingInstructionsC());
			order.setVAS_Customs_Value__c(lineInput.getVASCustomsValueC());
			order.setOra_Case_Number__c(lineInput.getOraCaseNumberC());

			String fssdc = lineInput.getFSSDC();
			if (fssdc != null && fssdc.trim().length() != 0) {
				Date dateFssdc = new SimpleDateFormat("yyyy-MM-dd").parse(fssdc.trim());
				System.out.println(dateFssdc);
				Calendar calendarfssdc = Calendar.getInstance();
				calendarfssdc.setTime(dateFssdc);
				order.setFSSD__c(calendarfssdc);
			}
			order.setTruck_Load_Qty_Enabled__c(lineInput.getTruckLoadQtyEnabledC());
			order.setCommercial_Invoice_Number__c(lineInput.getCommercialInvoiceNumberC());

			String pickedQuantity = lineInput.getPickedQuantityC();
			if (pickedQuantity != null && pickedQuantity.trim().length() != 0) {
				double doubPicked = Double.parseDouble(pickedQuantity.trim());
				order.setPicked_Quantity__c(doubPicked);
			}

			String pickRelease = lineInput.getPickReleaseDateC();
			if (pickRelease != null && pickRelease.trim().length() != 0) {
				Date datePick = new SimpleDateFormat("yyyy-MM-dd").parse(pickRelease.trim());
				System.out.println(datePick);
				Calendar calendarPick = Calendar.getInstance();
				calendarPick.setTime(datePick);
				order.setPick_Release_Date__c(calendarPick);
			}

			String reservationDate = lineInput.getReservationDateC();
			if (reservationDate != null && reservationDate.trim().length() != 0) {
				Date dateReserver = new SimpleDateFormat("yyyy-MM-dd").parse(reservationDate.trim());
				System.out.println(dateReserver);
				Calendar calendarReserve = Calendar.getInstance();
				calendarReserve.setTime(dateReserver);
				order.setReservation_Date__c(calendarReserve);
			}

			order.setAdded_By__c(lineInput.getAddedByC());

			String deliveryDate = lineInput.getDeliveryDateC();
			if (deliveryDate != null && deliveryDate.trim().length() != 0) {
				Date dateDelivery = new SimpleDateFormat("yyyy-MM-dd").parse(deliveryDate.trim());
				System.out.println(dateDelivery);
				Calendar calendarDelivery = Calendar.getInstance();
				calendarDelivery.setTime(dateDelivery);
				order.setDelivery_Date__c(calendarDelivery);
			}

			order.setFreight_Forwarder__c(lineInput.getFreightForwarderC());

			String lastReservationDate = lineInput.getLastReservedDateC();
			if (lastReservationDate != null && lastReservationDate.trim().length() != 0) {
				Date dateLastReserver = new SimpleDateFormat("yyyy-MM-dd").parse(lastReservationDate.trim());
				System.out.println(dateLastReserver);
				Calendar calendarLastReserve = Calendar.getInstance();
				calendarLastReserve.setTime(dateLastReserver);
				order.setLast_Reserved_Date__c(calendarLastReserve);
			}

			String setLastDate = lineInput.getLastUpdateDateC();
			if (setLastDate != null && setLastDate.trim().length() != 0) {
				Date dateLastSet = new SimpleDateFormat("yyyy-MM-dd").parse(setLastDate.trim());
				System.out.println(dateLastSet);
				Calendar calendarLastSet = Calendar.getInstance();
				calendarLastSet.setTime(dateLastSet);
				order.setLast_Update_Date__c(calendarLastSet);
			}

			String licensePlate = lineInput.getLicensePlateC();
			if (licensePlate != null && licensePlate.trim().length() != 0) {
				double doubLicense = Double.parseDouble(licensePlate.trim());
				order.setLicense_Plate__c(doubLicense);
			}
			order.setNamed_Place__c(lineInput.getNamedPlaceC());
			order.setRMA_Original_Invoice__c(lineInput.getRMAOriginalInvoiceC());

			String rmaQuantity = lineInput.getRMAQuantityReceivedC();
			if (rmaQuantity != null && rmaQuantity.trim().length() != 0) {
				double doubRma = Double.parseDouble(rmaQuantity.trim());
				order.setRMA_Quantity_Received__c(doubRma);
			}
			order.setRMA_Receipt_Number__c(lineInput.getRMAReceiptNumberC());

			String rmaReceivedDate = lineInput.getRMAReceivedDateTimeC();
			if (rmaReceivedDate != null && rmaReceivedDate.trim().length() != 0) {
				Date dateRmaReceived = new SimpleDateFormat("yyyy-MM-dd").parse(rmaReceivedDate.trim());
				System.out.println(dateRmaReceived);
				Calendar calendarRmaReceived = Calendar.getInstance();
				calendarRmaReceived.setTime(dateRmaReceived);
				order.setRMA_Received_DateTime__c(calendarRmaReceived);
			}

			String scheduledArrival = lineInput.getScheduleArrivalDateC();
			if (scheduledArrival != null && scheduledArrival.trim().length() != 0) {
				Date dateScheduledArrival = new SimpleDateFormat("yyyy-MM-dd").parse(scheduledArrival.trim());
				System.out.println(dateScheduledArrival);
				Calendar calendarScheduledArrival = Calendar.getInstance();
				calendarScheduledArrival.setTime(dateScheduledArrival);
				order.setSchedule_Arrival_Date__c(calendarScheduledArrival);
			}
			order.setShip_From_Org__c(lineInput.getShipFromOrgC());
			order.setShipment_Number__c(lineInput.getShipmentNumberC());
			order.setSource_Type_Code__c(lineInput.getSourceTypeCodeC());
			order.setUOM__c(lineInput.getUOMC());

			String onHandQuantity = lineInput.getOnhandQuantityC();
			if (onHandQuantity != null && onHandQuantity.trim().length() != 0) {
				double doubHand = Double.parseDouble(onHandQuantity.trim());
				order.setOnhand_Quantity__c(doubHand);
			}

			order.setTracker__c(lineInput.getTrackerC());
			order.setOrig_System_Reference__c(lineInput.getOrigSystemReferenceC());
			order.setOrdered_Part__c(lineInput.getOrderedPartC());
			order.setEDI_Item__c(lineInput.getEDIItemC());

			String invoiceQuantity = lineInput.getInvoiceQtyC();
			if (invoiceQuantity != null && invoiceQuantity.trim().length() != 0) {
				double doubInvoice = Double.parseDouble(invoiceQuantity.trim());
				order.setInvoice_Qty__c(doubInvoice);
			}

			Account account = new Account();
			account.setCustomer_Number_HnM__c(lineInput.getCustomerNumberHnMC());
			order.setCustomer__r(account);
			order.setShip_Via2__c(lineInput.getShipVia2C());
			order.setBill_To_Address__c(lineInput.getBillToAddressC());
			order.setShip_To_Address__c(lineInput.getShipToAddressC());

			Order_Header__c oracle = new Order_Header__c();
			oracle.setOracle_Order_Number__c(lineInput.getOracleOrderNumberC());
			order.setOrder__r(oracle);

			order.setShip_To_Address__c(lineInput.getShipToAddressC());

			orderObj[0] = order;
			// Below code is for to update in SFDC using connection

			logger.info("connection = " + connection);

			if (connection != null) {

				logger.info("SFDC Upsert Begins");

				UpsertResult[] upsertResult = connection.upsert("External_ID__c", orderObj);

				if (upsertResult != null) {
					for (int j = 0; j < upsertResult.length; j++) {
						// UpsertAccountOutput UpsertAccountOutput =
						// customerMasterOutput.getUpsertAccountOutput();

						if (upsertResult[j].getId() != null) {
							lineOutput.setId(upsertResult[j].getId());
						} else {
							lineOutput.setId("");
						}

						lineOutput.setSuccess(String.valueOf(upsertResult[j].getSuccess()));

						if (upsertResult[j].getErrors().length > 0) {
							lineOutput.setErrors(upsertResult[j].getErrors()[0].getMessage());
						} else {
							lineOutput.setErrors("false");
						}

						logger.info("HeaderHoldsOutput = " + lineOutput);
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
						+ lineOutput);
		return lineOutput;
	}

}