package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopcommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable( HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		// return new RegisterPageObject(driver);
		return PageGeneratorManager.getUserRegisterPage(driver);
	
	}

	public UserLoginPageObject openLoginPage() {
		waitForElementClickable( HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);

	}

	public boolean isLogoutLinkDisplayed() {
		waitForElementVisible(HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.LOGOUT_LINK);
	
	}

	public UserSearchPageObject clickToSearchPageLink() {
		waitForElementVisible(HomePageUI.SEARCH_PAGE_LINK);
		clickToElement(HomePageUI.SEARCH_PAGE_LINK);
		return PageGeneratorManager.getUserSearchPage(driver);
	}

	public NoteBookPageObject clickToNoteBookLink() {
		waitForElementVisible(HomePageUI.COMPUTER_LINK);
		hoverMouseToElement(HomePageUI.COMPUTER_LINK);
		clickToElement(HomePageUI.NOTEBOOK_LINK);
		return PageGeneratorManager.getNoteBookPage(driver);
	}

}
