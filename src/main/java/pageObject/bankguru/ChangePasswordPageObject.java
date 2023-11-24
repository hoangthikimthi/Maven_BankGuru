package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class ChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
