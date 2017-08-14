package com.propertyfinder.automation.reporter;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


public class ScreenshotUtility {

	public static ITestResult captureScreenShot(ITestResult result, String status) {
		try {		 
			String destDir = "target/screenshots/";
			String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "-" + result.getMethod().getMethodName();
			// XmlTest xmlTest = result.getTestContext().getCurrentXmlTest();
			 //String key = String.format("driver-%s-%s-%s", xmlTest.getParameter("platform"), xmlTest.getParameter("deviceName"), xmlTest.getParameter("nodeURL"));
			 WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
			 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			 if (status.equalsIgnoreCase("fail")) {
				 destDir = destDir + "Failures";
			 }
			 else if (status.equalsIgnoreCase("pass")) {
				 destDir = destDir + "Success";
			 }
			 new File(destDir).mkdirs();
			 String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";
			 FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (Exception e) {
	 		e.printStackTrace();
	 	}
		return result;
 	}
}
