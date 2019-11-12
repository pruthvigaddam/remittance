package com.cerner.Remittance_demo.model;

import com.cerner.Remittance_demo.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.*;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RequestReader class reads the json request, calls request executer and reply
 * the data.
 * 
 * @author PG074553
 *
 */
public class RequestReader {
	private static final Logger LOGGER = Logger.getLogger(RequestReader.class.getName());

	/**
	 * getResponse function reads the json request and returns reply to rest call.
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String getResponse(String request) throws Exception {

		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can cause null pointer and input mismatch exceptions");
		ArrayList<ResultSet> ListofResultSets = new ArrayList<ResultSet>();
		GenerateReply genreply = new GenerateReply();
		RequestExecuter reqexec = new RequestExecuter();
		String reply = "";
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(request);
		String remittanceid = (String) json.get("remittanceID");
		String groupbyflag = (String) json.get("groupByFlag");
		String debitCreditGroupByFlag = (String) json.get("debitCreditGroupByFlag");
		int remmitance=0;
		String checkgroupbyflag="";
		String checkdebitcredit="";
		try {
		     remmitance=Integer.parseInt(remittanceid);
		     checkgroupbyflag=groupbyflag.toUpperCase();
		     checkdebitcredit=debitCreditGroupByFlag.toUpperCase();
		}
		catch(Exception e){
			LOGGER.log(Level.SEVERE, "Conversion error:" + e);
		}
		
		if(remmitance<=0) {
			String s="Error:Enter valid Remittanceid";
	
			/*JSONObject ren = null;
			ren.put("ERROR", "Desclaimer:Enter valid values");
			return ren;*/
			return s;
		}
		else if(!(checkdebitcredit.equals("DEBIT")||checkdebitcredit.equals("CREDIT"))) {
			System.out.println(checkdebitcredit);
			String s="Error:Enter valid debit credit groupbyflag";
			return s;
		}
		else if(!(checkgroupbyflag.equals("GROUP_BY_PAYER"))) {
			System.out.println(checkgroupbyflag);
			String s="Error:Enter valid groupbyflag";
			return s;
		}
	
	
		
		
		else {
		try {
			ListofResultSets = reqexec.getReplyList(remittanceid, groupbyflag, debitCreditGroupByFlag);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception Occured:" + e);
		}
		
		reply = genreply.getReply(ListofResultSets);
	
		return reply;
	}
		}
	
}
