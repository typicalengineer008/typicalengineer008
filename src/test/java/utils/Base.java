package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	Properties prop = new ReadProperty().getProperties();

	public WebDriver openBrowser() {
		WebDriver driver;
		String browsername = prop.getProperty("browsername");
		if (browsername.equalsIgnoreCase("Microsoft Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	public void openUrl(WebDriver driver) {
		
		driver.get(prop.getProperty("url"));
		//driver.get(prop.getProperty("https://ikiru.in/"));
	}

	public void openUrl2(WebDriver driver) {
		driver.get(prop.getProperty("url2"));

	}

}
