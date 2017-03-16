package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProductInput;
import com.arris.sfdc.pojo.UpsertProductOutput;
import com.arris.sfdc.service.provider.ServiceMaxProductsOperationServiceProvider;

@Path("/operations")
public class ServiceMaxProductsOperationService {

	Logger logger = Logger.getLogger(ServiceMaxProductsOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response performProdcutOperation(UpsertProductInput upsertProductInput){
		logger.info("Entering - com.arris.sfdc.api.rest.ServiceMaxProductsOperationService.performProdcutOperation(UpsertProductInput) : "+upsertProductInput);
		
		ServiceMaxProductsOperationServiceProvider serviceMaxProductsOperationServiceProvider = new ServiceMaxProductsOperationServiceProvider();
		UpsertProductOutput upsertProductOutput = null;
		
		if(upsertProductInput != null){
			upsertProductOutput = serviceMaxProductsOperationServiceProvider.performProdcutOperation(upsertProductInput);
		}
		
		logger.info("Leaving - com.arris.sfdc.api.rest.ServiceMaxProductsOperationService.performProdcutOperation(UpsertProductInput) - upsertProductOutput : "+upsertProductOutput);
		return Response.status(200).entity(upsertProductOutput).build();
	}
}
