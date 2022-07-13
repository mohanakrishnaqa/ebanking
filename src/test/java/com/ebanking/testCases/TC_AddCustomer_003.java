package com.ebanking.testCases;

import java.io.IOException;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddCustomerPage;
import com.ebanking.pageObjects.loginpage;

public class TC_AddCustomer_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
	loginpage lp = new loginpage(driver);
	lp.setUserName(uname);
	logger.info("Username entered");
	
	lp.setPassword(pwd);
	logger.info("Password entered");
	
	lp.clickSubmit();
	logger.info("Submitted");
	Thread.sleep(3000);
	
	AddCustomerPage addcust = new AddCustomerPage(driver);

	addcust.clickAddNewCustomer();
	logger.info("Navigated to new customer page");
	Thread.sleep(3000);
	
	
	closead();
	
	
	addcust.AddCustomerName("Mohana Krishna");
	addcust.AddCustomerGender("male");
	addcust.AddCustomerDOB("12", "08", "1990");
	Thread.sleep(3000);
	addcust.AddCustomerAddress("Thumuvari Street"
			+ "cot Gardens");
	addcust.AddCustomerCity("Rajahmundry");
	addcust.AddCustomerState("Andhra Pradesh");
	addcust.AddCustomerPin("533101");
	addcust.AddCustomerPhone("9966337199");
	
	String email = randomString()+"@gmail.com";
	addcust.AddCustomerEmail(email);
	
	addcust.AddCustomerPassword("Jesus");
	logger.info("Filled new customer details");
	
	addcust.CustomerSubmit();
	logger.info("New customer details submitted");
	Thread.sleep(3000);
	
	logger.info("Validation started");
	boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
	if (res==true)
	{
		Assert.assertTrue(true);
		logger.info("Testcase passed");
	}
	else
	{
	captureScreen(driver, "addNewCustomer");	
	Assert.assertTrue(false);	
	logger.info("Testcase failed");
	}
	}
	
	
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	
	}
	
	

}
