package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.bankguru.NewAccountPageUI;

public class NewAccountPageObject extends BasePage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void inputToCustomerID(String customerID) {
		waitForElementVisible(NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendkeysToElement(NewAccountPageUI.CUSTOMER_ID_TEXTBOX, customerID);
	}

	public void selectAccoutType(String accountType) {
		waitForElementVisible(NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDefautDropdown(NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, accountType);
	}

	public void inputToInitialDeposit(String initialDeposit) {
		waitForElementVisible(NewAccountPageUI.INITIAL_DEPOST_TEXTBOX);
		sendkeysToElement(NewAccountPageUI.INITIAL_DEPOST_TEXTBOX, initialDeposit);

	}

	public ManagerPageObject clickToSubmitButton() {
		waitForElementVisible(NewAccountPageUI.SUBMIT_BUTTON);
		clickToElement(NewAccountPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getManagerPage(driver);
	}

}
