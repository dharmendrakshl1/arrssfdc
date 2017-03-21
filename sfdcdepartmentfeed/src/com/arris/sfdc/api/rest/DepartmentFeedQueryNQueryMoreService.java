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
import com.sforce.soap.enterprise.fault.ApiFault;
import com.sforce.soap.enterprise.fault.ApiQueryFault;
import com.sforce.soap.enterprise.fault.InvalidFieldFault;
import com.sforce.soap.enterprise.fault.InvalidIdFault;
import com.sforce.soap.enterprise.fault.InvalidNewPasswordFault;
import com.sforce.soap.enterprise.fault.InvalidQueryLocatorFault;
import com.sforce.soap.enterprise.fault.InvalidSObjectFault;
import com.sforce.soap.enterprise.fault.LoginFault;
import com.sforce.soap.enterprise.fault.MalformedQueryFault;
import com.sforce.soap.enterprise.fault.MalformedSearchFault;
import com.sforce.soap.enterprise.fault.UnexpectedErrorFault;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.SoapFaultException;

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
		
		if(queryInput != null){
			try{
				queryResult = departmentFeedUpdateServiceProvider.departmentFeedQueryNQueryMore(queryInput);
				logger.info("queryResult : "+queryResult);
				
			}catch(LoginFault e){
				logger.error("LoginFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(401).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(InvalidFieldFault e){
				logger.error("InvalidFieldFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(InvalidIdFault e){
				logger.error("InvalidIdFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(InvalidQueryLocatorFault e){
				logger.error("InvalidQueryLocatorFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(InvalidSObjectFault e){
				logger.error("InvalidSObjectFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(MalformedQueryFault e){
				logger.error("MalformedQueryFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(MalformedSearchFault e){
				logger.error("MalformedSearchFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(UnexpectedErrorFault e){
				logger.error("UnexpectedErrorFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(InvalidNewPasswordFault e){
				logger.error("InvalidNewPasswordFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(ApiQueryFault e){
				logger.error("ApiQueryFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(ApiFault e){
				logger.error("ApiFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryResult).build();
				
			}catch(SoapFaultException e){
				logger.error("SoapFaultException Exception : ERROR_CODE : "+e.getFaultCode()+", ERROR_MESSAGE : "+e.getMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getFaultCode()+", ERROR_MESSAGE : "+e.getMessage()).entity(queryResult).build();
				
			}catch(ConnectionException e){
				logger.error("ConnectionException Exception : ERROR_MESSAGE : "+e.getMessage());
				return Response.status(500).header("statusMessage", "ERROR_MESSAGE : "+e.getMessage()).entity(queryResult).build();
				
			}catch(Exception e) {
				logger.error("Exception : ERROR_MESSAGE : "+e.getMessage());
				return Response.status(500).header("statusMessage", "ERROR_MESSAGE : "+e.getMessage()).entity(queryResult).build();
				
			}
		}
		
		logger.info("Leaving - com.arris.sfdc.api.rest.DepartmentFeedQueryNQueryMoreService.departmentFeedQueryNQuery(QueryInput) - queryResult : "+queryResult);
		return Response.status(200).entity(queryResult).build();
	}
}
