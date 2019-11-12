package com.cerner.Remittance_demo.model;

import com.cerner.Remittance_demo.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * ReturnDatevalue class returns the current date.
 * 
 * @author PG074553
 *
 */
public class ReturnDateValue {
	/**
	 * @return date value.
	 */
	public String getDateValue() {

		Calendar calobj = Calendar.getInstance();
		DateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
		String date = dateformat.format(calobj.getTime());
		return date;
	}
}
