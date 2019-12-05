package com.test2plugs.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	WebDriver ldriver;
	public Loginpage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath= "/html/body/div/header/div/ul/li[1]/a/span")
	WebElement btnlogin;
	@FindBy(xpath="//input[@id='signInEmail']")
	WebElement txtusername;
	@FindBy(xpath="//*[@id='signInPassword']")
	WebElement txtpassword;
	@FindBy(xpath="//span[contains(text(),'LOG IN')]")
	 WebElement btnsignin;
	
	@FindBy(xpath="//span[contains(text(),'Hi,polaris')]")
	public WebElement btnhi;
	@FindBy(xpath="//span[contains(text(),'Sign Out')]") WebElement btnsignout;
	
	public void userLogin()
	{
		btnlogin.click();
	}
	
	public void setUsername(String unm)
	{
		txtusername.sendKeys(unm);
	}
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	
	public void SignIn()
	{
		btnsignin.click();
	}
	
	public void movetohi()
	{
	
	JavascriptExecutor js=(JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].click;",btnhi);
		//btnhi.click();
	}
	
	public void logOut()
	{
		btnsignout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
