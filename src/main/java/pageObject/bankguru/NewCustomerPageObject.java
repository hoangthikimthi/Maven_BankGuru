package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class NewCustomerPageObject extends BasePage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
