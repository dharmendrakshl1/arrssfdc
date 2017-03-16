package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.LineDetails;
import com.arris.sfdc.pojo.UpdateOutput;
import com.arris.sfdc.service.provider.OrderLineCQueryUpdateServiceProvider;

@Path("/orderlinecqueryupdate")
public class OrderLineCQueryUpdateService {

	Logger logger = Logger.getLogger(OrderLineCQueryUpdateService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response orderLineCQureyOrUpdate(LineDetails lineDetails){
		logger.info("Entering - com.arris.sfdc.api.rest.OrderLineCQueryUpdateService.orderLineCQureyOrUpdate(LineDetails) : "+lineDetails);
		
		OrderLineCQueryUpdateServiceProvider cQueryUpdateServiceProvider = new OrderLineCQueryUpdateServiceProvider();
		UpdateOutput updateOutput = null;
		
		updateOutput = cQueryUpdateServiceProvider.orderLineCQureyOrUpdate(lineDetails);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.OrderLineCQueryUpdateService.orderLineCQureyOrUpdate(LineDetails) - updateOutput : "+updateOutput);
		return Response.status(200).entity(updateOutput).build();
	}
}
