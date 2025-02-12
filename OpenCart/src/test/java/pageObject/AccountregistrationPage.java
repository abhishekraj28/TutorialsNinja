package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseCase.BaseClass;

public class AccountregistrationPage extends BaseClass {

    WebDriver d;
    BaseClass base = new BaseClass();

    public AccountregistrationPage(WebDriver d) {
        super();
        this.d = d;
        PageFactory.initElements(d, this); // Ensure WebElements are initialized
    }

   
    @FindBy(xpath=("//input[@id='input-firstname']")) WebElement fir_name;
    @FindBy(xpath=("//input[@id='input-lastname']")) WebElement last_name;
    @FindBy(xpath=("//input[@id='input-email']")) WebElement email;
    @FindBy(xpath=("//input[@id='input-telephone']")) WebElement tele;
    @FindBy(xpath=("//input[@id='input-password']")) WebElement pwd;
    @FindBy(xpath=("//input[@id='input-confirm']")) WebElement con_pwd;
    @FindBy(xpath=("//input[@name='agree']")) WebElement agree;
    @FindBy(xpath=("//input[@value='Continue']")) WebElement submit;
    @FindBy(xpath=("//h1[normalize-space()='Your Account Has Been Created!']")) WebElement ans;
    
    
    
    public void setFirstName(String name) {
    	fir_name.sendKeys(name);
    }
    
	 public void setLastName(String name) {
		 last_name.sendKeys(name);
	    }
	 public void setEmail(String name) {
		 email.sendKeys(name);
	 }
	 
	 public void telephone(String name) {
	    	tele.sendKeys(name);
	    }
	 
	 public void setPassword(String name) {
		 pwd.sendKeys(name);
	    }
	 
	 public void setconfPassword(String name) {
		 con_pwd.sendKeys(name);	
	    }
	 
	 public void setAgree() {
	    	agree.click();
	    }
	 
	 public void clickSubmit() {
	    	submit.click();
	    }
	 
	 public String getConfirmation() {
		 return ans.getText();
	 }
	 
}
