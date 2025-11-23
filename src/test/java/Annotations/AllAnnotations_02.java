package Annotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations_02 {

	WebDriver BrowserDriver;

	@BeforeSuite
	void BeforeSuite() {
		System.out.println("@BeforeSuite methods.......");	
	}
	@BeforeTest
	void BeforeTest() {
		System.out.println("@BeforeTest methods.......");	
	}
	@BeforeClass
	void BeforeClass() {
		System.out.println("@BeforeClass methods.......");	
	}
	@BeforeMethod
	void Login() throws Throwable {
		System.out.println("@BeforeMethod methods.......");	
		BrowserDriver=new ChromeDriver();
		BrowserDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		BrowserDriver.manage().window().maximize();
		BrowserDriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test(priority = 1)	//priority is optional
	void Search() throws Throwable {
		System.out.println("Search methods.......");
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Jeevan L P");
		Thread.sleep(1500);
	}
	
	@Test(priority = 2)	//priority is optional
	void Profile() throws Throwable {
		System.out.println("Profile methods.......");	
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//a[normalize-space()='About']")).click();
		Thread.sleep(1500);
	}
	@AfterMethod
	void Logout() {
		System.out.println("@AfterMethod methods.......");	
		BrowserDriver.quit();
	}
	@AfterClass
	void AfterClass() {
		System.out.println("@AfterClass methods.......");	
	}
	@AfterTest
	void AfterTest() {
		System.out.println("@AfterTest methods.......");
	}
	@AfterSuite
	void AfterSuite() {
		System.out.println("@AfterSuite methods.......");	
	}
}
