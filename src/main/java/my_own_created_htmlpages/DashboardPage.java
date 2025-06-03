package my_own_created_htmlpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import baseclass.Basepage;

public class DashboardPage extends Basepage {

    // Locators
    private By firstNameField    = By.id("firstName");
    private By lastNameField     = By.id("lastName");
    private By maleRadio         = By.xpath("//input[@value='Male']");
    private By femaleRadio       = By.xpath("//input[@value='Female']");
    private By seleniumCheckbox  = By.xpath("//input[@value='Selenium']");
    private By playwrightCheckbox= By.xpath("//input[@value='Playwright']");
    private By cypressCheckbox   = By.xpath("//input[@value='Cypress']");
    private By apiCheckbox       = By.xpath("//input[@value='API']");
    private By countryDropdown   = By.id("country");
    private By uploadFileInput   = By.id("uploadFile");
    private By frameTextField    = By.id("frameTextField");
    private By windowsAlertBtn   = By.id("windowsAlert");
    private By saveBtn           = By.id("saveBtn");
    private By logoutBtn         = By.id("logoutBtn");

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void enterFirstName(String firstName) {
        SendKeys(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        SendKeys(lastNameField, lastName);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            Click(maleRadio);
        } else if (gender.equalsIgnoreCase("female")) {
            Click(femaleRadio);
        }
    }

    public void selectSkill(String skill) {
        if (skill == null || skill.trim().isEmpty()) {
            throw new IllegalArgumentException("Skill cannot be null or empty");
        }

        skill = skill.trim().toLowerCase();

        if (skill.equals("selenium")) {
            Click(seleniumCheckbox);
        } else if (skill.equals("playwright")) {
            Click(playwrightCheckbox);
        } else if (skill.equals("cypress")) {
            Click(cypressCheckbox);
        } else if (skill.equals("api")) {
            Click(apiCheckbox);
        } else {
            throw new IllegalArgumentException("Invalid skill: " + skill);
        }
    }

    public void selectCountry(String country) {
    	selectBy(countryDropdown, country);
   
    }

    public void uploadFile(String filePath) {
        SendKeys(uploadFileInput, filePath);
    }

    public void enterFrameText(String text) {
        SendKeys(frameTextField, text);
    }

    public void clickWindowsAlert() {
        Click(windowsAlertBtn);
    }

    public void clickSave() {
        Click(saveBtn);
    }

    public void clickLogout() {
        Click(logoutBtn);
    }
}
