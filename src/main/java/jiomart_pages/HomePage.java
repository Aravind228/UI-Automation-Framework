package jiomart_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import TestData.HashMapData;
import baseclass.Basepage;

public class HomePage extends Basepage {
	
	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		}
	
	
	private By Carticon = By.xpath("//button[@aria-label='cart icon']");
	private By Jiomart = By.xpath("//img[@alt='JioMart']");
	private By Groceries = By.xpath("//a[text()='Groceries']");
	private By Fruitsandvegetables = By.xpath("//a[text()='Fruits & Vegetables']");
	private By FreshFruits = By.xpath("//a[text()='Fresh Fruits']");
	private By closelocation = By.xpath("//img[@alt='close icon']");
	private By Searchsection = By.xpath("//img[@src='https://www.jiomart.com/assets/ds2web/jds-icons/ds-list-icon.svg']");
	private By Globalinput = By.xpath("//textarea[@id='rel_search_val']");
	private By GlobalSearch = By.xpath("//div[contains(@class,'shopping-list-cta-item')]//button[@type='submit']");
	
	
	
	
	
	public boolean VerifyTitle() {
		return isdisplayed(Jiomart);
		
	}
	
	public String ValidateURl() {
		return getCurrentUrl();
		
	}
	
	public CartPage ClickonCart() {
		Click(Carticon);
		return new CartPage(driver);
		
	}
	
	public FreshFruitsPage Hoverandclick() {
		waitUntilVisible(Groceries);
		hoveron(Groceries);
		waitUntilVisible(Fruitsandvegetables);
		hoveron(Fruitsandvegetables);
		waitUntilVisible(FreshFruits);
		Click(FreshFruits);
		
		return new FreshFruitsPage(driver);
		
	}
	
	public void alert() {
		handleAlert("dismiss");
	}
	
	
	public void Closelocation() {
		waitUntilVisible(closelocation);
		Click(closelocation);
	}
	
	public void Searchappln_with_hashmapdata() {
		String[] s=HashMapData.GetMapdata("RIce items");
		waitUntilVisible(Searchsection);
		Click(Searchsection);
		SendKeys(Globalinput, s[0]);
		SendKeys(Globalinput, s[1]);
		waitUntilVisible(GlobalSearch);
		Click(GlobalSearch);
	}
	
	
	public void Searchappln_with_DataProvider(String item1,String item2 ) {
		waitUntilVisible(Searchsection);
		Click(Searchsection);
		SendKeys(Globalinput, item1);
		SendKeys(Globalinput, item2);
		waitUntilVisible(GlobalSearch);
		Click(GlobalSearch);
	}
	
	public void Validatecurrenturl() {
		getCurrentUrl();
	}
	
	
	

}
