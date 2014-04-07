package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.ProductDiscount;


public class testProductDiscount {
	ProductDiscount productdiscount = null;
	float myDiscount = 50.0f;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		productdiscount = new ProductDiscount(myDiscount);
	}
	
	@After
	public void tearDown() throws Exception {
		productdiscount = null;
	}
	
	@Test
	public void testdiscount(){
		Assert.assertEquals(myDiscount, productdiscount.discount(),0);
	}
	
	@Test
	public void testdiscountMessage(){
		String message = "\tProduct Discount: ";
		Assert.assertEquals(message, productdiscount.discountMessage());
	}
}
