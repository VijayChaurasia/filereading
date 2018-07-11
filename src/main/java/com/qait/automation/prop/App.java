package com.qait.automation.prop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class App 
{
	    WebDriver driver;
	    JavascriptExecutor executor;
	    String username;
	    String password;
	    
	  
	    public App(WebDriver driver) {
	    	
			// TODO Auto-generated constructor stub
	    	this.driver=driver;
	    	executor=(JavascriptExecutor)driver;
		}
	    
	    public void readfile() throws IOException
	    {
	    	FileReader reader = null;
	    	//File file=new File("/home/vijayprakash/eclipse-workspace/prop/src/main/java/propertyfile/db.properties");
	    	try {
				reader=new FileReader("/home/vijayprakash/eclipse-workspace/prop/src/main/java/propertyfile/db.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Properties p=new Properties();
	    	p.load(reader);
	    	username=p.getProperty("username");
	    	password=p.getProperty("password");
	    }
	   
	    
	    
		public WebElement getuserentry()
	    {
	    	WebElement username=driver.findElement(By.id("txtUserName"));
	    	return username;
	    }
	    
	    public WebElement getpasswordentry()
	    {
	    	WebElement password=driver.findElement(By.id("txtPassword"));
	    	return password;
	    }
	    public String login() throws IOException
	    {
	    	readfile();
	    	getuserentry().clear();
	    	getuserentry().sendKeys(username);
	    	getpasswordentry().clear();
	    	getpasswordentry().sendKeys(password);
	    	getpasswordentry().submit();
	    	String url=driver.getCurrentUrl();
	    	return url;
	    	
	    }
	    public void logout()
	    {
	    	driver.findElement(By.className("profile-btn")).click();
	    	//driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/ul/li/ul/li[4]/a/span")).click();
	    	driver.findElement(By.xpath("//*[text()[contains(.,'Logout')]]")).click();
	        System.out.println(driver.getTitle());
	    	//select.selectByVisibleText("Logout");
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//driver.findElement(By.className("user-profile-option")).findElement(By.cssSelector("ul > li:nth-child(4)")).click();	
	    	WebElement element=driver.findElement(By.className("user-profile-option")).findElement(By.cssSelector("ul > li:nth-child(4) > a:nth-child(1) "));
	    	executor.executeScript("arguments[0].click();",element);
	    	
	}

}