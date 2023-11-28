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
import utilities.DataFaker;

public class Payment extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPageObject newCustomerPage;
	String customerName, dateOfBirth, address, city, state, mobile, emailCustomer;
	int pin;

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
		customerName = DataFaker.getFirstName() + DataFaker.getLastName();
		dateOfBirth = "01/01/1989";
		address = DataFaker.getEmail();
		city = DataFaker.getCity();
		emailCustomer = DataFaker.getEmail();
		state = DataFaker.getState();
		pin = DataFaker.getPIN();
		mobile = DataFaker.getPhoneNumber();
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
		newCustomerPage.inputToTextboxByName("Customer Name", "AUTOMATION TESTING");

		log.info("TC_01_Step_03:  Fill in Gender Radio Button");
		newCustomerPage.selectGenderMaleRadioButton();

		log.info("TC_01_Step_04:  Fill in Date Of birth");
		newCustomerPage.inputDateOfBirth(dateOfBirth);

		log.info("TC_01_Step_05:  Fill in Address");
		newCustomerPage.inputToTextboxByName("Address", address);

		log.info("TC_01_Step_06:  Fill in City");
		newCustomerPage.inputToTextboxByName("City", city);

		log.info("TC_01_Step_07:  Fill in State");
		newCustomerPage.inputToTextboxByName("State", state);

		log.info("TC_01_Step_08:  Fill in PIN");
		newCustomerPage.inputToTextboxByName("PIN", String.valueOf(pin));

		log.info("TC_01_Step_09:  Fill in Mobile");
		newCustomerPage.inputToTextboxByName("Mobile Number", mobile);

		log.info("TC_01_Step_10:  Fill in Email");
		newCustomerPage.inputToTextboxByName("E-mail", emailCustomer);

		log.info("TC_01_Step_11:  Fill in Password");
		newCustomerPage.inputToTextboxByName("Password", Register.password);

		log.info("TC_01_Step_12:  Click Submit button");
		managerPage = newCustomerPage.clickToSubmitButton();

		log.info("TC_01_Step_13:  Verify add new customer successfully");
		Assert.assertEquals(managerPage.getRegisterSuccessMessage(), "Customer Registered Successfully!!!");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
