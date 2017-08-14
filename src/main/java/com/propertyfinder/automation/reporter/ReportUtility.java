package com.propertyfinder.automation.reporter;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportUtility implements ITestListener {
	
	private static final Logger LOGGER = Logger.getLogger(ReportUtility.class);

	public void onStart(ITestContext result) {

	}

	public void onFinish(ITestContext result) {

	}

	public void onTestSuccess(ITestResult result) {
		try {
			ScreenshotUtility.captureScreenShot(result, "Pass");
		} catch(Exception e) {
			LOGGER.info("Test Case has been passed"+result.getMethod());
			
		}
	
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*****"+result.getName()+" test has failed *****");
		ScreenshotUtility.captureScreenShot(result, "Fail");
	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSkipped(ITestResult result) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

//	public void captureScreenShot(ITestResult result, String status) {
//		try {		 
//			String destDir = "target/screenshots/";
//			String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "-" + result.getMethod().getMethodName();
//			 XmlTest xmlTest = result.getTestContext().getCurrentXmlTest();
//			 String key = String.format("driver-%s-%s-%s", xmlTest.getParameter("platform"), xmlTest.getParameter("deviceName"), xmlTest.getParameter("nodeURL"));
//			 WebDriver driver = (WebDriver) result.getTestContext().getAttribute(key);
//			 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			 DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
//			 if (status.equalsIgnoreCase("fail")) {
//				 destDir = destDir + "Failures";
//			 }
//			 else if (status.equalsIgnoreCase("pass")) {
//				 destDir = destDir + "Success";
//			 }
//			 new File(destDir).mkdirs();
//			 String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";
//			 FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
//		} catch (Exception e) {
//	 		e.printStackTrace();
//	 	}
// 	}
}