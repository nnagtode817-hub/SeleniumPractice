package Practice270426;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class first1 {
WebDriver driver;

@BeforeTest  
public void launch() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("https://www.amazon.in/");
}
@Test
public void sel() throws InterruptedException {
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_electronics']")).click(); 
driver.findElement(By.xpath("//span[text()='Cameras & Photography']")).click();
JavascriptExecutor js = (JavascriptExecutor)driver;
WebElement cam = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/31vCLB4YQoL.AC_SX250.jpg']"));
js.executeScript("arguments[0].scrollIntoView(true);", cam);
cam.click();
WebElement lense = driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
js.executeScript("arguments[0].scrollIntoView(true);", lense);
lense.click();

/*driver.findElement(By.xpath("//span[text()='Accessories']")).click();
Thread.sleep(2000);
JavascriptExecutor js = (JavascriptExecutor)driver;
//WebElement cover = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/41Z2UJTVKOL.AC_SX250.jpg']"));
//js.executeScript("arguments[0].scrollIntoView(true);", cover);
WebElement c =driver.findElement(By.xpath("//h3[@id='octopus-pc-category-title-0']"));
js.executeScript("arguments[0].scrollIntoView(true);", c);
c.click();
Thread.sleep(2000);

WebElement cover = driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/I/41Z2UJTVKOL.AC_SX250.jpg']"));
js.executeScript("arguments[0].scrollIntoView(true);", cover);
cover.click();*/
}
}