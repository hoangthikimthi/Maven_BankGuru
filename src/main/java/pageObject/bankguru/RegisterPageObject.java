package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUI.bankguru.LoginPageUI;
import pageUI.bankguru.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendkeysToEmailIDTextbox(String emailID) {
		waitForElementVisible(RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendkeysToElement(RegisterPageUI.EMAIL_ID_TEXTBOX, emailID);

	}

	public void clickToSubmitButton() {
		waitForElementClickable(RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(RegisterPageUI.SUBMIT_BUTTON);
	}

	public String checkDisplayAndGetUserIDGenerator() {
		waitForElementVisible(RegisterPageUI.USER_ID);
		isElementDisplayed(RegisterPageUI.USER_ID);
		return getElementText(RegisterPageUI.USER_ID);
	}

	public String checkDisplayAndGetPasswordGenerator() {
		waitForElementVisible(RegisterPageUI.PASSWORD);
		isElementDisplayed(RegisterPageUI.PASSWORD);
		return getElementText(RegisterPageUI.PASSWORD);
	}

	public LoginPageObject openLoginPage() {
		openPageUrl(GlobalConstants.lOGIN_PAGE_URL);
		return PageGeneratorManager.getLoginPage(driver);
	}
}
