package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DeleteAccountPageObject extends BasePage {
	WebDriver driver;

	public DeleteAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
