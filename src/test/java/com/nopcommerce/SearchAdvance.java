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
	String relativeData, absoluteData, macbookpro;

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
		macbookpro = "Apple MacBook Pro";
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
		Assert.assertEquals(searchPage.numberOfProductTitle(), 2);
		Assert.assertTrue(searchPage.isProductTitleContainSearchKey(relativeData));
		
		
	}
	
	@Test
	public void TC_04_SearchWithAbsoluteData() {
		searchPage.inputToSearchTextbox(absoluteData);
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.numberOfProductTitle(), 1);
		Assert.assertTrue(searchPage.isProductTitleContainSearchKey(absoluteData));
	}
	
	@Test
	public void TC_05_SearchWithParentCategory() {
		searchPage.inputToSearchTextbox(macbookpro);
		searchPage.checkAdvancedSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.uncheckSearchSubCategories();
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNoProductMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_06_SearchWithSubCategory() {
		searchPage.inputToSearchTextbox(macbookpro);
		searchPage.checkAdvancedSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSearchSubCategories();
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.numberOfProductTitle(), 1);
		Assert.assertTrue(searchPage.isProductTitleContainSearchKey(macbookpro));
	}
	
	@Test
	public void TC_07_SearchWithIncorrectManufacturer() {
		searchPage.inputToSearchTextbox(macbookpro);
		searchPage.checkAdvancedSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSearchSubCategories();
		searchPage.selectManufacturer("HP");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.getNoProductMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_08_SearchWithCorrectManufacturer() {
		searchPage.inputToSearchTextbox(macbookpro);
		searchPage.checkAdvancedSearchCheckbox();
		searchPage.selectCategory("Computers");
		searchPage.checkSearchSubCategories();
		searchPage.selectManufacturer("Apple");
		searchPage.clickToSearchButton();
		Assert.assertEquals(searchPage.numberOfProductTitle(), 1);
		Assert.assertTrue(searchPage.isProductTitleContainSearchKey(macbookpro));
		}
	
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
