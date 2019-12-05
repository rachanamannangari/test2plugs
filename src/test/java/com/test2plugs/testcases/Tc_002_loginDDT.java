package com.test2plugs.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test2plugs.pageobjects.Loginpage;
import com.test2plugs.utilities.XLutils;

public class Tc_002_loginDDT extends Baseclass {

//public String 	xlpath=System.getProperty("user.dir")+ "src\\test\\java\\com\\test2plugs\\testdata\\logindata.xlsx";
	//public String xlpath="C:\\Users\\BIJOY\\Desktop\\busyqa course work\\eclipse\\test2plugs\\src\\test\\java\\com\\test2plugs\\testdata\\logindata.xlsx";
	
	@Test(dataProvider="logindata")
	public void loginUserdata(String usr,String pwd) throws Exception
	{
		driver.get(url);
		logger.info("open the webpage");
		Loginpage obj=new Loginpage(driver);
		obj.setUsername(usr);
		logger.info("enter the username");
		obj.setPassword(pwd);
		logger.info("enter the password");
		obj.SignIn();
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();
		//SoftAssert softassert=new SoftAssert();
		
		if(url.equalsIgnoreCase("https://qatest.twoplugs.com/home "))
		{
			
			
		Assert.assertTrue(true);
			logger.info("testcase is passed");
			obj.movetohi();
			obj.logOut();
			
		}
			
		
		else
		{
			try {
			Assert.assertFalse(false);
			}catch(AssertionError e){
				e.printStackTrace();
				throw e;
				}
			
		//	captureScreen(driver,"loginTest");
			logger.info("testcase is failed");
		}
		
		
	}
	
	
	
	
	@DataProvider(name="logindata")
	public String[][] getData() throws IOException
	{
		//XLutils xl=new XLutils();
	 String xlpath="C:\\Users\\BIJOY\\Desktop\\busyqa course work\\eclipse\\test2plugs\\src\\test\\java\\com\\test2plugs\\testdata\\logindata.xlsx";
	int rowcount=	XLutils.getRowCount(xlpath,"Sheet1");
	int colcount=XLutils.getCellCount(xlpath,"Sheet1",1);
	System.out.println("row is"+rowcount +"column count is"+colcount);
	String logindata[][]=new String[rowcount][colcount];
	for(int i=1;i<=rowcount;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLutils.getCellData(xlpath,"Sheet1",i,j);
			
		}
	}
	for(int i=0;i<rowcount;i++)
	{
		for(int j=0;j<colcount;j++) {
			
		
		System.out.print(logindata[i][j]+ " ");
		
		}
		System.out.println();
	}
	return logindata;
	}
}
