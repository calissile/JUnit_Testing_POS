package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.TMNoTax;

public class testTMNoTax {
	TMNoTax tmnotax = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tmnotax = new TMNoTax();
	}

	@After
	public void tearDown() throws Exception {
		tmnotax = null;
	}


	@Test
	public void testafterTaxPrice(){
		float price = 50.0f;
		Assert.assertEquals(price, tmnotax.afterTaxPrice(price), 0);
		
	}
}
