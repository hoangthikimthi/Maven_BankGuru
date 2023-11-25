package pageObject.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.bankguru.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isIframeDisplayed() {
		waitForElementVisible(NewCustomerPageUI.IFRAME);
		return isElementDisplayed(NewCustomerPageUI.IFRAME);
	}

	public void closeIframe() {
		switchToFrameIframe(NewCustomerPageUI.IFRAME).close();
		switchToDefaultContent();
	}

	public boolean isCustomerPageDisplayed() {
		waitForElementVisible(NewCustomerPageUI.ADD_NEW_CUSTOMER_TEXT);
		return isElementDisplayed(NewCustomerPageUI.ADD_NEW_CUSTOMER_TEXT);
	}

	public void clickToNameTextbox() {
		waitForElementVisible(NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		clickToElement(NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
	}

	public void enterTabKeyboard(String string) {
		pressKeyToElement(NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		
	}

	public boolean isErrorMessageNotBeBlankDisplayed() {
		waitForElementVisible(NewCustomerPageUI.BLANK_CUSTOMER_NAME_MESSAGE);
		return isElementDisplayed(NewCustomerPageUI.BLANK_CUSTOMER_NAME_MESSAGE);
	}

}
