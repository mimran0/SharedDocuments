package webdriver;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CnnWithFirefox {

	WebDriver driver = null;
	String expectedTitle = "";
	String actualTitle = "CNN - Breaking News, Latest News and Videos";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://www.cnn.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	//@Test
	public void test1() {
		System.out.println(driver.getCurrentUrl());
		expectedTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void test2() throws InterruptedException{
		//click with xpath
		//driver.findElement(By.xpath("html/body/div[4]/div[2]/div[2]/div[2]/a[3]")).click();
		//click with css
		List<WebElement> element = new ArrayList<WebElement>();
		element = driver.findElements(By.cssSelector(".nav-menu-links__link"));
		for(int i=1; i<element.size() ; i++){
		driver.findElement(By.cssSelector(".nav-menu-links .nav-menu-links__link:nth-child("+i+")")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		}
		
	}
	

}
