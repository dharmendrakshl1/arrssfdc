package com.arris.sfdc.service.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.VMIOrderOperationConstants;
import com.arris.sfdc.pojo.OrderImportInput;
import com.arris.sfdc.pojo.OrderImportInput.QueryPODetailsInput;
import com.arris.sfdc.pojo.OrderImportInput.QueryPONumberInput;
import com.arris.sfdc.pojo.OrderImportInput.UpdateInterfaceStatusInput;
import com.arris.sfdc.pojo.OrderImportOutput;
import com.arris.sfdc.pojo.OrderImportOutput.QueryPODetailsOutput;
import com.arris.sfdc.pojo.OrderImportOutput.QueryPONumberOutput;
import com.arris.sfdc.pojo.OrderImportOutput.UpdateInterfaceStatusOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Order_Staging__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class VMIOrderOperationServiceProvider {
	Logger logger = Logger.getLogger(VMIOrderOperationServiceProvider.class);
	
	public OrderImportOutput vmiOrderOperation(OrderImportInput orderImportInput) throws Exception {
		logger.info("Entering - com.arris.sfdc.service.provider.VMIOrderOperationServiceProvider.vmiOrderOperation(OrderImportInput) : "+orderImportInput);
		
		String operation = orderImportInput.getOperation().trim();
		logger.info("Operation : "+operation);
		
		OrderImportOutput orderImportOutput = new OrderImportOutput();
		
		if(operation != null){
			try{
				EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
				if(connection != null){
				
					if(operation.equalsIgnoreCase(VMIOrderOperationConstants.VMI_ORDER_OPERATION_QUERY_NEW_POs)){
						logger.info("VMIOrderOperationConstants.VMI_ORDER_OPERATION_QUERY_NEW_POs condition Matched");
						
						QueryPONumberInput queryPONumberInput = orderImportInput.getQueryPONumberInput();
						logger.info("queryPONumberInput : "+queryPONumberInput);
						
						orderImportOutput = performQueryNewPOs(connection, queryPONumberInput);
						logger.info("orderImportOutput : "+orderImportOutput);
					}
					
					else if(operation.equalsIgnoreCase(VMIOrderOperationConstants.VMI_ORDER_OPERATION_QUERY_PO_DATA)){
						logger.info("VMIOrderOperationConstants.VMI_ORDER_OPERATION_QUERY_PO_DATA condition Matched");
						
						QueryPODetailsInput queryPODetailsInput = orderImportInput.getQueryPODetailsInput();
						logger.info("queryPODetailsInput : "+queryPODetailsInput);
						
						orderImportOutput = performQueryPOData(connection, queryPODetailsInput);
						logger.info("orderImportOutput : "+orderImportOutput);
					}
					
					else if(operation.equalsIgnoreCase(VMIOrderOperationConstants.VMI_ORDER_OPERATION_UPDATE_INTERFACE_STATUS)){
						logger.info("VMIOrderOperationConstants.VMI_ORDER_OPERATION_UPDATE_INTERFACE_STATUS condition Matched");
						
						UpdateInterfaceStatusInput updateInterfaceStatusInput = orderImportInput.getUpdateInterfaceStatusInput();
						logger.info("updateInterfaceStatusInput : "+updateInterfaceStatusInput);
						
						orderImportOutput = performUpdateInterfaceStatus(connection, updateInterfaceStatusInput);
						logger.info("orderImportOutput : "+orderImportOutput);
					}
				}
			}catch(Exception e){
				logger.error("Error in performing Operation : "+e.getMessage());
				e.printStackTrace();
				
				throw e;
			}
		}
		logger.info("Leaving - com.arris.sfdc.service.provider.VMIOrderOperationServiceProvider.vmiOrderOperation(OrderImportInput) - orderImportOutput : "+orderImportOutput);
		return orderImportOutput;
	}
	
	public OrderImportOutput performQueryNewPOs(EnterpriseConnection connection, QueryPONumberInput queryPONumberInput) throws ConnectionException{
		logger.info("Entering - performQueryNewPOs(EnterpriseConnection, QueryPONumberInput, OrderImportOutput) : Method");
		OrderImportOutput orderImportOutput = new OrderImportOutput();
		QueryPONumberOutput queryPONumberOutput = orderImportOutput.getQueryPONumberOutput();
		if(queryPONumberOutput == null){
			logger.info("queryPONumberOutput is null");
			queryPONumberOutput = new QueryPONumberOutput();
			orderImportOutput.setQueryPONumberOutput(queryPONumberOutput);
		}
		
		List<String> listPoNumberC = queryPONumberOutput.getPONumberC();
		logger.info("listPoNumberC : "+listPoNumberC);
		
		String interfaceStatusC = queryPONumberInput.getInterfaceStatusC();
		logger.info("interfaceStatusC : "+interfaceStatusC);
		if(interfaceStatusC != null && !(interfaceStatusC.trim().length() > 0)){
			interfaceStatusC = "New";
		}
		logger.info("after If Check interfaceStatusC : "+interfaceStatusC);
		
		boolean done = false;
		
		QueryResult queryResult = connection.query("select PO_Number__c from Order_Staging__c where Interface_Status__c = '"+interfaceStatusC+"'");
		//QueryResult queryResult = connection.query("select PO_Number__c from Order_Staging__c");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getSize());
			logger.info("queryResult getRecords Size : "+queryResult.getRecords().length);
			
			if(queryResult.getSize() > 0){
				while(!done){
					for(SObject sObject : queryResult.getRecords()){
						Order_Staging__c order_Staging__c = (Order_Staging__c) sObject;
						
						listPoNumberC.add(order_Staging__c.getPO_Number__c());
						
						logger.info("PO_Number__c : "+order_Staging__c.getPO_Number__c());
					}
					
					if(queryResult.isDone()){
						logger.info("Query is Done !!!!");
						done = true;
					}else{
						logger.info("Query Results Has More Records.... ");
						queryResult = connection.queryMore(queryResult.getQueryLocator());
					}
				}
			}
			
			logger.info("listPoNumberC : "+listPoNumberC);
		}
		
		logger.info("Leaving - performQueryNewPOs(EnterpriseConnection, QueryPONumberInput, OrderImportOutput) : Method - "+orderImportOutput);
		return orderImportOutput;
	}
	
	public OrderImportOutput performQueryPOData(EnterpriseConnection connection, QueryPODetailsInput quPoDetailsInput) throws ConnectionException{
		logger.info("Entering - performQueryPOData(EnterpriseConnection connection, QueryPODetailsInput quPoDetailsInput) : Method");
		OrderImportOutput orderImportOutput = new OrderImportOutput();
		List<QueryPODetailsOutput> listQueryPODetailsOutput = orderImportOutput.getQueryPODetailsOutput();
		
		logger.info("listQueryPODetailsOutput : "+listQueryPODetailsOutput);
		
		String poNumberC = quPoDetailsInput.getPONumberC();
		logger.info("poNumberC : "+poNumberC);
		
		QueryResult queryResult = connection.query("SELECT Order_Staging__c.Id, Order_Staging__c.CurrencyIsoCode, "
						+ "Order_Staging__c.ASN_Email__c, Order_Staging__c.Account_Number__c, "
						+ "Order_Staging__c.Attention_To__c, Order_Staging__c.Business_Group__c, "
						+ "Order_Staging__c.Cancelled_Quantity__c, Order_Staging__c.Carrier__c, "
						+ "Order_Staging__c.Customer_Item_Number__c, Order_Staging__c.Customer_Number__c, "
						+ "Order_Staging__c.Department__c, Order_Staging__c.External_Line_Ref__c, "
						+ "Order_Staging__c.External_Order_Ref__c, Order_Staging__c.FOB__c, "
						+ "Order_Staging__c.Freight_Terms__c, Order_Staging__c.Fulfillment_Service_Level__c, "
						+ "Order_Staging__c.Header_Attribute1__c, Order_Staging__c.Header_Attribute2__c, "
						+ "Order_Staging__c.Header_Bill_To_Use_ID__c, Order_Staging__c.Header_CRRD__c, "
						+ "Order_Staging__c.Header_Notes__c, Order_Staging__c.Header_Ship_To_Use_ID__c, "
						+ "Order_Staging__c.Interface_Date_Time__c, Order_Staging__c.Interface_Status__c, "
						+ "Order_Staging__c.Item_Number__c, Order_Staging__c.Line_Attribute1__c, "
						+ "Order_Staging__c.Line_Attribute2__c, Order_Staging__c.Line_Bill_To_Use_ID__c, "
						+ "Order_Staging__c.Line_CRSD__c, Order_Staging__c.Line_Notes__c, "
						+ "Order_Staging__c.Line_Ship_To_Use_ID__c, Order_Staging__c.Line_Type__c, "
						+ "Order_Staging__c.OU_ID__c, Order_Staging__c.OU_Name__c, Order_Staging__c.Order_Date__c, "
						+ "Order_Staging__c.Order_Type__c, Order_Staging__c.Ordered_Quantity__c, "
						+ "Order_Staging__c.PO_Number__c, Order_Staging__c.Packing_Instructions__c, "
						+ "Order_Staging__c.Payment_Terms__c, Order_Staging__c.Po_Line_Number__c, "
						+ "Order_Staging__c.Pricelist_Name__c, Order_Staging__c.Primary_SalesRep_Name__c, "
						+ "Order_Staging__c.Return_Reason_Code__c, Order_Staging__c.SOA_Email__c, "
						+ "Order_Staging__c.Ship_Partial_Flag__c, Order_Staging__c.Ship_To_Loc_Code__c, "
						+ "Order_Staging__c.Line_Shipment_Method__c, Order_Staging__c.Shipment_Proirity_Code__c, "
						+ "Order_Staging__c.Shipping_Amount__c, Order_Staging__c.Shipping_Instructions__c, "
						+ "Order_Staging__c.Tax_State__c, Order_Staging__c.Unit_Price__c, "
						+ "Order_Staging__c.Header_Shipment_Method__c, Order_Staging__c.Sales_Program__c, "
						+ "Order_Staging__c.Header_Attribute3__c, Order_Staging__c.Line_Attribute4__c, "
						+ "Order_Staging__c.UOM__c, Order_Staging__c.Price_Date__c FROM Order_Staging__c "
						//+ "where Interface_Status__c = 'New' and  PO_Number__c = '"+poNumberC+"'");
						+ "where PO_Number__c = '"+poNumberC+"'");
		
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getSize());
			
			for(SObject sObject : queryResult.getRecords()){
				Order_Staging__c osc = (Order_Staging__c) sObject;
				
				QueryPODetailsOutput queryPODetailsOutput = new QueryPODetailsOutput();
				
				queryPODetailsOutput.setASNEmailC(osc.getASN_Email__c());
				queryPODetailsOutput.setAccountNumberC(osc.getAccount_Number__c());
				queryPODetailsOutput.setAttentionToC(osc.getAttention_To__c());
				queryPODetailsOutput.setBusinessGroupC(osc.getBusiness_Group__c());
				
				Double cancelledQuantityC = osc.getCancelled_Quantity__c();
				if(cancelledQuantityC != null){
					queryPODetailsOutput.setCancelledQuantityC(String.valueOf(cancelledQuantityC));
				}
				
				queryPODetailsOutput.setCurrencyIsoCode(osc.getCurrencyIsoCode());
				queryPODetailsOutput.setCustomerItemNumberC(osc.getCustomer_Item_Number__c());
				queryPODetailsOutput.setCustomerNumberC(osc.getCustomer_Number__c());
				queryPODetailsOutput.setDepartmentC(osc.getDepartment__c());
				queryPODetailsOutput.setExternalLineRefC(osc.getExternal_Line_Ref__c());
				queryPODetailsOutput.setExternalOrderRefC(osc.getExternal_Order_Ref__c());
				queryPODetailsOutput.setFOBC(osc.getFOB__c());
				queryPODetailsOutput.setFreightTermsC(osc.getFreight_Terms__c());
				queryPODetailsOutput.setFulfillmentServiceLevelC(osc.getFulfillment_Service_Level__c());
				queryPODetailsOutput.setHeaderATTRIBUTE1(osc.getHeader_Attribute1__c());
				queryPODetailsOutput.setHeaderATTRIBUTE2(osc.getHeader_Attribute2__c());
				queryPODetailsOutput.setHeaderATTRIBUTE3(osc.getHeader_Attribute3__c());
				queryPODetailsOutput.setHeaderBillToUseID(osc.getHeader_Bill_To_Use_ID__c());
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
				String formatedDate = null;
				
				Calendar headerCRRDC = osc.getHeader_CRRD__c();
				if(headerCRRDC != null){
					formatedDate = sdf.format(headerCRRDC.getTime());
					queryPODetailsOutput.setHeaderCRRDC(formatedDate);
				}
				
				queryPODetailsOutput.setHeaderNotesC(osc.getHeader_Notes__c());
				queryPODetailsOutput.setHeaderShipToUseID(osc.getHeader_Ship_To_Use_ID__c());
				queryPODetailsOutput.setId(osc.getId());
				queryPODetailsOutput.setItemNumberC(osc.getItem_Number__c());
				queryPODetailsOutput.setLineATTRIBUTE1(osc.getLine_Attribute1__c());
				queryPODetailsOutput.setLineATTRIBUTE2(osc.getLine_Attribute2__c());
				queryPODetailsOutput.setLineATTRIBUTE4(osc.getLine_Attribute4__c());
				queryPODetailsOutput.setLineBillToUseID(osc.getLine_Bill_To_Use_ID__c());
				
				Calendar lineCRSDC = osc.getLine_CRSD__c();
				if(lineCRSDC != null){
					formatedDate = null;
					formatedDate = sdf.format(lineCRSDC.getTime());
					queryPODetailsOutput.setLineCRSDC(formatedDate);
				}
				
				queryPODetailsOutput.setLineNotesC(osc.getLine_Notes__c());
				queryPODetailsOutput.setLineShipToUseID(osc.getLine_Ship_To_Use_ID__c());
				queryPODetailsOutput.setLineShipmentMethodC(osc.getLine_Shipment_Method__c());
				queryPODetailsOutput.setLineTypeC(osc.getLine_Type__c());
				
				Double ouIDC = osc.getOU_ID__c();
				if(ouIDC != null){
					queryPODetailsOutput.setOUIDC(String.valueOf(ouIDC));
				}
				
				queryPODetailsOutput.setOUNameC(osc.getOU_Name__c());
				
				Calendar orderDateC = osc.getOrder_Date__c();
				if(orderDateC != null){
					formatedDate = null;
					formatedDate = sdf.format(orderDateC.getTime());
					queryPODetailsOutput.setOrderDateC(formatedDate);
				}
				
				queryPODetailsOutput.setOrderTypeC(osc.getOrder_Type__c());
				
				Double orderedQuantityC = osc.getOrdered_Quantity__c();
				if(orderedQuantityC != null){
					queryPODetailsOutput.setOrderedQuantityC(String.valueOf(orderedQuantityC));
				}
				
				queryPODetailsOutput.setPONumberC(osc.getPO_Number__c());
				queryPODetailsOutput.setPackingInstructionsC(osc.getPacking_Instructions__c());
				queryPODetailsOutput.setPaymentTermsC(osc.getPayment_Terms__c());
				queryPODetailsOutput.setPoLineNumberC(osc.getPo_Line_Number__c());
				queryPODetailsOutput.setPriceDateC(osc.getPrice_Date__c());
				queryPODetailsOutput.setPricelistNameC(osc.getPricelist_Name__c());
				queryPODetailsOutput.setPrimarySalesRepNameC(osc.getPrimary_SalesRep_Name__c());
				queryPODetailsOutput.setReturnReasonCodeC(osc.getReturn_Reason_Code__c());
				queryPODetailsOutput.setSOAEmailC(osc.getSOA_Email__c());
				queryPODetailsOutput.setSalesProgramC(osc.getSales_Program__c());
				queryPODetailsOutput.setShipPartialFlagC(osc.getShip_Partial_Flag__c());
				queryPODetailsOutput.setShipToLocCodeC(osc.getShip_To_Loc_Code__c());
				
				Double shippingAmountC = osc.getShipping_Amount__c();
				if(shippingAmountC != null){
					queryPODetailsOutput.setShippingAmountC(String.valueOf(shippingAmountC));
				}
				
				queryPODetailsOutput.setShippingInstructionsC(osc.getShipping_Instructions__c());
				queryPODetailsOutput.setTaxStateC(osc.getTax_State__c());
				queryPODetailsOutput.setUOMC(osc.getUOM__c());
				
				Double unitPriceC = osc.getUnit_Price__c();
				if(unitPriceC != null){
					queryPODetailsOutput.setUnitPriceC(String.valueOf(unitPriceC));
				}
				
				logger.info("queryPODetailsOutput : "+queryPODetailsOutput);
				
				listQueryPODetailsOutput.add(queryPODetailsOutput);
			}
			logger.info("listQueryPODetailsOutput : "+listQueryPODetailsOutput);
		}
		
		logger.info("Leaving - performQueryPOData(EnterpriseConnection connection, QueryPODetailsInput quPoDetailsInput) : Method - "+orderImportOutput);
		return orderImportOutput;
	}
	
	public OrderImportOutput performUpdateInterfaceStatus(EnterpriseConnection connection, UpdateInterfaceStatusInput updateInterfaceStatusInput) throws ConnectionException, ParseException{
		logger.info("Entering - performUpdateInterfaceStatus(EnterpriseConnection connection, UpdateInterfaceStatusInput updateInterfaceStatusInput) : Method");
		OrderImportOutput orderImportOutput = new OrderImportOutput();
		
		UpdateInterfaceStatusOutput updateInterfaceStatusOutput = orderImportOutput.getUpdateInterfaceStatusOutput();
		if(updateInterfaceStatusOutput == null){
			logger.info("updateInterfaceStatusOutput is null, So Creating New Instance of it.");
			updateInterfaceStatusOutput = new UpdateInterfaceStatusOutput();
			orderImportOutput.setUpdateInterfaceStatusOutput(updateInterfaceStatusOutput);
		}
		
		Order_Staging__c []records = new Order_Staging__c[1];
		Order_Staging__c osc = new Order_Staging__c();
		
		osc.setId(updateInterfaceStatusInput.getId());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
		String interfaceDateTimeC = updateInterfaceStatusInput.getInterfaceDateTimeC();
		if(interfaceDateTimeC != null && interfaceDateTimeC.trim().length() != 0){
			Date formatedDate = sdf.parse(interfaceDateTimeC.trim());
			logger.info("formatedDate : "+formatedDate);
			osc.setInterface_Date_Time__c(sdf.getCalendar());
		}
		
		osc.setInterface_Error_Message__c(updateInterfaceStatusInput.getInterfaceErrorMessageC());
		osc.setInterface_Status__c(updateInterfaceStatusInput.getInterfaceStatusC());
		osc.setPO_Number__c(updateInterfaceStatusInput.getPONumberC());
		
		records[0] = osc;
		
		SaveResult saveResult[] = connection.update(records);
		if(saveResult != null){
			for(int i = 0; i < saveResult.length; i++){
				
				if(saveResult[i].getId() != null){
					updateInterfaceStatusOutput.setId(saveResult[i].getId());
				}else{
					updateInterfaceStatusOutput.setId(updateInterfaceStatusInput.getId());
				}
				
				updateInterfaceStatusOutput.setSuccess(String.valueOf(saveResult[i].getSuccess()));
				
				if(saveResult[i].getErrors().length > 0){
					updateInterfaceStatusOutput.setErrors(saveResult[i].getErrors()[0].getMessage());
				}else{
					updateInterfaceStatusOutput.setErrors(String.valueOf(false));
				}
				logger.info("outputElement : "+updateInterfaceStatusOutput);
			}
		}
		
		logger.info("Leaving - performUpdateInterfaceStatus(EnterpriseConnection connection, UpdateInterfaceStatusInput updateInterfaceStatusInput) : Method - "+orderImportOutput);
		return orderImportOutput;
	}
}
