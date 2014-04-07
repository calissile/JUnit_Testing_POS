package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.Payment;

public class testPayment {
	float discount = 0.05f;
	Payment payment = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		payment = new Payment();
	}
	
	@After
	public void tearDown() throws Exception {
		payment = null;
	}
	
	@Test
	public void testaddDiscount(){
		
	}
	
	@Test
	public void testafterDiscount(){
		
	}
	
	@Test
	public void testshowDiscount(){
		
	}
}
