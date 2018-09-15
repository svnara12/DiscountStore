package com.shri.store;

import java.util.Date;

/**
 * Class representing an affiliate
 * 
 * @author SHRIDHAR
 *
 */
public class Affiliate extends Customer {
	
	/**
	 * Discount percentage for affiliate
	 */
	private static double DISCOUNT = 10.0;
	
	// Constructor
	public Affiliate(String name, Date from) {
		super(name, from);
	}
		
	/**
	 * get the discount percentage
	 */
	@Override
	public double getDiscount() {
		return DISCOUNT;
	}
}
