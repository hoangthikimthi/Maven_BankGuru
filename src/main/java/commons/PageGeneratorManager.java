package commons;

import org.openqa.selenium.WebDriver;

import pageObject.bankguru.LoginPageObject;
import pageObject.bankguru.ManagerPageObject;
import pageObject.bankguru.RegisterPageObject;

public class PageGeneratorManager {

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ManagerPageObject getManagerPage(WebDriver driver) {
		return new ManagerPageObject(driver);
	}
}
