package Annotations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Methods_02 {

	WebDriver BrowserDriver;
	
	@BeforeMethod
	void Login() throws Throwable {
		System.out.println("Login @BeforeMethod methods.......");
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
	void MyInfo() throws Throwable {
		System.out.println("MyInfo methods.......");	
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
		Thread.sleep(1500);
	}
	
	@AfterMethod
	void Logout() {
		System.out.println("Logout @AfterMethod methods.......");
		BrowserDriver.quit();
	}
}
