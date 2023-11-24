package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class FundTransferPageObject extends BasePage {
	WebDriver driver;

	public FundTransferPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
