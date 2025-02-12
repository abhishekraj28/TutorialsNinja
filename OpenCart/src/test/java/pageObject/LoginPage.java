package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver d) {
		super(d);
	}
	

		@FindBy(xpath=("//input[@id='input-email']"))WebElement email;
		@FindBy(xpath=("//input[@id='input-password']"))WebElement password;
		@FindBy(xpath=("//input[@value='Login']"))WebElement login;
		
		
		public void setEmail(String email) {
			this.email.sendKeys(email);
		}
		
		public void setPwd(String password) {
			this.password.sendKeys(password);
		}
		
		public void clickLogin() {
			login.click();
		}
}
