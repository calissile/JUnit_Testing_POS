package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.CompositeDiscount;
import POS.ProductDiscount;



public class testCompositeDiscount {
	CompositeDiscount compositediscount;
	ProductDiscount discount1;
	ProductDiscount discount2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		compositediscount = new CompositeDiscount();
		discount1 = new ProductDiscount(0.2f);
		discount2 = new ProductDiscount(0.05f);
	}
	
	@After
	public void tearDown() throws Exception {
		compositediscount = null;
		discount1 = null;
		discount2 = null;
	}
	
	@Test
	public void testAddDiscount(){
		Assert.assertEquals(compositediscount.discount(), 1.0f, 0);
		compositediscount.add(discount1);
		Assert.assertEquals(compositediscount.discount(), 0.8f, 0);
		compositediscount.add(discount2);
		Assert.assertEquals(compositediscount.discount(), 0.8f*0.95f, 0);
	}
	
	@Test
	public void testRemoveDiscount() {
		compositediscount.remove(discount1);
		compositediscount.remove(discount2);
		Assert.assertEquals(compositediscount.discount(), 1.0f, 0);
	}
	
	@Test
	public void testdiscountMessage(){
		
	}
	
	
}
