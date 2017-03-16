package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryProductInput;
import com.arris.sfdc.pojo.QueryProductOutput;
import com.arris.sfdc.service.provider.ServiceMaxProductsOperationServiceProvider;

@Path("/operations")
public class ServiceMaxProductsOperationService {

	Logger logger = Logger.getLogger(ServiceMaxProductsOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response performProdcutOperation(QueryProductInput queryProductInput){
		logger.info("Entering - com.arris.sfdc.api.rest.ServiceMaxProductsOperationService.performProdcutOperation(QueryProductInput) : "+queryProductInput);
		
		ServiceMaxProductsOperationServiceProvider serviceMaxProductsOperationServiceProvider = new ServiceMaxProductsOperationServiceProvider();
		QueryProductOutput queryProductOutput = null;
		
		if(queryProductInput != null){
			queryProductOutput = serviceMaxProductsOperationServiceProvider.performProdcutOperation(queryProductInput);
		}
		
		logger.info("Leaving - com.arris.sfdc.api.rest.ServiceMaxProductsOperationService.performProdcutOperation(QueryProductInput) - queryProductOutput : "+queryProductOutput);
		return Response.status(200).entity(queryProductOutput).build();
	}
}
