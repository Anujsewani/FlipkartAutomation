package com.SeleniumExitTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}

	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")
	public WebElement username;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	public WebElement loginButton;
	
	@FindBy(how = How.XPATH , using = "html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[3]/span[1]")
	public WebElement message;
//	@FindBy(how = How.XPATH , using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/span[2]/span[1]")
//	public WebElement message1;
	

	//Login 
	public void enterUserName(String email) {
		username.sendKeys(email);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickSubmit() {
		
		loginButton.click();
	}
	
//	public void message(String msg) {
//		msg=message.getText();
//	}
//	public void message1(String msg1) {
//		msg1=message1.getText();
//	}


}
