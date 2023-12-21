package com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserLoginPageObject;
import pageObject.nopcommerce.user.UserSearchPageObject;

public class SearchAdvance extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserSearchPageObject searchPage;
	String relativeData, absoluteData;

	@Parameters({ "browser", "serverName", "envName" })
	@BeforeClass
	public void BeforeClass(String browser, String serverName, String envName) {
		driver = getBrowserDriver(browser, serverName, envName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		loginPage = homePage.openLoginPage();

		loginPage.sendkeysEmailTextbox(Common_Register.emailAddress);
		loginPage.sendkeysPasswordTextbox(Common_Register.password);
		homePage = loginPage.clickToLoginButton();
		verifyTrue(homePage.isLogoutLinkDisplayed());
		searchPage = homePage.clickToSearchPageLink();
		verifyTrue(searchPage.isSearchPageDisplayed());
		
		relativeData = "Lenovo";
		absoluteData = "Apple MacBook Pro 13-inch";

	}

	@Test
	public void TC_01_SearchWithEmptyData() {
		searchPage.inputToSearchTextbox("");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getErrorMessage(), "Search term minimum length is 3 characters");

	}
	
	@Test
	public void TC_02_SearchWithDataNotExits() {
		searchPage.inputToSearchTextbox("Macbook Pro 2050");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNoProductMessage(), "No products were found that matched your criteria.");

	}

	@Test
	public void TC_03_SearchWithRelativeData() {
		searchPage.inputToSearchTextbox(relativeData);
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isResultShowCorrectly(relativeData,2));
	}
	
	@Test
	public void TC_04_SearchWithAbsoluteData() {
		searchPage.inputToSearchTextbox(absoluteData);
		searchPage.clickToSearchButton();
		Assert.assertTrue(searchPage.isResultShowCorrectly(absoluteData,1));
	}
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
