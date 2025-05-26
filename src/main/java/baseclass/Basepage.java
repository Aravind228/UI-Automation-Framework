package baseclass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public class Basepage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	protected JavascriptExecutor js;
	
	public Basepage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		}
	
	public void Click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void SendKeys(By locator,String input) {
		driver.findElement(locator).sendKeys(input);
	}
	
	public String gettext(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void EX_wait(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public boolean isdisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void hoveron(By locator) {
		
		WebElement el = driver.findElement(locator);
		actions.moveToElement(el).perform();;
	}
	
	public void JSclick(By locator) {
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].click();", element);
	}
	
	
	public void Alert(String action) {
		Alert alert =driver.switchTo().alert();
		if (action.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
		}
		if (action.equalsIgnoreCase("accept")) {
			alert.accept();
		}
	}
	
	public String CurrentURl() {
			return driver.getCurrentUrl();
	}
	
	
	
	
	
	
}
