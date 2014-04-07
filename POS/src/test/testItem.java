package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.Discount;
import POS.Item;

public class testItem {
	
	Item item = null;
	String itemName = "abc";
	int number = 50;
	float price = 50.0f;
	Discount discount;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		item = new Item(itemName, number, price);
	}
	
	@After
	public void tearDown() throws Exception {
		item = null;
		discount = null;
	}
	
	@Test
	public void testItemCon(){
		Assert.assertEquals(itemName, item.itemName);
		Assert.assertEquals(number, item.number, 0);
		Assert.assertEquals(price, item.price, 0);
		Assert.assertEquals(discount, null);
	}
	
	@Test
	public void testsetDiscount(){
		item.setDiscount(null);
		Assert.assertEquals(discount, null);
		
	}
}
