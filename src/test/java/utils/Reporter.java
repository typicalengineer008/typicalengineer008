package utils;

import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

	ExtentReports extend;
	ExtentTest logger;
	ExtentSparkReporter extentRep;

	public String createReport() {
		DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("HH-mm-ss");
		String dat = java.time.LocalDate.now().toString();
		String tim = timeformat.format(java.time.LocalTime.now()).toString();
		String filename = "Report_" + dat + "_" + tim + ".html";
		extentRep = new ExtentSparkReporter("./reports/" + filename);
		extend = new ExtentReports();
		extend.attachReporter(extentRep);
		return filename;
	}

	public ExtentReports getReport() {
		return extend;

	}

}