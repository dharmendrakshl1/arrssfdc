package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.arris.sfdc.pojo.PartNumberInput;
import com.arris.sfdc.pojo.PartNumberOutput;
import com.arris.sfdc.service.provider.SMCustomerOperationServiceProvider;
import com.sforce.soap.enterprise.fault.ApiFault;
import com.sforce.soap.enterprise.fault.ApiQueryFault;
import com.sforce.soap.enterprise.fault.FaultCode;
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

@Path("/servicemastercustomerpartupsertoperation")
public class SMCustomerPartUpsertOperationService {

	Logger logger = Logger.getLogger(SMCustomerPartUpsertOperationService.class);
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response vmiOrderOperation(PartNumberInput customerUpsertInput){
		logger.info("Entering - com.arris.sfdc.api.rest.VMIOrderOperationService.vmiOrderOperation(OrderImportInput) : "+customerUpsertInput);
		
		SMCustomerOperationServiceProvider sMCustomerOperationServiceProvider = new SMCustomerOperationServiceProvider();
		PartNumberOutput customerUpsertOutput = null;
		try{
		customerUpsertOutput = sMCustomerOperationServiceProvider.smCustomerUpsertOperation(customerUpsertInput);
		
		logger.info("Leaving - com.arris.sfdc.api.rest.VMIOrderOperationService.vmiOrderOperation(OrderImportInput) - orderImportOutput : "+customerUpsertOutput);
		return Response.status(200).entity(customerUpsertOutput).build();
		}catch(LoginFault e){
			System.out.println("LoginFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(InvalidFieldFault e){
			System.out.println("InvalidFieldFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(InvalidIdFault e){
			System.out.println("InvalidIdFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(InvalidQueryLocatorFault e){
			System.out.println("InvalidQueryLocatorFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(InvalidSObjectFault e){
			System.out.println("InvalidSObjectFault ....... : "+e.getExceptionMessage());
			System.out.println("Message Code : "+e.getExceptionCode());
			System.out.println("F COde : "+FaultCode.INVALID_TYPE.ordinal());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(MalformedQueryFault e){
			System.out.println("MalformedQueryFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(MalformedSearchFault e){
			System.out.println("MalformedSearchFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(UnexpectedErrorFault e){
			System.out.println("UnexpectedErrorFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(InvalidNewPasswordFault e){
			System.out.println("InvalidNewPasswordFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(ApiQueryFault e){
			System.out.println("ApiQueryFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(ApiFault e){
			System.out.println("ApiFault ....... : "+e.getExceptionMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(SoapFaultException e){
			System.out.println("SoapFaultException ....... : "+e.getMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch(ConnectionException e){
			System.out.println("ConnectionException ....... : "+e.getMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}catch (Exception e) {
			System.out.println("Exception ....... : "+e.getMessage());
			return Response.status(401).entity(customerUpsertOutput).build();
		}
	}
}
