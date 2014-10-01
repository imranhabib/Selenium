package com.selenium.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelTest {

	public static String gmail = "add your gmail account here"; 
	public static String hotmail = "add your hotmail account here"; 
	public static String user = "username here"; 
	public static String pass = "add password here (account 1)"; 
	public static String pass2 = "add password here (account 2)";
    public static String emailSubject = "This is a test email"; 
    public static String emailTest ="Just a quick tester"; 
    
  //possible functions to use..
  		//1. startDay: logs into all accounts at one time (hotmail, gmail, ubc) [syntax: startDay(driver);]
  		//2. checkGrades: checks current grades at UBC (log in not included)    [syntax: checkGrades(driver);]
  		//3. newEmail: sends an email from hotmail account 						[syntax: newEmail(driver);]
    	//4. newTab: when called will open a new tab in the browser
    	//5. gmailLogin: signs into a gmail account 							[syntax: gmailLogin(driver);]
    	//6. hotmailLogin: signs into a hotmail account 						[syntax: hotmailLogin(driver);]
    	//7. ubcLogin: signs into UBC account 									[syntax: ubcLogin(driver);]
	
    
    
    
    
    public static void gmailLogin(WebDriver driver){ 
		//driver.manage().window().maximize(); 
		driver.get("http://www.gmail.com");
			WebElement query = driver.findElement(By.name("Email")); 
			query.sendKeys(gmail);
			query = driver.findElement(By.name("Passwd")); 
			query.sendKeys(pass); 
			query.submit();
	}
	
	public static void hotmailLogin(WebDriver driver){ 
		   driver.manage().window().maximize();
		driver.get("http://www.outlook.com");
			WebElement query2 = driver.findElement(By.name("login")); 
			query2.sendKeys(hotmail); 
			query2 = driver.findElement(By.name("passwd")); 
			query2.sendKeys(pass2);
			query2.submit();
			
	}
	
	public static void ubcLogin(WebDriver driver){
		driver.get("http://ssc.adm.ubc.ca/");
		 WebElement query3 = driver.findElement(By.xpath("//input[@id='username']")); 
		 query3.sendKeys(user); 
		 query3 = driver.findElement(By.xpath("//input[@id='password']")); 
		 query3.sendKeys(pass);
		 query3.submit();
				
	}
	
	public static void newTab(WebDriver driver){ 
		try{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		} catch (WebDriverException e) { 
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		}
		
		
		}
	
    public static void newEmail(WebDriver driver) { 
    	try{ 
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	driver.findElement(By.id("NewMessage")).click();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    	driver.findElement(By.cssSelector(".Focus > span:nth-child(2) > textarea:nth-child(1)")).sendKeys(gmail);  
    	driver.findElement(By.id("fSubject")).sendKeys(emailSubject);
    	driver.findElement(By.id("ComposeRteEditor_surface")).sendKeys(emailTest);
    	driver.findElement(By.cssSelector("#SendMessage")).click();
    	} catch (WebDriverException e){ 
    	        	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    	        	driver.findElement(By.id("NewMessage")).click();
    	        	driver.findElement(By.cssSelector(".Focus > span:nth-child(2) > textarea:nth-child(1)")).sendKeys(gmail); 
    	        	driver.findElement(By.id("fSubject")).sendKeys(emailSubject);
    	        	driver.findElement(By.id("ComposeRteEditor_surface")).sendKeys(emailTest);
    	        	driver.findElement(By.cssSelector("#SendMessage")).click(); 
    	        }
    	}
        
    
    
    
	
   public static void checkGrades(WebDriver driver){ 
      driver.findElement(By.cssSelector("#tasks > li:nth-child(3) > a:nth-child(1)")).click(); 
      
	   
   }

 
   public static void startDay(WebDriver driver){ 
	   hotmailLogin(driver);
       newTab(driver); 
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   gmailLogin(driver);
       newTab(driver); 
       System.out.println("before the wait");
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       System.out.println("reached here");
       ubcLogin(driver);   
   }

	
   public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
	    hotmailLogin(driver); 
		newEmail(driver);  
		 
		
   
		System.out.println("Success! :)"); 

       

	}
   
   
}
