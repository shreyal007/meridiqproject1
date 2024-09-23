package testNotesFiles;

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

public class AddNotePrescriptionSubmitDraft 
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
	void addNoteWithPrescription() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//h5[text()='Records']/following::*[1]")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//div[text()='Notes & Files']")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Note with Prescription");
  		Thread.sleep(3000);
  		
  		WebElement e = driver.findElement(By.xpath("//input[@placeholder='Search']"));
  		e.click();
  		Thread.sleep(3000);
  		
  		Actions a = new Actions(driver);
  		
  		a.sendKeys(e, "ENG Consultation Template").perform();
  		a.sendKeys(Keys.ENTER).build().perform();
  		Thread.sleep(3000);
  		
  		//Select Prescription
  		
  		driver.findElement(By.xpath("//div[text()='Add Prescription']")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//p[text()='New Prescription']")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//div[text()='Submit']")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//div[text()='Submit Draft']")).click();
  		Thread.sleep(3000);
		
	}
	
	@AfterTest
  	void quitBrowser()
  	{
  		
  		driver.quit();
  		
  	}
	
	
}
