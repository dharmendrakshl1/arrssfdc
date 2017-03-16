package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryPriceBookInput;
import com.arris.sfdc.pojo.QueryPriceBookOutput;
import com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider;

@Path("/operations")
public class ServiceMaxPriceBookOperationService {

	Logger logger = Logger.getLogger(ServiceMaxPriceBookOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response performPriceBookOperation(QueryPriceBookInput queryPriceBookInput){
		logger.info("Entering - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.performPriceBookOperation(QueryPriceBookInput) : "+queryPriceBookInput);
		
		ServiceMaxPriceBookOperationServiceProvider serviceMaxPriceBookOperationServiceProvider = new ServiceMaxPriceBookOperationServiceProvider();
		QueryPriceBookOutput queryPriceBookOutput = null;
		
		if(queryPriceBookInput != null){
			queryPriceBookOutput = serviceMaxPriceBookOperationServiceProvider.performPriceBookOperation(queryPriceBookInput);
		}
		
		logger.info("Leaving - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.performPriceBookOperation(QueryPriceBookInput) - queryPriceBookOutput : "+queryPriceBookOutput);
		return Response.status(200).entity(queryPriceBookOutput).build();
	}
}
