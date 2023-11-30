package pageObject.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
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

	public void inputToTextboxByName(String textboxName, String textValue) {
		waitForElementClickable(NewCustomerPageUI.DYNAMIC_TEXTBOX_NAME, textboxName);
		sendkeysToElement(NewCustomerPageUI.DYNAMIC_TEXTBOX_NAME, textValue, textboxName);

	}

	public void selectGenderMaleRadioButton() {
		waitForElementClickable(NewCustomerPageUI.MALE_GENDER);
		clickToElement(NewCustomerPageUI.MALE_GENDER);

	}

	public void inputDateOfBirth(String date) {
		waitForElementClickable(NewCustomerPageUI.DATE_OF_BIRTH);
		removeAttributeInDOM(NewCustomerPageUI.DATE_OF_BIRTH, "type");
		sendkeysToElement(NewCustomerPageUI.DATE_OF_BIRTH, date);
	}

	public ManagerPageObject clickToSubmitButton() {
		waitForElementClickable(NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(NewCustomerPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getManagerPage(driver);
	}

	public void inputToAreaByName(String textAreaName, String address) {
		waitForElementClickable(NewCustomerPageUI.DYNAMIC_TEXTAREA_NAME, textAreaName);
		sendkeysToElement(NewCustomerPageUI.DYNAMIC_TEXTAREA_NAME, address, textAreaName);

	}

	public void turnOffPopup() {
		if (isElementDisplayed(NewCustomerPageUI.POPUP)) {
			switchToFrameIframe(NewCustomerPageUI.POPUP);
			clickToElement(NewCustomerPageUI.CLOSE_POPUP_BUTTON);
			switchToDefaultContent();
		}

	}

}
