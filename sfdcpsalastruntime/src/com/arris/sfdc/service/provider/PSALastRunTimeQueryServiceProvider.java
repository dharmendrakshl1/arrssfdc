package com.arris.sfdc.service.provider;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Load_File__c;
import com.sforce.soap.enterprise.sobject.SObject;

public class PSALastRunTimeQueryServiceProvider {
	Logger logger = Logger.getLogger(PSALastRunTimeQueryServiceProvider.class);
	
	public OutputElement psaLastRunTimeQuery(InputElement inputElement) throws Exception{
		logger.info("Entering - com.arris.sfdc.service.provider.PSALastRunTimeQueryServiceProvider.psaLastRunTimeQuery(InputElement) : "+inputElement);
		
		OutputElement outputElement = new OutputElement();
		
		try{
			EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
			if(connection != null){
			
				String name = inputElement.getName();
				logger.info("Name = "+name);
				QueryResult queryResult = connection.query("select Load_Time__c from Load_File__c where Name__c = '"+name+"' order by Load_Time__c desc limit 1");
				if(queryResult != null){
					logger.info("queryResult Size : "+queryResult.getRecords().length);
					
					for(SObject records : queryResult.getRecords()){
						Load_File__c load_File__c = (Load_File__c) records;
						
						Calendar calendar = load_File__c.getLoad_Time__c();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
						String formatedDate = sdf.format(calendar.getTime());
						logger.info("Load_Time__c = "+formatedDate);
						outputElement.setLoadTimeC(formatedDate);
					}
				}
				
			}
		}catch(Exception e){
			logger.error("Error in Querying Object from Load_File__c Object : "+e.getMessage());
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
		
		logger.info("Leaving - com.arris.sfdc.service.provider.PSALastRunTimeQueryServiceProvider.psaLastRunTimeQuery(InputElement) - outputElement : "+outputElement);
		return outputElement;
	}
}
