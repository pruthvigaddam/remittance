package com.cerner.Remittance_demo.dao;

import com.cerner.Remittance_demo.model.*;
import com.cerner.Remittance_demo.dao.ConnectionClass;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;

/**
 * returns code values of requested code set and cdf_meaning.
 * 
 * @author PG074553
 *
 */
public class CodeValue {
	private static final Logger LOGGER = Logger.getLogger(CodeValue.class.getName());
	
	/**
	 * getCodeValue returns the code value of particular code set.
	 * 
	 * @param codeSet
	 * @param cdf_meaning
	 * @return code value.
	 */
	public float getCodeValue(float codeSet, String cdf_meaning) {
		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can Cause Exception");
		float codevalue = 0;
		try {
			ConnectionClass connectionClass = new ConnectionClass();
			Statement stmt = connectionClass.getConnection().createStatement();
			// Query to get code value for code set.
			ResultSet rs = stmt.executeQuery("select * from code_value where code_set = " + codeSet
					+ " and cdf_meaning = '" + cdf_meaning + "' ");
			while (rs.next()) {
				codevalue = rs.getFloat("code_value");
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception Occured" + e);
		}
		return codevalue;// returns code value.
	}

}
