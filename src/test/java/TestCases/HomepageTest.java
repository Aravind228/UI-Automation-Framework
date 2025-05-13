package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.StartDriver;
import pages.CartPage;
import pages.HomePage;

public class HomepageTest extends StartDriver {
	
	HomePage homepage;
	CartPage cartpage;
	
	
	@Test(priority =0)
	public void VerifyTitleTest() {
		homepage = new HomePage(GetDriver());
		boolean status = homepage.VerifyTitle();
		Assert.assertTrue(status);
	}
	
	@Test(priority =1)
	public void ClickonCart() {
		cartpage = homepage.ClickonCart();
		String get=cartpage.Verifycart();
		Assert.assertEquals(get, "My Cart");
		
		}

}
