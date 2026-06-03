package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.BaseClass;

public class HomePage extends BaseClass {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//locators
	@FindBy(xpath="//div[@class='MuiFormControl-root MuiTextField-root search-desktop css-i44wyl']//input[@placeholder='Search for items/categories']")
	WebElement search;
	@FindBy(xpath="//select[@id='uncontrolled-native']")
	WebElement sizeDropdown;
	@FindBy(xpath="//button[text()='Size chart']")
	WebElement chart;
	@FindBy(xpath="//button[contains(.,'Add to cart')]")
	WebElement addToCartButton;
	public void productsearch(String product) {
		waitForClick(search);
		search.clear();
		search.sendKeys(product);
	}
	public void showsizechart() {
		clickelement(chart);
	}
	public void checkdrop() {
		if (sizeDropdown == null) {
        throw new RuntimeException("The dropdown WebElement passed into selectDropdownByText is NULL! Check your @FindBy locator.");
		}}
		
	  public void selectByText(String size) {
	        try {
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            
	            // 1. Force change the value of the hidden dropdown to "8"
	            js.executeScript("arguments[0].value='" + size + "';", sizeDropdown);
	            
	            // 2. Trigger the 'change' event so the webpage knows you selected a size
	            js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", sizeDropdown);
	            
	            System.out.println("JavaScript successfully forced selection of size: " + size);
	        } catch (Exception e) {
	            System.out.println("Failed to select size via JavaScript: " + e.getMessage());
	        }
	    }
	
public void selectByIndex(int index) {
	Select sc=new Select(sizeDropdown);
	sc.selectByIndex(index);
}
public void selectByValue(String value) {
	Select sc=new Select(sizeDropdown);
	sc.selectByValue(value);
}
public void addcart() {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
     // Arguments[0] ensures it targets your exact WebElement variable safely
     js.executeScript("arguments[0].click();", addToCartButton);
     System.out.println("Successfully forced click on Add to Cart button using JavaScript.");
 }
}
