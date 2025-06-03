package jioMart_TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.StartDriver;
import jiomart_pages.CartPage;
import jiomart_pages.FreshFruitsPage;
import jiomart_pages.HomePage;
import jiomart_pages.Siginpage;

public class CartpageValidation extends StartDriver {
	
	CartPage cartpage;
	Siginpage signinpage;
	HomePage homepage;
	FreshFruitsPage fruits;
	
	@Test(priority =0,enabled=false,groups="CartpageValidation")
	public void clickonplaceordertest() {
		homepage = new HomePage(GetDriver());
		homepage.Closelocation();
		fruits =homepage.Hoverandclick();
		fruits.addfirstfruit();
		cartpage =fruits.NavigatetoCart();
		signinpage = cartpage.clickonorder();
		Boolean b=signinpage.verifysignin();
		Assert.assertTrue(b);
		
		}
	
	@DataProvider(name="Items")
	public static Object[][] GetDataProviderdata() {
		return new Object[][]
				{
				{"Rice,","Dhall"},
				{"Sugar,","Salt"}
				};
	}
	
	@Test(dataProvider="Items",groups="CartpageValidation")
	public void ValidatesearchwithDataprovider(String item1,String item2) {
		homepage = new HomePage(GetDriver());
		homepage.Closelocation();
		homepage.Searchappln_with_DataProvider(item1, item2);
		}
	
	

}
