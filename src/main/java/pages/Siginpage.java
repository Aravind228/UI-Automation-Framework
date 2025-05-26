package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ISelect;

import baseclass.Basepage;

public class Siginpage extends Basepage{
	
	public Siginpage(WebDriver driver) {
		super(driver);
	}
	
	By signintext = By.xpath("//div[text()='Sign in']");
	
	public Boolean verifysignin() {
		return isdisplayed(signintext);
	}
	
	

}
