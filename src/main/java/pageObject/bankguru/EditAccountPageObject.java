package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EditAccountPageObject extends BasePage {
	WebDriver driver;

	public EditAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
