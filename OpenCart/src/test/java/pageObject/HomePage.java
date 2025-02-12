package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	WebDriver d;
	
	public  HomePage(WebDriver d) {
		super(d);
	}
	
	@FindBy(xpath=("//span[normalize-space()='My Account']")) WebElement myAcc;
	@FindBy(xpath=("//a[normalize-space()='Register']")) WebElement reg;
	@FindBy(xpath=("//a[normalize-space()='Login']")) WebElement login;

	
	public void clickMyAcc()
	{
		myAcc.click();
	}
	
	
	public void clickReg()
	{
		reg.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
}
