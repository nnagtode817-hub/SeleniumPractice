package Practice280426;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class google {

	WebDriver driver;
	
	@BeforeTest
	public void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.google.com/");
	}

	@Test
	public void search() {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement search1 =   wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
search1.sendKeys("test");
	}

}