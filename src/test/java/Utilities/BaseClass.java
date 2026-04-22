package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {
public static String browserName;
public static String url;
public static WebDriver driver;
public static ExtentReports extent;
public static ExtentTest test;
@BeforeSuite
public void setupReport() {
	extent=ExtentManager.getReport();
}
@BeforeMethod(alwaysRun=true)
public static void browserinitialize() {
	try {
		browserName = FetchDataFromProperty.readDataFromProperty().getProperty("browser");
		url=FetchDataFromProperty.readDataFromProperty().getProperty("url");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	if(browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
	}
	else{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		
}
	driver.get(url);
}
public static String PageTitle(){
	String title=driver.getTitle();
	return title;
}
//generic wait for visibility
public void waitForVisibility(WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}

//generic wait for click
public void waitForClick(WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public String CaptureToastMessage(By locator) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement toast=wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) ;
	String message=toast.getText();
	return message;
}


@AfterMethod(alwaysRun=true)
public void teardown(ITestResult result) throws IOException {
	System.out.println("After method is executing");
	if(result.getStatus()==ITestResult.FAILURE) {
		System.out.println("Inside Failure BLOCK");
		String screenshotPath=takeScreenshot(result.getName());
		System.out.println("Test failed:"+result.getName());
		System.out.println("Screenshot:"+screenshotPath);
	}
		//if test case passed
		else if(result.getStatus()==ITestResult.SUCCESS) {
			System.out.println("Test is passed:"+result.getName());
		}
		driver.quit();	
	}
public String takeScreenshot(String TestName) throws IOException {
	if(driver==null) {
		
		System.out.println("Driver is null");
	}
	TakesScreenshot tc=(TakesScreenshot)driver;
	File src=tc.getScreenshotAs(OutputType.FILE);
String folderpath=System.getProperty("user.dir") +"/target/screenshots/";
String filepath=folderpath + TestName + "_"+System.currentTimeMillis() + ".png";
File dest=new File(filepath);
FileUtils.copyFile(src, dest);
System.out.println("Screenshot method called");
return filepath;

}
@AfterSuite
public void eteardown() {
	extent.flush();
}
}
