package PageClasses;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class LoginPage extends BaseClass{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators
	@FindBy(xpath="//button[text()='Login']")
	WebElement initiallog;
	@FindBy(xpath="//input[@id='username']")
	WebElement logusername;
	@FindBy(xpath="//input[@id='password']")
	WebElement logpass;
	@FindBy(xpath="//button[normalize-space()='Login to QKart']")
	WebElement lgnbtn;
	@FindBy(xpath="//a[text()='Register now']")
	WebElement registernow;
	
	//methods
	public void iniclicklogin() {
		waitForClick(initiallog);
		initiallog.click();
	}
	public void enterUsername(String user) {
		waitForVisibility(logusername);
		logusername.sendKeys(user);
	}
	public void enterPassword(String pass) {
		waitForVisibility(logpass);
		logpass.sendKeys(pass);
	}
	public void clicklogin() {
		waitForClick(lgnbtn);
		lgnbtn.click();
	}
		public void registernow1(){
			registernow.click();
		}
	
	//method combine to call
	public void login(String user,String pass) {
		iniclicklogin();
		test.info("entering username");
		enterUsername(user);
		test.info("entering password");
		enterPassword(pass);
		test.info("clciking on the login button");
		clicklogin();
	}
	
}
