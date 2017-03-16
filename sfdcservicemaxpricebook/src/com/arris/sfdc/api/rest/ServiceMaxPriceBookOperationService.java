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

@Path("/pricebook")
public class ServiceMaxPriceBookOperationService {

	Logger logger = Logger.getLogger(ServiceMaxPriceBookOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response maxPriceBookOperation(PriceBookInput priceBookInput){
		logger.info("Entering - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.maxPriceBookOperation(PriceBookInput) : "+priceBookInput);
		
		ServiceMaxPriceBookOperationServiceProvider serviceMaxPriceBookOperationServiceProvider = new ServiceMaxPriceBookOperationServiceProvider();
		PriceBookOutput priceBookOutput = null;
		
		priceBookOutput = serviceMaxPriceBookOperationServiceProvider.maxPriceBookOperation(priceBookInput);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.maxPriceBookOperation(PriceBookInput) - priceBookOutput : "+priceBookOutput);
		return Response.status(200).entity(priceBookOutput).build();
	}
}
