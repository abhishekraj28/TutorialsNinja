package testCases;

import org.testng.Assert;
import org.testng.annotations.*;
import baseCase.BaseClass;
import pageObject.AccountregistrationPage;
import pageObject.HomePage;

public class TTC001_accountRegistrationTest extends BaseClass {

	
	@Test (groups={"Sanity","Master"})
	public void verify_account_registration() {
	
		logger.info("Starting TTC001_accountRegistrationTet");

		try {
		HomePage hp=new HomePage(d);
		hp.clickMyAcc();
		hp.clickReg();
		AccountregistrationPage reg=new AccountregistrationPage(d);
		reg.setFirstName(randomString().toUpperCase());
		reg.setLastName(randomString().toUpperCase());
		reg.setEmail(randomString()+"@gmail.com");
		reg.telephone(randomNumber());
		String pass=randomAlphaNumeric();
		reg.setPassword(pass);
		reg.setconfPassword(pass);
		reg.setAgree();
		reg.clickSubmit();
		String conf=reg.getConfirmation();
		Assert.assertEquals(conf, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test failed");
			logger.debug("Debug logs...");
			Assert.fail();
	    }
	}
	   
}