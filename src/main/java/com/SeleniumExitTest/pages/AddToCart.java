package com.SeleniumExitTest.pages;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Set;



public class AddToCart {
	
	WebDriver driver;
	public AddToCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}


	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	public WebElement addtocart;
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]")
	public WebElement Remove;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]")
	public WebElement confirmRemove;
	
	@FindBy(how=How.XPATH,using="	/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")
	public WebElement savelater;
	
	@FindBy(how=How.CLASS_NAME ,using="_1LCJ1U")
	public WebElement message;
	
	
	@FindBy(how=How.XPATH ,using="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement later;     
	
	public void clickProduct() throws InterruptedException
	{
	WebDriverWait wait=new WebDriverWait(driver,30);
	//need to switch to this frame before clicking the slider
	Thread.sleep(3000);
	List<WebElement> elements = driver.findElements(By.className("s1Q9rs"));
	elements.get(elements.size()-38).click();

	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("scrollBy(0, 500)");

	String currentHandle = driver.getWindowHandle();
	Set<String> handleSet = driver.getWindowHandles();
	for (String handle : handleSet) {
	if (!handle.equalsIgnoreCase(currentHandle)) {
	driver.switchTo().window(handle);
	}
	}
	Thread.sleep(5000);
	addtocart.click();
	}
	
	
	public void removeProduct() {
		Remove.click();
		confirmRemove.click();
	}
	
	public void saveForLater() {
		savelater.click();
	}
	

}
