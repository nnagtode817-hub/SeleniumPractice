package Practice280426;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {                                                    

	WebDriver driver;
	
	@BeforeTest                 
	public void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.nykaa.com/");
	   
	}
   
    
	//choose category
         
        //	 JavascriptExecutor js = (JavascriptExecutor)driver;   
        	 
        	 //scroll down
        	 //js.executeScript("window.scrollBy(0,2000)");
        	 
        	 
       	 
       @Test
       public void pro() {
    driver.navigate().to("https://www.nykaa.com/mom-baby/c/14797");
	WebElement par = driver.findElement(By.xpath("//h2[text()='Cetaphil Baby Daily Lotion']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", par);
	//par.click();

}                          
         
}
                                         
                                       
                                          




