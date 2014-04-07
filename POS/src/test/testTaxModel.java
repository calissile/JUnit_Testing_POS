package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.TaxModel;

public class testTaxModel {
	myTaxModel testtaxmodel = null;
	
	private class myTaxModel implements TaxModel{
		public myTaxModel(){
		}
		
		@Override
		public float afterTaxPrice(float myprice){
			return myprice;
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
		testtaxmodel = new myTaxModel();
	}

	@After
	public void tearDown() throws Exception {
		testtaxmodel = null;
	}	

	@Test
	public void testafterTaxPrice(){
		float price = 50.0f;
		Assert.assertEquals(price, testtaxmodel.afterTaxPrice(price), 0);
	}
	
}
