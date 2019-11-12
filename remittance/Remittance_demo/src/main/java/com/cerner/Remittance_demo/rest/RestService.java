package com.cerner.Remittance_demo.rest;

import com.cerner.Remittance_demo.*;
import com.cerner.Remittance_demo.model.RequestReader;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

/**
 * Restservice class is the rest call for the application which takes request
 * and provides appropriate response.
 * 
 * @author PG074553
 *
 */
@Path("/")

public class RestService {
	private static final Logger LOGGER = Logger.getLogger(RestService.class.getName());

	@GET
	@Path("/request/{request}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getReply(@PathParam("request") String request) throws Exception {
		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can cause null pointer and input mismatch exceptions");
		String reply =null;
		try {
			RequestReader reqRead = new RequestReader();
			reply = reqRead.getResponse(request);

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception Occured:" + e);
		}
		return reply;

	}
	public static void main(String args[]) {
		RestService rs = new RestService();
		String response = null;
		try {
			response = rs.getReply(
					"{\"groupByFlag\":\"GROUP_BY_PAYER\",\"debitCreditGroupByFlag\":\"DEBIT\",\"remittanceID\":\"2450833\"}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(response);
	}
}
