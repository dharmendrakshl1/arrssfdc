package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputElement;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.service.provider.CurrencyTypeServiceProvider;

@Path("/currencyrateupdate")
public class CurrencyTypeService {
	
	Logger logger = Logger.getLogger(CurrencyTypeService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response updateCurrencyType(InputElement inputElement){
		logger.info("Entering - com.arris.sfdc.api.rest.CurrencyTypeService.updateCurrencyType(InputElement) : "+inputElement);
		OutputElement outputElement = null;
		CurrencyTypeServiceProvider currencyTypeSoapProvider = new CurrencyTypeServiceProvider();
		
		outputElement = currencyTypeSoapProvider.updateCurrencyType(inputElement);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.CurrencyTypeService.updateCurrencyType(InputElement) - outputElement : "+outputElement);
		return Response.status(200).entity(outputElement).build();
	}

}
