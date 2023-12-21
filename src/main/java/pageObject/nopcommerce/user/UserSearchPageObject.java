package pageObject.nopcommerce.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.nopcommerce.user.SearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isSearchPageDisplayed() {
		return isElementDisplayed(SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
	}

	public void inputToSearchTextbox(String value) {
		waitForElementVisible(SearchPageUI.SEARCH_KEYWORD_TEXTBOX);
		sendkeysToElement(SearchPageUI.SEARCH_KEYWORD_TEXTBOX, value);

	}

	public void clickToSearchButton() {
		waitForElementVisible(SearchPageUI.SEARCH_BUTTON);
		clickToElement(SearchPageUI.SEARCH_BUTTON);

	}

	public String getErrorMessage() {
		waitForElementVisible(SearchPageUI.WARNING_MESSAGE);
		return getElementText(SearchPageUI.WARNING_MESSAGE);
	}

	public String getNoProductMessage() {
		waitForElementVisible(SearchPageUI.NO_PRODUCT_MESSAGE);
		return getElementText(SearchPageUI.NO_PRODUCT_MESSAGE);
	}

	public boolean isResultShowCorrectly(String searchKey, int numberProduct) {
		ArrayList<String> producTitles = new ArrayList<>();
		waitForAllElementVisible(SearchPageUI.PRODUCT_TITLE);
		List<WebElement> elements = getListElement(SearchPageUI.PRODUCT_TITLE);
		for (WebElement element : elements) {
			producTitles.add(element.getText());
		}
		boolean containSearchKey = false;
		for (String title : producTitles) {
			if (!title.contains(searchKey)) {
				return containSearchKey;
			} else {
				return containSearchKey = true;
			}
		}
		if (producTitles.size() == numberProduct & containSearchKey == true) {
			return true;
		} else {
			return false;
		}
	}
}