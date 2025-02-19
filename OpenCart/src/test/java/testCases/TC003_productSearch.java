package testCases;

import org.testng.annotations.Test;

import baseCase.BaseClass;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductSearch;

public class TC003_productSearch extends BaseClass {
	
	@Test
	public void productSearch() {
		
		HomePage hp=new HomePage(d);
		hp.clickMyAcc();
		hp.clickLogin();
		
		
		//LoginPage
		LoginPage lp=new LoginPage(d);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("password"));
		lp.clickLogin();
		
	    ProductSearch ps=new ProductSearch(d);
	    ps.searchProduct(p.getProperty("item"));
	    ps.clickSearch();
	    ps.clickAddToCart();
	    ps.cart();
	    ps.checkout();
		
	
	}

}
