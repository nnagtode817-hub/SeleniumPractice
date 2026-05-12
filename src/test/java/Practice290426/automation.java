package Practice290426;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class automation {
	WebDriver driver;
	
	@BeforeTest  
	public void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.get("https://automationexercise.com/");
	}
	
	@Test
	public void signup() throws InterruptedException {
	//signup
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	WebElement sign = driver.findElement(By.xpath("//a[@href='/login']"));
	sign.click();
	WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
	name.sendKeys("Nandini");
	WebElement mail= driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
	mail.sendKeys("shubam167@gmail.com");
	WebElement signUp= driver.findElement(By.xpath("//button[text()='Signup']"));
	signUp.click();

	// Enter details
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Athang@1234");
	
	//Day dropdown
	WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
	Select selectDay = new Select(day);
	selectDay.selectByVisibleText("15"); 
	
	//Month dropdown
		WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("June"); 

	//year dropdown
	WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
	Select selectYear = new Select(year);
	selectYear.selectByVisibleText("2000"); 
	
	driver.findElement(By.xpath("//input[@id='newsletter']")).click();
	driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Nandini");
	driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Giri");
	driver.findElement(By.xpath("//input[@id='company']")).sendKeys("BSIT software services");
	driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("sitabuldi");
	driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("Dharampeth");
	driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Maharashtra");
	driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Nagpur");
	driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("410051");
	driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9503566299");
	driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
	
	driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
	// add wait
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
    
	
	
	}
	
	
	
	
	
	
}