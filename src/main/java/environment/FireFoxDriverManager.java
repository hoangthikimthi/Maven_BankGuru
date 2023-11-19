package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import commons.GlobalConstant;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstant.BROWSER_LOG_PATH);
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstant.DOWNLOAD_FILE);
		options.addPreference("browser.download.userDowloadDir", true);
		options.addPreference("pdfjs.disabled", "true");
		return new FirefoxDriver(options);
	}
	///

}