package utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ScreenShot {
	public static String takescreenshot(WebDriver driver, String name) {

		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HH-mm-ss");
		String dat = java.time.LocalDate.now().toString();
		String tim = timeformat.format(java.time.LocalTime.now()).toString();
		String screenshotname = name + "_" + dat + "_" + tim + ".png";

		try {
			TakesScreenshot t = (TakesScreenshot) driver;
			File source = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/" + screenshotname));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return System.getProperty("user.dir") + "./screenshot/" + screenshotname;
	}

	public static void addScreenshotToReport(ExtentTest logger, WebDriver driver, String message) {
		String screenshotPath = takescreenshot(driver, message);
		byte[] imagebytes = null;
		FileInputStream ff;
		try {
			ff = new FileInputStream(screenshotPath);
			imagebytes = IOUtils.toByteArray(ff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String encodedString = Base64.getEncoder().encodeToString(imagebytes);
		logger.log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromBase64String(encodedString).build());
	}
}
