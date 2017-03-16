package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpdateDeptInput;
import com.arris.sfdc.pojo.UpdateOutput;
import com.arris.sfdc.service.provider.DepartmentFeedUpdateServiceProvider;

@Path("/departmentfeedupdate")
public class DepartmentFeedUpdateService {

	Logger logger = Logger.getLogger(DepartmentFeedUpdateService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response departmentFeedUpdate(UpdateDeptInput updateDeptInput){
		logger.info("Entering - com.arris.sfdc.api.rest.DepartmentFeedUpsertService.departmentFeedUpdate(UpdateDeptInput) : "+updateDeptInput);
		
		DepartmentFeedUpdateServiceProvider departmentFeedUpdateServiceProvider = new DepartmentFeedUpdateServiceProvider();
		UpdateOutput updateOutput = null;
		
		updateOutput = departmentFeedUpdateServiceProvider.departmentFeedUpdate(updateDeptInput);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.DepartmentFeedUpsertService.departmentFeedUpdate(UpdateDeptInput) - updateOutput : "+updateOutput);
		return Response.status(200).entity(updateOutput).build();
	}
}
