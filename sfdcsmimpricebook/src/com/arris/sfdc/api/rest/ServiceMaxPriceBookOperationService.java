package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.PriceBookInput;
import com.arris.sfdc.pojo.PriceBookOutput;
import com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider;

@Path("/operations")
public class ServiceMaxPriceBookOperationService {

	Logger logger = Logger.getLogger(ServiceMaxPriceBookOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response performPriceBookOperation(PriceBookInput priceBookInput){
		logger.info("Entering - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.performPriceBookOperation(PriceBookInput) : "+priceBookInput);
		
		ServiceMaxPriceBookOperationServiceProvider serviceMaxPriceBookOperationServiceProvider = new ServiceMaxPriceBookOperationServiceProvider();
		PriceBookOutput priceBookOutput = null;
		
		if(priceBookInput != null){
			priceBookOutput = serviceMaxPriceBookOperationServiceProvider.performPriceBookOperation(priceBookInput);
		}
		
		logger.info("Leaving - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.performPriceBookOperation(PriceBookInput) - priceBookOutput : "+priceBookOutput);
		return Response.status(200).entity(priceBookOutput).build();
	}
}
