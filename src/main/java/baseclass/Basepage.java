package baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basepage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	
	public Basepage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
		this.actions = new Actions(driver);
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
	
	public void wait(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public boolean isdisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

}
