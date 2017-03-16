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
import com.arris.sfdc.service.provider.PSAInDirectExpensesCreateServiceProvider;

@Path("/psaindexpcreate")
public class PSAInDirectExpensesCreateService {

	Logger logger = Logger.getLogger(PSAInDirectExpensesCreateService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response psaInDirectExpensesCreate(InputElement inputElement){
		logger.info("Entering - com.arris.sfdc.api.rest.PSAInDirectExpensesCreateService.psaInDirectExpensesCreate(InputElement) : "+inputElement);
		
		PSAInDirectExpensesCreateServiceProvider psaInDirectExpensesCreateServiceProvider = new PSAInDirectExpensesCreateServiceProvider();
		OutputElement outputElement = null;
		
		outputElement = psaInDirectExpensesCreateServiceProvider.psaInDirectExpensesCreate(inputElement);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.PSAInDirectExpensesCreateService.psaInDirectExpensesCreate(InputElement) - outputElement : "+outputElement);
		return Response.status(200).entity(outputElement).build();
	}
}
