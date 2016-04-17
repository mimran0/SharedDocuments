package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Amazon {
  WebDriver driver = null;
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://www.amazon.com");
	  driver.manage().window().maximize();
  }

  @Test
  public void dropDownSearch() throws InterruptedException {
	 
	  List<WebElement> list = new ArrayList<WebElement>();
	  list = getListOfWebElements("searchDropdownBox option");
	  WebElement element = driver.findElement(By.id("searchDropdownBox"));
	  for(int i=1; i<list.size(); i++){
	  Select select = new Select(element);
	  select.selectByVisibleText(list.get(i).getText());
	  System.out.println(list.get(i).getText());
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  element = driver.findElement(By.id("searchDropdownBox"));
	  list = getListOfWebElements("searchDropdownBox option");

	  }
  }
  public List<WebElement> getListOfWebElements(String locator){
	  
	  List<WebElement> list = new ArrayList<WebElement>();
	  list = driver.findElements(By.id(locator));
	  
	  return list;
  }
  public List<String> getListOfString(List<WebElement> list){
	  
	  List<String> items = new ArrayList<String>();
	  for(WebElement element:list){
	    items.add(element.getText());
	  }
	  
	  return items;
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
