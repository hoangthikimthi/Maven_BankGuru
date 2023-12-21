package com.nopcommerce;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserLoginPageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;

public class Common_Register extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	public static String firstName, lastName, emailAddress, password;

	@Parameters({"browser", "serverName", "envName"})
	@BeforeClass
	public void BeforeClass (String browser, String serverName, String envName) {
		driver = getBrowserDriver(browser, serverName, envName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Thi";
		lastName = "Hoang";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "12345a";

		log.info("Register - Steps 01: Navigate to 'Register' page");
		homePage.openRegisterPage();
		registerPage = homePage.openRegisterPage();

		log.info("Register - Steps 02: Enter Firstname textbox with value is '" + firstName + "'");
		registerPage.senkeysToFirstNameTextbox(firstName);

		log.info("Register - Steps 03: Enter lastName textbox with value is '" + lastName + "'");
		registerPage.senkeysToLastNameTextbox(lastName);

		log.info("Register - Steps 04: Enter exittingEmail textbox with value is '" + emailAddress + "'");
		registerPage.senkeysToEmailTextbox(emailAddress);

		log.info("Register - Steps 05: Enter validPassword textbox with value is '" + password + "'");
		registerPage.senkeysToPasswordTextbox(password);

		log.info("Register - Steps 06: Enter validPassword textbox with value is '" + password + "'");
		registerPage.senkeysToConfirmPasswordTextbox(password);

		log.info("Register - Steps 07: Click to register button");
		registerPage.clickToRegisterButton();

		log.info("Register - Steps 08: Enter Firstname textbox with value is '" + firstName + "'");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}
	@Test
	public void TC_01() {
		
	}

	public int generateFakeNumber() {
		Random ran = new Random();
		return ran.nextInt(9999);

	}

	@AfterClass
	public void closedriver() {
		driver.quit();
	}

}
