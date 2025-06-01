package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status; 
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;






public class ExtentReportClass extends TestUtility implements ITestListener {
	
	private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./AutomationTestReports/" + repName);
        sparkReporter.config().setDocumentTitle("JioMart Automation Report");
        sparkReporter.config().setReportName("Regression Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Environment", "Automation");
        extent.setSystemInfo("Tester", "Aravind");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
        extentTest.log(Status.INFO, "Test started: " + result.getName());
    }

    
    public void onTestSuccess(ITestResult result) {
        ExtentTest extentTest = test.get();
        extentTest.log(Status.PASS, "Test passed: " + result.getName());

        attachScreenshot(extentTest, result);
    }

    
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = test.get();
        extentTest.log(Status.FAIL, "Test failed: " + result.getThrowable());

        attachScreenshot(extentTest, result);
    }
    
   
    public void onTestSkipped(ITestResult result) {
        ExtentTest extentTest = test.get();
        extentTest.log(Status.SKIP, "Test skipped: " + result.getName());
    }

   
    public void onFinish(ITestContext context) {
        extent.flush();
    }

  
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional to implement
    }

    private void attachScreenshot(ExtentTest extentTest, ITestResult result) {
        try {
            String screenshotPath = capturescreenshot(result.getName());
            if (screenshotPath != null) {
                extentTest.addScreenCaptureFromPath(screenshotPath);
            }
        } catch (IOException e) {
            extentTest.log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
        }
    }
	


	                                                                                                                                                                                                                                                                           
}
