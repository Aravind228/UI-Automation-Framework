package jioMart_TestCases;


import org.testng.annotations.Test;

import baseclass.StartDriver;
import jiomart_pages.CartPage;
import jiomart_pages.FreshFruitsPage;
import jiomart_pages.HomePage;
import junit.framework.Assert;

public class AddFruitstocart extends StartDriver {
	
	HomePage homepage;
	FreshFruitsPage fruits;
	CartPage cartpage;
	
	
	@Test(priority =2,groups="AddFruitstocart")
	public void Clickonfruits() {
		homepage = new HomePage(GetDriver());
		homepage.Closelocation();
		fruits =homepage.Hoverandclick();
		
	}
	
	@Test(priority =3,groups="AddFruitstocart")
	public void addfruitsandclickoncart() {
		fruits.addfirstfruit();
		cartpage =fruits.NavigatetoCart();
		String s=cartpage.Verifypaymenttext();
		Assert.assertEquals("Successfully added fruits to cart page and awaiting payment", "Payment Details",s);
		
		
	}
	
	
	
	

}
