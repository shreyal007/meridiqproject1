package testBooking;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddClientBooking 
{
  
	public static WebDriver driver;
	  
	@BeforeTest
	void login() throws InterruptedException 
	{
	  
	  WebDriverManager.chromedriver().setup();
	  
	  driver = new ChromeDriver();
	  
	  driver.get("https://early-access.meridiq.com/");
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("LightSaber");
	  Thread.sleep(3000);
	
	  driver.findElement(By.xpath("//button[text()='Submit']")).click();
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//input[@placeholder='E-mail']")).sendKeys("srshah1231998@gmail.com");
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pa$$w0rd!");
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//div[text()='Login Now']")).click();
	  Thread.sleep(5000);
	  
	}
	
	@Test(priority=1)
	void goToClient() throws InterruptedException
	{
		
  		driver.findElement(By.xpath("//div[text()='Clients']")).click();
  		Thread.sleep(3000);
  		
	}
	
	@Test(priority=2)
  	void searchClient() throws InterruptedException
  	{
  		
  		WebElement e = driver.findElement(By.xpath("//input[@placeholder='Search']"));
  		e.click();
  		Thread.sleep(3000);
  		
  		Actions a = new Actions(driver);
  		
  		a.sendKeys(e, "Shreyal Shah").perform();
  		a.sendKeys(Keys.ENTER).build().perform();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//span[text()='Client Name']//following::*[65]")).click();
  		Thread.sleep(3000);
  	}
	
	@Test(priority=3)
	void addBooking() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//h5[text()='Records']/following::*[1]")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//div[text()='Booking Records']")).click();
  		Thread.sleep(3000);
  		
  		//Select Service
  		
  		WebElement e = driver.findElement(By.xpath("//input[@placeholder='Service']"));
  		e.click();
  		Thread.sleep(3000);
  		
  		Actions a = new Actions(driver);
  		a.sendKeys(e, "Single Service (30 minutes)").perform();
  		a.sendKeys(Keys.ENTER).build().perform();
  		Thread.sleep(3000);
  		
  		//Select Practitioner
  		
  		WebElement e1 = driver.findElement(By.xpath("//input[@placeholder='Practitioner']"));
  		e1.click();
  		Thread.sleep(3000);
  		
  		Actions a1 = new Actions(driver);
  		a1.sendKeys(e1, "Shreyal Shah").perform();
  		a1.sendKeys(Keys.ENTER).build().perform();
  		Thread.sleep(3000);
  		
  		//Enter Date
  		driver.findElement(By.xpath("//input[@placeholder='Date']")).sendKeys("26/07/2024");
  		Thread.sleep(3000);
  		
  		//Display all the date options
  		
  		driver.findElement(By.xpath("//p[text()='Start Time']//following::*[16]")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//p[text()='03:00 PM']")).click();
  		Thread.sleep(3000);
  		
  		//Select Client
  		
  		WebElement e2 = driver.findElement(By.xpath("//input[@placeholder='Client']"));
  		e2.click();
  		Thread.sleep(3000);
  		
  		Actions a2 = new Actions(driver);
  		a2.sendKeys(e2, "Shreyal Shah").perform();
  		a2.sendKeys(Keys.ENTER).build().perform();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//div[text()='Submit']")).click();
  		Thread.sleep(3000);
  		
	}
	
	@AfterTest
  	void quitBrowser()
  	{
  		
  		driver.quit();
  		
  	}
	
	
}
