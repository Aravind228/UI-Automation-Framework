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
}
