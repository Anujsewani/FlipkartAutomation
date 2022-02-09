package com.SeleniumExitTest.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SeleniumExitTest.pages.LoginPage;
import com.SeleniumExitTest.pages.LogoutPage;
import com.SeleniumExitTest.utils.CommonUtils;
import com.relevantcodes.extentreports.LogStatus;

public class LogoutTest extends BaseTest {

	private String sheetName = prop.getProperty("logoutPageSheetName");

	@Test(groups = { "validLogin" }, priority = 1, enabled = true)
	public void logout() throws InterruptedException {

		String testCaseName = "whenUserClickLogoutButton";
		// Fetching all test data from excel file
		HashMap<String, String> fetchData = new HashMap<String, String>();
		try {
			extentTest = extent.startTest("Verifying the functionality of Logout page");
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
			LogoutPage logout = new LogoutPage(driver);

			login.enterUserName(user);
			login.enterPassword(pass);
			login.clickSubmit();
			Thread.sleep(5000);
			logout.clickProfile();
			Thread.sleep(12000);
			logout.clickLogout();
			Thread.sleep(5000);
			logg.info("logout button was clicked button was clicked");
			Assert.assertEquals(driver.getTitle(), title);

			extentTest.log(LogStatus.PASS, "Logout Functionality is working fine");
			extent.endTest(extentTest);
		} catch (AssertionError e) {
			extentTest.log(LogStatus.FAIL, "failed");
			extent.endTest(extentTest);

		}

		// assert.assertEquals(driver.getClass(),"_1_3w1N");

	}
}
