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
import com.arris.sfdc.service.provider.PSADirectExpensesCreateServiceProvider;

@Path("/psadexpcreate")
public class PSADirectExpensesCreateService {

	Logger logger = Logger.getLogger(PSADirectExpensesCreateService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response psaDirectExpensesCreate(InputElement inputElement){
		logger.info("Entering - com.arris.sfdc.api.rest.PSADirectExpensesCreateService.psaDirectExpensesCreate(InputElement) : "+inputElement);
		
		PSADirectExpensesCreateServiceProvider psaDirectExpensesCreateServiceProvider = new PSADirectExpensesCreateServiceProvider();
		OutputElement outputElement = null;
		
		outputElement = psaDirectExpensesCreateServiceProvider.psaDirectExpensesCreate(inputElement);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.PSADirectExpensesCreateService.psaDirectExpensesCreate(InputElement) - outputElement : "+outputElement);
		return Response.status(200).entity(outputElement).build();
	}
}
