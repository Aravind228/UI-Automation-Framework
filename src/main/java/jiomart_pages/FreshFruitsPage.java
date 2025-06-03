package jiomart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseclass.Basepage;

public class FreshFruitsPage extends Basepage {
	
	public FreshFruitsPage(WebDriver driver) {
		super(driver);
	}

	private By Firstfruit = By.xpath("(//button[@data-vertical='GROCERIES'])[1]");
	
	//using xpath child to fetch the element
	private By addedcarticon = By.xpath("//button[@aria-label='cart icon']//child::img");
	
	public void addfirstfruit () {
		waitUntilVisible(Firstfruit);
		Click(Firstfruit);
		}
	
	public CartPage NavigatetoCart () {
		waitUntilVisible(addedcarticon);
		jsClick(addedcarticon);
		
		return new CartPage(driver);
	}

}
