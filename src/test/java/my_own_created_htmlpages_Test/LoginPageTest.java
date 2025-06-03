package my_own_created_htmlpages_Test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseclass.StartDriver;
import my_own_created_htmlpages.LoginPage;

public class LoginPageTest extends StartDriver {

    private LoginPage loginPage;
    
    @BeforeMethod(alwaysRun = true)
    public void setupPageObjects() {
        loginPage = new LoginPage(GetDriver());
    }

    @Test(priority = 0)
    public void TestpageTitle() {
        String expectedTitle = "Login - Aravind Form"; // Replace with actual title after login
        Assert.assertTrue(GetDriver().getTitle().contains(expectedTitle),
            "Login page Title mismatches "+GetDriver().getTitle());
       
    }

    @Test(priority = 1)
    @Parameters({"username", "password"})
    public void testValidLogin(String username, String password) {
        loginPage.login(username, password);
        
        try {
            Thread.sleep(5000); // hard wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace(); // or handle more gracefully
        }
        // TODO: Replace with actual validation (e.g., check URL, title, or element)
        String expectedTitle = "Aravind Form"; // Replace with actual title after login
        Assert.assertTrue(GetDriver().getTitle().contains(expectedTitle),
            "Login failed - Page title mismatch");
    }

    @Test(priority = 2)
    public void testInvalidLogin() {
        loginPage.login("invalidUser", "wrongPassword");

        // TODO: Replace with actual validation
        String currentUrl = GetDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("My-own-web-apps/"), 
            "Should not navigate to other pages if user not valid");
    }

    @Test(priority = 3)
    public void testBlankUsername() {
        loginPage.login("", "somePassword");

        // TODO: Replace with actual validation
        String currentUrl = GetDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("My-own-web-apps/"),
            "Blank username should not allow to login to dashboard page");
    }

    @Test(priority = 4)
    public void testBlankPassword() {
        loginPage.login("someUser", "");

        // TODO: Replace with actual validation
        String currentUrl = GetDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("My-own-web-apps/"),
            "Blank password should not allow to login to dashboard page");
    }

    @Test(priority = 5)
    public void testBlankUsernameAndPassword() {
        loginPage.login("", "");

        // TODO: Replace with actual validation
        String currentUrl = GetDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("My-own-web-apps/"),
            "Blank credentials should not allow to login to dashboard page");
    }

    @Test(priority = 6)
    public void testErrorMessageDisplay() {
        loginPage.login("invalid", "invalid");

        String errorMsg = loginPage.getErrorMessage();
        Assert.assertFalse(errorMsg == null || errorMsg.isEmpty(), "Error message should be displayed");
    }
}

