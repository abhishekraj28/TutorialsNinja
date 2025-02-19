package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearch extends BasePage {

		public ProductSearch(WebDriver d) {
			super(d);
			
		}
		
		@FindBy(xpath=("//input[@placeholder='Search']")) WebElement search;
		@FindBy(xpath=("//button[@class='btn btn-default btn-lg']")) WebElement clickSearch;
        @FindBy(xpath=("//span[normalize-space()='Add to Cart']")) WebElement iphone;
		@FindBy(xpath=("//span[normalize-space()='Shopping Cart']")) WebElement cart;
		@FindBy(xpath=("//a[@class='btn btn-primary']")) WebElement checkout;
		
		public void searchProduct(String item) {
			this.search.sendKeys("item");
		}
		
		public void clickSearch() {
			clickSearch.click();
		}
		
		public void clickAddToCart() {
			iphone.click();
		}
		
		public void cart() {
			cart.click();
		}
		
		public void checkout() {
			checkout.click();
		}
}
