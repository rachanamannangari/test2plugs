package com.test2plugs.pageobjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Signuppage {

	public WebDriver ldriver ;
	public Signuppage( WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	By signup_button=By.xpath("//a[@class='btn btn-border']");
	By usernmame_textbox=By.name("username");
	By email_textbox=By.name("email");
	By password_textbox=By.name("password");
	By signup_button2=By.xpath("//button[@class='btn btn-success w-btn-success wide']");
	public void signupButton()
	{
	ldriver.findElement(signup_button).click();
	}
	public void usernameTextbox(String uname)
	{
		ldriver.findElement(usernmame_textbox).sendKeys(uname);
	}
	public void emailTextbox(String email)
	{
		ldriver.findElement(email_textbox).sendKeys(email);
	}

public void passwordtextbox(String password)
{
	ldriver.findElement(password_textbox).sendKeys(password);
}

public void signupButton2()
{
	ldriver.findElement(signup_button2).click();
}




}