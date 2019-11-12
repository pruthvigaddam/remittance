package com.cerner.Remittance_demo.model;

import com.cerner.Remittance_demo.*;
import com.cerner.Remittance_demo.dao.ConnectionClass;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RequestExecuter class executes the queries and returns list of resultsets.
 * 
 * @author PG074553
 *
 */
public class RequestExecuter {
	private static final Logger LOGGER = Logger.getLogger(RequestExecuter.class.getName());

	/**
	 * getReplyList calls the getQueryResults Function and returns the arraylist of
	 * result sets.
	 * 
	 * @param remittanceid
	 * @param groupbyflag
	 * @param debitcreditgroupbyflag
	 * @return
	 */
	public ArrayList<ResultSet> getReplyList(String remittanceid, String groupbyflag, String debitcreditgroupbyflag) {

		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can cause null pointer and input mismatch exceptions");
		String remittanceId = remittanceid;
		String groupByFlag = groupbyflag;
		String debitcrediGroupByFlag = debitcreditgroupbyflag;
		String flg = "DEBIT";
		ArrayList<ResultSet> resultlist = new ArrayList<ResultSet>();
		QueryExecuter r = new QueryExecuter();
		int flagvalue = 0;
		if (flg.equals(debitcrediGroupByFlag.toUpperCase())) {
			flagvalue = 1;
		} else {
			flagvalue = 2;
		}
		resultlist = r.getQueryResults(flagvalue, remittanceId);
		return resultlist;

	}

	
}
