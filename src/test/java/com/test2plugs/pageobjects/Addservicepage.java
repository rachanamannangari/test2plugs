package com.test2plugs.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Addservicepage {
	WebDriver ldriver;
	public Addservicepage(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	By creatnew =By.xpath("//span[contains(text(),'Create New')]");
	By addservice=By.xpath("/html/body/div[7]/nav/div/form/div[2]/ul/li[1]/a");
	By title_textbox=By.xpath("//input[@id='name']");
	By descriptiontextbox=By.xpath(" //textarea[@id='description']");
	By categorydropdown=By.xpath("//select[@id='category_id']");
	By pricetextbox=By.xpath("//input[@id='price']");
	By refundvalidtextbox=By.xpath("//input[@id='refund_valid']");
	By refundpercent =By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all']");
	By youtubeurl=By.xpath("//input[@id='refund_valid']");
	By addimage=By.xpath("//*[@id=\"download-line\"]/li[1]");
	By checkboxes=By.xpath("//div[@class= 'jq-checkbox']");
	By checkbox=By.xpath("//input[@name='active']");
	By bidbox=By.xpath("//*[@id=\"imagegroup\"]/div[4]/div/ul/li[2]/span/label/div");
	By create=By.xpath("//*[@id=\"imagegroup\"]/div[5]/ul/li[2]/button");
	public void title(String title)
	{
		ldriver.findElement(title_textbox).sendKeys(title);
	}
	public void description(String desc)
	{
		ldriver.findElement(descriptiontextbox).sendKeys(desc);
		
	}
	public void createnew()
	{
		ldriver.findElement(creatnew).click();
	}
	public void creatnewservice()
	{
		ldriver.findElement(addservice).click();
	}
	
public void category(String value) throws InterruptedException
{
	//ldriver.findElement(categorydropdown).click();
	Select drop=new Select(ldriver.findElement(categorydropdown));
	Thread.sleep(3000);
	drop.selectByValue(value);
	
	}


public void price(String price)
{
	ldriver.findElement(pricetextbox).sendKeys(price);
}
public void refundper()
{
	WebElement slider=ldriver.findElement(refundpercent);
	Actions mouse=new Actions(ldriver);
	mouse.moveToElement(slider).dragAndDropBy(slider, 100, 0).build().perform();
	
	
}
public void refundValid(String refundvalid) throws InterruptedException 
{
	ldriver.findElement(refundvalidtextbox).sendKeys(refundvalid);
	Thread.sleep(5000);
	
}

public void addImage() throws InterruptedException, FindFailed
{
	WebElement image=ldriver.findElement(addimage);
	JavascriptExecutor js=(JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].scrollIntoView();", image);
	Thread.sleep(5000);
	Actions mose=new Actions(ldriver) ;
	mose.moveToElement(image).doubleClick().build().perform();
	
	//js.executeScript("arguments[0].click();", image);
	//image.click();
	
	//Thread.sleep(5000);
	Pattern fileinputTextbox=new Pattern("C:\\selenium\\fileupload\\Capture.PNG");
	Pattern  openbutton=new Pattern("C:\\selenium\\fileupload\\openbutton.PNG");
	Screen s=new Screen();
	Thread.sleep(3000);
	s.wait(fileinputTextbox,20);
	s.type(fileinputTextbox,"C:\\selenium\\fileupload\\dog.jfif");
	s.click(openbutton);
//Thread.sleep(2000);
}

public void checkBox(String name) throws InterruptedException
{
	String exp=ldriver.findElement(checkboxes).getText();
	System.out.println();
	if(exp.equalsIgnoreCase(name))
	{
		ldriver.findElement(checkboxes).isSelected();
	}
	else if (name.equalsIgnoreCase("no bidding allowed")) {
		ldriver.findElement(bidbox).click();
		Thread.sleep(5000);
	}
	else
	{
		ldriver.findElement(checkbox).isSelected();
		ldriver.findElement(bidbox).isSelected();
	}
}
	public void serviceCreate()
	{
		ldriver.findElement(create).click();
	}

}
