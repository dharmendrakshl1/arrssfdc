package com.arris.sfdc.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import com.arris.sfdc.service.provider.OperationalSalServiceProvider_QueryApproval;
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
import com.arris.sfdc.pojo.InputElement_QueryApproval;
import com.arris.sfdc.pojo.OutputElement_QueryApproval;

@Path("/operationalsalqueryapproval")

public class sfdcOperationalSalSerivce_QueryApproval {

	Logger logger = Logger.getLogger(sfdcOperationalSalSerivce_QueryApproval.class);

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response OperationalSalQueryFlex(InputElement_QueryApproval approvalInputElement) throws Exception {
		System.out.println("the first line of the code");
		logger.info(
				"Entering - com.arris.sfdc.api.rest.sfdcOperationalSalSerivce_QueryApproval.OperationalSalQueryFlex(InputElement approvalInputElement) : "
						+ approvalInputElement);
		OutputElement_QueryApproval approvalOutputElement = null;
		try{
		OperationalSalServiceProvider_QueryApproval SalAutomationServiceProvider2 = new OperationalSalServiceProvider_QueryApproval();
		approvalOutputElement = SalAutomationServiceProvider2.QueryApprovalOperationalSal(approvalInputElement);
		
		logger.info(
				"Leaving - com.arris.sfdc.api.rest.sfdcOperationalSalSerivce_QueryApproval.OperationalSalQueryFlex(approvalInputElement) - approvalapprovalOutputElement : "
						+ approvalOutputElement);
		return Response.status(401).entity(approvalOutputElement).build();
		}catch(LoginFault e){
			logger.error("LoginFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(401).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(InvalidFieldFault e){
			logger.error("InvalidFieldFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(InvalidIdFault e){
			logger.error("InvalidIdFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(InvalidQueryLocatorFault e){
			logger.error("InvalidQueryLocatorFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(InvalidSObjectFault e){
			logger.error("InvalidSObjectFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(MalformedQueryFault e){
			logger.error("MalformedQueryFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(MalformedSearchFault e){
			logger.error("MalformedSearchFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(UnexpectedErrorFault e){
			logger.error("UnexpectedErrorFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(InvalidNewPasswordFault e){
			logger.error("InvalidNewPasswordFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(ApiQueryFault e){
			logger.error("ApiQueryFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(ApiFault e){
			logger.error("ApiFault Error : ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getExceptionCode()+", ERROR_MESSAGE : "+e.getExceptionMessage()).entity(approvalOutputElement).build();
			
		}catch(SoapFaultException e){
			logger.error("SoapFaultException Exception : ERROR_CODE : "+e.getFaultCode()+", ERROR_MESSAGE : "+e.getMessage());
			return Response.status(500).header("statusMessage", "ERROR_CODE : "+e.getFaultCode()+", ERROR_MESSAGE : "+e.getMessage()).entity(approvalOutputElement).build();
			
		}catch(ConnectionException e){
			logger.error("ConnectionException Exception : ERROR_MESSAGE : "+e.getMessage());
			return Response.status(500).header("statusMessage", "ERROR_MESSAGE : "+e.getMessage()).entity(approvalOutputElement).build();
			
		}catch(Exception e) {
			logger.error("Exception : ERROR_MESSAGE : "+e.getMessage());
			return Response.status(500).header("statusMessage", "ERROR_MESSAGE : "+e.getMessage()).entity(approvalOutputElement).build();
			
		}
	}

}
