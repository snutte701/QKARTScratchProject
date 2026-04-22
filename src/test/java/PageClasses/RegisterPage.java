package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class RegisterPage extends BaseClass{
	

		WebDriver driver;
		public RegisterPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			
		}
		@FindBy(xpath="//button[text()='Register']")
		WebElement registerbtn;
		
		@FindBy(xpath="//input[@id='username']")
		WebElement username;
		
		@FindBy(xpath="//input[contains(@name,'password')]")
		WebElement password;
		
		@FindBy(xpath="//input[starts-with(@name,'confirm')]")
		WebElement confirmpass;
		
		@FindBy(xpath="//button[normalize-space()='Register Now']")
		WebElement confirmregirbtn;
		
		By toastMsg=By.xpath("//div[contains(@class,'SnackbarItem-message')and contains(text(),'Username already exists')]");
		
		
		@FindBy(xpath="//a[text()='Login here']")
		WebElement loginhere;
		
		public void clicktoregister() {
			registerbtn.click();
		}
		public void enterUsername(String user) {
			username.sendKeys(user);
		}
		public void enterPassword(String pass) {
			password.sendKeys(pass);
		}
		
		public void enterConfirmPassword(String confpass) {
			confirmpass.sendKeys(confpass);
		}
		public void clicktforegister() {
			confirmregirbtn.click();
	}
		public String getToastMessage() {
			return CaptureToastMessage(toastMsg);
		}
		public void clickonloginhere() {
			loginhere.click();
		}
		}
