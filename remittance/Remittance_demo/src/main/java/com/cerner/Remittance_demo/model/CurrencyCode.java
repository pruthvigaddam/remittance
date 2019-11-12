package com.cerner.Remittance_demo.model;

import com.cerner.Remittance_demo.dao.ConnectionClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * returns currency code.
 * 
 * @author PG074553
 *
 */
public class CurrencyCode {

	private static final Logger LOGGER = Logger.getLogger(RequestReader.class.getName());

	/**
	 * getCurrencycode function returns currency code value.
	 * 
	 * @param r
	 * @return currency code Value.
	 * @throws Exception
	 */
	public int getCurrencycode(String r) throws Exception {
		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can cause SQLException and FileNotFoundException");
		int currencycode = 0;
		String querydata;
		int remittanceid = Integer.parseInt(r);
		PreparedStatement preparedStatement;
		ResultSet rs = null;

		try {
			ConnectionClass connectionClass = new ConnectionClass();
			Connection connection = connectionClass.getConnection();
			QueryReader qr = new QueryReader();
			querydata = qr.getQueryData(CodeSets.currencycode);
			preparedStatement = connection.prepareStatement(querydata);
			preparedStatement.setInt(1, remittanceid);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				currencycode = rs.getInt("Code");
			}

		} catch (SQLException e) {

			LOGGER.log(Level.SEVERE, "Exception Occured:" + e);
		}
		return currencycode;
	}

}
