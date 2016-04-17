package webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class CnnWithFirefoxTestng {
  
	WebDriver driver = null;
	
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://www.cnn.com");
	  driver.manage().window().maximize();
  }
  
  //@Test
  public void title() {
	  
	  System.out.println(driver.getTitle());
  }
  
 // @Test
  public void menuTabs()throws InterruptedException{
	  List<WebElement> element = new ArrayList<WebElement>();
		element = driver.findElements(By.cssSelector(".nav-menu-links__link"));
		for(int i=1; i<element.size() ; i++){
		driver.findElement(By.cssSelector(".nav-menu-links .nav-menu-links__link:nth-child("+i+")")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		}
  }
  
  @Test
  public void search()throws InterruptedException{
	  driver.findElement(By.id("search-button")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("search-input-field")).sendKeys("Politics", Keys.ENTER);
	  Thread.sleep(3000);
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
