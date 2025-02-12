package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseCase.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC002_loginTest extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void verify_login() {
		
		//HomePage
		logger.info("Startinf TC002+loginTest");
		try {
		HomePage hp=new HomePage(d);
		hp.clickMyAcc();
		hp.clickLogin();
		
		
		//LoginPage
		LoginPage lp=new LoginPage(d);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage ma=new MyAccountPage(d);
		boolean ans=ma.isMyAccountPageDisplayed();
		
		
		Assert.assertTrue(ans); //Assert.assertEquals(ans, true,"Login Failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("finished");
		
		
	}
	
}
