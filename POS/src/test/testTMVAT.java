package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.TMVAT;


public class testTMVAT {
	TMVAT tmvat = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tmvat = new TMVAT();
	}

	@After
	public void tearDown() throws Exception {
		tmvat = null;
	}


	@Test
	public void testafterTaxPrice(){
		float price = 50.0f;
		Assert.assertEquals(price, tmvat.afterTaxPrice(price), 0);
		
	}
}
