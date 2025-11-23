package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase {

	WebDriver BrowserDriver;
	
	@Test(priority = 1)
	void Launching() {
		BrowserDriver=new ChromeDriver();
		BrowserDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		BrowserDriver.manage().window().maximize();
	}
	@Test(priority = 2)
	void Login() throws Throwable {
		BrowserDriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	@Test(priority = 3)
	void Logo() {
		WebElement logo = BrowserDriver.findElement(By.xpath("//img[@alt='client brand banner']"));
		if(logo.isDisplayed()) {
			System.out.println(logo.getAttribute("src"));
		}
		else {
			System.out.println("no logo present");
		}
	}
	@Test(priority = 4)
	void Logout() throws Throwable {
		BrowserDriver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		Thread.sleep(1500);
		BrowserDriver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		Thread.sleep(2500);
		BrowserDriver.quit();
	}
	
	
}
