package TestClasses;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageClasses.RegisterPage;
import Utilities.BaseClass;
import Utilities.FetchDataFromExcel;

public class RegisterTest extends BaseClass{
	@Test //Register+login
	public void registeruser() throws IOException
	{	
	RegisterPage rp=new RegisterPage(driver);
	rp.clicktoregister();
	String user=FetchDataFromExcel.getData(1, 0);
	rp.enterUsername(user);
	String pass=FetchDataFromExcel.getData(1, 1);
	rp.enterPassword(pass);
	rp.enterConfirmPassword(pass);
	rp.clicktforegister();
	String actual=rp.getToastMessage();
	String expected="Username already exists";
	Assert.assertEquals(actual, expected);
	
	}
	
}
