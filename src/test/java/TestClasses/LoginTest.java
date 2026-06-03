package TestClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClasses.LoginPage;
import Utilities.BaseClass;

public class LoginTest extends BaseClass {
	LoginPage lp;
	//create dataprovider
	@DataProvider(name="LoginData")
	public Object[][] getData(){
		return new Object[][] {
			{"supriyabhalke","Shivansh@18112024"},
			//{"manoj bhalke","Welcome#123"}
			
		};
	}

	@Test(dataProvider="LoginData")
public void logintest(String user,String pass ) {
    lp = new LoginPage(driver);
	
	test=extent.createTest("Login test with user:"+user);
	lp.login(user, pass);
	test.pass("login successful for user:"+user);              
}
}
