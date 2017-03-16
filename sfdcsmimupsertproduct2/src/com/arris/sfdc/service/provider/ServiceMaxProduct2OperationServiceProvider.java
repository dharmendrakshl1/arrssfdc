package com.arris.sfdc.service.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProduct2Input;
import com.arris.sfdc.pojo.UpsertProduct2Output;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Product2;

public class ServiceMaxProduct2OperationServiceProvider {
	Logger logger = Logger.getLogger(ServiceMaxProduct2OperationServiceProvider.class);
	
	public UpsertProduct2Output performProdcut2Operation(UpsertProduct2Input input){
		logger.info("Entering - com.arris.sfdc.service.provider.ServiceMaxProduct2OperationServiceProvider.performProdcutOperation(UpsertProduct2Input) : "+input);
		
		UpsertProduct2Output upsertProduct2Output = new UpsertProduct2Output();
		
		if(input != null){
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
				try{
					Product2 records[] = new Product2[1];
					
					Product2 record = new Product2();
					
					record.setAPC_Surcharge_Type__c(input.getAPCSurchargeTypeC());
					record.setBigMachines_Part_Number__c(input.getBigMachinesPartNumberC());
					
					String cumulativeLeadTimeC = input.getCumulativeLeadTimeC();
					if(cumulativeLeadTimeC != null && cumulativeLeadTimeC.length() != 0){
						record.setCumulative_Lead_Time__c(Double.valueOf(cumulativeLeadTimeC));
					}
					
					record.setDefault_Shipping_Org__c(input.getDefaultShippingOrgC());
					record.setDescription(input.getDescription());
					record.setDimensions_UOM__c(input.getDimensionsUOMC());
					record.setECCN__c(input.getECCNC());
					
					String frozenCostC = input.getFrozenCostC();
					if(frozenCostC != null && frozenCostC.length() != 0){
						record.setFrozen_Cost__c(Double.valueOf(frozenCostC));
					}
					
					String integrationInScopeC = input.getIntegrationInScopeC();
					if(integrationInScopeC != null && integrationInScopeC.length() != 0){
						record.setIntegration_In_Scope__c(Boolean.valueOf(integrationInScopeC));
					}
					
					String isActive = input.getIsActive();
					if(isActive != null && isActive.length() != 0){
						record.setIsActive(Boolean.valueOf(isActive));
					}
					
					String minSalePriceC = input.getMinSalePriceC();
					if(minSalePriceC != null && minSalePriceC.length() != 0){
						record.setMin_Sale_Price__c(Double.valueOf(minSalePriceC));
					}
					
					record.setModel__c(input.getModelC());
					record.setName(input.getName());
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String obsoleteDateC = input.getObsoleteDateC();
					if(obsoleteDateC != null && obsoleteDateC.length() > 0){
						sdf.parse(obsoleteDateC);
						record.setObsolete_Date__c(sdf.getCalendar());
					}
					
					record.setOracle_Item_Type__c(input.getOracleItemTypeC());
					record.setPH_APC__c(input.getPHAPCC());
					record.setPH_Class__c(input.getPHClassC());
					record.setPH_Family__c(input.getPHFamilyC());
					record.setPH_Line__c(input.getPHLineC());
					record.setPH_Product_Code__c(input.getPHProductCodeC());
					record.setPH_SBU__c(input.getPHSBUC());
					record.setPH_Technology__c(input.getPHTechnologyC());
					record.setProductCode(input.getProductCode());
					record.setSource_System__c(input.getSourceSystemC());
					record.setStatus__c(input.getStatusC());
					record.setUnit_Height__c(input.getUnitHeightC());
					record.setUnit_Length__c(input.getUnitLengthC());
					record.setUnit_Volume__c(input.getUnitVolumeC());
					record.setUnit_Width__c(input.getUnitWidthC());
					record.setUnit_of_Measure__c(input.getUnitOfMeasureC());
					record.setVolume_UOM__c(input.getVolumeUOMC());
					record.setWeight_UOM__c(input.getWeightUOMC());
					record.setWeight__c(input.getWeightC());
					
					String standardPackC = input.getStandardPackC();
					if(standardPackC != null && standardPackC.length() != 0){
						record.setStandard_pack__c(Double.valueOf(standardPackC));
					}
					
					records[0] = record;
					
					UpsertResult upsertResult[] = connection.upsert("BigMachines_Part_Number__c", records);
					if(upsertResult != null){
						for(int i = 0; i < upsertResult.length; i++){
							
							if(upsertResult[i].getId() != null){
								upsertProduct2Output.setId(upsertResult[i].getId());
							}else{
								upsertProduct2Output.setId("");
							}
							upsertProduct2Output.setSuccess(String.valueOf(upsertResult[i].getSuccess()));
							
							if(upsertResult[i].getErrors().length > 0){
								upsertProduct2Output.setErrors(upsertResult[i].getErrors()[0].getMessage());
							}else{
								upsertProduct2Output.setErrors(String.valueOf(false));
							}
							logger.info("upsertProduct2Output : "+upsertProduct2Output);
						}
					}
				}catch(NumberFormatException e){
					logger.error("Error in Converting to Number : "+e.getMessage());
					e.printStackTrace();
				}
				catch(ParseException e){
					logger.error("Error in Parsing : "+e.getMessage());
					e.printStackTrace();
				}catch(Exception e){
					logger.error("Error in performing Operation : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		logger.info("Leaving - com.arris.sfdc.service.provider.ServiceMaxProduct2OperationServiceProvider.performProdcutOperation(UpsertProduct2Input) - upsertProductOutput : "+upsertProduct2Output);
		return upsertProduct2Output;
	}
}
