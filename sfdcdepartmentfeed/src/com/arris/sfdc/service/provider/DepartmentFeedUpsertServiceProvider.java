package com.arris.sfdc.service.provider;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertDepts;
import com.arris.sfdc.pojo.UpsertDepts.Inputs;
import com.arris.sfdc.pojo.UpsertOutput;
import com.arris.sfdc.pojo.UpsertOutput.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.UpsertResult;
import com.sforce.soap.enterprise.sobject.Departments__c;

public class DepartmentFeedUpsertServiceProvider {
	Logger logger = Logger.getLogger(DepartmentFeedUpsertServiceProvider.class);
	
	public UpsertOutput departmentFeedUpsert(UpsertDepts upsertDepts){
		logger.info("Entering - com.arris.sfdc.service.provider.DepartmentFeedUpsertServiceProvider.departmentFeedUpsert(UpsertDepts) : "+upsertDepts);
		
		UpsertOutput upsertOutput = new UpsertOutput();
		List<Results> results = upsertOutput.getResults();
				
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		if(connection != null){
			try{
				List<Inputs> inputsList = upsertDepts.getInputs();
				logger.info("inputList Size : "+inputsList.size());
				
				Departments__c []departments__c = new Departments__c[inputsList.size()];
				
				int i = 0;
				Iterator<Inputs> inputsIterator = inputsList.iterator();
				while(inputsIterator.hasNext()){
					Inputs inputs = inputsIterator.next();
					
					Departments__c deptc = new Departments__c();
					
					deptc.setDept__c(inputs.getDeptC());
					deptc.setName(inputs.getName());
					deptc.setDepartment_Description__c(inputs.getDepartmentDescriptionC());
					deptc.setDepartment_Entity__c(inputs.getDepartmentEntityC());
					deptc.setDepartment_BU__c(inputs.getDepartmentBUC());
					deptc.setAccounting_Code__c(inputs.getAccountingCodeC());
					deptc.setIsActive__c(Boolean.parseBoolean(inputs.getIsActiveC()));
					
					departments__c[i] = deptc;
					i++;
				}
				
				//Below code is to upsert in Departments__c Object
				if(departments__c.length > 0){
					UpsertResult upsertResult[] = connection.upsert("Dept__c", departments__c);
					if(upsertResult != null){
						for(int j = 0; j < upsertResult.length; j++){
							
							Results rs = new Results();
							
							if(upsertResult[j].getId() != null){
								rs.setId(upsertResult[j].getId());
							}else{
								rs.setId("");
							}
							rs.setSuccess(String.valueOf(upsertResult[j].getSuccess()));
							
							if(upsertResult[j].getErrors().length > 0){
								rs.setErrors(upsertResult[j].getErrors()[0].getMessage());
							}else{
								rs.setErrors(String.valueOf(false));
							}
							
							logger.info("Results rs : "+rs);
							
							results.add(rs);
						}
					}
				}
			}catch(Exception e){
				logger.error("Error in Upserting Object in Departments__c Object : "+e.getMessage());
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
		
		logger.info("Leaving - com.arris.sfdc.service.provider.DepartmentFeedUpsertServiceProvider.departmentFeedUpsert(UpsertDepts) - upsertOutput : "+upsertOutput);
		return upsertOutput;
	}
}
