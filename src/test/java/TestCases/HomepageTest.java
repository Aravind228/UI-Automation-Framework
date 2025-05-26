package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseclass.StartDriver;
import pages.CartPage;
import pages.HomePage;

public class HomepageTest extends StartDriver {
	
	HomePage homepage;
	CartPage cartpage;
	
	
	
	@Test(priority =1,enabled=true)
	public void VerifyTitleTest() {
		
		/*homepage = new HomePage(GetDriver());
		homepage.Closelocation();*/
		boolean status = homepage.VerifyTitle();
		Assert.assertTrue(status);
	}
	
	
	@Test(priority =2,enabled=true)
	public void ClickonCart() {
		cartpage = homepage.ClickonCart();
		String get=cartpage.Verifycart();
		Assert.assertEquals(get, "My Cart");
		
		}
	
	@Test(priority =0)
	public void Validatesearchwithhashmap() {
		homepage = new HomePage(GetDriver());
		homepage.Closelocation();
		homepage.Searchappln_with_hashmapdata();
		}
	
	

}
