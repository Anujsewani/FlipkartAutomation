package com.SeleniumExitTest.tests;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SeleniumExitTest.pages.AddToCart;
import com.SeleniumExitTest.pages.HomePage;
import com.SeleniumExitTest.pages.LoginPage;
import com.SeleniumExitTest.utils.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class AddToCartTest extends BaseTest {
	
	private String sheetName1 = prop.getProperty("AddToCartPageSheetName");
	
	
	@Test(groups= {"validLogin"},priority=18, enabled = true)
	public void AddProductToCart() throws InterruptedException {
		

		String testCaseName1 = "whenUserAddsProductToCart";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Add to cart");
			fetchData1 = reader.getRowTestData(sheetName1, testCaseName1);
	
			String executionRequired = fetchData1.get("Execution Required");
			String user = fetchData1.get("Username");
			String pass = fetchData1.get("Password");
			String title=fetchData1.get("Expected Title");
			// log all data
			CommonUtils.logTestData(sheetName1, testCaseName1);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
	
			String search=fetchData1.get("ProductSearch");
			Thread.sleep(5000);
			home.searchProduct(search);

			Thread.sleep(5000);
			
			AddToCart add=new AddToCart(driver);
			
			
			
			add.clickProduct();
			Thread.sleep(2000);
			logg.info("Add to cart button was clicked button was clicked");
			Assert.assertEquals(driver.getTitle(),title);
			extentTest.log(LogStatus.PASS, "Add To Cart Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	@Test(groups= {"validLogin"},priority=19, enabled = true)
	public void RemoveProductFromCart() throws InterruptedException {
		
		String testCaseName1 = "whenUserRemoveProductFromCart";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Removing Product from cart ");
			fetchData1 = reader.getRowTestData(sheetName1, testCaseName1);
	
			String executionRequired = fetchData1.get("Execution Required");
			String user = fetchData1.get("Username");
			String pass = fetchData1.get("Password");
			String title=fetchData1.get("Expected Title");
			// log all data
			CommonUtils.logTestData(sheetName1, testCaseName1);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
	
			String search=fetchData1.get("ProductSearch");
			Thread.sleep(5000);
			home.searchProduct(search);
			Thread.sleep(5000);
			
			AddToCart add=new AddToCart(driver);
			
			
			
			add.clickProduct();
			add.removeProduct();
			Thread.sleep(10000);
			logg.info("Remove button was clicked button was clicked");
			Thread.sleep(5000);
			Assert.assertEquals(add.message.getText(),title);
			extentTest.log(LogStatus.PASS, "Remove from Cart Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
	}
	
	
	@Test(groups= {"validLogin"},priority=20, enabled = true)
	public void SaveForLater() throws InterruptedException {
		

		String testCaseName1 = "whenUserClickSaveForLater";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of save for later");
			fetchData1 = reader.getRowTestData(sheetName1, testCaseName1);
	
			String executionRequired = fetchData1.get("Execution Required");
			String user = fetchData1.get("Username");
			String pass = fetchData1.get("Password");
			String title=fetchData1.get("Expected Title");
			// log all data
			CommonUtils.logTestData(sheetName1, testCaseName1);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);
			LoginPage login=new LoginPage(driver);
			HomePage home=new HomePage(driver);
	
			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
	
			String search=fetchData1.get("ProductSearch");
			Thread.sleep(5000);

			home.searchProduct(search);

			Thread.sleep(5000);
			AddToCart add=new AddToCart(driver);
			
			
			
			add.clickProduct();
			Thread.sleep(2000);
			add.saveForLater();
	
			Thread.sleep(5000);
			logg.info("Save for later button was clicked ");
			Assert.assertEquals(add.later.getText(), title);
			extentTest.log(LogStatus.PASS, "Save For Later Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
	}
	
		
	

}
