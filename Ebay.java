package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ebay 
{
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void url()
	{
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException
	{
		Actions act = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));
		act.moveToElement(move);
		act.perform();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/div[2]/div[1]/nav[1]/ul/li[6]/a")).click();
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}
}
