package commons;

import org.openqa.selenium.WebDriver;

import pageObject.bankguru.BalanceEnquiryPageObject;
import pageObject.bankguru.ChangePasswordPageObject;
import pageObject.bankguru.CustomisedStatementPageObject;
import pageObject.bankguru.DeleteAccountPageObject;
import pageObject.bankguru.DeleteCustomerPageObject;
import pageObject.bankguru.DepositPageObject;
import pageObject.bankguru.EditAccountPageObject;
import pageObject.bankguru.EditCustomerPageObject;
import pageObject.bankguru.FundTransferPageObject;
import pageObject.bankguru.LogOutPageObject;
import pageObject.bankguru.LoginPageObject;
import pageObject.bankguru.ManagerPageObject;
import pageObject.bankguru.MiniStatementPageObject;
import pageObject.bankguru.NewAccountPageObject;
import pageObject.bankguru.NewCustomerPageObject;
import pageObject.bankguru.RegisterPageObject;
import pageObject.bankguru.WithfrawallPageObject;
import pageObject.nopcommerce.user.NoteBookPageObject;
import pageObject.nopcommerce.user.UserHomePageObject;
import pageObject.nopcommerce.user.UserLoginPageObject;
import pageObject.nopcommerce.user.UserRegisterPageObject;
import pageObject.nopcommerce.user.UserSearchPageObject;

public class PageGeneratorManager {
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static ManagerPageObject getManagerPage(WebDriver driver) {
		return new ManagerPageObject(driver);
	}

	public static BalanceEnquiryPageObject getBalanceEnquiryPage(WebDriver driver) {
		return new BalanceEnquiryPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static CustomisedStatementPageObject getCustomisedStatementPage(WebDriver driver) {
		return new CustomisedStatementPageObject(driver);
	}

	public static DeleteAccountPageObject getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccountPageObject(driver);
	}

	public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}

	public static DepositPageObject getDepositPage(WebDriver driver) {
		return new DepositPageObject(driver);
	}

	public static EditAccountPageObject getEditAccountPage(WebDriver driver) {
		return new EditAccountPageObject(driver);
	}

	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}

	public static FundTransferPageObject getFundTransferPage(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}

	public static LogOutPageObject getLogOutPageObject(WebDriver driver) {
		return new LogOutPageObject(driver);
	}

	public static MiniStatementPageObject getMiniStatementPage(WebDriver driver) {
		return new MiniStatementPageObject(driver);
	}

	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}

	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}

	public static WithfrawallPageObject getWithfrawallPage(WebDriver driver) {
		return new WithfrawallPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserSearchPageObject getUserSearchPage(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	public static NoteBookPageObject getNoteBookPage(WebDriver driver) {
		return new NoteBookPageObject(driver);
	}
}
