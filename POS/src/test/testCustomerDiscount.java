package test;

import java.lang.reflect.Constructor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.CustomerDiscount;

public class testCustomerDiscount {
	CustomerDiscount customerdiscount = null;
	float discount;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// initiate reflection of private constructor of CustomerDiscount
	@Before
	public void setUp() throws Exception {
		discount = 50.0f;
		Constructor<CustomerDiscount> myclass = CustomerDiscount.class.getDeclaredConstructor(float.class);
		myclass.setAccessible(true);
		customerdiscount = myclass.newInstance(discount);
	}
	

	@After
	public void tearDown() throws Exception {
		customerdiscount = null;
		discount = 0;
	}
	
	@Test
	public void testdiscount(){
		Assert.assertEquals(discount,customerdiscount.discount(),0);
	}
	
	@Test
	public void testdiscountmessage(){
		String message = "\tMembership Discount: " + discount*100 + "%" + "\n";
		Assert.assertEquals(message, customerdiscount.discountMessage());
	}
}
