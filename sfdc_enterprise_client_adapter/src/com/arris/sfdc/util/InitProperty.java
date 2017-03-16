/**
 * 
 */
package com.arris.sfdc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;


/**
 * @author Dharmendra Kumar Kaushal
 *
 */
public class InitProperty {

	protected static final String SFDC_PROPERTIES_FILE = "arrisSFDC.properties";
	private static final String FILE_Path = "/opt/wm/tom/sfdcproperties";
	private static final Logger log = Logger.getLogger(InitProperty.class);

	public static PropertyResourceBundle getProperty(String propertyType) 
	{
		PropertyResourceBundle bundle = null;	
		try{
			
			//ClassLoader loader = InitProperty.class.getClassLoader();
			
			log.info("Loading SFDC Properties File : "+FILE_Path+"/"+ApplicationProperties.getInstance().getAppProperty(SFDC_PROPERTIES_FILE));
			
			//InputStream input = loader.getResourceAsStream(ApplicationProperties.getInstance().getAppProperty(propertyType));
			InputStream input = new FileInputStream(FILE_Path+"/"+ApplicationProperties.getInstance().getAppProperty(propertyType));  
			bundle = new PropertyResourceBundle(input);
		}
		catch(IOException e){
			System.out.println("Exception in loading SFDC Properties File : "+e.getMessage());
			log.error(e);
		}
	
	 return bundle;
	}
}

