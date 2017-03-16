package com.arris.sfdc.service.provider;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpdateDeptInput;
import com.arris.sfdc.pojo.UpdateOutput;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Departments__c;

public class DepartmentFeedUpdateServiceProvider {
	Logger logger = Logger.getLogger(DepartmentFeedUpdateServiceProvider.class);
	
	public UpdateOutput departmentFeedUpdate(UpdateDeptInput updateDeptInput){
		logger.info("Entering - com.arris.sfdc.service.provider.DepartmentFeedUpdateServiceProvider.departmentFeedUpdate(UpdateDeptInput) : "+updateDeptInput);
		
		UpdateOutput updateOutput = new UpdateOutput();
		List<com.arris.sfdc.pojo.UpdateOutput.Results> results = updateOutput.getResults();
				
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		if(connection != null){
			try{
				List<com.arris.sfdc.pojo.UpdateDeptInput.Inputs> inputsList = updateDeptInput.getInputs();
				logger.info("inputList Size : "+inputsList.size());
				
				Departments__c []departments__c = new Departments__c[inputsList.size()];
				
				int i = 0;
				Iterator<com.arris.sfdc.pojo.UpdateDeptInput.Inputs> inputsIterator = inputsList.iterator();
				while(inputsIterator.hasNext()){
					com.arris.sfdc.pojo.UpdateDeptInput.Inputs inputs = inputsIterator.next();
					
					Departments__c deptc = new Departments__c();
					
					deptc.setId(inputs.getId());
					deptc.setIsActive__c(Boolean.parseBoolean(inputs.getIsActiveC()));
					
					departments__c[i] = deptc;
					i++;
				}
				
				//Below code is to Update in Departments__c Object
				if(departments__c.length > 0){
					SaveResult saveResult[] = connection.update(departments__c);
					if(saveResult != null){
						for(int j = 0; j < saveResult.length; j++){
							
							com.arris.sfdc.pojo.UpdateOutput.Results rs = new com.arris.sfdc.pojo.UpdateOutput.Results();
							
							if(saveResult[j].getId() != null){
								rs.setId(saveResult[j].getId());
							}else{
								rs.setId(inputsList.get(j).getId());
							}
							rs.setSuccess(String.valueOf(saveResult[j].getSuccess()));
							
							if(saveResult[j].getErrors().length > 0){
								rs.setErrors(saveResult[j].getErrors()[0].getMessage());
							}else{
								rs.setErrors(String.valueOf(false));
							}
							
							logger.info("Results rs : "+rs);
							
							results.add(rs);
						}
					}
				}
			}catch(Exception e){
				logger.error("Error in Updating Object in Departments__c Object : "+e.getMessage());
				e.printStackTrace();
			}/*finally{
				if(connection != null){
					try {
						logger.info("Session Logging Out... ");
						connection.logout();
						logger.info("connection : "+connection);
					} catch (ConnectionException e) {
						logger.error("Error in Releaseing Connection : "+e.getMessage());
						e.printStackTrace();
					}
				}
			}*/
		}
		
		logger.info("Leaving - com.arris.sfdc.service.provider.DepartmentFeedUpdateServiceProvider.departmentFeedUpdate(UpdateDeptInput) - updateOutput : "+updateOutput);
		return updateOutput;
	}
}
