/**
 * 
 */
package com.shri.store;

import java.util.List;

/**
 * Class representing a bill
 * 
 * @author SHRIDHAR
 *
 */
public class Bill {
	
	private static double DISCOUNT_PER_100 = 5.0;
	
	/**
	 * Who is this bill for?
	 */
	private Customer customer;
	
	/**
	 *  What are the items?
	 */
	private List<BillItem> items;

	// Constructor
	public Bill(Customer customer, List<BillItem> items) {
		super();
		this.customer = customer;
		this.items = items;
	}

	
	/**
	 * Method to get the bill total without any discount
	 * @return double undiscounted total
	 */
	public double getUndiscountedTotal() {
		double sum = 0.0;
		
		for (BillItem item : items) {
			sum += item.getQuantity() * item.getRate();
		}
		
		return sum;
	}
	
	/**
	 * Method to get the bill total WITH
	 * all discounts
	 * @return double discounted total
	 */
	public double getDiscountedTotal() {
		double sum = 0.0;
		
		/**
		 * Maximum cost of a non-grocery item
		 */
		double maxNonGroceryCost = 0.0;
		
		for (BillItem item : items) {
			double cost = item.getQuantity() * item.getRate(); 
			sum += cost;
			
			if (!(item instanceof GroceryItem)
					&& (maxNonGroceryCost < cost)) {
				maxNonGroceryCost = cost;
			}
		}
		
		// apply discount on total cost for every $100
		sum -= ((int)sum/100)*DISCOUNT_PER_100;
		
		// apply non grocery cost discount
		sum -= maxNonGroceryCost *
				customer.getDiscount() / 100.0;
		
		return sum;
	}
}
