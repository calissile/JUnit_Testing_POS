package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.USCurrency;

public class testUSCurrency {
	USCurrency uscurrency = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		uscurrency = new USCurrency();
	}
	
	@After
	public void tearDown() throws Exception {
		uscurrency = null;
	}

	
	@Test
	public void testshow(){
		String sign = "US$";
		Assert.assertEquals(sign, uscurrency.show());
		
	}
}
