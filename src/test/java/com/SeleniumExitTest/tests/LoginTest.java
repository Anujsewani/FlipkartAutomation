package com.SeleniumExitTest.tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SeleniumExitTest.pages.LoginPage;
import com.SeleniumExitTest.utils.CommonUtils;
import com.SeleniumExitTest.utils.ReadDataFromExcel;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest {

	private String sheetName = prop.getProperty("loginPageSheetName");

	@Test(groups = { "validLogin" }, priority = 2, enabled = true)

	public void validLogin() throws InterruptedException {
		// extentTest=extent.startTest("verifying the valid login");
		String testCaseName = "whenUserEntersValidMobileNumberAndValidPassword";
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Valid Login page");

			// Fetching all test data from excel file

			fetchData = reader.getRowTestData(sheetName, testCaseName);

			String user = fetchData.get("Username");
			String pass = fetchData.get("Password");
			String title = fetchData.get("Expected Title");
			String executionRequired = fetchData.get("Execution Required");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);
			// Thread.sleep(2000);
			login.enterUserName(user);
			login.enterPassword(pass);
			Thread.sleep(2000);
			login.clickSubmit();

			Assert.assertEquals(driver.getTitle(), title);
			logg.info("login button was clicked");
			extentTest.log(LogStatus.PASS, "Valid Login Functionality is working successfully");
			extent.endTest(extentTest);

		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

		// extentTest.log(LogStatus.PASS,"Login done Successfully!!!");
//		extent.endTest(extentTest);
	}

	@Test(groups = { "invalidLogin" }, priority = 3, enabled = true)
	public void invalidUsername() throws InterruptedException {

		String testCaseName = "whenUserEntersInvalidMobileNumberAndValidPassword";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Login page");
			fetchData = reader.getRowTestData(sheetName, testCaseName);

			// String executionRequired = fetchData.get("Execution Required");
			String user = fetchData.get("Username");
			String pass = fetchData.get("Password");
			String message = fetchData.get("Message");
			String executionRequired = fetchData.get("Execution Required");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);

			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
			Thread.sleep(5000);
			Assert.assertEquals(login.message.getText(), message);
			logg.info("login button was clicked");
			extentTest.log(LogStatus.INFO, "Invalid username Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}
	}

	@Test(groups = { "invalidLogin" }, priority = 4, enabled = true)
	public void invalidPassword() throws InterruptedException {

		String testCaseName = "whenUserEntersValidMobileNumberAndInvalidPassword";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Login page");
			fetchData = reader.getRowTestData(sheetName, testCaseName);

			String executionRequired = fetchData.get("Execution Required");
			String user = fetchData.get("Username");
			String pass = fetchData.get("Password");
			String message = fetchData.get("Message");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);

			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
			Thread.sleep(5000);
			Assert.assertEquals(login.message.getText(), message);
			logg.info("login button was clicked");
			extentTest.log(LogStatus.INFO, "InValid Password Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

	}

	@Test(groups = { "invalidLogin" }, priority = 5, enabled = true)
	public void emptyUsernameAndEmptyPassword() throws InterruptedException {

		String testCaseName = "whenUserEntersEmptyMobileNumberAndEmptyPassword";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Login page");
			fetchData = reader.getRowTestData(sheetName, testCaseName);

			String executionRequired = fetchData.get("Execution Required");
			String user = fetchData.get("Username");
			String pass = fetchData.get("Password");
			String title = fetchData.get("Expected Title");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);
			LoginPage login = new LoginPage(driver);

			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
			Thread.sleep(5000);
			Assert.assertEquals(driver.getTitle(), title);
			logg.info("login button was clicked");
			extentTest.log(LogStatus.INFO, "Empty Username and Password Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

	}

	@Test(groups = { "invalidLogin" }, priority = 6, enabled = true)
	public void emptyUsername() {

		String testCaseName = "whenUserEntersEmptyMobileNumberAndValidPassword";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Login page");
			fetchData = reader.getRowTestData(sheetName, testCaseName);

			String executionRequired = fetchData.get("Execution Required");
			String user = fetchData.get("Username");
			String pass = fetchData.get("Password");
			String title = fetchData.get("Expected Title");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);

			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
			Assert.assertEquals(driver.getTitle(), title);
			logg.info("login button was clicked");
			extentTest.log(LogStatus.INFO, "Empty Username Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

	}

	@Test(groups = { "invalidLogin" }, priority = 7, enabled = true)
	public void emptyPassword() {

		String testCaseName = "whenUserEntersValidMobileNumberAndEmptyPassword";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Login page");
			fetchData = reader.getRowTestData(sheetName, testCaseName);

			String executionRequired = fetchData.get("Execution Required");
			String user = fetchData.get("Username");
			String pass = fetchData.get("Password");
			String title = fetchData.get("Expected Title");
			// log all data
			CommonUtils.logTestData(sheetName, testCaseName);

			// if execution required field is no
			CommonUtils.toCheckExecutionRequired(executionRequired);

			LoginPage login = new LoginPage(driver);

			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
			Assert.assertEquals(driver.getTitle(), title);
			logg.info("login button was clicked");
			extentTest.log(LogStatus.INFO, "Empty Password Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

	}

}
