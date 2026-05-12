package Practice040526;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class insightCosmetics {
WebDriver driver;
	
	@BeforeTest                 
	public void launch() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); 
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://insightcosmetics.in/");
	}
@Test
public void bundle() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[contains(@src, 'Bundles')]")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
    WebElement combo = driver.findElement(By.xpath("//a[contains(@href, 'primer-cr-105-kit')][1]"));
	js.executeScript("arguments[0].scrollIntoView(true);", combo);
	combo.click();
	driver.findElement(By.xpath("//span[text()='Add to Cart'][1]")).click();

}



}
