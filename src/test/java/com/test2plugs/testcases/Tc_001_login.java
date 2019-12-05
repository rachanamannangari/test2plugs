package com.test2plugs.testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test2plugs.pageobjects.Loginpage;

public class Tc_001_login extends Baseclass{
	
	
	@Test
	public void loginUser() throws InterruptedException, IOException
	{
		driver.get(url);
		logger.info("open the webpage");
		Loginpage obj=new Loginpage(driver);
		obj.setUsername(username);
		logger.info("enter the username");
		obj.setPassword(password);
		logger.info("enter the password");
		obj.SignIn();
		Thread.sleep(5000);
		String title=driver.getTitle();
		
		
		if(title.contains("twoPLUGS - "))
		{
			Assert.assertTrue(true);
			logger.info("testcase is passed");
			Actions mouse=new Actions(driver);
			mouse.doubleClick(obj.btnhi).perform();
			
			//obj.movetohi();
			
			obj.logOut();
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"loginTest");
			logger.info("testcase is failed");
		}
	}
	
	
}
