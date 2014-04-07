package test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.POS;


public class testPOScon {
	final String username = "chunlin";
	final String password = "chunlin";
	

	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		POS.getInst();
		POS.batchMode = false;
		
	}

	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void testinit() throws Exception{
		POS.getInst().init();
	}
	
	@Test
	public void testsalesRegisterNormal() throws Exception{
		POS.getInst().init();
		POS.getInst().userName = username;
		POS.getInst().password = password;

		String input = "1\n" + "y\n" + "ID001\n" + "2\n"
				+ "c\n" + "2\n" + "2\n";
		InputStream oldStdIn = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		POS.getInst().saleRegister();
		
		// reset System.in after testing
		System.setIn(oldStdIn);
	}
	
	@Test
	public void testsalesRegisterInsufficientFunds() throws Exception{
		POS.getInst().init();
		POS.getInst().userName = username;
		POS.getInst().password = password;

		String input = "1\n" + "n\n" + "ID002\n" + "2\n"
				+ "c\n" + "2\n"  + "300\n" + "2\n";
		InputStream oldStdIn = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		POS.getInst().saleRegister();
		
		// reset System.in after testing
		System.setIn(oldStdIn);
	}
	
	@Test
	public void testsalesRegisterInvalidProductCommand() throws Exception{
		POS.getInst().init();
		POS.getInst().userName = username;
		POS.getInst().password = password;

		String input = "1\n" + "q\n" +"y\n" + "ABCDE\n" + "ID002\n" + "2\n"
				+ "c\n" + "2\n"  + "300\n" + "2\n";
		
		InputStream oldStdIn = System.in;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		POS.getInst().saleRegister();
		// reset System.in after testing
		System.setIn(oldStdIn);
	}
	
	@Test
	public void testsalesRegisterCancelPayment() throws Exception{
		POS.getInst().init();
		POS.getInst().userName = username;
		POS.getInst().password = password;

		String input = "1\n" +"y\n" + "ABCDE\n" + "ID005\n" + "2\n"
				+ "c\n" + "2\n"  +  "0\n" + "2\n";
		
		InputStream oldStdIn = System.in;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		POS.getInst().saleRegister();
		// reset System.in after testing
		System.setIn(oldStdIn);
	}	
	
	@Test
	public void testsalesRegisterInvalidCommand() throws Exception{
		POS.getInst().init();
		POS.getInst().userName = username;
		POS.getInst().password = password;

		String input = "3\n" + "1\n" + "y\n" + "ID005\n" + "2\n"
				+ "c\n" + "2\n"  + "300\n" + "2\n";
		
		InputStream oldStdIn = System.in;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		POS.getInst().saleRegister();
		// reset System.in after testing
		System.setIn(oldStdIn);
	}	
	
	
	
	@Test
	public void testRegister() throws Exception{
		POS2 pos2 = new POS2();
		// input as in following sequence:
		// wrong username, correct username, wrong password, correct password
		String input = "tehee\n" + "chunlin\n" + "heehee\n" + "chunlin\n";
		pos2.batchMode = false;
		InputStream oldStdIn = System.in;
		
		pos2.init();
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		pos2.register();
		
		System.setIn(oldStdIn);

	}
	
	// uses all methods from original POS but an overridden saleRegister()
	private class POS2 extends POS {
		@Override
		public void saleRegister() {
			/* empty method */
		}

	}
	
}
