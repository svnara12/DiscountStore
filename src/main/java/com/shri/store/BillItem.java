/**
 * 
 */
package com.shri.store;

/**
 * Class reepresenting an item billed
 * 
 * @author SHRIDHAR
 *
 */
public class BillItem {
	
	private String name;
	private String description;
	private double rate;
	private double quantity;
	
	// Constructor
	public BillItem(String name, String description, double rate, double quantity) {
		super();
		this.name = name;
		this.description = description;
		this.rate = rate;
		this.quantity = quantity;
	}

	// Getters and setters
	
	public double getRate() {
		return rate;
	}

	public double getQuantity() {
		return quantity;
	}
}
