package com.arris.sfdc.service.provider;

import java.util.List;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputProjectAssignments;
import com.arris.sfdc.pojo.OutputProjectAssignments;
import com.arris.sfdc.pojo.OutputProjectAssignments.Results;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Pse__Proj__c;
import com.sforce.soap.enterprise.sobject.SObject;

public class PSAQueryServiceProvider {
	Logger logger = Logger.getLogger(PSAQueryServiceProvider.class);
	
	public OutputProjectAssignments psaQuery(InputProjectAssignments inputProjectAssignments) throws Exception {
		logger.info("Entering - com.arris.sfdc.service.provider.PSAQueryServiceProvider.psaQuery(InputProjectAssignments) : "+inputProjectAssignments);
		
		OutputProjectAssignments outputProjectAssignments = new OutputProjectAssignments();
		List<Results> listResults = outputProjectAssignments.getResults();
		
		try{
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
			
				QueryResult queryResult = connection.query("SELECT Name, PS_Project__c FROM pse__Proj__c WHERE pse__Stage__c IN ('Active', 'Cost Collection', 'Forecasted') AND PS_Project__c != null");
				if(queryResult != null){
					logger.info("queryResult Size : "+queryResult.getRecords().length);
					
					for(SObject records : queryResult.getRecords()){
						Pse__Proj__c pse__Proj__c = (Pse__Proj__c) records;
						
						Results rs = new Results();
						rs.setName(pse__Proj__c.getName());
						rs.setPSProjectC(pse__Proj__c.getPS_Project__c());
						
						logger.info("Results rs : "+rs);
						
						listResults.add(rs);
					}
				}
				
			}
		}catch(Exception e){
			logger.error("Error in Querying Object from pse__Proj__c Object : "+e.getMessage());
			e.printStackTrace();
			
			throw e;
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
		
		logger.info("Leaving - com.arris.sfdc.service.provider.PSAQueryServiceProvider.psaQuery(InputProjectAssignments) - outputProjectAssignments : "+outputProjectAssignments);
		return outputProjectAssignments;
	}
}
