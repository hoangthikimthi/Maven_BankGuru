package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class MiniStatementPageObject extends BasePage {
	WebDriver driver;

	public MiniStatementPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
