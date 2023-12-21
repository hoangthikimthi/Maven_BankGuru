package pageObject.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopcommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void senkeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeysToElement(RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);

	}
	
	public void senkeysToLastNameTextbox(String firstName) {
		waitForElementVisible(RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeysToElement(RegisterPageUI.LASTNAME_TEXTBOX, firstName);

	}

	public void senkeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(RegisterPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void senkeysToPasswordTextbox(String password) {
		waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void senkeysToConfirmPasswordTextbox(String password) {
		waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeysToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);


	}

	public void clickToRegisterButton() {
		waitForElementClickable(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(RegisterPageUI.REGISTER_SUCCESS_MASSAGE);
		return getElementText(RegisterPageUI.REGISTER_SUCCESS_MASSAGE);

	}

}
