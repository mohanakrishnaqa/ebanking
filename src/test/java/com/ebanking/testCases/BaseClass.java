package com.ebanking.testCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.ebanking.utilities.readConfig;


public class BaseClass 
{
	readConfig rc = new readConfig();
	
	public String baseURL = rc.getApplicatonURL(); 
	public String uname = rc.getUserName();
	public String pwd = rc.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("ebanking");	
		PropertyConfigurator.configure("log4j.properties");
	
		if (br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver = new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", rc.getFireFox());
		driver = new FirefoxDriver();
		}
		else if (br.equals("msedge"))
		{
		System.setProperty("webdriver.edge.driver", rc.getMSEdge());
		driver = new EdgeDriver();
		}
		
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		driver.get(baseURL);
	
	}
		   
	@AfterClass
	public void TearDown()
	{
	driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png"); 
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot Captured");
	}

	public String randomString()
	{
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	return generatedstring;	
	}

	public String randomNumber()
	{
	String generatednumber=RandomStringUtils.randomNumeric(4);
	return generatednumber;	
	}
	
	
	public void closead()
	{
	try
	{
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[text()='Close']")).click();		
	}
	catch (Exception e)
	{
		driver.switchTo().defaultContent();	
	}
	}
	
	
}

