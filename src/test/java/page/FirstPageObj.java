package page;

import org.openqa.selenium.WebDriver;

import uisStore.FirstPagelocators;
import utils.WebDriverHelper;

public class FirstPageObj {
	WebDriverHelper helper=new WebDriverHelper();
WebDriver driver;
FirstPagelocators loc=new FirstPagelocators();
public void searchLamp( WebDriver driver) {
	helper.sendKeys(loc.SearchBox, "Table Lamp", driver);
	helper.enter(loc.SearchBox, driver);
	
	
}
public void VeificationResults( WebDriver driver) {
	helper.assertPartialText(loc.result, "results", driver);
	
	
}
public void clickOnFirstList( WebDriver driver) {
	helper.clickOnElement(loc.firstProduct, driver);
	System.out.println("Clicked on 1st element");
	
	
}
public void hoverOverDecorClickOnElemet(WebDriver driver) {
	helper.hoverAndClick(driver, loc.Decor, loc.Wall_Paintings_Prints);
}

}
