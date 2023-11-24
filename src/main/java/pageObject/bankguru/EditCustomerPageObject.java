package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class EditCustomerPageObject extends BasePage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
