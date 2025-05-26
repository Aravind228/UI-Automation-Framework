package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;





import baseclass.Basepage;
import baseclass.StartDriver;

public class TestUtility extends StartDriver{
	
	public String capturescreenshot(String testname) throws IOException {
		
		try {
			String TimeStamp=new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
			File source=((TakesScreenshot)GetDriver()).getScreenshotAs(OutputType.FILE);
			/*String destination= System.getProperty("user.dir")+"\\screenshot\\" + testname + "_" + TimeStamp + ".png";
			System.out.println(destination);
			File dest =new File(destination);*/
			String userDir = System.getProperty("user.dir");

            // Define screenshot file path
            String filePath = userDir + File.separator + "screenshot.png";
            File f= new File(filePath);
            FileUtils.copyFile(source, f);
			/*System.out.println("screenshot saved: " + f.getAbsolutePath());
			return f.getAbsolutePath();*/
			System.out.println("screenshot saved: " + filePath);
			return filePath;
		} catch (Exception e) {
			System.out.println("Screenshot capture failed: " + e.getMessage());
			return null;
		}
	}

}
