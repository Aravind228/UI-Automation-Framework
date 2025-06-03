package baseclass;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Basepage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	protected JavascriptExecutor jsExecutor;;
	protected Select select;
	
	public Basepage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver,10);
		actions = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
		}
	
	//All methods designed to follow method overloading concept 
	//and encapsulation is also used in some of the methods eg: select methods getselect is encapsulated
	
	
	// -------------------- Click Methods --------------------
	
	
	public void Click(By locator) {
        try {
            waitUntilVisible(locator);
            driver.findElement(locator).click();
        } catch (Exception e) {
            System.err.println("Error clicking element at locator: " + locator + " - " + e.getMessage());
        }
    }

    public void Click(WebElement element) {
        try {
            waitUntilVisible(element);
            element.click();
        } catch (Exception e) {
            System.err.println("Error clicking WebElement: " + e.getMessage());
        }
    }

    public void Click(By locator, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, timeoutInSeconds)
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
        } catch (TimeoutException e) {
            System.err.println("Timed out waiting to click: " + locator);
        } catch (Exception e) {
            System.err.println("Error clicking element with custom timeout: " + e.getMessage());
        }
    }
    
    public void jsClick(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.err.println("Error performing JS click on: " + locator + " - " + e.getMessage());
        }
    }

    public void jsClick(WebElement element) {
        try {
            jsExecutor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.err.println("Error performing JS click on WebElement: " + e.getMessage());
        }
    }

    // -------------------- SendKeys Methods --------------------

    public void SendKeys(By locator, String input) {
        try {
            waitUntilVisible(locator);
            driver.findElement(locator).sendKeys(input);
        } catch (Exception e) {
            System.out.println("Error sending keys to element: " + locator + " - " + e.getMessage());
        }
    }

    public void SendKeys(WebElement element, String input) {
        try {
            waitUntilVisible(element);
            element.sendKeys(input);
        } catch (Exception e) {
            System.out.println("Error sending keys to WebElement: " + e.getMessage());
        }
    }

    public void SendKeys(By locator, String input, boolean clearBeforeTyping) {
        try {
            WebElement element = driver.findElement(locator);
            waitUntilVisible(element);
            if (clearBeforeTyping) {
                element.clear();
            }
            element.sendKeys(input);
        } catch (Exception e) {
            System.out.println("Error in sendKeys with clear flag at locator: " + locator + " - " + e.getMessage());
        }
    }

    // -------------------- GetText Methods --------------------

    public String gettext(By locator) {
        try {
            waitUntilVisible(locator);
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            System.out.println("Error getting text from element: " + locator + " - " + e.getMessage());
            return null;
        }
    }

    public String gettext(WebElement element) {
        try {
            waitUntilVisible(element);
            return element.getText();
        } catch (Exception e) {
            System.out.println("Error getting text from WebElement: " + e.getMessage());
            return null;
        }
    }

    // -------------------- Wait Methods --------------------

    public void waitUntilVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for visibility of locator: " + locator);
        }
    }

    public void waitUntilVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for visibility of WebElement.");
        }
    }
    
    // -------------------- SendKeys Methods --------------------
    
   public void selectBy(By locator, String visibleText) {
        if (visibleText == null || visibleText.trim().isEmpty()) {
            throw new IllegalArgumentException("Visible text cannot be null or empty.");
        }
        getSelect(locator).selectByVisibleText(visibleText.trim());
    }


    public void selectBy(By locator, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Dropdown index cannot be negative.");
        }
        getSelect(locator).selectByIndex(index);
    }
    
    public void selectByValue(By locator, String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty.");
        }
        getSelect(locator).selectByValue(value.trim());
    }
    
    private Select getSelect(By locator) {
        WebElement element = driver.findElement(locator);
        return new Select(element);
    }


    // -------------------- Other Utilities --------------------

    public boolean isdisplayed(By locator) {
    	try {
    	    return driver.findElement(locator).isDisplayed();
    	} catch (NoSuchElementException e) {
    	    return false;
    	} catch (StaleElementReferenceException e) {
    	    return false;
    	}
    }

    public boolean isdisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void hoveron(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Error hovering over element: " + locator + " - " + e.getMessage());
        }
    }

    public void hoveron(WebElement element) {
        try {
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Error hovering over WebElement: " + e.getMessage());
        }
    }

    

    public void handleAlert(String action) {
        try {
            Alert alert = driver.switchTo().alert();
            if ("accept".equalsIgnoreCase(action)) {
                alert.accept();
            } else if ("dismiss".equalsIgnoreCase(action)) {
                alert.dismiss();
            }
        } catch (Exception e) {
            System.out.println("Error handling alert: " + e.getMessage());
        }
    }

    public String getCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("Error retrieving current URL: " + e.getMessage());
            return null;
        }
    }

    public void clearInput(By locator) {
        try {
            waitUntilVisible(locator);
            driver.findElement(locator).clear();
        } catch (Exception e) {
            System.out.println("Error clearing input for: " + locator + " - " + e.getMessage());
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            return !driver.findElements(locator).isEmpty();
        } catch (Exception e) {
            System.out.println("Error checking presence of element: " + locator + " - " + e.getMessage());
            return false;
        }
    }
	
	
	
	
	
	
}
