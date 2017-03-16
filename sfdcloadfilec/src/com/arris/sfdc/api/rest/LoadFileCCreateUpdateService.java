package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.LoadFileCRequest;
import com.arris.sfdc.pojo.OutputElement;
import com.arris.sfdc.service.provider.LoadFileCCreateUpdateServiceProvider;

@Path("/loadfileccreateupdate")
public class LoadFileCCreateUpdateService {

	Logger logger = Logger.getLogger(LoadFileCCreateUpdateService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response loadFileCCreateOrUpdate(LoadFileCRequest loadFileCRequest){
		logger.info("Entering - com.arris.sfdc.api.rest.LoadFileCCreateUpdateService.loadFileCCreateOrUpdate(LoadFileCRequest) : "+loadFileCRequest);
		
		LoadFileCCreateUpdateServiceProvider loadFileCCreateUpdateServiceProvider = new LoadFileCCreateUpdateServiceProvider();
		OutputElement outputElement = null;
		
		outputElement = loadFileCCreateUpdateServiceProvider.loadFileCCreateOrUpdate(loadFileCRequest);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.LoadFileCCreateUpdateService.loadFileCCreateOrUpdate(LoadFileCRequest) - outputElement : "+outputElement);
		return Response.status(200).entity(outputElement).build();
	}
}
