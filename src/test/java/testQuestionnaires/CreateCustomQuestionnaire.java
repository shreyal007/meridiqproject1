package testQuestionnaires;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomQuestionnaire 
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
	void goToCustomQuestionnaire() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[text()='Record System']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='Custom Questionnaire']")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=2)
	void addQuestion1() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[text()='Testing Questionnaire']//following::*[10]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='New Question']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='question']")).sendKeys("Question 1");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='order']")).sendKeys("1");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[text()='Type']//following::*[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[text()='Yes/No with Textbox']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='Submit']")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=3, dependsOnMethods= {"addQuestion1"})
	void addQuestion2() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[text()='New Question']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='question']")).sendKeys("Question 2");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='order']")).sendKeys("2");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[text()='Type']//following::*[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[text()='Yes/No']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='Submit']")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=4, dependsOnMethods= {"addQuestion2"})
	void addQuestion3() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[text()='New Question']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='question']")).sendKeys("Question 3");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='order']")).sendKeys("3");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[text()='Type']//following::*[1]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[text()='Textbox']")).click();
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
