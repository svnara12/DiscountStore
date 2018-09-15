package com.shri.store;

import java.util.Date;

/**
 * Class representing an employee
 * 
 * @author SHRIDHAR
 *
 */
public class Employee extends Customer {
	
	/**
	 * Discount percentage for employee
	 */
	private static double DISCOUNT = 30.0;
	
	// Constructor
	public Employee(String name, Date from) {
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
