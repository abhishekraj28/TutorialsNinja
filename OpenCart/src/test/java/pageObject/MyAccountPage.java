package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver d) {
		super(d);
	}
	
	@FindBy(xpath=("//h2[normalize-space()='My Account']")) WebElement account;
	@FindBy(xpath=("//div[@class='list-group-item']//a[normalize-space()='Logout']"))WebElement logOut;
	
	public boolean isMyAccountPageDisplayed() {
		try {
		return account.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}

	}
	
	public void logOut() {
		this.logOut.click();
	}
}
