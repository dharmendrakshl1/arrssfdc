package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.ServiceMaxPriceBookOperationConstants;
import com.arris.sfdc.pojo.PriceBookInput;
import com.arris.sfdc.pojo.PriceBookInput.DeletePriceListLineInput;
import com.arris.sfdc.pojo.PriceBookInput.QueryPriceListInput;
import com.arris.sfdc.pojo.PriceBookInput.QueryPriceListLineInput;
import com.arris.sfdc.pojo.PriceBookInput.QueryProduct2Input;
import com.arris.sfdc.pojo.PriceBookInput.UpsertPriceListInput;
import com.arris.sfdc.pojo.PriceBookOutput;
import com.arris.sfdc.pojo.PriceBookOutput.DeletePriceListLineOutput;
import com.arris.sfdc.pojo.PriceBookOutput.QueryPriceListLineOutput;
import com.arris.sfdc.pojo.PriceBookOutput.QueryPriceListOutput;
import com.arris.sfdc.pojo.PriceBookOutput.QueryProduct2Output;
import com.arris.sfdc.pojo.PriceBookOutput.UpsertPriceListOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.DeleteResult;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Price_List_Line__c;
import com.sforce.soap.enterprise.sobject.Price_List__c;
import com.sforce.soap.enterprise.sobject.Product2;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

public class ServiceMaxPriceBookOperationServiceProvider {
	Logger logger = Logger.getLogger(ServiceMaxPriceBookOperationServiceProvider.class);
	
	public PriceBookOutput maxPriceBookOperation(PriceBookInput priceBookInput) throws Exception{
		logger.info("Entering - com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider.maxPriceBookOperation(PriceBookInput) : "+priceBookInput);
		
		String operation = priceBookInput.getOperation().trim();
		logger.info("Operation : "+operation);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		
		if(operation != null){
			try{
				EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
				if(connection != null){
				
					if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.QUERY_PRODUCT2)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRODUCT2 condition Matched");
						
						QueryProduct2Input queryProduct2Input = priceBookInput.getQueryProduct2Input();
						logger.info("queryProduct2Input : "+queryProduct2Input);
						
						if(queryProduct2Input != null){
							priceBookOutput = performQueryProduct2(connection, queryProduct2Input);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.QUERY_PRICE_LIST)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRICE_LIST condition Matched");
						
						QueryPriceListInput queryPriceListInput = priceBookInput.getQueryPriceListInput();
						logger.info("queryPriceListInput : "+queryPriceListInput);
						
						if(queryPriceListInput != null){
							priceBookOutput = performQueryPriceList(connection, queryPriceListInput);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.QUERY_PRICE_LIST_LINE)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRICE_LIST_LINE condition Matched");
						
						QueryPriceListLineInput queryPriceListLineInput = priceBookInput.getQueryPriceListLineInput();
						logger.info("queryPriceListLineInput : "+queryPriceListLineInput);
						
						if(queryPriceListLineInput != null){
							priceBookOutput = performQueryPriceListLine(connection, queryPriceListLineInput);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.UPSERT_PRICE_LIST_LINE)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRICE_LIST_LINE condition Matched");
						
						UpsertPriceListInput upsertPriceListInput = priceBookInput.getUpsertPriceListInput();
						logger.info("upsertPriceListInput : "+upsertPriceListInput);
						
						if(upsertPriceListInput != null){
							priceBookOutput = performUpsertPriceListLine(connection, upsertPriceListInput);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxPriceBookOperationConstants.DELETE_PRICE_LIST_LINE)){
						logger.info("ServiceMaxPriceBookOperationConstants.DELETE_PRICE_LIST_LINE condition Matched");
						
						DeletePriceListLineInput deletePriceListLineInput = priceBookInput.getDeletePriceListLineInput();
						logger.info("deletePriceListLineInput : "+deletePriceListLineInput);
						
						if(deletePriceListLineInput != null){
							priceBookOutput = performDeletePriceListLine(connection, deletePriceListLineInput);
						}
						logger.info("priceBookOutput : "+priceBookOutput);
					}
				}
			}catch(Exception e){
				logger.error("Error in performing Operation : "+e.getMessage());
				e.printStackTrace();
				
				throw e;
			}
		}
		logger.info("Leaving - com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider.maxPriceBookOperation(PriceBookInput) - priceBookOutput : "+priceBookOutput);
		return priceBookOutput;
	}
	
	public PriceBookOutput performQueryProduct2(EnterpriseConnection connection, QueryProduct2Input queryProduct2Input) throws ConnectionException{
		logger.info("Entering - performQueryProduct2(EnterpriseConnection connection, QueryProduct2Input queryProduct2Input) : Method");
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		QueryProduct2Output queryProduct2Output = priceBookOutput.getQueryProduct2Output();
		if(queryProduct2Output == null){
			logger.info("queryProduct2Output is null... Creating new Instance of it");
			queryProduct2Output = new QueryProduct2Output();
			priceBookOutput.setQueryProduct2Output(queryProduct2Output);
		}
		
		String itemNumber = queryProduct2Input.getITEMNUMBER();
		logger.info("itemNumber : "+itemNumber);
		
		QueryResult queryResult = connection.query("select Id, Name from Product2 where BigMachines_Part_Number__c = '"+itemNumber+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getSize());
			
			for(SObject sObject : queryResult.getRecords()){
				Product2 product2 = (Product2) sObject;
				
				queryProduct2Output.setId(product2.getId());
				queryProduct2Output.setName(product2.getName());
			}
			logger.info("queryProduct2Output : "+queryProduct2Output);
		}
		
		logger.info("Leaving - performQueryProduct2(EnterpriseConnection connection, QueryProduct2Input queryProduct2Input) : Method - "+priceBookOutput);
		return priceBookOutput;
	}
	
	public PriceBookOutput performQueryPriceList(EnterpriseConnection connection, QueryPriceListInput queryPriceListInput) throws ConnectionException{
		logger.info("Entering - performQueryPriceList(EnterpriseConnection connection, QueryPriceListInput queryPriceListInput) : Method");
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		
		QueryPriceListOutput queryPriceListOutput = priceBookOutput.getQueryPriceListOutput();
		if(queryPriceListOutput == null){
			logger.info("queryPriceListOutput is null... Creating new instance of it.");
			queryPriceListOutput = new QueryPriceListOutput();
			priceBookOutput.setQueryPriceListOutput(queryPriceListOutput);
		}
		
		String priceListId = queryPriceListInput.getPRICELISTID();
		logger.info("priceListId : "+priceListId);
		
		QueryResult queryResult = connection.query("select Id from Price_List__c where Price_List_Number__c = "+priceListId);
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getSize());
			
			for(SObject sObject : queryResult.getRecords()){
				Price_List__c plc = (Price_List__c) sObject;
				
				queryPriceListOutput.setId(plc.getId());
			}
			logger.info("queryPriceListOutput : "+queryPriceListOutput);
		}
		
		logger.info("Leaving - performQueryPriceList(EnterpriseConnection connection, QueryPriceListInput queryPriceListInput) : Method - "+priceBookOutput);
		return priceBookOutput;
	}
	
	public PriceBookOutput performQueryPriceListLine(EnterpriseConnection connection, QueryPriceListLineInput queryPriceListLineInput) throws ConnectionException{
		logger.info("Entering - performQueryPriceListLine(EnterpriseConnection connection, QueryPriceListLineInput queryPriceListLineInput) :  Method - "+queryPriceListLineInput);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		QueryPriceListLineOutput queryPriceListLineOutput = priceBookOutput.getQueryPriceListLineOutput();
		if(queryPriceListLineOutput == null){
			logger.info("queryPriceLineOutput is null... Creating a new instance of it.");
			queryPriceListLineOutput = new QueryPriceListLineOutput();
			priceBookOutput.setQueryPriceListLineOutput(queryPriceListLineOutput);
		}
		
		String externalIDC = queryPriceListLineInput.getExternalIDC();
		logger.info("externalIDC : "+externalIDC);
		
		QueryResult queryResult = connection.query("select Id from Price_List_Line__c where External_ID__c = '"+externalIDC+"'");
		if(queryResult != null){
			logger.info("queryResult Size : "+queryResult.getSize());
			
			for(SObject sObject : queryResult.getRecords()){
				Price_List_Line__c pllc = (Price_List_Line__c) sObject;
				
				queryPriceListLineOutput.setId(pllc.getId());
			}
			logger.info("queryPriceListLineOutput : "+queryPriceListLineOutput);
		}
		
		logger.info("Leaving - performQueryPriceListLine(EnterpriseConnection connection, QueryPriceListLineInput queryPriceListLineInput) :  priceBookOutput - "+priceBookOutput);
		return priceBookOutput;
	}
	
	public PriceBookOutput performUpsertPriceListLine(EnterpriseConnection connection, UpsertPriceListInput upsertPriceListInput) throws ConnectionException {
		logger.info("Entering - performUpsertPriceListLine(EnterpriseConnection connection, UpsertPriceListInput upsertPriceListInput) : Method - "+upsertPriceListInput);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		UpsertPriceListOutput upsertPriceListOutput = priceBookOutput.getUpsertPriceListOutput();
		if(upsertPriceListOutput ==  null){
			logger.info("upsertPriceListOutput is null... Creating a new instance of it.");
			upsertPriceListOutput = new UpsertPriceListOutput();
			priceBookOutput.setUpsertPriceListOutput(upsertPriceListOutput);
		}
		
		Price_List_Line__c []records = new Price_List_Line__c[1];
		
		Price_List_Line__c pllc = new Price_List_Line__c();
		pllc.setCurrencyIsoCode(upsertPriceListInput.getCurrencyIsoCode());
		
		String unitPriceC = upsertPriceListInput.getUnitPriceC();
		if(unitPriceC != null && unitPriceC.trim().length() != 0){
			pllc.setUnit_Price__c(Double.parseDouble(unitPriceC.trim()));
		}
		
		pllc.setProduct__c(upsertPriceListInput.getProductC());
		pllc.setName(upsertPriceListInput.getName());
		pllc.setExternal_ID__c(upsertPriceListInput.getExternalIDC());
		pllc.setPrice_List__c(upsertPriceListInput.getPriceListC());
		
		records[0] = pllc;
		
		UpsertResult []upsertResult = connection.upsert("External_ID__c", records);
		if(upsertResult != null){
			for(int i = 0; i < upsertResult.length; i++){
				if(upsertResult[i].getId() != null){
					upsertPriceListOutput.setId(upsertResult[i].getId());
				}else{
					upsertPriceListOutput.setId("");
				}
				
				upsertPriceListOutput.setSuccess(String.valueOf(upsertResult[i].getSuccess()));
				
				if(upsertResult[i].getErrors().length > 0){
					upsertPriceListOutput.setErrors(upsertResult[i].getErrors()[0].getMessage());
				}else{
					upsertPriceListOutput.setErrors(String.valueOf(false));
				}
				logger.info("upsertPriceListOutput : "+upsertPriceListOutput);
			}
		}
		
		logger.info("Leaving - performUpsertPriceListLine(EnterpriseConnection connection, UpsertPriceListInput upsertPriceListInput) : priceBookOutput - "+priceBookOutput);
		return priceBookOutput;
	}
	
	public PriceBookOutput performDeletePriceListLine(EnterpriseConnection connection, DeletePriceListLineInput deletePriceListLineInput) throws ConnectionException{
		logger.info("Entering - performDeletePriceListLine(EnterpriseConnection connection, DeletePriceListLineInput deletePriceListLineInput) : "+deletePriceListLineInput);
		
		PriceBookOutput priceBookOutput = new PriceBookOutput();
		DeletePriceListLineOutput deletePriceListLineOutput = priceBookOutput.getDeletePriceListLineOutput();
		if(deletePriceListLineOutput == null){
			logger.info("deletePriceListLineOutput is null... Creating a new instance of it.");
			deletePriceListLineOutput = new DeletePriceListLineOutput();
			priceBookOutput.setDeletePriceListLineOutput(deletePriceListLineOutput);
		}
		
		String priceListId = deletePriceListLineInput.getPRICELISTID();
		logger.info("priceListId : "+priceListId);
		
		String []ids = new String[1];
		ids[0] = priceListId;
		
		DeleteResult []deleteResult = connection.delete(ids);
		if(deleteResult != null){
			for(int i = 0; i<deleteResult.length; i++){
				if(deleteResult[i].getId() != null){
					deletePriceListLineOutput.setId(deleteResult[i].getId());
				}else{
					deletePriceListLineOutput.setId("");
				}
				
				deletePriceListLineOutput.setSuccess(String.valueOf(deleteResult[i].getSuccess()));
				
				if(deleteResult[i].getErrors().length > 0){
					deletePriceListLineOutput.setErrors(deleteResult[i].getErrors()[0].getMessage());
				}else{
					deletePriceListLineOutput.setErrors(String.valueOf(false));
				}
			}
		}
		
		logger.info("Entering - performDeletePriceListLine(EnterpriseConnection connection, DeletePriceListLineInput deletePriceListLineInput) : priceBookOutput -  "+priceBookOutput);
		return priceBookOutput;
	}
}
