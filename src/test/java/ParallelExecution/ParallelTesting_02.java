package ParallelExecution;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTesting_02 {

		WebDriver BrowserDriver;
		WebElement Elements;
		@BeforeClass
		@Parameters({"browser"})
		public void Login(String value) throws Throwable {
			
			switch (value) {
			case "chrome":BrowserDriver=new ChromeDriver(); break;
			case "firefox":BrowserDriver=new FirefoxDriver(); break;
			case "edge":BrowserDriver=new EdgeDriver(); break;
			
			default:System.out.println("Invalid browser");
			return;
			}
			System.out.println("Login @BeforeClass methods.......");	
			BrowserDriver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
			BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			BrowserDriver.manage().window().maximize();	

		}
	
		
		@Test
		void MainAction() throws Throwable {
			System.out.println("MainAction methods.......");
		Actions action = new Actions(BrowserDriver);
		WebElement whashington = BrowserDriver.findElement(By.xpath("//div[@id='box3']"));
		WebElement US = BrowserDriver.findElement(By.xpath("//div[@id='box103']"));
		
		WebElement Norway = BrowserDriver.findElement(By.xpath("//div[@id='box101']"));
		WebElement Oslo = BrowserDriver.findElement(By.xpath("//div[@id='box1']"));
		
		WebElement Rome = BrowserDriver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Italy = BrowserDriver.findElement(By.xpath("//div[@id='box106']"));
		
		action.dragAndDrop(whashington, US).perform();
		 Thread.sleep(2000);
		 action.dragAndDrop(Oslo,Norway ).perform();
		 Thread.sleep(2000);
		 action.dragAndDrop(Rome, Italy).perform();
		 
		
		 }

		@AfterClass
		void Logout() throws Throwable {
			System.out.println("Login @AfterClass methods.......");
			Thread.sleep(5000);
			 BrowserDriver.quit();
		}
			
}
