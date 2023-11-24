package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class NewAccountPageObject extends BasePage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
