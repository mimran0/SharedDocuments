package webdriver;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CnnWithIE {
WebDriver driver = null;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\rrt\\selenium-browser-driver\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.cnn.com");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test()throws InterruptedException {
		List<WebElement> element = new ArrayList<WebElement>();
		element = driver.findElements(By.cssSelector(".nav-menu-links__link"));
		for(int i=1; i<element.size() ; i++){
		driver.findElement(By.cssSelector(".nav-menu-links .nav-menu-links__link:nth-child("+i+")")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		}
	}
}
