package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Action_class 
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
		driver.get("https://www.rediff.com/");
	}
	
	@Test
	public void test()
	{		
		driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).click();
		
		WebElement firstname =  driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		firstname.sendKeys("Shani");
		
		WebElement id = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
		
		Actions act = new Actions(driver); 
		act.keyDown(firstname,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(firstname,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(id,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		
		act.perform();
	}
}
