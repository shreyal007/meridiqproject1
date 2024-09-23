package testLoC;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddLoC 
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
	void selectLOC() throws InterruptedException
	{
		
  		driver.findElement(By.xpath("//div[text()='Record System']")).click();
  		Thread.sleep(3000);
  		
  		driver.findElement(By.xpath("//div[text()='Letters of Consent']")).click();
  		Thread.sleep(3000);
  		
	}
	
	@Test(priority=2)
  	void addLOC() throws InterruptedException
  	{
  		
		driver.findElement(By.xpath("//div[text()='Add']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Consent Title']")).sendKeys("New Test LOC");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='tiptap ProseMirror']")).sendKeys("Testing Testing Testing Testing Testing");
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
