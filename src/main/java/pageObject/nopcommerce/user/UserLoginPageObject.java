package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopcommerce.user.LoginPageUI;


public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendkeysEmailTextbox(String emailAddress) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	
		
	}

	public void sendkeysPasswordTextbox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXBOX);
		sendkeysToElement(LoginPageUI.PASSWORD_TEXBOX, password);
	
		
	}

	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	
	}
}
