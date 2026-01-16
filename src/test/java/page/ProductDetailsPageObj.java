package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uisStore.ProductDetailsLocator;
import utils.WebDriverHelper;

public class ProductDetailsPageObj {
	ProductDetailsLocator loc=new ProductDetailsLocator();	
	WebDriverHelper helper =new WebDriverHelper();
	
	public void verificationTableLamp(WebDriver driver) {
		
		String actual=helper.gettingTitle(driver);
		System.out.println(helper.verifyTextContains(actual, "Table Lamp", driver));
		
	
	
	}
	public void verificationofprice(WebDriver driver) {
		
		String actual=helper.getText(loc.price, driver);
		System.out.println("The price of first item is :"+actual);
		
	
	
	}
public void plusclick(WebDriver driver) {
		
		helper.clickOnElement(loc.plusButton, driver);
		
	
	
	}
public void addToCart(WebDriver driver) {
	
	helper.clickOnElement(loc.addToCartBtn, driver);
	


}

public void verificationYourCart(WebDriver driver) {
	
	String actual=helper.getText(loc.yourCartPopup, driver);
	System.out.println(helper.verifyTextContains(actual, "Your Cart", driver));
	
	System.out.println("POP UP VERIFICATION PASSED");	


}
public void clickOnOrderNote(WebDriver driver) {
	
	helper.clickOnElement(loc.orderNote, driver);
	


}
public void clickOnCheckOut(WebDriver driver) {
	
	helper.clickOnElement(loc.checkOut, driver);
	


}

public void enterordernote(WebDriver driver) {
	
	helper.sendKeys(loc.OrderNoteText, "Entering Order Note", driver);;
	helper.clickOnElement(loc.Applybtn, driver);


}
}
 