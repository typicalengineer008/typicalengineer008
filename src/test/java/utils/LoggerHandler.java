package utils;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import java.time.format.DateTimeFormatter;

public class LoggerHandler {

	public Logger createLog() {

		Logger logger = Logger.getLogger(LoggerHandler.class);
		try {
			DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HH-mm-ss");
			String dat = java.time.LocalDate.now().toString();
			String tim = timeformat.format(java.time.LocalTime.now()).toString();
			String filename = "logfile_" + dat + "_" + tim;

			System.setProperty("logfile", filename);
			PropertyConfigurator.configure("./src/main/java/resources/log4j.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logger;
	}

}
