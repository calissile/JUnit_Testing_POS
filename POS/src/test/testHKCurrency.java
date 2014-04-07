package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.HKCurrency;

public class testHKCurrency {
	HKCurrency hkcurrency = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		hkcurrency = new HKCurrency();
	}
	
	@After
	public void tearDown() throws Exception {
		hkcurrency = null;
	}

	
	@Test
	public void testshow(){
		String sign = "HK$";
		Assert.assertEquals(sign, hkcurrency.show());
		
	}
}
