package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import baseclass.Basepage;
import baseclass.StartDriver;

public class TestUtility extends StartDriver{
	
	public String capturescreenshot(String testname) throws IOException {
		
		
		try {
		    WebDriver driver = GetDriver();
			//WebDriver driver = new ChromeDriver();// capture it in a variable first
		    if (driver == null) {
		        System.out.println("WebDriver is null in this method!");
		        return null;
		    }

		    if (testname == null) {
		        System.out.println("testname is null!");
		        testname = "defaultTest"; // Fallback
		    }

		    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
		    File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    String destination = System.getProperty("user.dir") + "/Screenshots/" + testname + "_" + timeStamp + ".png";
		    File dest = new File(destination);

		    dest.getParentFile().mkdirs(); // Ensure directory exists

		    FileUtils.copyFile(source, dest);
		    System.out.println("Screenshot saved: " + dest.getAbsolutePath());
		    return dest.getAbsolutePath();
		} catch (Exception e) {
		    System.out.println("Screenshot capture failed: " + e.getMessage());
		    e.printStackTrace(); // Print stack trace to see exact location
		    return null;
		}

		
	}

}
