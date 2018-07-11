package com.qait.automation.prop;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NewTest {
	WebDriver driver;
	App app;
	
  @BeforeClass
  public void before() 
    {
	  driver=new ChromeDriver();
	  driver.get("https://hris.qainfotech.com/login.php");
	  app=new App(driver);
    }
	
	
  @Test
  public void testlogin() throws IOException {
	  String str=app.login();
	  Assert.assertEquals(str,"https://hris.qainfotech.com:8086/time/timesheet");
  }
}
