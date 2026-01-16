package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.FirstPageObj;
import page.ProductDetailsPageObj;
import utils.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class TestRunner {
	WebDriver driver;
	Base base= new Base();
	FirstPageObj firstpage=new FirstPageObj();
	ProductDetailsPageObj productPage=new ProductDetailsPageObj();
	

;	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting execution");
	
		driver = base.openBrowser();
		base.openUrl(driver);
	}

   @Test(priority =2)
   public void testcase1() throws InterruptedException {
	 
	   System.out.println("TC 1 DEMO STARTED");
	   firstpage.searchLamp(driver);
	   firstpage.VeificationResults(driver);
	   firstpage.clickOnFirstList(driver);
	   Thread.sleep(2000);
	   productPage.verificationTableLamp(driver);
	   productPage.verificationofprice(driver);
	   productPage.plusclick(driver);
	   productPage.addToCart(driver);
	   productPage.verificationYourCart(driver);
	   productPage.clickOnOrderNote(driver);
	   Thread.sleep(1000);
	   productPage.enterordernote(driver);
	   Thread.sleep(1000);
	   productPage.clickOnCheckOut(driver);
	   Thread.sleep(1000);
	   
	   
	   
   }
   @Test (priority=1)
   public void testcase2()
   {  
	   System.out.println("TC 2 DEMO STARTED");
	   firstpage.hoverOverDecorClickOnElemet(driver);
   }
	   
	   
	   @AfterMethod
   
   public void afterMethod() {
	 // driver.quit(); 
	   
   }
}
