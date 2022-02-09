package com.SeleniumExitTest.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SeleniumExitTest.pages.HomePage;
import com.SeleniumExitTest.pages.LoginPage;
import com.SeleniumExitTest.utils.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class HomeTest extends BaseTest {
	
	private String sheetName1 = prop.getProperty("homePageSheetName");
	
	@Test(groups= {"validLogin"},priority=8, enabled = true)
	public void productSearch() throws InterruptedException {

		String testCaseName1 = "whenUserSearchProduct";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Search product");
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
			logg.info("Search button was clicked button");
			Assert.assertEquals(driver.getTitle(), title);
			extentTest.log(LogStatus.PASS, "Search product Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
			
	}
	
	
	@Test(groups= {"validLogin"},priority=9, enabled = true)
	public void wishlistProduct() throws InterruptedException {

		String testCaseName1 = "whenUserWishlistProduct";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Wishlist product");
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
			home.addToWishlist();
			Thread.sleep(5000);
			logg.info("Wishlist button was clicked button");
			Assert.assertEquals(home.message.getText(),title);
			extentTest.log(LogStatus.PASS, "Wishlist Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}

	@Test(groups= {"validLogin"},priority=10, enabled = true)
	public void removeWishlistProduct() throws InterruptedException {

		String testCaseName1 = "whenUserRemoveProductFromWishlist";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Remove Wishlist product");
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
	
			
			Thread.sleep(2000);
			home.removeFromWishlist();
			Thread.sleep(5000);
			logg.info("Remove Wishlist button was clicked ");
			Assert.assertEquals(home.wishlistMessage.getText(),title);
			extentTest.log(LogStatus.PASS, "Remove Wishlist Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
 
	}
	
	@Test(groups= {"validLogin","abc"},priority=11, enabled = true)
	public void myOrders() throws InterruptedException {

		String testCaseName1 = "whenUserClickOrders";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Myorder");
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
	
			
			Thread.sleep(2000);
			home.yourOrders();
			Thread.sleep(5000);
			logg.info("Myorder button was clicked ");
			Assert.assertEquals(driver.getTitle(),title);
			extentTest.log(LogStatus.PASS, "Myorder Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);
	
			}

	}
	
	@Test(groups= {"validLogin","abc"},priority=12, enabled = true)
	public void superCoin() throws InterruptedException {

		String testCaseName1 = "whenUserClickSuperCoins";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Super Coin");
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
	
			
			Thread.sleep(2000);
			home.superCoin();
			
			Thread.sleep(5000);
			logg.info("Myorder button was clicked button");
			Assert.assertEquals(driver.getTitle(), title);
			Thread.sleep(5000);
			
			
			extentTest.log(LogStatus.PASS, "Super Coin Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);
	
			}

	}
	
	@Test(groups= {"validLogin"},priority=13, enabled = true)
	public void flipkartLogo() throws InterruptedException {

		String testCaseName1 = "whenUserClickFlipkartLogo";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Flipkart Logo");
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
			
			Thread.sleep(2000);
			home.searchProduct(search);
			Thread.sleep(2000);
			home.flipkartLogo();
			
			Thread.sleep(5000);
			logg.info("Flipkart logo was clicked button");
			Assert.assertEquals(driver.getTitle(), title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Flipkart Logo Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	
	@Test(groups= {"validLogin"},priority=14, enabled = true)
	public void flipkartPlusZone() throws InterruptedException {

		String testCaseName1 = "whenUserClickFlipkartPlusZone";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Flipkart PlusZone");
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
			
			Thread.sleep(2000);
			home.searchProduct(search);
			Thread.sleep(2000);
			home.flipkartPlusZone();
			
			Thread.sleep(5000);
			logg.info("Flipkart logo was clicked");
			Assert.assertEquals(driver.getTitle(),title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Flipkart Plus Zone Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	
	@Test(groups= {"validLogin"},priority=15, enabled = true)
	public void flipkartCoupons() throws InterruptedException {
		String testCaseName1 = "whenUserClickCoupons";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of Flipkart Coupons");
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
		
			Thread.sleep(2000);
			home.getCoupons();;
			
			Thread.sleep(5000);
			logg.info("Flipkart coupons was clicked ");
			logg.info("Terms and conditions button was clicked");
			Assert.assertEquals(home.termsandconditions.getText(),title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Flipkart Coupons Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}
		
	}
	
	@Test(groups= {"validLogin"},priority=16, enabled = true)
		public void flipkartNotifications() throws InterruptedException {

			String testCaseName1 = "whenUserClickNotifications";
			// Fetching all test data from excel file
			HashMap<String, String> fetchData1 = new HashMap<String,String>();
			try{
				extentTest = extent.startTest("Verifying the functionality of Flipkart Notification");
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
	
				
				Thread.sleep(2000);
				home.flipkartNotifications();
				
				Thread.sleep(5000);
				logg.info("Flipkart Notification button was clicked ");
				Assert.assertEquals(home.caughtup.getText(),title);
				Thread.sleep(5000);
				extentTest.log(LogStatus.PASS, "Flipkart Notification Functionality is working fine");
				extent.endTest(extentTest);
				}
				catch(AssertionError e) {
				extentTest.log(LogStatus.FAIL,"failed");
				extent.endTest(extentTest);

				}

		}
	
	@Test(groups= {"validLogin"},priority=17, enabled = true)
	public void flipkartFilterType() throws InterruptedException {

		String testCaseName1 = "whenUserClicksInTheEar";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData1 = new HashMap<String,String>();
		try{
			extentTest = extent.startTest("Verifying the functionality of product by using some filter");
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
	
			
			Thread.sleep(2000);
			String search=fetchData1.get("ProductSearch");
			Thread.sleep(5000);
			home.searchProduct(search);;
			
			Thread.sleep(5000);
			home.productFilterType();
			Thread.sleep(2000);
			logg.info("Filter In The Ear was clicked ");
			Assert.assertEquals(home.filtermessage.getText(), title);
			Thread.sleep(5000);
			extentTest.log(LogStatus.PASS, "Filter Functionality is working fine");
			extent.endTest(extentTest);
			}
			catch(AssertionError e) {
			extentTest.log(LogStatus.FAIL,"failed");
			extent.endTest(extentTest);

			}

	}
	

}
