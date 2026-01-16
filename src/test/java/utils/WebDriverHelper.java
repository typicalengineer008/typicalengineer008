package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class WebDriverHelper {

	public void waitForElementToBeVisible(By element, int timeoutInSeconds, WebDriver driver) {
		new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
				.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void clickOnElement(By element, WebDriver driver) {
		WebElement webElement = driver.findElement(element);
		webElement.click();
	}

	public void sendKeys(By element, String data, WebDriver driver) {
		WebElement webElement = driver.findElement(element);
		webElement.clear();
		webElement.sendKeys(data);
	}
	public String gettingTitle( WebDriver driver) {
		String s=driver.getTitle();
		return s;
	}
	public String gettingCurrentURL( WebDriver driver) {
		String s=driver.getCurrentUrl();
		return s;
	}
	
	public boolean verifyTextContains(String actual, String expected, WebDriver driver) {
	   
	    return actual.contains(expected);
	}
	public void enter(By element,WebDriver driver) {
		WebElement webElement = driver.findElement(element);
		
		webElement.sendKeys(Keys.ENTER);
	}

	public String getText(By element, WebDriver driver) {
		WebElement webElement = driver.findElement(element);
		return webElement.getText();
	}
	
	public void assertText(By element, String expectedText, WebDriver driver) {
	    WebElement webElement = driver.findElement(element);
	    String actualText = webElement.getText();
	    Assert.assertEquals(actualText, expectedText, 
	        "❌ Text assertion failed for element: " + element.toString());
	}
	public void assertPartialText(By element, String expectedPartialText, WebDriver driver) {
	    WebElement webElement = driver.findElement(element);
	    String actualText = webElement.getText();

	    // Convert both to lower case for case-insensitive comparison
	    boolean contains = actualText.toLowerCase().contains(expectedPartialText.toLowerCase());

	    Assert.assertTrue(contains,
	        "❌ Expected partial text: \"" + expectedPartialText + 
	        "\" not found in actual text: \"" + actualText + "\"");
	}

	public void clickCanvas(By element, int a, int b, WebDriver driver) throws Exception {
		WebElement canvas = driver.findElement(element);

		int width = canvas.getSize().getWidth();
		int height = canvas.getSize().getHeight();

		Actions act = new Actions(driver);
		act.moveToElement(canvas).moveByOffset(-Math.round(width / 2) + a, -Math.round(height / 2) + b).click()
				.perform();
		Thread.sleep(2000);
	}

	public void jsClick(By locator, WebDriver driver) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javascriptScroll(By locator, WebDriver driver) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void waitForElementToBeVisible1(By next, int timeoutInSeconds, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	public void hoverOnElement(WebDriver driver, By locator) {
		
		WebElement element = driver.findElement(locator);
	    Actions act = new Actions(driver);
	    act.moveToElement(element).perform();
	}
	public void hoverAndClick(WebDriver driver,By locator1 , By locator2) {
	    Actions act = new Actions(driver);
	    WebElement main = driver.findElement(locator1);
	    WebElement sub = driver.findElement(locator2);
	    act.moveToElement(main).perform();
	    act.moveToElement(sub).click().perform();
	}

	public void selectByValue(By locator, String value,WebDriver driver) {
		WebElement element = driver.findElement(locator);
	    Select sel = new Select(element);
	    sel.selectByValue(value);
	}

}
