package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseCase.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataProviders;

public class TC003_loginDataDrivenTest extends BaseClass {

	@Test(dataProvider="loginData", dataProviderClass=DataProviders.class, groups="dataDriven")
	public void verify_loginDataDrivenTest(String email, String password, String exp) {
		
		
		try {
		//HomePage
		HomePage hp=new HomePage(d);
		hp.clickMyAcc();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(d);
		lp.setEmail(email);
		lp.setPwd(password);
		lp.clickLogin();
		
		
		//MyAccount
		MyAccountPage mp=new MyAccountPage(d);
		boolean targetPage=mp.isMyAccountPageDisplayed();
		
		
		/*
		  Data is Valid- login success=> Test Passed=> logout
		  				 login failed=> test failed
		  				 
		  data is Invalid- login success=> Test fail=> logout
		  				 login failed=> test pass
		 */
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
			mp.logOut();
			Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				mp.logOut();
				Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}		
			}
	}
	catch(Exception e) {
		Assert.fail();
	}
}
}