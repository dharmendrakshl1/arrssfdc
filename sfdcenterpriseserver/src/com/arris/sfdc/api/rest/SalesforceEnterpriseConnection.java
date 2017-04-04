package com.arris.sfdc.api.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.SessionBean;

@Path("/session")
public class SalesforceEnterpriseConnection {
	@Context ServletContext context;
	
	Logger logger = Logger.getLogger(SalesforceEnterpriseConnection.class);
	
	@Path("/get")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getSFDCSessionId(){
		logger.info("Entering - com.arris.sfdc.api.rest.SalesforceEnterpriseConnection.getSFDCSessionId()");
		String sessionId = null;
		
		sessionId = (String) context.getAttribute("session_id");
		logger.info("Session_ID : "+sessionId);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.SalesforceEnterpriseConnection.getSFDCSessionId()");
		return Response.status(200).entity(sessionId).build();
	}
	
	@Path("/store")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response storeSFDCSessionId(SessionBean sessionBean){
		logger.info("Entering - com.arris.sfdc.api.rest.SalesforceEnterpriseConnection.storeSFDCSessionId(String)");
		logger.info("New Session ID : "+sessionBean.getSessionId());
		logger.info("Generated Session DateTime : "+sessionBean.getSessionIdGeneratedDateTime());
		
		context.setAttribute("session_id", sessionBean.getSessionId());
		context.setAttribute("sessionID_generated_dateTime", sessionBean.getSessionIdGeneratedDateTime());
		
		logger.info("New Session Id stored in Application Context Variable");
		
		logger.info("Leaving - com.arris.sfdc.api.rest.SalesforceEnterpriseConnection.storeSFDCSessionId(String)");
		return Response.status(200).entity("Session Got Saved Successfully").build();
	}
}
