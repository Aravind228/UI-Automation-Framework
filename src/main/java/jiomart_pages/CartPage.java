package jiomart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseclass.Basepage;

public class CartPage extends Basepage{
	
	private By Cart = By.xpath("//h1[text()='My Cart']");
	private By Paymentdetails = By.xpath("//div[text()='Payment Details']");
	private By Placeorder = By.xpath("//div[text()=' Place Order ']");

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public String Verifycart() {
		return gettext(Cart);
	}
	
	public String Verifypaymenttext() {
		return gettext(Paymentdetails);
	}
	
	public Siginpage clickonorder() {
		Click(Placeorder);
		return new Siginpage(driver);
	}
	
	
	
	
	
	
	

}
