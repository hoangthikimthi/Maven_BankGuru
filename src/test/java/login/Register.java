package login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Register extends BaseTest {
	WebDriver driver;

	@Parameters({ "envName", "serverName", "browser"})
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, @Optional("dev") String serverName, @Optional("local") String envName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber,
			@Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(browserName, serverName, envName, ipAddress, portNumber, osName, osVersion);

	}
	@Test
	public void TC_01() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
