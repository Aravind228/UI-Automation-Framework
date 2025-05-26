package TestData;

import org.testng.annotations.DataProvider;

public class DataProviderData {
	
	@DataProvider(name="Items")
	public static Object[][] GetDataProviderdata() {
		return new Object[][]
				{
				{"Rice","Dhall"},
				{"Sugar","Salt"}
				};
	}

}
