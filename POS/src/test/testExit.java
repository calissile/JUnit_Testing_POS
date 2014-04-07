package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.rules.ExpectedException;

import POS.POS;

public class testExit {
	
	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();
	
	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInvalidCommand() throws Exception {
		exit.expectSystemExitWithStatus(1);
		// catches the system.exit, but the whole thing isn't included in the coverage
		POS.batchFile = "invalidCommandBat.txt";
		POS.getInst().init();
		POS.batchMode = true;
		POS.getInst().loadBatchFile();
		POS.getInst().saleRegister();
		
	}

}
