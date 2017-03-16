package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.ServiceMaxProductsOperationConstants;
import com.arris.sfdc.operation.provider.QueryAPCProvider;
import com.arris.sfdc.operation.provider.QueryProductClassProvider;
import com.arris.sfdc.operation.provider.QueryProductCodeProvider;
import com.arris.sfdc.operation.provider.QueryProductFamilyProvider;
import com.arris.sfdc.operation.provider.QueryProductLineProvider;
import com.arris.sfdc.operation.provider.QueryProductSBUProvider;
import com.arris.sfdc.operation.provider.QueryProductTechnologyProvider;
import com.arris.sfdc.pojo.QueryProductInput;
import com.arris.sfdc.pojo.QueryProductInput.QueryAPCInput;
import com.arris.sfdc.pojo.QueryProductInput.QueryProductClassInput;
import com.arris.sfdc.pojo.QueryProductInput.QueryProductCodeInput;
import com.arris.sfdc.pojo.QueryProductInput.QueryProductFamilyInput;
import com.arris.sfdc.pojo.QueryProductInput.QueryProductLineInput;
import com.arris.sfdc.pojo.QueryProductInput.QueryProductSBUInput;
import com.arris.sfdc.pojo.QueryProductInput.QueryProductTechnologyInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;

public class ServiceMaxProductsOperationServiceProvider {
	Logger logger = Logger.getLogger(ServiceMaxProductsOperationServiceProvider.class);
	
	public QueryProductOutput performProdcutOperation(QueryProductInput queryProductInput){
		logger.info("Entering - com.arris.sfdc.service.provider.ServiceMaxProductsOperationServiceProvider.performProdcutOperation(QueryProductInput) : "+queryProductInput);
		
		String operation = queryProductInput.getOperation().trim();
		logger.info("Operation : "+operation);
		
		QueryProductOutput queryProductOutput = new QueryProductOutput();
		
		if(operation != null){
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
				try{
					if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.QUERY_APC)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_APC condition Matched");
						
						QueryAPCInput queryAPCInput = queryProductInput.getQueryAPCInput();
						logger.info("queryAPCInput : "+queryAPCInput);
						
						if(queryAPCInput != null){
							queryProductOutput = QueryAPCProvider.queryAPC(connection, queryAPCInput);
						}
						logger.info("queryProductOutput : "+queryProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.QUERY_PRODUCT_SBU)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRODUCT_SBU condition Matched");
						
						QueryProductSBUInput queryProductSBUInput = queryProductInput.getQueryProductSBUInput();
						logger.info("queryProductSBUInput : "+queryProductSBUInput);
						
						if(queryProductSBUInput != null){
							queryProductOutput = QueryProductSBUProvider.queryProductSBU(connection, queryProductSBUInput);
						}
						logger.info("queryProductOutput : "+queryProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.QUERY_PRODUCT_TECHNOLOGY)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRODUCT_TECHNOLOGY condition Matched");
						
						QueryProductTechnologyInput queryProductTechnologyInput = queryProductInput.getQueryProductTechnologyInput();
						logger.info("queryProductTechnologyInput : "+queryProductTechnologyInput);
						
						if(queryProductTechnologyInput != null){
							queryProductOutput = QueryProductTechnologyProvider.queryProductTechnology(connection, queryProductTechnologyInput);
						}
						logger.info("queryProductOutput : "+queryProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.QUERY_PRODUCT_FAMILY)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRODUCT_FAMILY condition Matched");
						
						QueryProductFamilyInput queryProductFamilyInput = queryProductInput.getQueryProductFamilyInput();
						logger.info("queryProductFamilyInput : "+queryProductFamilyInput);
						
						if(queryProductFamilyInput != null){
							queryProductOutput = QueryProductFamilyProvider.queryProductFamily(connection, queryProductFamilyInput);
						}
						logger.info("queryProductOutput : "+queryProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.QUERY_PRODUCT_LINE)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRODUCT_LINE condition Matched");
						
						QueryProductLineInput queryProductLineInput = queryProductInput.getQueryProductLineInput();
						logger.info("queryProductLineInput : "+queryProductLineInput);
						
						if(queryProductLineInput != null){
							queryProductOutput = QueryProductLineProvider.queryProductLine(connection, queryProductLineInput);
						}
						logger.info("queryProductOutput : "+queryProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.QEURY_PRODUCT_CLASS)){
						logger.info("ServiceMaxPriceBookOperationConstants.QEURY_PRODUCT_CLASS condition Matched");
						
						QueryProductClassInput queryProductClassInput = queryProductInput.getQueryProductClassInput();
						logger.info("queryProductClassInput : "+queryProductClassInput);
						
						if(queryProductClassInput != null){
							queryProductOutput = QueryProductClassProvider.queryProductClass(connection, queryProductClassInput);
						}
						logger.info("queryProductOutput : "+queryProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.QUERY_PRODUCT_CODE)){
						logger.info("ServiceMaxPriceBookOperationConstants.QUERY_PRODUCT_CODE condition Matched");
						
						QueryProductCodeInput queryProductCodeInput = queryProductInput.getQueryProductCodeInput();
						logger.info("queryProductCodeInput : "+queryProductCodeInput);
						
						if(queryProductCodeInput != null){
							queryProductOutput = QueryProductCodeProvider.queryProductCode(connection, queryProductCodeInput);
						}
						logger.info("queryProductOutput : "+queryProductOutput);
					}
					
				}catch(Exception e){
					logger.error("Error in performing Operation : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		logger.info("Leaving - com.arris.sfdc.service.provider.ServiceMaxProductsOperationServiceProvider.performProdcutOperation(QueryProductInput) - queryProductOutput : "+queryProductOutput);
		return queryProductOutput;
	}
}
