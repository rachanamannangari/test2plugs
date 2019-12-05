package com.test2plugs.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test2plugs.pageobjects.Signuppage;
import com.test2plugs.utilities.XLutils;

public class Tc_004_signupDDT extends Baseclass {
	
	@Test(dataProvider="signupdata")
	public void signUp(String uname,String email,String password) throws IOException
	{
		driver.get(url);
		Signuppage obj=new Signuppage(driver);
		obj.signupButton();
		obj.usernameTextbox(uname);
		obj.emailTextbox(email);
		obj.passwordtextbox(password);
		obj.signupButton2();
		String exp="account has been created";
		  String act=driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/font[1]")).getText();
		  if(exp.contains(act))
		  {
			  Assert.assertTrue(true);
			  logger.info("signup is passed");
		  }
		  else
		  {
			  Assert.assertFalse(false);
			  logger.info("signup is failed");
			  captureScreen(driver, "signupDDt");
		  }
		
	}
@DataProvider(name="signupdata")
public  String[][] signupdataProvider() throws IOException
{
	String path="C:\\Users\\BIJOY\\Desktop\\busyqa course work\\eclipse\\test2plugs\\src\\test\\java\\com\\test2plugs\\testdata\\signuppage.xlsx";
		int rownum=XLutils.getRowCount(path, "Sheet1");
		int colnum=XLutils.getCellCount(path, "Sheet1", 1);
		String[][] signupdata=new String[rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++)
			{
				signupdata[i-1][j] =XLutils.getCellData(path, "Sheet1",i, j);
			}
		}
		return signupdata;
		
}
}
