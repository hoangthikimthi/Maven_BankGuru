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

}
