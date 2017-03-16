package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.InputProjectAssignments;
import com.arris.sfdc.pojo.OutputProjectAssignments;
import com.arris.sfdc.service.provider.PSAQueryServiceProvider;

@Path("/psaquery")
public class PSAQueryService {

	Logger logger = Logger.getLogger(PSAQueryService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response psaQuery(InputProjectAssignments inputProjectAssignments){
		logger.info("Entering - com.arris.sfdc.api.rest.PSAQueryService.psaQuery(InputProjectAssignments) : "+inputProjectAssignments);
		
		PSAQueryServiceProvider psaQueryServiceProvider = new PSAQueryServiceProvider();
		OutputProjectAssignments outputProjectAssignments = null;
		
		outputProjectAssignments = psaQueryServiceProvider.psaQuery(inputProjectAssignments);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.PSAQueryService.psaQuery(InputProjectAssignments) - outputProjectAssignments : "+outputProjectAssignments);
		return Response.status(200).entity(outputProjectAssignments).build();
	}
}
