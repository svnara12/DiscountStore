package com.shri.store;

import java.time.Period;
import java.util.Date;

/**
 * Class representing a customer
 * 
 * @author SHRIDHAR
 *
 */
public class Customer {
	/**
	 * Discount percentage for old customers
	 */
	private static double DISCOUNT = 5.0;
	
	/**
	 * Minimum number of years of customer
	 * relationship for discount
	 */
	private static double MIN_OLD = 2.0;
	
	/**
	 * Customer details
	 */
	private String name;
	
	/**
	 * Start date of relationship
	 */
	private Date from;
	
	// Constructor
	public Customer(String name, Date from) {
		super();
		this.name = name;
		this.from = from;
	}


	/**
	 * get the discount percentage
	 * @return double discount percentage
	 */
	public double getDiscount() {
		Date now = new Date(); // now
		// approx date check
		if ((now.getTime() - from.getTime())
				> MIN_OLD*1000*86400*365) {
			return DISCOUNT;
		}
		return 0.0;
	}
}
