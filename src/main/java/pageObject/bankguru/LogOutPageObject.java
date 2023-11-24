package pageObject.bankguru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LogOutPageObject extends BasePage {
	WebDriver driver;

	public LogOutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
