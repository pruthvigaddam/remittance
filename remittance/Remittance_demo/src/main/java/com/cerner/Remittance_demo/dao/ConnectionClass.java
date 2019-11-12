package com.cerner.Remittance_demo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connects to DataBase and return connection "con" value. getConnectionStatus()
 * helps to check the status of connection.
 * 
 * @author PG074553
 *
 */
public class ConnectionClass {
	private static final Logger LOGGER = Logger.getLogger(ConnectionClass.class.getName());

	/**
	 * @return connection con .
	 */
	public Connection getConnection() {
		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can Cause SQL Exception");
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@ipt18dvdb.ip.devcerner.net:1521:t18dv1", "v500",
					"v500");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception Occured" + e);
		}
		return con;

	}

	public boolean getConnectionStatus() {
		ConnectionClass cs = new ConnectionClass();
		if (cs.getConnection() != null) {
			return true;
		} else
			return false;
	}

}
