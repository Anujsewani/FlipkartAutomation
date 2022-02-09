package com.SeleniumExitTest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	//productsearchxpaths
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/input[1]")
	public WebElement searchBox;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/button[1]/*[name()='svg'][1]")
	public WebElement searchIcon;
	
	//addtowishlishxpaths
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/a[1]/div[2]/div[1]/*[name()='svg'][1]/*[name()='path'][1]")
	public WebElement heartIcon;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[5]/a[1]")
	public WebElement wishlist;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]")
	public WebElement message;
	
	//removefromwishlistxpaths
	
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[2]/div[2]/div[1]/span[1]/img[1]")
	public WebElement delete;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[2]")
	public WebElement confirmDelete;
	@FindBy(how=How.CLASS_NAME ,using="_3Juh7R")
	public WebElement wishlistMessage;
	
	//orders
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[4]/a[1]")
	public WebElement orders;
	
	//supercoin
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[2]/a[1]/div[1]")
	public WebElement coins;
	//Flipkart
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]")
	public WebElement flipkart;
	//Pluszone
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[3]/a[1]/div[1]")
	public WebElement pluszone;
	//coupons
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[7]/a[1]/div[1]")
	public WebElement coupons;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[1]/div[2]/div[2]/span[1]")
	public WebElement viewCoupons;
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/strong[1]")
	public WebElement termsandconditions;
	
	//notifications
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[9]/a[1]/div[1]")
	public WebElement notification;
	@FindBy(how=How.CLASS_NAME,using="_3Juh7R")
	public WebElement caughtup;
	
	//productfilterType
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/section[4]/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]")
	public WebElement producttype;
	
	@FindBy(how=How.CLASS_NAME,using="_3sckoD")
	public WebElement filtermessage;
	
	public void searchProduct(String name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchBox.sendKeys(name);
		//driver.manage().timeouts().implicitlyWait(275, TimeUnit.SECONDS);
		Thread.sleep(10000);
		searchIcon.click();
 
	}
	
	public void addToWishlist() throws InterruptedException {
		heartIcon.click();
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(8000);
		wishlist.click();
		
	}
	
	public void removeFromWishlist() throws InterruptedException {
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(2000);
		wishlist.click();
		Thread.sleep(2000);
		delete.click();
		//Thread.sleep(2000);
		confirmDelete.click();
	}
	
	public void yourOrders() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();

		Thread.sleep(8000);
		orders.click();
	}
	
	public void superCoin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(10000);
		coins.click();
	}
	
	public void flipkartLogo() {
		flipkart.click();
	}
	public void flipkartPlusZone() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(5000);
		pluszone.click();
		
	}
	public void getCoupons() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(8000);
		coupons.click();
		viewCoupons.click();
	}
	public void flipkartNotifications() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(profileButton).perform();
		Thread.sleep(8000);
		notification.click();
		
	}
	public void productFilterType() throws InterruptedException {
		producttype.click();
		
	}
 
}
