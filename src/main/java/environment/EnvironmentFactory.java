package environment;

import org.openqa.selenium.WebDriver;

public interface EnvironmentFactory {
	WebDriver createDriver();
}
