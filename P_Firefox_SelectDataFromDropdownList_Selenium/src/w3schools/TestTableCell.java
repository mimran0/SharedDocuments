package w3schools;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestTableCell {
  
WebDriver driver = null;
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.navigate().to("http://www.w3schools.com/sql/sql_where.asp");
	  driver.manage().window().maximize();
  }
  
  @Test
  public void f() {
	  for(int i=2; i<6; i++){
		  for(int j=1; j<=6; j++){
	  String list = driver.findElement(By.cssSelector(".w3-table-all.notranslate tbody>tr:nth-child("+i+") td:nth-child("+j+")")).getText();
	  System.out.println(list);
		  }
	  }
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
