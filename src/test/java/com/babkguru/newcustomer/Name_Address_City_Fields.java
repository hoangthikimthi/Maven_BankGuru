package com.babkguru.newcustomer;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;

import com.bankguru.register.Register;

import commons.BaseTest;
import pageObject.bankguru.LoginPageObject;
import pageObject.bankguru.ManagerPageObject;
import pageObject.bankguru.RegisterPageObject;

public class Name_Address_City_Fields extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;

	@Parameters({ "browserName", "serverName", "envName" })
	@BeforeClass
	// public void beforeClass(String browserName, String serverName, String envName) {
	// driver = getBrowserDriver(browserName, serverName, envName);
	public void beforeClass(@Optional("chrome") String browserName, @Optional("dev") String serverName, @Optional("local") String envName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(browserName, serverName, envName, ipAddress, portNumber, osName, osVersion);

		// LOGIN
		log.info("Login - 01:  Navigate to 'Login' page");
		loginPage = registerPage.openLoginPage();

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
	public void TC_01_VerifyNameField() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
