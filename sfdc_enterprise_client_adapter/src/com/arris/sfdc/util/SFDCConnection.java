package com.arris.sfdc.util;

import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.fault.ApiFault;
import com.sforce.soap.enterprise.fault.ApiQueryFault;
import com.sforce.soap.enterprise.fault.FaultCode;
import com.sforce.soap.enterprise.fault.InvalidFieldFault;
import com.sforce.soap.enterprise.fault.InvalidIdFault;
import com.sforce.soap.enterprise.fault.InvalidNewPasswordFault;
import com.sforce.soap.enterprise.fault.InvalidQueryLocatorFault;
import com.sforce.soap.enterprise.fault.InvalidSObjectFault;
import com.sforce.soap.enterprise.fault.LoginFault;
import com.sforce.soap.enterprise.fault.MalformedQueryFault;
import com.sforce.soap.enterprise.fault.MalformedSearchFault;
import com.sforce.soap.enterprise.fault.UnexpectedErrorFault;
import com.sforce.soap.enterprise.sobject.Order_Staging__c;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.SoapFaultException;

public class SFDCConnection {
	private static EnterpriseConnection connection = null;
	private static ConnectorConfig config = null;
	private static PropertyResourceBundle bundle = null;
	
	private static Logger logger = Logger.getLogger(SFDCConnection.class);
	
	public static EnterpriseConnection getEnterpriseConnection() throws Exception{
		logger.info("Entering - com.arris.sfdc.util.SFDCConnection.getEnterpriseConnection() ");
		try{
			bundle = InitProperty.getProperty("arrisSFDC.properties");
			String userName = bundle.getString("username");
			logger.info("User Name : "+userName);
			String password = bundle.getString("password");
			
			config = new ConnectorConfig();
			config.setUsername(userName);
			config.setPassword(password);
			connection = Connector.newConnection(config);
			logger.info("Successfully Established connection with SFDC : "+connection);
		}
		catch(Exception e){
			connection = null;
			logger.error("Error in creating connection with SFDC : "+e);
			throw e;
		}
		
		logger.info("Leaving - com.arris.sfdc.util.SFDCConnection.getEnterpriseConnection() : Connection -  "+connection);
		return connection;
	}
	
	public static void main(String[] args) {
		EnterpriseConnection conn = null;
		try {
			conn = getEnterpriseConnection();
			QueryResult results = conn.query("select PO_Number__c, Interface_Status__c from Order_Staging__c");
			for(com.sforce.soap.enterprise.sobject.SObject record : results.getRecords()){
				Order_Staging__c lfc = (Order_Staging__c) record;
				System.out.println("PO_Number__c : "+lfc.getPO_Number__c());
				System.out.println("Interface_Status__c : "+lfc.getInterface_Status__c());
				System.out.println("=======================================================");
			}
		}catch(LoginFault e){
			System.out.println("LoginFault ....... : "+e.getExceptionMessage());
		}catch(InvalidFieldFault e){
			System.out.println("InvalidFieldFault ....... : "+e.getExceptionMessage());
		}catch(InvalidIdFault e){
			System.out.println("InvalidIdFault ....... : "+e.getExceptionMessage());
		}catch(InvalidQueryLocatorFault e){
			System.out.println("InvalidQueryLocatorFault ....... : "+e.getExceptionMessage());
		}catch(InvalidSObjectFault e){
			System.out.println("InvalidSObjectFault ....... : "+e.getExceptionMessage());
			System.out.println("Message Code : "+e.getExceptionCode());
			System.out.println("F COde : "+FaultCode.INVALID_TYPE.ordinal());
		}catch(MalformedQueryFault e){
			System.out.println("MalformedQueryFault ....... : "+e.getExceptionMessage());
		}catch(MalformedSearchFault e){
			System.out.println("MalformedSearchFault ....... : "+e.getExceptionMessage());
		}catch(UnexpectedErrorFault e){
			System.out.println("UnexpectedErrorFault ....... : "+e.getExceptionMessage());
		}catch(InvalidNewPasswordFault e){
			System.out.println("InvalidNewPasswordFault ....... : "+e.getExceptionMessage());
		}catch(ApiQueryFault e){
			System.out.println("ApiQueryFault ....... : "+e.getExceptionMessage());
		}catch(ApiFault e){
			System.out.println("ApiFault ....... : "+e.getExceptionMessage());
		}catch(SoapFaultException e){
			System.out.println("SoapFaultException ....... : "+e.getMessage());
		}catch(ConnectionException e){
			System.out.println("ConnectionException ....... : "+e.getMessage());
		}catch (Exception e) {
			System.out.println("Exception ....... : "+e.getMessage());
		}
	}
}
