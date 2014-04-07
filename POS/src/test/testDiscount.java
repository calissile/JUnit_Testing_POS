package test;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.Discount;


public class testDiscount {
	float thisDiscount = 10.0f;
	String thisMessage = "Hello World";
	myClass tDiscount = null;
	
	public class myClass implements Discount{
		private float myDiscount = 10.0f;
		private String myMessage = "Hello World";
		
		@Override
		public float discount() {
			return myDiscount;
		}
		@Override
		public String discountMessage() {
			return myMessage;
		}
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tDiscount = new myClass();
	}
	
	@After
	public void tearDown() throws Exception {
		tDiscount = null;
	}

	@Test
	public void testdiscount(){
		Assert.assertEquals(thisDiscount, tDiscount.discount(),0);
	}
	
	@Test
	public void testdiscountMessage(){
		Assert.assertEquals(thisMessage, tDiscount.discountMessage());
	}
	
}
