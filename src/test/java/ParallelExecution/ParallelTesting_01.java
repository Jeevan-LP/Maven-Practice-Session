package ParallelExecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting_01 {
	
WebDriver BrowserDriver;
	
	@BeforeClass
	@Parameters({"browser"})
	void Login(String value) throws Throwable {
		
		switch (value) {
		case "chrome":BrowserDriver=new ChromeDriver(); break;
		case "firefox":BrowserDriver=new FirefoxDriver(); break;
		case "edge":BrowserDriver=new EdgeDriver(); break;
		
		default:System.out.println("Invalid browser");
		return;
		}
		System.out.println("Login @BeforeClass methods.......");	
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
		BrowserDriver.findElement(By.xpath("//button[@class='oxd-dialog-close-button oxd-dialog-close-button-position']")).click();
	}
	
	@Test(priority = 3)
	void Upgrade() throws Throwable {
		System.out.println("Upgrade methods.......");
		Thread.sleep(3000);
		boolean Upgradelogo = BrowserDriver.findElement(By.xpath("//button[normalize-space()='Upgrade']")).isDisplayed();
		if(Upgradelogo) {
			System.out.println("Logo displayed");
		}
		else {
			System.out.println("Logo not displayed");
		}
		Thread.sleep(1500);
	}
	
	@AfterClass
	void Logout() {
		System.out.println("Logout @AfterClass methods.......");
		BrowserDriver.quit();
	}

}
