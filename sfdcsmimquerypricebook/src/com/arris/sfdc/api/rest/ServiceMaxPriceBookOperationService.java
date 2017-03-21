package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.QueryPriceBookInput;
import com.arris.sfdc.pojo.QueryPriceBookOutput;
import com.arris.sfdc.service.provider.ServiceMaxPriceBookOperationServiceProvider;
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

@Path("/operations")
public class ServiceMaxPriceBookOperationService {

	Logger logger = Logger.getLogger(ServiceMaxPriceBookOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response performPriceBookOperation(QueryPriceBookInput queryPriceBookInput){
		logger.info("Entering - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.performPriceBookOperation(QueryPriceBookInput) : "+queryPriceBookInput);
		
		ServiceMaxPriceBookOperationServiceProvider serviceMaxPriceBookOperationServiceProvider = new ServiceMaxPriceBookOperationServiceProvider();
		QueryPriceBookOutput queryPriceBookOutput = null;
		
		if(queryPriceBookInput != null){
			try{
				queryPriceBookOutput = serviceMaxPriceBookOperationServiceProvider.performPriceBookOperation(queryPriceBookInput);
				logger.info("queryPriceBookOutput : "+queryPriceBookOutput);
				
			}catch(LoginFault e){
				logger.error("LoginFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(401).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(InvalidFieldFault e){
				logger.error("InvalidFieldFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(InvalidIdFault e){
				logger.error("InvalidIdFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(InvalidQueryLocatorFault e){
				logger.error("InvalidQueryLocatorFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(InvalidSObjectFault e){
				logger.error("InvalidSObjectFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(MalformedQueryFault e){
				logger.error("MalformedQueryFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(MalformedSearchFault e){
				logger.error("MalformedSearchFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(UnexpectedErrorFault e){
				logger.error("UnexpectedErrorFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(InvalidNewPasswordFault e){
				logger.error("InvalidNewPasswordFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(ApiQueryFault e){
				logger.error("ApiQueryFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(ApiFault e){
				logger.error("ApiFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(queryPriceBookOutput).build();
				
			}catch(SoapFaultException e){
				logger.error("SoapFaultException Exception : ERROR_CODE : "+e.getFaultCode()+", ERROR_MESSAGE : "+e.getMessage());
				return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getFaultCode()+", ERROR_MESSAGE : "+e.getMessage()).entity(queryPriceBookOutput).build();
				
			}catch(ConnectionException e){
				logger.error("ConnectionException Exception : ERROR_MESSAGE : "+e.getMessage());
				return Response.status(500).header("statusMessage", "ERROR_MESSAGE : "+e.getMessage()).entity(queryPriceBookOutput).build();
				
			}catch(Exception e) {
				logger.error("Exception : ERROR_MESSAGE : "+e.getMessage());
				return Response.status(500).header("statusMessage", "ERROR_MESSAGE : "+e.getMessage()).entity(queryPriceBookOutput).build();
				
			}
		}
		
		logger.info("Leaving - com.arris.sfdc.api.rest.ServiceMaxPriceBookOperationService.performPriceBookOperation(QueryPriceBookInput) - queryPriceBookOutput : "+queryPriceBookOutput);
		return Response.status(200).entity(queryPriceBookOutput).build();
	}
}
