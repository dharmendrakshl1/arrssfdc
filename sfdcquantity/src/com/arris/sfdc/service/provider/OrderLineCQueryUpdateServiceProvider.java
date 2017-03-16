package com.arris.sfdc.service.provider;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.constant.OrderLineCOperationConstants;
import com.arris.sfdc.pojo.LineDetails;
import com.arris.sfdc.pojo.LineDetails.Inputs;
import com.arris.sfdc.pojo.UpdateOutput;
import com.arris.sfdc.pojo.UpdateOutput.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Order_Line__c;
import com.sforce.soap.enterprise.sobject.SObject;

public class OrderLineCQueryUpdateServiceProvider {
	Logger logger = Logger.getLogger(OrderLineCQueryUpdateServiceProvider.class);
	
	public UpdateOutput orderLineCQureyOrUpdate(LineDetails lineDetails){
		logger.info("Entering - com.arris.sfdc.service.provider.OrderLineCQueryUpdateServiceProvider.orderLineCQureyOrUpdate(LineDetails) : "+lineDetails);
		
		UpdateOutput updateOutput = new UpdateOutput();
		List<Results> results = updateOutput.getResults();
		
		List<Inputs> listInputs = lineDetails.getInputs();
		logger.info("listInputs Size : "+listInputs.size());
				
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		if(connection != null){
			String operation = listInputs.get(0).getOperation().trim();
			logger.info("Operation = "+operation);
			
			//If Operation = Query 
			if(OrderLineCOperationConstants.ORDER_LINE_C_OPERATION_QUERY.equalsIgnoreCase(operation)){
				logger.info("Entering in Query Operation");
				try{
					Inputs inputs = listInputs.get(0);
					String external_id__c = inputs.getExternalIDC();
					logger.info("External_ID__c : "+external_id__c);
					
					if(external_id__c != null && external_id__c.length() > 0){
						QueryResult queryResult = connection.query("select Id from Order_Line__c where External_ID__c = '"+external_id__c+"'");
						if(queryResult != null){
							logger.info("queryResult size : "+queryResult.getRecords().length);
							
							for(SObject sObject : queryResult.getRecords()){
								Order_Line__c order_Line__c = (Order_Line__c) sObject;
								
								Results rs = new Results();
								rs.setId(order_Line__c.getId());
								rs.setErrors("");
								rs.setSuccess("");
								
								logger.info("Results rs : "+rs);
								
								results.add(rs);
							}
						}
					}
					
				}catch(Exception e){
					logger.error("Error in Reading Object from Order_Line__c Object : "+e.getMessage());
					e.printStackTrace();
				}
			}
			
			//If Operation = Update
			if(OrderLineCOperationConstants.ORDER_LINE_C_OPERATION_UPDATE.equalsIgnoreCase(operation)){
				logger.info("Entering in Update Operation");
				try{
					Order_Line__c records[] = new Order_Line__c[listInputs.size()];
					Iterator<Inputs> inputsIterator = listInputs.iterator();
					int i = 0;
					
					while(inputsIterator.hasNext()){
						Inputs inputs = inputsIterator.next();
					
						Order_Line__c order_Line__c = new Order_Line__c();
						
						order_Line__c.setExternal_ID__c(inputs.getExternalIDC());
						order_Line__c.setAvailable_Quantity__c(Double.parseDouble(inputs.getAvailableQuantityC()));
						order_Line__c.setId(inputs.getId());
						order_Line__c.setOnhand_Quantity__c(Double.parseDouble(inputs.getOnhandQuantityC()));
												
						records[i] = order_Line__c;
						i++;
					}
					
					logger.info("Order_Line__c Update Begins");
					SaveResult saveResult[] = connection.update(records);
					if(saveResult != null){
						for(int j=0; j < saveResult.length; j++){
							Results rs = new Results();
							
							if(saveResult[j].getId() != null){
								rs.setId(saveResult[j].getId());
							}else{
								rs.setId(listInputs.get(j).getId());
							}
							
							rs.setSuccess(String.valueOf(saveResult[j].getSuccess()));
							
							if(saveResult[j].getErrors().length > 0){
								rs.setErrors(saveResult[j].getErrors()[0].getMessage());
							}
							else{
								rs.setErrors(String.valueOf(false));
							}
							
							results.add(rs);
							
							logger.info("Results rs : "+rs);
						}
					}
				}catch(Exception e){
					logger.error("Error in Updating Object in Order_Line__c Object : "+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		logger.info("Leaving - com.arris.sfdc.service.provider.OrderLineCQueryUpdateServiceProvider.orderLineCQureyOrUpdate(LineDetails) - updateOutput : "+updateOutput);
		return updateOutput;
	}
}
