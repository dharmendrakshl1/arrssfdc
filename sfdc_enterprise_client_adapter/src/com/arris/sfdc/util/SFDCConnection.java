package com.arris.sfdc.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PropertyResourceBundle;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
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
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.SoapFaultException;

public class SFDCConnection {
	private static EnterpriseConnection connection = null;
	private static ConnectorConfig config = null;
	private static PropertyResourceBundle bundle = null;
	private static String sessionId = null;
	private static String serviceEndpoint = null;
	
	private static Logger logger = Logger.getLogger(SFDCConnection.class);
	
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	public static synchronized EnterpriseConnection getEnterpriseConnection() throws Exception{
		logger.info("Entering - com.arris.sfdc.util.SFDCConnection.getEnterpriseConnection() ");
		try{
			bundle = InitProperty.getProperty("arrisSFDC.properties");
			
			sessionId = bundle.getString("session_id");
			logger.info("sessionID : "+sessionId);
			
			serviceEndpoint = bundle.getString("service_endpoint");
			logger.info("serviceEndpoint : "+serviceEndpoint);
			
			config = new ConnectorConfig();
			config.setSessionId(sessionId);
			config.setServiceEndpoint(serviceEndpoint);
			
			connection = Connector.newConnection(config);
			logger.info("Successfully Established connection with SFDC : "+connection);
			
			Date logginDateTime = connection.getServerTimestamp().getTimestamp().getTime();
			logger.info("logginDateTime : "+logginDateTime);
			System.out.println("logginDateTime : "+logginDateTime);
			
		}catch(UnexpectedErrorFault e){
			System.out.println("ERRRORORORORORR");
			
			logger.error("UnexpectedErrorFault Exception : Error Code : "+e.getExceptionCode()+", Exception Message : "+e.getExceptionMessage());
			config.setSessionId(null);
			
			String userName = bundle.getString("username");
			logger.info("User Name : "+userName);
			String password = bundle.getString("password");
			
			String authEndpoint = bundle.getString("auth_endpoint");
			logger.info("authEndpoint : "+authEndpoint);
			
			config.setUsername(userName);
			config.setPassword(password);
			config.setAuthEndpoint(authEndpoint);
			config.setServiceEndpoint(authEndpoint);
			
			connection = Connector.newConnection(config);
			logger.info("Successfully Established connection with SFDC : "+connection);
			logger.info("New Session ID : "+config.getSessionId());
			System.out.println("NEW SESSION ID : "+config.getSessionId());
			
			File file = new File(InitProperty.getPropertyFilePath("arrisSFDC.properties"));
			
			/*FileInputStream fis = new FileInputStream(file);
			Properties props = new Properties();
			props.load(fis);
			fis.close();
			
			FileOutputStream fos = new FileOutputStream(file);
			props.setProperty("session_id", config.getSessionId());
			props.store(fos, null);
			fos.close();*/
			
			Parameters parameters = new Parameters();
			FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
					.configure(parameters.properties().
							setFile(file)
							.setListDelimiterHandler(new DefaultListDelimiterHandler(',')));
							
			Configuration configuration = builder.getConfiguration();
			
			configuration.setProperty("session_id", config.getSessionId());
			
			String formatDate = df.format(connection.getServerTimestamp().getTimestamp().getTime());
			System.out.println("Formated Date : "+formatDate);
			configuration.setProperty("sessionID_generated_dateTime", formatDate);
			
			builder.save();
			
		}catch(Exception e){
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
			QueryResult results = conn.query("select Id from Account where id = '001a000001fOhq0AAC'");
			for(com.sforce.soap.enterprise.sobject.SObject record : results.getRecords()){
				Account account = (Account) record;
				System.out.println("ID : "+account.getId());
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
