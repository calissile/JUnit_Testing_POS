package test;

import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import POS.CurrencyFactory;
import POS.HKCurrency;
import POS.USCurrency;

public class testCurrencyFactory {
	CurrencyFactory cFactory = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cFactory = new CurrencyFactory();
	}
	
	@After
	public void tearDown() throws Exception {
		cFactory = null;
	}
	
	@Test
	public void testCountry(){
		Assert.assertThat(CurrencyFactory.Country.valueOf("HK"), IsNull.notNullValue());
		Assert.assertThat(CurrencyFactory.Country.valueOf("US"), IsNull.notNullValue());
	}

	@Test
	public void testcreateCurrency(){
		String HK = new HKCurrency().show();
		String US = new USCurrency().show();
		Assert.assertEquals(CurrencyFactory.createCurrency(CurrencyFactory.Country.HK).show(), HK);
		Assert.assertEquals(CurrencyFactory.createCurrency(CurrencyFactory.Country.US).show(), US);
		Assert.assertThat(CurrencyFactory.createCurrency(null), IsNull.nullValue());
	}
}
