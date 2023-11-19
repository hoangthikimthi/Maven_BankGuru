package environment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import commons.BrowserNotSupport;
import commons.GlobalConstant;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFactory implements EnvironmentFactory {
	private WebDriver driver;
	private String browserName;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	@Override
	public WebDriver createDriver() {
		Browser browser = Browser.valueOf(browserName.toUpperCase());
		switch (browser) {
		case FIREFOX:
			driver = new FireFoxDriverManager().getBrowserDriver();
			break;
		case CHROME:
			driver = new ChromeDriverManagement().getBrowserDriver();
			break;
		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;
		default:
			throw new BrowserNotSupport(browserName);
		}
		return driver;
	}

}
