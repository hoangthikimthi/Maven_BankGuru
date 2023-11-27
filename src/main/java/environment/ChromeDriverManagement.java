package environment;

import java.io.File;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManagement implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		WebDriverManager.chromedriver().setup();
		File file = new File(GlobalConstants.PROJECT_PATH + "\\browserExtensions\\DGJBALJGOLMLCMMKLMMEAFECIKIDMJPI_1_9_6_0.crx");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(file);
		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		return new ChromeDriver(options);
	}

}