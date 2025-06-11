package my_own_created_htmlpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import baseclass.Basepage;

public class LoginPage extends Basepage {

    // Private locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton   = By.xpath("//button[text()='Login']");
    private By errorMessage  = By.id("errorMessage"); 
    private By loadingSpinner = By.id("loadingSpinner");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Public actions using Basepage methods
    public void enterUsername(String username) {
        SendKeys(usernameField, username); // Clear before typing
    }

    public void enterPassword(String password) {
        SendKeys(passwordField, password); // Clear before typing
    }

    public void clickLogin() {
        Click(loginButton);
    }

    // Combined login method
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public String getErrorMessage() {
        return gettext(errorMessage);
    }

    // --- Method Overriding Example ---
    @Override
    public void Click(By locator) {
        // If the locator is specifically the login button, perform custom actions
        if (locator.equals(loginButton)) {
            System.out.println("Overriding Click for loginButton: Performing click and waiting for loading spinner.");
            super.Click(locator); // Call the original click from Basepage
            try {
                // Add an explicit wait for the loading spinner to disappear
                // Using the 'wait' object from Basepage
                wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSpinner));
                System.out.println("Loading spinner disappeared after login click.");
            } catch (TimeoutException e) {
                System.err.println("Timeout waiting for loading spinner to disappear after login: " + e.getMessage());
                // You might want to log a warning or throw a custom exception here
            } catch (Exception e) {
                System.err.println("Error waiting for loading spinner after login: " + e.getMessage());
            }
        } else {
            // For any other locator, use the default Click method from Basepage
            super.Click(locator);
        }
    }
    // --- End of Method Overriding Example ---

}
