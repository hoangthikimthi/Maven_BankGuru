package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DeleteCustomerPageObject extends BasePage {
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
