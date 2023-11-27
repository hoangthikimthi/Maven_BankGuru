package pageObject.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.bankguru.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void closeIframePopup() {
		WebElement iframe = getWebElement(NewCustomerPageUI.IFRAME);
		if (iframe.isDisplayed()) {
			switchToFrameIframe(NewCustomerPageUI.IFRAME).close();
			switchToDefaultContent();
		}

	}

	public boolean isCustomerPageDisplayed() {
		waitForElementVisible(NewCustomerPageUI.ADD_NEW_CUSTOMER_TEXT);
		return isElementDisplayed(NewCustomerPageUI.ADD_NEW_CUSTOMER_TEXT);
	}

	public void enterTabKeysOnCustomerNameTextbox(String textboxName, Keys key) {
		waitForElementVisible(NewCustomerPageUI.DYNAMIC_TEXTBOX_NAME, textboxName);
		pressKeyToElement(NewCustomerPageUI.DYNAMIC_TEXTBOX_NAME, key, textboxName);

	}

	public String getMessageErrorOnCustomerNameTextbox(String textboxName) {
		waitForElementVisible(NewCustomerPageUI.DYNAMIC_TEXTBOX_ERROR_MESSAGE, textboxName);
		return getElementText(NewCustomerPageUI.DYNAMIC_TEXTBOX_ERROR_MESSAGE, textboxName);
	}

	public void inputToCustomerNameTextbox(String textboxName, String textValue) {
		waitForElementClickable(NewCustomerPageUI.DYNAMIC_TEXTBOX_NAME, textboxName);
		sendkeysToElement(NewCustomerPageUI.DYNAMIC_TEXTBOX_NAME, textValue, textboxName);

	}

	public void selectGenderRadioButton(String string) {
		// TODO Auto-generated method stub

	}

	public void selectDateOfBirth(String string) {
		// TODO Auto-generated method stub

	}

	public void inputToAddressTextbox(String string, String string2) {
		// TODO Auto-generated method stub

	}

	public void inputToCityTextBox(String string, String string2) {
		// TODO Auto-generated method stub

	}

	public void inputToStateTextbox(String string, String string2) {
		// TODO Auto-generated method stub

	}

	public void inputToPINTextbox(String string, String string2) {
		// TODO Auto-generated method stub

	}

	public void inputToMobileTextbox(String string, String string2) {
		// TODO Auto-generated method stub

	}

	public void inputToEmailTextbox(String string, String string2) {
		// TODO Auto-generated method stub

	}

	public void inputToPasswordTextbox(String string, String string2) {
		// TODO Auto-generated method stub

	}

}
