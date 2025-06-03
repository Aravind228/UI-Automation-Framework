package jioMart_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseclass.StartDriver;
import jiomart_pages.CartPage;
import jiomart_pages.HomePage;


public class HomepageTest extends StartDriver {
	
	HomePage homepage;
	CartPage cartpage;
	
	
	
	@Test(priority =0,enabled=true,groups="HomepageTest")
	public void VerifyTitleTest() {
		
		homepage = new HomePage(GetDriver());
		//homepage.Closelocation();
		boolean status = homepage.VerifyTitle();
		Assert.assertTrue(status);
	}
	
	@Test(priority =1,enabled=true,groups="HomepageTest")
	public void ValidatejiomartURL() {
		
		String url=homepage.getCurrentUrl();
		Assert.assertEquals(url, "http://www.jiomart.com/");
	}
	
	
	@Test(priority =2,enabled=false,groups="HomepageTest")
	public void ClickonCart() {
		cartpage = homepage.ClickonCart();
		String get=cartpage.Verifycart();
		Assert.assertEquals(get, "My Cart");
		
		}
	
	@Test(priority =0,enabled=false,groups="HomepageTest")
	public void Validatesearchwithhashmap() {
		homepage = new HomePage(GetDriver());
		homepage.Closelocation();
		homepage.Searchappln_with_hashmapdata();
		}
	
	

}
