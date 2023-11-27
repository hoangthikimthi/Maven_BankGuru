package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.register.Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.bankguru.LoginPageObject;
import pageObject.bankguru.ManagerPageObject;
import pageObject.bankguru.NewCustomerPageObject;
import pageObject.bankguru.RegisterPageObject;

public class Payment extends BaseTest {
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
	public void TC_01_AddNewCustomer() {
		log.info("TC_01_Step_01:  Click to 'New Customer' Page");
		newCustomerPage = (NewCustomerPageObject) managerPage.openBankGuruByPageName("New Customer");

		log.info("TC_01_Step_02:  Fill in Customer Name textbox");
		newCustomerPage.inputToCustomerNameTextbox("Customer Name", "AUTOMATION TESTING");

		log.info("TC_01_Step_03:  Fill in Gender Radio Button");
		newCustomerPage.selectGenderRadioButton("male");

		log.info("TC_01_Step_04:  Fill in Date Of birth");
		newCustomerPage.selectDateOfBirth("01/01/1989");

		log.info("TC_01_Step_05:  Fill in Address");
		newCustomerPage.inputToAddressTextbox("Address", "PO Box 911 8331 Duis Avenue");

		log.info("TC_01_Step_06:  Fill in City");
		newCustomerPage.inputToCityTextBox("City", "Tampa");

		log.info("TC_01_Step_06:  Fill in State");
		newCustomerPage.inputToStateTextbox("State", "FL");

		log.info("TC_01_Step_06:  Fill in PIN");
		newCustomerPage.inputToPINTextbox("PIN", "466250");

		log.info("TC_01_Step_06:  Fill in Mobile");
		newCustomerPage.inputToMobileTextbox("Mobile Number", "4555442476");

		log.info("TC_01_Step_06:  Fill in Email");
		newCustomerPage.inputToEmailTextbox("E-mail", "automation@gmail.com");

		log.info("TC_01_Step_06:  Fill in Password");
		newCustomerPage.inputToPasswordTextbox("Password", "123456");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
