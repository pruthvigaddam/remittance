package com.cerner.Remittance_demo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cerner.Remittance_demo.dao.ConnectionClass;

/**
 * @author PG074553
 * QueryExecuter class returns the list of result sets.
 *
 */
public class QueryExecuter {
	
	private static final Logger LOGGER = Logger.getLogger(RequestExecuter.class.getName());

	/**
	 * getqueryResults execute the queries and returns the results.
	 * 
	 * @param fld
	 * @param remittance
	 * @return list of resultsets
	 */
	public ArrayList<ResultSet> getQueryResults(int fld, String remittance) {

		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can cause null pointer and input mismatch exceptions");
		ResultSet resultsetforIME = null;
		ResultSet resultsetforselfpay = null;
		ResultSet resultsetforclient = null;
		ArrayList<ResultSet> ListofResultsets = new ArrayList<ResultSet>();
		int flagvalues = fld;
		int Remittance = Integer.parseInt(remittance);
		try {

			CodeSets cs = new CodeSets();
			ConnectionClass c = new ConnectionClass();
			Connection s = c.getConnection();
			PreparedStatement ps = null;
			PreparedStatement ps1 = null;
			PreparedStatement ps2 = null;
			QueryReader qr = new QueryReader();
			ReturnDateValue T = new ReturnDateValue();
			float Payment_cd = cs.getCS18649_PAYMENT();
			float adjustment_cd = cs.getCS18649_ADJUST();
			float ar_cd = cs.getCS18736_AR();
			float patient_cd = cs.getCS20849_PATIENT();
			float statement_inv = cs.getCS21849_INVOICE_CD();
			float client_cd = cs.getCS20849_CLIENT();
			float research_cd = cs.getCS20849_RESEARCH();
			float general_cd = cs.getCS20849_GENERAL();
			float nonar_glone = cs.getCS18736_NONAR_GLONLY_CD();
			float roletype = cs.getCS18936_CLIENT_CD();
			float IME_BILLING = cs.getCS4002034_IME_BILLING();
			float patient_stat = cs.getCS21849_STATEMENT_CD();
			float CS21749_HCFA_1450_CD = cs.getCS21749_HCFA_1450();
			float CS21749_HCFA_1500_CD = cs.getCS21749_HCFA_1500();
			String date = T.getDateValue();//
			float SELF_PAY = cs.getCS354_SELFPAY();
			String Query;
			Query = qr.getQueryData(CodeSets.groupbypayerbyIME);
			ps = s.prepareStatement(Query);
			ps.setDouble(1, Payment_cd);
			ps.setDouble(2, Payment_cd);
			ps.setDouble(3, adjustment_cd);
			ps.setDouble(4, adjustment_cd);
			ps.setFloat(5, CS21749_HCFA_1450_CD);
			ps.setFloat(6, CS21749_HCFA_1500_CD);
			ps.setString(7, date);
			ps.setString(8, date);
			ps.setFloat(9, SELF_PAY);
			ps.setInt(10, Remittance);
			ps.setInt(11, flagvalues);
			ps.setDouble(12, Payment_cd);
			ps.setDouble(13, Payment_cd);
			ps.setDouble(14, adjustment_cd);
			ps.setDouble(15, adjustment_cd);
			ps.setFloat(16, CS21749_HCFA_1450_CD);
			ps.setFloat(17, CS21749_HCFA_1500_CD);
			ps.setString(18, date);
			ps.setString(19, date);
			ps.setFloat(20, IME_BILLING);
			ps.setFloat(21, SELF_PAY);
			ps.setInt(22, Remittance);
			ps.setInt(23, flagvalues);
			resultsetforIME = ps.executeQuery();
			ListofResultsets.add(resultsetforIME);
			

			String Query1;
			Query1 = qr.getQueryData(CodeSets.groupbypayerbySelfPay);
			ps1 = s.prepareStatement(Query1);
			ps1.setDouble(1, Payment_cd);
			ps1.setDouble(2, Payment_cd);
			ps1.setDouble(3, adjustment_cd);
			ps1.setDouble(4, adjustment_cd);
			ps1.setDouble(5, patient_stat);
			ps1.setInt(6, Remittance);
			ps1.setInt(7, flagvalues);
			ps1.setDouble(8, Payment_cd);
			ps1.setDouble(9, Payment_cd);
			ps1.setDouble(10, adjustment_cd);
			ps1.setDouble(11, adjustment_cd);
			ps1.setInt(12, Remittance);
			ps1.setInt(13, flagvalues);
			ps1.setDouble(14, Payment_cd);
			ps1.setDouble(15, Payment_cd);
			ps1.setDouble(16, adjustment_cd);
			ps1.setDouble(17, adjustment_cd);
			ps1.setInt(18, Remittance);
			ps1.setInt(19, flagvalues);
			ps1.setDouble(20, Payment_cd);
			ps1.setDouble(21, Payment_cd);
			ps1.setDouble(22, adjustment_cd);
			ps1.setDouble(23, adjustment_cd);
			ps1.setDouble(24, ar_cd);
			ps1.setDouble(25, patient_cd);
			ps1.setInt(26, Remittance);
			ps1.setInt(27, flagvalues);
			ps1.setDouble(28, Payment_cd);
			ps1.setDouble(29, Payment_cd);
			ps1.setDouble(30, adjustment_cd);
			ps1.setDouble(31, adjustment_cd);
			ps1.setInt(32, Remittance);
			ps1.setInt(33, flagvalues);
			resultsetforselfpay = ps1.executeQuery();
			ListofResultsets.add(resultsetforselfpay);

			String Query2;
			Query2 = qr.getQueryData(CodeSets.groupbypayerbyClientResearch);
			ps2 = s.prepareStatement(Query2);
			ps2.setDouble(1, Payment_cd);
			ps2.setDouble(2, Payment_cd);
			ps2.setDouble(3, adjustment_cd);
			ps2.setDouble(4, adjustment_cd);
			ps2.setDouble(5, ar_cd);
			ps2.setDouble(6, client_cd);
			ps2.setDouble(7, research_cd);
			ps2.setInt(8, Remittance);
			ps2.setInt(9, flagvalues);
			ps2.setDouble(10, Payment_cd);
			ps2.setDouble(11, Payment_cd);
			ps2.setDouble(12, adjustment_cd);
			ps2.setDouble(13, adjustment_cd);
			ps2.setDouble(14, ar_cd);
			ps2.setDouble(15, general_cd);
			ps2.setDouble(16, nonar_glone);
			ps2.setInt(17, Remittance);
			ps2.setInt(18, flagvalues);
			ps2.setDouble(19, Payment_cd);
			ps2.setDouble(20, Payment_cd);
			ps2.setDouble(21, adjustment_cd);
			ps2.setDouble(22, adjustment_cd);
			ps2.setDouble(23, statement_inv);
			ps2.setString(24, date);
			ps2.setString(25, date);
			ps2.setDouble(26, ar_cd);
			ps2.setDouble(27, client_cd);
			ps2.setDouble(28, research_cd);
			ps2.setDouble(29, roletype);
			ps2.setInt(30, Remittance);
			ps2.setInt(31, flagvalues);
			resultsetforclient = ps2.executeQuery();
			ListofResultsets.add(resultsetforclient);

		}

		catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception Occured:" + e);
		}
		return ListofResultsets;

	}


}
