package my_own_created_htmlpages_Test;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseclass.StartDriver;
import my_own_created_htmlpages.DashboardPage;
import my_own_created_htmlpages.LoginPage;

public class DashboardPageTest extends StartDriver {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void setupPageObjects() {
        loginPage = new LoginPage(GetDriver());
        dashboardPage = new DashboardPage(GetDriver());
    }

    // Helper method to login first (called in each test)
    private void doLogin(String username, String password) {
        loginPage.login(username, password);

        // Optionally wait for page to load or title change
        try {
            Thread.sleep(3000); // Hard wait, replace with explicit wait if possible
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedTitle = "Aravind Form";
        Assert.assertTrue(GetDriver().getTitle().contains(expectedTitle),
            "Login failed - Did not land on dashboard page");
    }

    @Test(priority = 7)
    @Parameters({"username", "password"})
    public void testFillNameAfterLogin(String username, String password) {
        doLogin(username, password);

        dashboardPage.enterFirstName("John");
        dashboardPage.enterLastName("Doe");

        // Optionally assert entered values if retrievable or check UI changes
    }

    @Test(priority = 8)
    @Parameters({"username", "password", "gender"})
    public void testSelectGenderAfterLogin(String username, String password, String gender) {
        doLogin(username, password);
        dashboardPage.selectGender(gender);
    }

    @Test(priority = 9)
    @Parameters({"username", "password", "skill"})
    public void testSelectSkillAfterLogin(String username, String password, String skill) {
        doLogin(username, password);
        dashboardPage.selectSkill(skill);
    }

    @Test(priority = 10)
    @Parameters({"username", "password", "country"})
    public void testSelectCountryAfterLogin(String username, String password, String country) {
        doLogin(username, password);
        dashboardPage.selectCountry(country);
    }

    @Test(priority = 11)
    @Parameters({"username", "password", "filePath"})
    public void testUploadFileAfterLogin(String username, String password, String filePath) {
        doLogin(username, password);
        dashboardPage.uploadFile(filePath);
    }

    
    @Test(priority = 12)
    @Parameters({"username", "password"})
    public void testClickAlertAndSaveAfterLogin(String username, String password) {
        doLogin(username, password);
        dashboardPage.clickWindowsAlert();
        dashboardPage.clickSave();
    }

    @Test(priority = 13)
    @Parameters({"username", "password"})
    public void testLogoutAfterLogin(String username, String password) {
        doLogin(username, password);
        dashboardPage.clickLogout();

        String expectedLogoutUrlFragment = "My-own-web-apps/";
        Assert.assertTrue(GetDriver().getCurrentUrl().contains(expectedLogoutUrlFragment),
            "Logout failed or not redirected to login page");
    }
}
