package com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.nopcommerce.user.NoteBookPageObject;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserLoginPageObject;

public class Sort_Display_Paging extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	NoteBookPageObject notebookPage;

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
		notebookPage = homePage.clickToNoteBookLink();
		verifyTrue(notebookPage.isPageTitleDisplay("Notebooks"));
	}
//@Test
public void TC_01_Sort_ASC() {
	notebookPage.selectDropdownSortBy("Name: A to Z");
	Assert.assertEquals(notebookPage.getFistSelectOptionInProductOder(), "Name: A to Z");
	Assert.assertTrue(notebookPage.isProductNameSortCorrectly(false));
}

//@Test
public void TC_02_Sort_DESC() {
	notebookPage.selectDropdownSortBy("Name: Z to A");
	Assert.assertEquals(notebookPage.getFistSelectOptionInProductOder(), "Name: Z to A");
	Assert.assertTrue(notebookPage.isProductNameSortCorrectly(true));
}

//@Test
public void TC_03_Sort_Price_LowToHigh() {
	notebookPage.selectDropdownSortBy("Price: Low to High");
	Assert.assertEquals(notebookPage.getFistSelectOptionInProductOder(), "Price: Low to High");
	Assert.assertTrue(notebookPage.isPriceSortCorrectly(false));
}

@Test
public void TC_04_Sort_Price_HightToLow() {
	notebookPage.selectDropdownSortBy("Price: High to Low");
	Assert.assertEquals(notebookPage.getFistSelectOptionInProductOder(), "Price: High to Low");
	Assert.assertTrue(notebookPage.isPriceSortCorrectly(true));
}

//@Test
public void TC_05_Paging_3() {
	notebookPage.selectPageSizeDropDown("3");
	Assert.assertEquals(notebookPage.getFistSelectOptionInPageSize(), "3");
	Assert.assertTrue(notebookPage.isNumberOfProductDisplayCorrectly(3));
	Assert.assertTrue(notebookPage.isPagingDisplayCorrectly("1","Next"));
	Assert.assertTrue(notebookPage.isPagingDisplayCorrectly("2","Previous"));
}

//@Test
public void TC_06_Paging_6() {
	notebookPage.selectPageSizeDropDown("6");
	Assert.assertEquals(notebookPage.getFistSelectOptionInPageSize(), "6");
	Assert.assertTrue(notebookPage.isNumberOfProductDisplayCorrectly(6));
	Assert.assertFalse(notebookPage.isPagingFound("Next", "Previous"));
}

//@Test
public void TC_07_Paging_9() {
	notebookPage.selectPageSizeDropDown("9");
	Assert.assertEquals(notebookPage.getFistSelectOptionInPageSize(), "9");
	Assert.assertTrue(notebookPage.isNumberOfProductDisplayCorrectly(9));
	Assert.assertFalse(notebookPage.isPagingFound("Next", "Previous"));
}
	@AfterClass(alwaysRun = true)
	public void AfterClass() {
		closeBrowserDriver();
	}
}
