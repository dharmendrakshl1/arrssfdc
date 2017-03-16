package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.OrderImportInput;
import com.arris.sfdc.pojo.OrderImportOutput;
import com.arris.sfdc.service.provider.VMIOrderOperationServiceProvider;

@Path("/orderimport")
public class VMIOrderOperationService {

	Logger logger = Logger.getLogger(VMIOrderOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response vmiOrderOperation(OrderImportInput orderImportInput){
		logger.info("Entering - com.arris.sfdc.api.rest.VMIOrderOperationService.vmiOrderOperation(OrderImportInput) : "+orderImportInput);
		
		VMIOrderOperationServiceProvider vMIOrderOperationServiceProvider = new VMIOrderOperationServiceProvider();
		OrderImportOutput orderImportOutput = null;
		
		orderImportOutput = vMIOrderOperationServiceProvider.vmiOrderOperation(orderImportInput);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.VMIOrderOperationService.vmiOrderOperation(OrderImportInput) - orderImportOutput : "+orderImportOutput);
		return Response.status(200).entity(orderImportOutput).build();
	}
}
