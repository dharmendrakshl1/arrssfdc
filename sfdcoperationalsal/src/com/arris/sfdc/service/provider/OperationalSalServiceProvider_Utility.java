package com.arris.sfdc.service.provider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.ProcessResponse;
import com.arris.sfdc.util.SFDCConnection;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.GetServerTimestampResult;
import com.sforce.ws.ConnectionException;

public class OperationalSalServiceProvider_Utility {

	Logger logger = Logger.getLogger(OperationalSalServiceProvider_Utility.class);

	ProcessResponse updateOutputElement = new ProcessResponse();
	// List<Results> results = updateOutputElement.getResults();

	public ProcessResponse getUtility() throws Exception {
		try {
		// Below code is for to update in SFDC using connection
		EnterpriseConnection connection = SFDCConnection.getEnterpriseConnection();
		logger.info("connection = " + connection);
		

			GetServerTimestampResult result = connection.getServerTimestamp();
			
			Calendar calender = result.getTimestamp();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
			String formatedDate = sdf.format(calender.getTime());
			updateOutputElement.setResult(formatedDate);

		} catch (ConnectionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.info("Connection Exception :" + e1.getMessage());
			throw e1;
		}

		logger.info(
				"Leaving - com.arris.sfdc.soap.provider.CurrencyTypeSoapProvider.updateCurrencyType(CurrencyTypeInputElement) - updateOutputElement : "
						+ updateOutputElement);
		return updateOutputElement;
	}
}
