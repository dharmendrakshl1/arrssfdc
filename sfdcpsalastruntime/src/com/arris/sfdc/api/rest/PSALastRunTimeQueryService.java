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
import com.arris.sfdc.service.provider.PSALastRunTimeQueryServiceProvider;

@Path("/lastruntimequery")
public class PSALastRunTimeQueryService {

	Logger logger = Logger.getLogger(PSALastRunTimeQueryService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response psaLastRunTimeQuery(InputElement inputElement){
		logger.info("Entering - com.arris.sfdc.api.rest.PSALastRunTimeQueryService.psaLastRunTimeQuery(InputElement inputElement) : "+inputElement);
		
		PSALastRunTimeQueryServiceProvider psaLastRunTimeQueryServiceProvider = new PSALastRunTimeQueryServiceProvider();
		OutputElement outputElement = null;
		
		outputElement = psaLastRunTimeQueryServiceProvider.psaLastRunTimeQuery(inputElement);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.PSALastRunTimeQueryService.psaLastRunTimeQuery(InputElement inputElement) - outputElement : "+outputElement);
		return Response.status(200).entity(outputElement).build();
	}
}
