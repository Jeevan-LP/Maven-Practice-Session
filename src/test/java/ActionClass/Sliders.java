package ActionClass;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.time.Duration;

public class Sliders {

    @Test
    public void testSlider() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

        WebElement min = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
        WebElement max = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
        new Actions(driver).dragAndDropBy(min, 80, 0).perform();
        Thread.sleep(1000);
        System.out.println("Y axis------"+driver.manage().window().getSize().height);
        new Actions(driver).dragAndDropBy(max, -50, 0).perform();
        Thread.sleep(1000);
        System.out.println("X axis------"+driver.manage().window().getSize().width);


        driver.quit();
    }
}
