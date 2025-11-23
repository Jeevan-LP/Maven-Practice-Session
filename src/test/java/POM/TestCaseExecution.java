package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseExecution {

	public static WebDriver BrowserDriver;
	public static TestCasePageobject TestExecution;
	@Test
	public void MainTest() throws Throwable {
		
		BrowserDriver=new ChromeDriver();
		BrowserDriver.manage().window().maximize();
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		BrowserDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		
		TestExecution = new TestCasePageobject(BrowserDriver);
		TestExecution.getUsername().sendKeys("Admin");
		Thread.sleep(1500);
		TestExecution.getPassword().sendKeys("admin123");
		Thread.sleep(1500);
		TestExecution.getLogin().click();
		Thread.sleep(1500);
		TestExecution.getBackIcon().click();
		Thread.sleep(1500);
		TestExecution.getLogout().click();
	}
	@Test
	public void TearDown() {
		BrowserDriver.quit();
	}
	
	
	
}
