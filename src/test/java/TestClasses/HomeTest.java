package TestClasses;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClasses.HomePage;
import Utilities.BaseClass;
import Utilities.FetchDataFromExcel;

public class HomeTest extends BaseClass {
	HomePage hp;
	@DataProvider(name="getexceldata")
	public Object[][] data() throws FileNotFoundException, IOException{
		return new Object[][] {
			{FetchDataFromExcel.getData(1, 0)},
			//{FetchDataFromExcel.getData(2, 0)}
		};
	}
@Test(dataProvider="getexceldata")
public void checkproduct(String item) {
	hp=new HomePage(driver);
	 // Step 1: Search product
	hp.productsearch(item);
	System.out.println("Executed search for product: " +item);
	// Step 2: View chart
	hp.showsizechart();
	// Step 3: Select size
	hp.selectByText("8");
	// Step 4: Add to cart
	hp.addcart();
}
}
