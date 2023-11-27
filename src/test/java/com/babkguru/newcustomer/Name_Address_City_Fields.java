package com.babkguru.newcustomer;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.register.Register;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.bankguru.LoginPageObject;
import pageObject.bankguru.ManagerPageObject;
import pageObject.bankguru.NewCustomerPageObject;
import pageObject.bankguru.RegisterPageObject;
import utilities.ExcelUtils;

public class Name_Address_City_Fields extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPageObject newCustomerPage;

	@Parameters({ "browserName", "loginURL", "envName" })
	@BeforeClass
	public void beforeClass(String browserName, String loginURL, String envName) {
		driver = getBrowserDriver(browserName, loginURL, envName);
		// public void beforeClass(@Optional("chrome") String browserName, @Optional("dev") String serverName, @Optional("local") String envName, @Optional("localhost")
		// String ipAddress, @Optional("4444") String portNumber,
		// @Optional("Windows") String osName, @Optional("10") String osVersion) {
		// driver = getBrowserDriver(browserName, serverName, envName, ipAddress, portNumber, osName, osVersion);
		//
		// // LOGIN
		log.info("Login - 01:  Navigate to 'Login' page");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Login - 02:  Enter to UserID textbox with value: " + Register.userID);
		loginPage.inputUserIDTextbox(Register.userID);

		log.info("Login - 03:  Enter to Password textbox with value: " + Register.password);
		loginPage.inputPasswordTextbox(Register.password);

		log.info("Login - 04:  Click to Login button");
		managerPage = loginPage.clickToLoginButton();

		log.info("Login - 05:  Verify Manager's Page is displayed");
		Assert.assertEquals(managerPage.wellcomeMessageIsDisplayed(), "Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_01_NameCanNotBeEmpty() {
		log.info("TC_01_Step_01:  Click to 'New Customer' Page");
		newCustomerPage = (NewCustomerPageObject) managerPage.openBankGuruByPageName("New Customer");

		log.info("TC_01_Step_02:  Verify New Customer Page is displayed");
		newCustomerPage.isCustomerPageDisplayed();

		// log.info("TC_01_Step_03: Click to Name textbox");
		// newCustomerPage.clickToNameTextbox();

		log.info("TC_01_Step_04:  Press TAB keyboard to move to the next Field");
		newCustomerPage.enterTabKeysOnCustomerNameTextbox("Customer Name", Keys.TAB);

		log.info("TC_01_Step_05:  Verify message is shown 'Customer name must not be blank'");
		Assert.assertEquals(newCustomerPage.getMessageErrorOnCustomerNameTextbox("Customer Name"), "Customer name must not be blank");
	}

	@Test
	public void TC_02_NameCanNotHaveSpecialCharacters() throws IOException {
		log.info("TC_02_Step_01: Input secial character on Customer Name textbox");
		newCustomerPage.inputToCustomerNameTextbox("Customer Name", "name!@#");

		log.info("TC_02_Step_02: Verify message is shown 'Special characters are not allowed'");
		Assert.assertEquals(newCustomerPage.getMessageErrorOnCustomerNameTextbox("Customer Name"), "Special characters are not allowed");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closeBrowserDriver();
	}
}
