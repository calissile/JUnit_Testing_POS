package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.CurrencyFactory;
import POS.POS;

public class testPOSbat {
	
	private final String batchfile = "batchfile.txt";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		POS.getInst();
		POS.batchFile = batchfile;
		POS.batchMode = true;
		POS.getInst().loadBatchFile();
	}
	
	@After
	public void tearDown() throws Exception {
		POS.batchMode = false;
	}
	
	// Private Field Reflection template
	private Object getField(Object obj, String name) throws Exception
	{
		Class<? extends Object> c = obj.getClass();
		Field f = c.getDeclaredField(name);
		f.setAccessible(true);
		return f.get(obj);
	}
	
	// test on reflection of private method test
	@Test
	public void testtest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		int value = 1;
		Method method = POS.class.getDeclaredMethod("test");
		method.setAccessible(true);
		Assert.assertEquals(value, method.invoke(POS.getInst()));
	}
	
	@Test
	public void testgetInst() {
		POS pos = new POS();
		Assert.assertThat(POS.getInst(), IsNull.notNullValue());
		Assert.assertEquals(POS.getInst().getClass(),pos.getClass());
	}

	// test on reflection of private method getTaxModelNoTax
	@Test
	public void testgetTaxModelNOTAX() throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = POS.class.getDeclaredMethod("getTaxModel", String.class);
		method.setAccessible(true);
		String s = "NOTAX";
		method.invoke(POS.getInst(), s);
	}
	
	// test on reflection of private method getTaxModelVAT
	@Test
	public void testgetTaxModelVAT() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = POS.class.getDeclaredMethod("getTaxModel", String.class);
		method.setAccessible(true);
		String s = "VAT";
		method.invoke(POS.getInst(), s);
		
	}
	
	@Test
	public void testgetTaxModelwEmptyString() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method = POS.class.getDeclaredMethod("getTaxModel", String.class);
		method.setAccessible(true);
		String s = "";
		method.invoke(POS.getInst(), s);
	}

	// test on reflection of private method checkCurrency and setCurrency
	@Test
	public void testcheckandsetCurrency() throws Exception{
		
		Method method = POS.class.getDeclaredMethod("checkCurrency", String.class);
		Method met = POS.class.getDeclaredMethod("setCurrency", CurrencyFactory.Country.class);
		method.setAccessible(true);
		met.setAccessible(true);
		
		String s = "HK";
		method.invoke(POS.getInst(), s);
		boolean flag = (Boolean) met.invoke(POS.getInst(), CurrencyFactory.Country.HK);
		Assert.assertEquals(true, flag);
		
		s = "US";
		method.invoke(POS.getInst(), s);
		flag = (Boolean) met.invoke(POS.getInst(), CurrencyFactory.Country.US);
		Assert.assertEquals(true, flag);
		Assert.assertEquals(false, met.invoke(POS.getInst(), (Object)null));
		
		s = "";
		method.invoke(POS.getInst(), s);
		flag = (Boolean) met.invoke(POS.getInst(), CurrencyFactory.Country.US);
		//Assert.assertEquals(true, flag);
		Assert.assertEquals(false, met.invoke(POS.getInst(), (Object)null));
	}
	
	
	@Test
	public void testround(){
		double value = Math.random();
		int scale = 10;
		int roundingMode = BigDecimal.ROUND_HALF_UP;
		
		BigDecimal bd = new BigDecimal(value);  
        bd = bd.setScale(scale, roundingMode);  
        double d = bd.doubleValue();  
        bd = null;
		
        Assert.assertThat(POS.round(value,scale,roundingMode), IsNull.notNullValue());
        Assert.assertEquals(POS.round(value, scale, roundingMode), d, scale);
	}
	
	
	@Test
	public void testint2Str(){
		int i = 10;
		String []ss = {"00","0",""};
    	String xs = String.valueOf(i);
    	xs = ss[xs.length()]+xs;
    	
		Assert.assertThat(POS.int2Str(i), IsNull.notNullValue());
		Assert.assertEquals(xs,POS.int2Str(i));
		Assert.assertEquals(POS.int2Str(i).getClass(), String.class);
	}
	
	@Test
	public void testloadBatchFile() throws Exception{
		// initiate a reflection of private field baReader for testing
		BufferedReader thisReader = (BufferedReader)getField(POS.getInst(), "baReader");
		thisReader = new BufferedReader(new FileReader(POS.batchFile));
		BufferedReader bReader = new BufferedReader(new FileReader(POS.batchFile));
		POS.getInst().loadBatchFile();
		
		Assert.assertEquals(bReader.readLine(), thisReader.readLine());
		Assert.assertEquals(bReader.read(), thisReader.read());
		bReader.close();
		thisReader.close();
	}
	
	@Test
	public void testinit(){
		POS.getInst().init();
	}
	
	@Test
	public void testGetLine() throws IOException{
		Assert.assertEquals("chunlin", POS.getInst().getLine());
	}
	
	
	@Test
	public void testcorrectgetNum(){
		int mode = 0;
		String sMode = "1";
		mode = Integer.parseInt(sMode);
		Assert.assertThat(POS.getInst().getNum(sMode),IsNull.notNullValue());
		Assert.assertEquals(mode, POS.getInst().getNum(sMode));
	}
	
	@Test
	public void testwrongNum(){
		String input = "1\n";

		POS.batchMode = false;
		InputStream oldStdIn = System.in;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		Assert.assertEquals(1, POS.getInst().getNum("a"));
		// reset System.in after testing
		System.setIn(oldStdIn);
		POS.batchMode = true;
	}
	
	
	@Test
	public void testinvalidgetNum(){
		String input = "1\n";

		POS.batchMode = false;
		InputStream oldStdIn = System.in;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		Assert.assertEquals(1, POS.getInst().getNum("-1"));
		// reset System.in after testing
		System.setIn(oldStdIn);
		POS.batchMode = true;
		
	}
	
	
	@Test
	public void testgetFloat(){
		float mode = 0;
		String sMode = "1";
		mode = Float.parseFloat(sMode);
		Assert.assertThat(POS.getInst().getFloat(sMode), IsNull.notNullValue());
		Assert.assertEquals(mode, POS.getInst().getFloat(sMode), 0);
				
	}
	
	@Test
	public void testwronggetFloat(){
		String input = "1\n";

		POS.batchMode = false;
		InputStream oldStdIn = System.in;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		Assert.assertEquals(1, POS.getInst().getFloat("a"), 0);
		// reset System.in after testing
		System.setIn(oldStdIn);
		POS.batchMode = true;
	}

	
	@Test
	public void testInvalidgetFloat(){
		String input = "1\n";

		POS.batchMode = false;
		InputStream oldStdIn = System.in;
		
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		Assert.assertEquals(1.0f, POS.getInst().getFloat("-1"), 0);
		// reset System.in after testing
		System.setIn(oldStdIn);
		POS.batchMode = true;
	}
	
	@Test
	public void testSaleRegister(){
		POS.getInst().init();
		POS.batchMode = true;
		POS.batchFile = "saleregbat2.txt";
		POS.getInst().loadBatchFile();
		
		String mem = "y\n";
		
		InputStream oldStdIn = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream(mem.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		POS.getInst().saleRegister();
		// reset System.in after testing
		System.setIn(oldStdIn);
		POS.batchMode = true;
	}
	
	
	@Test
	public void testRegister(){
		POS2 pos = new POS2();
		pos.init();
		pos.batchMode = true;
		pos.batchFile = "regbat.txt";
		pos.loadBatchFile();
		
		pos.register();
		// reset System.in after testing
		
	}
	
	// uses all methods from original POS but an overridden saleRegister()
	private class POS2 extends POS {
		@Override
		public void saleRegister() {
			/* empty */
		}
	}
	
	@Test
	public void testMain(){
		String []s = {"regbat.txt"};
		String mem = "y\n";
		InputStream oldStdIn = System.in;
		ByteArrayInputStream in = new ByteArrayInputStream(
		mem.getBytes());
		System.setIn(in);
		// test program based on the inputStr string here
		POS.main(s);
		// reset System.in after testing
		System.setIn(oldStdIn);
		
	}
	
}

