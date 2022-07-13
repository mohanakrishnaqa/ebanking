package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using="//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using ="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using ="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.XPATH, using="//textarea[@onblur='validateAddress();']")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.XPATH, using="//input[@onblur='validateCity();']")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using ="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using ="pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how = How.NAME, using ="telephoneno")
	@CacheLookup
	WebElement txtMobileNumber;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using="//input[@value='Submit']")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void AddCustomerName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void AddCustomerGender(String cgender)
	{
		rdGender.click();
	}
	
	public void AddCustomerDOB(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void AddCustomerAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	
	public void AddCustomerCity (String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void AddCustomerState (String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void AddCustomerPin (String string)
	{
		txtPin.sendKeys(String.valueOf(string));
	}
	
	public void AddCustomerPhone (String cphone)
	{
		txtMobileNumber.sendKeys(cphone);
	}
	
	public void AddCustomerEmail(String cemail)
	{
		txtEmail.sendKeys(cemail);
	}
			
	public void AddCustomerPassword(String cpassword)
	{
		txtPassword.sendKeys(cpassword);
	}
	
	public void CustomerSubmit()
	{
		btnSubmit.click();
	}	
}
