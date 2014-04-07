package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.Currency;

public class testCurrency {
	
	myCurrency test = null;
	public static String mycurrency = "ABC";
	
	private class myCurrency extends Currency{
		public String thisCurrency = "ABC";
		public myCurrency(){
		}
		@Override
		public String show(){
			return thisCurrency;
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
		test = new myCurrency();
	}
	
	@After
	public void tearDown() throws Exception {
		test = null;
	}
	
	@Test
	public void testshow(){
		
		Assert.assertEquals(mycurrency, test.show());
	}
	
}
