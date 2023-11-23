package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ManagerPageObject extends BasePage {
	WebDriver driver;

	public ManagerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void isWellcomeMessageDisplayed() {
		// TODO Auto-generated method stub

	}

}
