  package Practice120526;

import java.time.Duration;


    
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class globalSQA {
WebDriver driver;
	
	@BeforeTest  
	public void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.globalsqa.com/demo-site/");
	}
    @Test(priority=1)                                                                                                                                                  
    //frames and windows
    public void frames() throws InterruptedException {
    	driver.navigate().to("https://www.globalsqa.com/demo-site/frames-and-windows/");
    	driver.findElement(By.xpath("//a[text()='Click Here']")).click(); 
    	String parentWindow = driver.getWindowHandle();
    	Set<String> windows = driver.getWindowHandles();
    	//switch to child window
    	for(String win : windows) {
    		if (!win.equals(parentWindow)) {
    			driver.switchTo().window(win);
    			System.out.println("child window Title : " +driver.getTitle());
    			driver.close();
    		}
    		
    	}
    	 //switch back to parent window
    	driver.switchTo().window(parentWindow);
    	
    	//***Iframe
    	
    	WebElement iframeMenu= driver.findElement(By.xpath("//li[text()='iFrame']"));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", iframeMenu);
    	//switch to iframe
    	Thread.sleep(2000);
    	//switch to iframe
    	WebElement iframe = driver.findElement(By.xpath("//iframe"));
    	driver.switchTo().frame(iframe);
    	
    	System.out.println("successfully switch to iframe");
    	//Back to main page
    	driver.switchTo().defaultContent();
    	System.out.println("Returned to main page");
 
    	
    	
    	
    	     
    }
   

    	//slider
    	@Test(priority=2)
    	public void sliders() throws InterruptedException {
    		driver.navigate().to("https://www.globalsqa.com/demo-site/sliders/");
    		//switch to iframe
    		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
    		
    		//Red slider
    		WebElement slider = driver.findElement(By.xpath("//div[@id='red']"));
    		//action to move slider
    		Actions action = new Actions(driver);
    		action.clickAndHold(slider).moveByOffset(50,0).release().perform();
    		
    		//green slider
    		WebElement slider2 = driver.findElement(By.xpath("//div[@id='green']"));
    		//action to move slider
    		Actions action2 = new Actions(driver);
    		action2.clickAndHold(slider2).moveByOffset(50,0).release().perform();
    	
    		//blue slider 
    		WebElement slider3 = driver.findElement(By.xpath("//div[@id='blue']"));
    		//action to move slider
    		Actions action3 = new Actions(driver);
    		action3.clickAndHold(slider3).moveByOffset(50,0).release().perform();
    	}
    	  /*  @Test 
    		//range slider
    	    public void range() {
    		driver.navigate().to("https://www.globalsqa.com/demo-site/sliders/");
    	   WebElement rangeTab = driver.findElement(By.xpath("//li[@id='Range']"));
    	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rangeTab); 
    	   //switch to iframe
    		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
    		List<WebElement> sliders = driver.findElements(By.xpath("//span[contains(@class, 'ui-slider-handle')]"));
    		WebElement leftslider = sliders.get(0);
    		WebElement rightslider = sliders.get(1);
      	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leftslider); 
            Actions action = new Actions(driver);
            
            //left slider
            action.moveToElement(leftslider).clickAndHold().moveByOffset(50, 0).release().perform();
          //right slider
            action.moveToElement(rightslider).clickAndHold().moveByOffset(-50, 0).release().perform();
    	
    	}
    	
    	    @Test 
    		//step slider
    	    public void step() {
    		driver.navigate().to("https://www.globalsqa.com/demo-site/sliders/");
    	   WebElement stepTab = driver.findElement(By.xpath("//li[@id='Steps']"));
    	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", stepTab); 
    	   
    	  //switch to iframe
  		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
    		
    	 // locate slider
    		WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'ui-slider-handle')]")));
      	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider); 

    		Actions action = new Actions(driver);
    	
    		action.moveToElement(slider).clickAndHold().moveByOffset(40, 0).release().perform();	
    	
    }
*/
  //dropdown  	    
@Test(priority=3)
public void dropdown() {
	driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
    WebElement dropdown = driver.findElement(By.tagName("Select"));
	Select country = new Select(dropdown);	
    country.selectByVisibleText("India");

}
   //    dialogue box
@Test(priority=4)
public void dialogue() {
	
	driver.navigate().to("https://www.globalsqa.com/demo-site/dialog-boxes/");
	//driver.switchTo().frame(0);
	//driver.findElement(By.xpath("//button[text()='Create new user']")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
	WebElement c2= driver.findElement(By.xpath("//button[@id='create-user']"));
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", c2);

	WebElement c3= driver.findElement(By.xpath("//button[text()='Create an account']"));
	js.executeScript("arguments[0].click();", c3);

	driver.switchTo().defaultContent();
	//message box
	List<WebElement>  msg = driver.findElements(By.xpath("//ul[@class='resp-tabs-list ']//li"));
	System.out.println("size of list in header:" + msg.size());
	for(WebElement msg1:msg)
		
	{
		System.out.println("name in list in dialog box:" + msg1.getText());
		if(msg1.getText().contains("Message Box"))
		{
			msg1.click();
			break;
		}
	}
} 

      @Test(priority=5)
    //DragAndDrop
    public void dragDrop() throws InterruptedException {
    driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
    //switch to frame
    WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
    driver.switchTo().frame(frame);
    
    //source image
    WebElement image = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
    //trash box
    WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
    
    // drag and drop
    Actions act = new Actions(driver);
    act.dragAndDrop(image, trash).perform();
   // Thread.sleep(3000);
   // driver.quit();
	
}
      @Test(priority=6)
      //DragAndDrop all 4 images
      public void dragDropAll() throws InterruptedException {
      driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
      //switch to frame
      WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
      driver.switchTo().frame(frame);
      
      //all image
      List<WebElement> images = driver.findElements(By.xpath("//ul[@id='gallery']/li"));
      
      //trash box
      WebElement trash = driver.findElement(By.xpath("//div[@id='trash']"));
      
      // drag and drop
      Actions act = new Actions(driver);
      for(WebElement img : images)
      {
      act.dragAndDrop(img, trash).perform();
      Thread.sleep(1000);
      }
      }
    /*  @Test
      public void acc() {
      //Accepted element
          driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");

      driver.findElement(By.xpath("//li[@aria-controls='tab_item-1']")).click();
    //switch to frame
      WebElement frame1 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
      driver.switchTo().frame(frame1);
      
      //draggablE box
      WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
      
      //target box
      WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
      Actions act1 = new Actions(driver);
      
      //drag and drop
      act1.dragAndDrop(source, target).perform();
} */
//***Date picker
    @Test(priority=7)
    public void datePicker() {
    	driver.navigate().to("https://www.globalsqa.com/demo-site/datepicker/#Simple%20Date%20Picker");
   	 // switching to frame
   	 driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]")));
   	 //input field to select
   	 driver.findElement(By.xpath("(//input[@id='datepicker'])[1]")).click();
   	 //month
   	 String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
   	 System.out.println("present month:" + month);
   	 //year
   	 String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
   	 System.out.println("present year:" + year);
   	 while(!(month.equalsIgnoreCase("May") && year.equalsIgnoreCase("2026")))
   	 {
   		 //next
   		 WebElement next = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
   		 next.click();
   		 driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
   		driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
   		System.out.println("selected year and month:" + month + year);
   	 }
   	 //particular date
   	 WebElement date = driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='15']"));
   	 date.click();
   	 System.out.println(date);
   	 driver.switchTo().defaultContent();
   	 //test1 = reports.createTest("simple date picker should select sucessfully ");
   	  Assert.assertTrue(true);
    }
// icon trigger
    @Test(priority=8)
    public void triggerIcon() {
    	driver.navigate().to("https://www.globalsqa.com/demo-site/datepicker/");
    	WebElement d3=driver.findElement(By.xpath("//li[@id='Icon Trigger']"));
    	JavascriptExecutor js= (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", d3);
      	 // switching to frame
      	 driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[3]")));
     	

      	 // click on calender icon
      	 WebElement i2= driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']"));
      	 js.executeScript("arguments[0].click()", i2);
      	 //get current month and year
       	 String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
       	 String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

       	 while(!(month.equalsIgnoreCase("May") && year.equalsIgnoreCase("2026")))
       	 {
       		 //next
       		 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
       		 
       		 month= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
       		year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
       		System.out.println("selected year and month:" + month + year);
       	 }
       	 //particular date
       	 WebElement date = driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='20']"));
      	 js.executeScript("arguments[0].click()", date);

       	 System.out.println("Date selected successfully");
       	 driver.switchTo().defaultContent();

    }
@AfterTest
public void closeBrowser() {
	driver.quit();
}

}












