package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.UpsertDepts;
import com.arris.sfdc.pojo.UpsertOutput;
import com.arris.sfdc.service.provider.DepartmentFeedUpsertServiceProvider;

@Path("/departmentfeedupsert")
public class DepartmentFeedUpsertService {

	Logger logger = Logger.getLogger(DepartmentFeedUpsertService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response departmentFeedUpsert(UpsertDepts upsertDepts){
		logger.info("Entering - com.arris.sfdc.api.rest.DepartmentFeedUpsertService.departmentFeedUpsert(UpsertDepts) : "+upsertDepts);
		
		DepartmentFeedUpsertServiceProvider departmentFeedUpsertServiceProvider = new DepartmentFeedUpsertServiceProvider();
		UpsertOutput upsertOutput = null;
		
		upsertOutput = departmentFeedUpsertServiceProvider.departmentFeedUpsert(upsertDepts);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.DepartmentFeedUpsertService.departmentFeedUpsert(UpsertDepts) - upsertOutput : "+upsertOutput);
		return Response.status(200).entity(upsertOutput).build();
	}
}
