package com.bankguru.register;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.bankguru.LoginPageObject;
import pageObject.bankguru.ManagerPageObject;
import pageObject.bankguru.RegisterPageObject;
import utilities.DataFaker;

public class Register extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	public static String emailID, userID, password;
	DataFaker dataFaker;

	@Parameters({ "browserName", "registerURL", "envName" })
	@BeforeClass
	// public void beforeClass(@Optional("chrome") String browserName, @Optional("dev") String serverName, @Optional("local") String envName, @Optional("localhost")
	// String ipAddress, @Optional("4444") String portNumber,
	// @Optional("Windows") String osName, @Optional("10") String osVersion) {
	// driver = getBrowserDriver(browserName, serverName, envName, ipAddress, portNumber, osName, osVersion);
	public void beforeClass(String browserName, String registerURL, String envName) {
		driver = getBrowserDriver(browserName, registerURL, envName);

		log.info("Register - 01: Navigate to 'Register' page");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		emailID = dataFaker.getEmail();

	}

	@Test
	public void Login_01_register() {

		log.info("Register - 02: Enter Valid Email to Email ID textbox");
		registerPage.sendkeysToEmailIDTextbox(emailID);

		log.info("Register - 03: Click to submit button");
		registerPage.clickToSubmitButton();

		log.info("Register - 04: Check UserID and Password display and get value ");
		userID = registerPage.checkDisplayAndGetUserIDGenerator();
		password = registerPage.checkDisplayAndGetPasswordGenerator();

	}

	// @Test
	// public void Login_02_Login() {
	//
	// // LOGIN
	// log.info("Login - 01: Navigate to 'Login' page");
	// loginPage = registerPage.openLoginPage();
	//
	// log.info("Login - 02: Enter to UserID textbox with value: " + userID);
	// loginPage.inputUserIDTextbox(userID);
	//
	// log.info("Login - 03: Enter to Password textbox with value: " + password);
	// loginPage.inputPasswordTextbox(password);
	//
	// log.info("Login - 04: Click to Login button");
	// managerPage = loginPage.clickToLoginButton();
	//
	// log.info("Login - 05: Verify Manager's Page is displayed");
	// Assert.assertEquals(managerPage.wellcomeMessageIsDisplayed(), "Welcome To Manager's Page of Guru99 Bank");
	// }

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
