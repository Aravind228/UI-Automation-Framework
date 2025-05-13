package baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartDriver {
	
	
	//Assigning the driver to theadlocal for parallel execution 
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	@Parameters({"browser"})
	@BeforeClass
	//setting driver according to browser needed for execution
	public void setdriver(String browser) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver localdriver = null;
		
		if(driver.get()==null) {
			
		if(browser.equalsIgnoreCase("chrome")) {
			localdriver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			localdriver = new EdgeDriver();
	}
		else if(browser.equalsIgnoreCase("safari")) {
			localdriver = new SafariDriver();
		
	}
		else {
			throw new IllegalArgumentException("No Browser Matching "+ browser );
		}
		driver.set(localdriver);
		driver.get().manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);
		driver.get().get(Prop_Reader.getproperty("url"));
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		}
		
	}
	
	//Getting the browser instance
	public WebDriver GetDriver() {
		return driver.get();
	}
	
	@AfterClass
	//closing the browser
	public void CloseDriver() {
		if (driver.get() != null) {
			driver.get().quit();
		}
	}
	
}
		
		
