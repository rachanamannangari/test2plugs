package com.test2plugs.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test2plugs.pageobjects.Signuppage;

public class Tc_003_signup extends Baseclass
{

	@Test
	public void signUp()
	{
		driver.get(url);
		logger.info("open the signup page");
		
		  Signuppage obj=new Signuppage(driver);
		  obj.signupButton(); 
		  String username=randomestring();
		  obj.usernameTextbox(username); 
		  String email=randomestring()+"@gmail.com"; 
		  obj.emailTextbox(email); String
		  password=randomeNum()+randomestring();
		  obj.passwordtextbox(password);
		  obj.signupButton2();
		  String exp="account has been created";
		  String act=driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/font[1]")).getText();
		  if(act.contains(exp))
		  {
			  Assert.assertTrue(true);
			  logger.info("signup is passed");
		  }
		  else
		  {
			  Assert.assertFalse(false);
			  logger.info("signup is failed");
		  }
		 
	}
	
}
