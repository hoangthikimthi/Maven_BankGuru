package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class CustomisedStatementPageObject extends BasePage {
	WebDriver driver;

	public CustomisedStatementPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
