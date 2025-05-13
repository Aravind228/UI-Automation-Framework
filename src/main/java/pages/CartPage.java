package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseclass.Basepage;

public class CartPage extends Basepage{
	
	By Cart = By.xpath("//h1[text()='My Cart']");

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public String Verifycart() {
		return gettext(Cart);
	}
	
	
	
	
	

}
