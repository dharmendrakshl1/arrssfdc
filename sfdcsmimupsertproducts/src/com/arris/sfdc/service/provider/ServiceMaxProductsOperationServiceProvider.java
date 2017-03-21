package com.arris.sfdc.service.provider;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.ServiceMaxProductsOperationConstants;
import com.arris.sfdc.operation.provider.UpsertProductAPCProvider;
import com.arris.sfdc.operation.provider.UpsertProductClassProvider;
import com.arris.sfdc.operation.provider.UpsertProductCodeProvider;
import com.arris.sfdc.operation.provider.UpsertProductFamilyProvider;
import com.arris.sfdc.operation.provider.UpsertProductLineProvider;
import com.arris.sfdc.operation.provider.UpsertProductSBUProvider;
import com.arris.sfdc.operation.provider.UpsertProductTechnologyProvider;
import com.arris.sfdc.pojo.UpsertProductInput;
import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductAPCInput;
import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductClassInput;
import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductCodeInput;
import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductFamilyInput;
import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductLineInput;
import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductSBUInput;
import com.arris.sfdc.pojo.UpsertProductInput.UpsertProductTechnologyInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;

public class ServiceMaxProductsOperationServiceProvider {
	Logger logger = Logger.getLogger(ServiceMaxProductsOperationServiceProvider.class);
	
	public UpsertProductOutput performProdcutOperation(UpsertProductInput upsertProductInput) throws Exception {
		logger.info("Entering - com.arris.sfdc.service.provider.ServiceMaxProductsOperationServiceProvider.performProdcutOperation(UpsertProductInput) : "+upsertProductInput);
		
		String operation = upsertProductInput.getOperation().trim();
		logger.info("Operation : "+operation);
		
		UpsertProductOutput upsertProductOutput = new UpsertProductOutput();
		
		if(operation != null){
			try{
				EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
				if(connection != null){
				
					if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.UPSERT_PRODUCT_APC)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRODUCT_APC condition Matched");
						
						UpsertProductAPCInput upsertProductAPCInput = upsertProductInput.getUpsertProductAPCInput();
						logger.info("upsertProductAPCInput : "+upsertProductAPCInput);
						
						if(upsertProductAPCInput != null){
							upsertProductOutput = UpsertProductAPCProvider.upsertProductAPC(connection, upsertProductAPCInput);
						}
						logger.info("upsertProductOutput : "+upsertProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.UPSERT_PRODUCT_SBU)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRODUCT_SBU condition Matched");
						
						UpsertProductSBUInput upsertProductSBUInput = upsertProductInput.getUpsertProductSBUInput();
						logger.info("upsertProductSBUInput : "+upsertProductSBUInput);
						
						if(upsertProductSBUInput != null){
							upsertProductOutput = UpsertProductSBUProvider.upsertProductSBU(connection, upsertProductSBUInput);
						}
						logger.info("upsertProductOutput : "+upsertProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.UPSERT_PRODUCT_TECHNOLOGY)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRODUCT_TECHNOLOGY condition Matched");
						
						UpsertProductTechnologyInput upsertProductTechnologyInput = upsertProductInput.getUpsertProductTechnologyInput();
						logger.info("upsertProductTechnologyInput : "+upsertProductTechnologyInput);
						
						if(upsertProductTechnologyInput != null){
							upsertProductOutput = UpsertProductTechnologyProvider.upsertProductTechnology(connection, upsertProductTechnologyInput);
						}
						logger.info("upsertProductOutput : "+upsertProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.UPSERT_PRODUCT_FAMILY)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRODUCT_FAMILY condition Matched");
						
						UpsertProductFamilyInput upsertProductFamilyInput = upsertProductInput.getUpsertProductFamilyInput();
						logger.info("upsertProductFamilyInput : "+upsertProductFamilyInput);
						
						if(upsertProductFamilyInput != null){
							upsertProductOutput = UpsertProductFamilyProvider.upsertProductFamily(connection, upsertProductFamilyInput);
						}
						logger.info("upsertProductOutput : "+upsertProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.UPSERT_PRODUCT_LINE)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRODUCT_LINE condition Matched");
						
						UpsertProductLineInput upsertProductLineInput = upsertProductInput.getUpsertProductLineInput();
						logger.info("upsertProductLineInput : "+upsertProductLineInput);
						
						if(upsertProductLineInput != null){
							upsertProductOutput = UpsertProductLineProvider.upsertProductLine(connection, upsertProductLineInput);
						}
						logger.info("upsertProductOutput : "+upsertProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.UPSERT_PRODUCT_CLASS)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRODUCT_CLASS condition Matched");
						
						UpsertProductClassInput upsertProductClassInput = upsertProductInput.getUpsertProductClassInput();
						logger.info("upsertProductClassInput : "+upsertProductClassInput);
						
						if(upsertProductClassInput != null){
							upsertProductOutput = UpsertProductClassProvider.upsertProductClass(connection, upsertProductClassInput);
						}
						logger.info("upsertProductOutput : "+upsertProductOutput);
					}
					
					else if(operation.equalsIgnoreCase(ServiceMaxProductsOperationConstants.UPSERT_PRODUCT_CODE)){
						logger.info("ServiceMaxPriceBookOperationConstants.UPSERT_PRODUCT_CODE condition Matched");
						
						UpsertProductCodeInput upsertProductCodeInput = upsertProductInput.getUpsertProductCodeInput();
						logger.info("upsertProductCodeInput : "+upsertProductCodeInput);
						
						if(upsertProductCodeInput != null){
							upsertProductOutput = UpsertProductCodeProvider.upsertProductCode(connection, upsertProductCodeInput);
						}
						logger.info("upsertProductOutput : "+upsertProductOutput);
					}
					
				}
			}catch(Exception e){
				logger.error("Error in performing Operation : "+e.getMessage());
				e.printStackTrace();
				
				throw e;
			}
		}
		logger.info("Leaving - com.arris.sfdc.service.provider.ServiceMaxProductsOperationServiceProvider.performProdcutOperation(UpsertProductInput) - upsertProductOutput : "+upsertProductOutput);
		return upsertProductOutput;
	}
}
