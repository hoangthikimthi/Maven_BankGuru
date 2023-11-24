package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUI.bankguru.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputUserIDTextbox(String userID) {
		waitForElementVisible(LoginPageUI.USER_ID_TEXTBOX);
		sendkeysToElement(LoginPageUI.USER_ID_TEXTBOX, userID);
	}

	public void inputPasswordTextbox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public ManagerPageObject clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getManagerPage(driver);

	}

}
