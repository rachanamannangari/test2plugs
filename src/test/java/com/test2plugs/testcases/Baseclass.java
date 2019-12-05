package com.test2plugs.testcases;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.test2plugs.utilities.Readconfig;

public class Baseclass {
	Readconfig readconfig=new Readconfig();
	public String url=readconfig.getApplicationurl();

	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			//System.setProperty("webdriver.chrome.driver", System.getProperty("User.dir")+"//drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxpath());
			driver=new FirefoxDriver();
		}
		logger=Logger.getLogger("test2plug");
		PropertyConfigurator.configure("log4j.properties");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		//File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File source = ts.getScreenshotAs(OutputType.FILE);
		//File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
		File target = new File("C:\\Users\\BIJOY\\Desktop\\busyqa course work\\eclipse\\test2plugs\\screenshots" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
}
