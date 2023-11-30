package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.bankguru.ManagerPageUI;

public class ManagerPageObject extends BasePage {
	WebDriver driver;

	public ManagerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String wellcomeMessageIsDisplayed() {
		waitForElementVisible(ManagerPageUI.WELCOME_MESSAGE);
		return getElementText(ManagerPageUI.WELCOME_MESSAGE);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(ManagerPageUI.CUSTOMER_REGISTER_SUCCESS_MESSAGE);
		return getElementText(ManagerPageUI.CUSTOMER_REGISTER_SUCCESS_MESSAGE);
	}

	public boolean isCustomerIDDisplayed() {
		waitForElementVisible(ManagerPageUI.CUSTOMER_INFO_ID);
		return isElementDisplayed(ManagerPageUI.CUSTOMER_INFO_ID);
	}

	public String getInfoCustomerInValue(String value) {
		waitForElementVisible(ManagerPageUI.DYNAMIC_CUSTOMER_INFO_VALUE, value);
		return getElementText(ManagerPageUI.DYNAMIC_CUSTOMER_INFO_VALUE, value);
	}

	public String getAccountGeneratedSuccessMessage() {
		waitForElementVisible(ManagerPageUI.CUSTOMER_REGISTER_SUCCESS_MESSAGE);
		return getElementText(ManagerPageUI.CUSTOMER_REGISTER_SUCCESS_MESSAGE);
	}

	public String getInfoAccountInValue(String value) {
		waitForElementVisible(ManagerPageUI.DYNAMIC_CUSTOMER_INFO_VALUE, value);
		return getElementText(ManagerPageUI.DYNAMIC_CUSTOMER_INFO_VALUE, value);
	}

}
