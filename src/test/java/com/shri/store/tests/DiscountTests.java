/**
 * 
 */
package com.shri.store.tests;

import com.shri.store.Affiliate;
import com.shri.store.Bill;
import com.shri.store.BillItem;
import com.shri.store.Customer;
import com.shri.store.Employee;
import com.shri.store.GroceryItem;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 * @author SHRIDHAR
 *
 */
public class DiscountTests {
	
	/**
	 * Tolerance for checking mearness
	 */
	private static double TOLERANCE = 0.5;
	
	/**
	 * Nearness checking method
	 * 
	 * @param a first value
	 * @param b second value
	 * @return booleam true iff near
	 */
	private boolean isNear(double a, double b) {
		return (
				((a - b) < TOLERANCE) && 
				((b - a) < TOLERANCE)
		);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * New customer, no grocery, total < $100
	 */
	@Test
	public void testNewPlainCutomerLowTotalNoDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer newCustomer = new Customer("Harish", new Date());
		Bill bill = new Bill(newCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $70
		assertTrue(isNear(discountedTotal, 70.0));
	}
	
	/**
	 * New customer, no grocery, total > $100
	 */
	@Test
	public void testNewPlainCutomerDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer newCustomer = new Customer("Harish", new Date());
		Bill bill = new Bill(newCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $135
		assertTrue(isNear(discountedTotal, 135.0));
	}
	
	/**
	 * Old customer, no grocery, total < $100
	 */
	@Test
	public void testOldPlainCutomerLowTotalDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date oldDate = null;
		try {
			oldDate = sdf.parse("05/01/1994");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Customer oldCustomer = new Customer("Harish", oldDate);
		Bill bill = new Bill(oldCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $67.5
		assertTrue(isNear(discountedTotal, 67.5));
	}
	
	/**
	 * Old customer, no grocery, total > $100
	 */
	@Test
	public void testOldPlainCutomerDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date oldDate = null;
		try {
			oldDate = sdf.parse("05/01/1994");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Customer oldCustomer = new Customer("Harish", oldDate);
		Bill bill = new Bill(oldCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $130
		assertTrue(isNear(discountedTotal, 130.0));
	}
	
	/**
	 * Employee, no grocery, total < $100
	 */
	@Test
	public void testEmployeeLowTotal() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Employee("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $55
		assertTrue(isNear(discountedTotal, 55.0));
	}
	
	/**
	 * Employee, no grocery, total > $100
	 */
	@Test
	public void testEmployeeHighTotalDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Employee("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $105
		assertTrue(isNear(discountedTotal, 105.0));
	}
	
	/**
	 * Affiliate, no grocery, total < $100
	 */
	@Test
	public void testAffiliateLowTotal() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Affiliate("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $65
		assertTrue(isNear(discountedTotal, 65.0));
	}
	
	/**
	 * Affiliate, no grocery, total > $100
	 */
	@Test
	public void testAffiliateHighTotalDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new BillItem("Computer", "Computer", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Affiliate("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $125
		assertTrue(isNear(discountedTotal, 125.0));
	}
	
	/**
	 * New customer, grocery, total < $100
	 */
	@Test
	public void testNewPlainCutomerLowTotalWithGroceryNoDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer newCustomer = new Customer("Harish", new Date());
		Bill bill = new Bill(newCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $70
		assertTrue(isNear(discountedTotal, 70.0));
	}
	
	/**
	 * New customer, grocery, total > $100
	 */
	@Test
	public void testNewPlainCutomerWithGroceryDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer newCustomer = new Customer("Harish", new Date());
		Bill bill = new Bill(newCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $135
		assertTrue(isNear(discountedTotal, 135.0));
	}
	
	/**
	 * Old customer, grocery, total < $100
	 */
	@Test
	public void testOldPlainCutomerLowTotalWithGroceryDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date oldDate = null;
		try {
			oldDate = sdf.parse("05/01/1994");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Customer oldCustomer = new Customer("Harish", oldDate);
		Bill bill = new Bill(oldCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $69
		assertTrue(isNear(discountedTotal, 69.0));
	}
	
	/**
	 * Old customer, grocery, total > $100
	 */
	@Test
	public void testOldPlainCutomerWithGroceryDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date oldDate = null;
		try {
			oldDate = sdf.parse("05/01/1994");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Customer oldCustomer = new Customer("Harish", oldDate);
		Bill bill = new Bill(oldCustomer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $133
		assertTrue(isNear(discountedTotal, 133.0));
	}
	
	/**
	 * Employee, grocery, total < $100
	 */
	@Test
	public void testEmployeeLowTotalWithGrocery() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Employee("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $64
		assertTrue(isNear(discountedTotal, 64.0));
	}
	
	/**
	 * Employee, grocery, total > $100
	 */
	@Test
	public void testEmployeeHighTotalWithGroceryDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Employee("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $123
		assertTrue(isNear(discountedTotal, 123.0));
	}
	
	/**
	 * Affiliate, grocery, total < $100
	 */
	@Test
	public void testAffiliateLowTotalWithGrocery() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 1);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 1);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Affiliate("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $70
		assertTrue(isNear(undiscountedTotal, 70.0));
		// Expect discounted total near to $68
		assertTrue(isNear(discountedTotal, 68.0));
	}
	
	/**
	 * Affiliate, grocery, total > $100
	 */
	@Test
	public void testAffiliateHighTotalWithGroceryDiscount() {
		BillItem i1 = new BillItem("Printer", "Printer", 20, 2);
		BillItem i2 = new GroceryItem("Corn", "Corn", 50, 2);
		List<BillItem> items = new ArrayList<BillItem>();
		items.add(i1);
		items.add(i2);
		Customer customer = new Affiliate("Harish", new Date());
		Bill bill = new Bill(customer, items);
		double undiscountedTotal = bill.getUndiscountedTotal();
		double discountedTotal = bill.getDiscountedTotal();
		
		// Expect undiscounted total near to $140
		assertTrue(isNear(undiscountedTotal, 140.0));
		// Expect discounted total near to $131
		assertTrue(isNear(discountedTotal, 131.0));
	}
}
