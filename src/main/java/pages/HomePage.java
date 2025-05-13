package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseclass.Basepage;

public class HomePage extends Basepage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		}
	
	By Carticon = By.xpath("//button[@aria-label='cart icon']");
	By Jiomart = By.xpath("//img[@alt='JioMart']");
	
	
	public boolean VerifyTitle() {
		return isdisplayed(Jiomart);
		
	}
	
	public CartPage ClickonCart() {
		Click(Carticon);
		return new CartPage(driver);
		
	}
	

}
