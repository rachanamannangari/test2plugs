package com.test2plugs.testcases;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test2plugs.pageobjects.Addservicepage;
import com.test2plugs.pageobjects.Loginpage;

public class Tc_005_addservice extends Baseclass {
  @Test
  public void addService() throws FindFailed, InterruptedException {
	  
	  
	  driver.get(url);
		logger.info("open the webpage");
		Loginpage obj1=new Loginpage(driver);
		obj1.setUsername(username);
		logger.info("enter the username");
		obj1.setPassword(password);
		logger.info("enter the password");
		obj1.SignIn();
		Thread.sleep(5000);
	  Addservicepage obj=new Addservicepage(driver);
	  obj.createnew();
	  obj.creatnewservice();
	  obj.title("dog walker");
	  obj.description("testing page");
	  obj.category("2");
	  Thread.sleep(3000);
	  obj.price("100");
	  obj.refundper();
	  obj.refundValid("10");
	  obj.addImage();
	  obj.checkBox("No Bidding Allowed");
	  obj.serviceCreate();
	  String act=driver.findElement(By.xpath("//div[contains(text(),'Service has been added')]")).getAttribute("innerText");
	  System.out.println("actual result is" +act);
	  if(act.contains("service has been added"))
	  {
		  Assert.assertTrue(true);
		  logger.info("test is passed");
	  }
	  else
	  {
		  Assert.assertFalse(false);
		  logger.info("service creation is failed");
	  }
  }
}
