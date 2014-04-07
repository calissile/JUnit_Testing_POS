package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.SalesLine;

public class testSalesLine {
	SalesLine sLine = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 sLine = new SalesLine();
	}
	
	@After
	public void tearDown() throws Exception {
		sLine = null;
	}
	
	@Test
	public void test(){
		
	}
}
