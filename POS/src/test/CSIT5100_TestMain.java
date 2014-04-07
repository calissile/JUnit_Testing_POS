package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses
({
	test.testPOSbat.class,
	test.testPOScon.class,
	test.testCompositeDiscount.class,  
	test.testCurrency.class,
	test.testCurrencyFactory.class,
	test.testCustomerDiscount.class,
	test.testDiscount.class,
	test.testEventDiscount.class,
	test.testHKCurrency.class,
	test.testItem.class,
	test.testProductDiscount.class,
	test.testTaxModel.class,
	test.testTMNoTax.class, 
	test.testTMVAT.class,
	test.testUSCurrency.class,
	test.testPayment.class,
 	test.testSalesLine.class,
 	// test.testExit.class
 	// please test the above separately (to avoid unexpected problem)
})

public class CSIT5100_TestMain {
	/* Nothing to see */
}
