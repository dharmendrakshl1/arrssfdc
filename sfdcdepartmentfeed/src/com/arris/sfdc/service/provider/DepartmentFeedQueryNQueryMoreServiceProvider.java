package com.arris.sfdc.service.provider;

import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryInput;
import com.arris.sfdc.pojo.QueryResult;
import com.arris.sfdc.pojo.QueryResult.DeptIDs;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.sobject.Departments__c;
import com.sforce.soap.enterprise.sobject.SObject;

public class DepartmentFeedQueryNQueryMoreServiceProvider {
	Logger logger = Logger.getLogger(DepartmentFeedQueryNQueryMoreServiceProvider.class);
	
	public QueryResult departmentFeedQueryNQueryMore(QueryInput queryInput){
		logger.info("Entering - com.arris.sfdc.service.provider.DepartmentFeedQueryNQueryMoreServiceProvider.departmentFeedQueryNQueryMore(QueryInput) : "+queryInput);
		
		QueryResult queryResultOutput = new QueryResult();
		List<DeptIDs> depIDsList = queryResultOutput.getDeptIDs();
		
		boolean done = false;
				
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		if(connection != null){
			try{
				String currentLoadDateTime = queryInput.getCurrentLoadDateTime();
				logger.info("currentLoadDateTime : "+currentLoadDateTime);
				
				com.sforce.soap.enterprise.QueryResult queryResult = connection.query("select Id from Departments__c "
						+ "where IsActive__c = true and LastModifiedDate < "+currentLoadDateTime);
				
				logger.info("queryResult Size : "+queryResult.getSize());
				logger.info("queryResult getRecords Size : "+queryResult.getRecords().length);
				if(queryResult.getSize() > 0){
					while(!done){
						for(SObject sObject : queryResult.getRecords()){
							Departments__c departments__c = (Departments__c) sObject;
							DeptIDs deptIDs = new DeptIDs();
							deptIDs.setId(departments__c.getId());
							
							logger.info("DeptIDs deptIDs : "+deptIDs);
							
							depIDsList.add(deptIDs);					
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
				
			}catch(Exception e){
				logger.error("Error in Querying Object in Departments__c Object : "+e.getMessage());
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
		logger.info("Results Size : "+depIDsList.size());
		logger.info("Leaving - com.arris.sfdc.service.provider.DepartmentFeedQueryNQueryMoreServiceProvider.departmentFeedQueryNQueryMore(QueryInput) - queryResultOutput : "+queryResultOutput);
		return queryResultOutput;
	}
}
