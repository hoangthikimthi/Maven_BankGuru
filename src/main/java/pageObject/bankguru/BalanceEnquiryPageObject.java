package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class BalanceEnquiryPageObject extends BasePage {
	WebDriver driver;

	public BalanceEnquiryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
