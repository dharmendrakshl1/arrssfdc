package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertProduct2Input;
import com.arris.sfdc.pojo.UpsertProduct2Output;
import com.arris.sfdc.service.provider.ServiceMaxProduct2OperationServiceProvider;

@Path("/operations")
public class ServiceMaxProduct2OperationService {

	Logger logger = Logger.getLogger(ServiceMaxProduct2OperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response performProdcutOperation(UpsertProduct2Input upsertProduct2Input){
		logger.info("Entering - com.arris.sfdc.api.rest.ServiceMaxProduct2OperationService.performProdcutOperation(UpsertProductInput) : "+upsertProduct2Input);
		
		ServiceMaxProduct2OperationServiceProvider serviceMaxProduct2OperationServiceProvider = new ServiceMaxProduct2OperationServiceProvider();
		UpsertProduct2Output upsertProduct2Output = null;
		
		if(upsertProduct2Input != null){
			upsertProduct2Output = serviceMaxProduct2OperationServiceProvider.performProdcut2Operation(upsertProduct2Input);
		}
		
		logger.info("Leaving - com.arris.sfdc.api.rest.ServiceMaxProduct2OperationService.performProdcutOperation(UpsertProductInput) - upsertProduct2Output : "+upsertProduct2Output);
		return Response.status(200).entity(upsertProduct2Output).build();
	}
}
