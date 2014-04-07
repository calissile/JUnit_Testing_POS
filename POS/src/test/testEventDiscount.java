package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.EventDiscount;


public class testEventDiscount {
	EventDiscount eventdiscount = null;
	float discount = 0.01f;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		eventdiscount = new EventDiscount(discount);
	}
	
	@After
	public void tearDown() throws Exception {
		eventdiscount = null;
	}
	
	@Test
	public void testdiscount(){
		Assert.assertEquals(discount,eventdiscount.discount(),0);
	}
	
	@Test
	public void testdiscountmessage(){
		String message = "\tEvent Discount: " + discount*100 + "%" + "\n";
		Assert.assertEquals(message, eventdiscount.discountMessage());
	}
}
