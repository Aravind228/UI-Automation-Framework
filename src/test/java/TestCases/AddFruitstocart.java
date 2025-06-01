package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.StartDriver;
import junit.framework.Assert;
import pages.CartPage;
import pages.FreshFruitsPage;
import pages.HomePage;

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
