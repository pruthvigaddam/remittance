package com.cerner.Remittance_demo.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * QueryReader helps to read the query from SQL files.
 * 
 * @author PG074553
 *
 */
public class QueryReader {
	private static final Logger LOGGER = Logger.getLogger(QueryReader.class.getName());

	/**
	 * @param filePath
	 * @return SQL query data.
	 */
	public String getQueryData(String filePath) {
		LOGGER.info("Logger Name: " + LOGGER.getName());
		LOGGER.warning("Can cause FileNotFound exception");
		String querycontent = "";
		try {
			querycontent = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "File not found" + e);
		}
		return querycontent;
	}
}
