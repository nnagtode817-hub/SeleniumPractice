package Practice290426;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class luvlap {
public static void main (String[] args) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.luvlap.com/");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 try {
		 WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'close')]")));
		 closePopup.click();
		 System.out.println("popup closed");
	 } catch (Exception e) {
		 System.out.println("No popup found");
	 }
	//wait for menu to be present first
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.//span[text()='Baby Care & Hygiene']]")));
	
	
	List<WebElement> menus = driver.findElements(By.xpath("//a[.//span[text()='Baby Care & Hygiene']]"));
	
	WebElement visibleMenu = null;
	for(WebElement menu : menus) {
		if(menu.isDisplayed()) {
			visibleMenu = menu;
			break;
		}
	}
	if (visibleMenu == null) {
		System.out.println("Menu not found");
		return;
	}
	
	Actions actions = new Actions(driver);
	actions.moveToElement(visibleMenu).perform();
	System.out.println("Hover successfull");
	
	// submenu
	//WebElement subMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(null)))
	
	
	
	
	
	
	
	
	
	}
	
	// step 1: Hover on baby care &Hygiene
	//WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")))
}









