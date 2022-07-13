
package com.ebanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;
import com.ebanking.pageObjects.loginpage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException
	{
		driver.get(baseURL);
		logger.info("Entered URL");
		
		loginpage lp = new loginpage(driver);
		
		lp.setUserName(uname);
		logger.info("Entered UserName");
		
		lp.setPassword(pwd);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		logger.info("Submitted");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);
		logger.info("Login test passed");
		}
		else
		{
		captureScreen(driver, "LoginTest_001");	
		Assert.assertTrue(false);	
		logger.info("Login test failed");
		}
	}
}
