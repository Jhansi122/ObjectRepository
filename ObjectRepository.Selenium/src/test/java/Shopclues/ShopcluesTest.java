package Shopclues;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configuration.ConfigReaderTest;

import org.openqa.selenium.interactions.Actions;
import Screenshot.UtilityTest;

public class ShopcluesTest {
	WebDriver driver;
	Logger log = Logger.getLogger(ShopcluesTest.class);

	@BeforeTest
	public void browser() throws NoAlertPresentException,Exception  {

		ConfigReaderTest config = new ConfigReaderTest();
		System.setProperty("webdriver.chrome.driver", config.getPath());
		driver = new ChromeDriver();
		log.debug("opening webdriver");
		driver.get(config.getURL());
		log.info("opening URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		UtilityTest.Utility(driver, "HomePage");
		driver.manage().deleteAllCookies();
		 
		 
		 


		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void operations() throws Exception 
	{

		List<WebElement> links = driver.findElements(By.tagName("a"));
		log.debug("Printing total number of links");
		System.out.println("Total links size " + links.size());
		for (WebElement total_elements : links) 
		{
			System.out.println("Link = " + total_elements.getText());
			log.debug("links = " + total_elements.getText());
		}
	}
		
	/*@Test(priority = 2)
			public void link(String LinkURL)
			 {
				 try {
					URL url= new URL(LinkURL);
					 HttpURLConnection httpurlconnection= (HttpURLConnection)url.openConnection();
					 httpurlconnection.setConnectTimeout(2000);
					 httpurlconnection.connect();
					 if(httpurlconnection.getResponseCode()==200)
					 {
						 System.out.println(LinkURL +"-" +httpurlconnection.getResponseMessage());
					 }
					 if(httpurlconnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
					 {
						 System.out.println(LinkURL +"-" +httpurlconnection.getResponseMessage() +"-" +httpurlconnection.getResponseMessage());
					 }
				
				} 
				 catch (Exception e) 
				 {
					System.out.println("Exception "+e.getMessage());
				 }	
		}*/
		

	

	@Test(priority = 3)
	public void Actions() throws Exception {
		log.info("Mouse Actions");
		WebElement element = driver.findElement(By.xpath("//a[contains(.,'WOMEN')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		UtilityTest.Utility(driver, "MouseHover");
		Thread.sleep(4000);
		WebElement element1= driver.findElement(By.xpath("(//a[contains(.,'Sarees')])[1]"));
		UtilityTest.Utility(driver, "MouseHover1");
		Thread.sleep(4000);
		element1.click();
	}

	@Test(priority = 4)
	public void multiWindow() throws Exception {
		String parent = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();

		System.out.println("number of windows opened= " + windows.size());
		for (String child : windows) 
		{
			if(!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
			}
			
		}
		
		driver.findElement(By.xpath("//input[contains(@placeholder,'What are you looking for?')]")).sendKeys("watches");
		UtilityTest.Utility(driver, "MouseHover1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@class,'srch_action btn orange')]")).click();
		UtilityTest.Utility(driver, "Search");
		

	}
	
	@Test(priority = 5)
	public void Alert() throws Exception
	{
        String parent = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();

		System.out.println("number of windows opened= " + windows.size());
		for (String child : windows) 
		{
			if(!parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				
			}
			Thread.sleep(3000);
			
			WebElement element	= driver.findElement(By.xpath("(//a[@onclick='loginPopup();'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		UtilityTest.Utility(driver, "Login");
			
		WebElement element1= driver.findElement(By.xpath("(//a[contains(.,'My Orders')])[2]"));
		UtilityTest.Utility(driver, "orders");
		element1.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@id,'main_user_login')]")).sendKeys("535262462");
		UtilityTest.Utility(driver, "username");
	    driver.findElement(By.xpath("//a[@id='login_button']")).click();
	    driver.findElement(By.xpath("//a[@class='close_login']")).click();
	    Thread.sleep(3000);
	    UtilityTest.Utility(driver, "HomePage1");
	    
	    
	}
	
		
	}
	
	@AfterTest 
	public void close()
	{
		driver.quit();
	}

}
