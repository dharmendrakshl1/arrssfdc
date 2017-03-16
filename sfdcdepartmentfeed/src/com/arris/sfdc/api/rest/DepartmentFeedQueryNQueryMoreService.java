package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryInput;
import com.arris.sfdc.pojo.QueryResult;
import com.arris.sfdc.service.provider.DepartmentFeedQueryNQueryMoreServiceProvider;

@Path("/departmentfeedquerynmore")
public class DepartmentFeedQueryNQueryMoreService {

	Logger logger = Logger.getLogger(DepartmentFeedQueryNQueryMoreService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response departmentFeedQueryNQueryMore(QueryInput queryInput){
		logger.info("Entering - com.arris.sfdc.api.rest.DepartmentFeedQueryNQueryMoreService.departmentFeedQueryNQuery(QueryInput) : "+queryInput);
		
		DepartmentFeedQueryNQueryMoreServiceProvider departmentFeedUpdateServiceProvider = new DepartmentFeedQueryNQueryMoreServiceProvider();
		QueryResult queryResult = null;
		
		queryResult = departmentFeedUpdateServiceProvider.departmentFeedQueryNQueryMore(queryInput);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.DepartmentFeedQueryNQueryMoreService.departmentFeedQueryNQuery(QueryInput) - queryResult : "+queryResult);
		return Response.status(200).entity(queryResult).build();
	}
}
