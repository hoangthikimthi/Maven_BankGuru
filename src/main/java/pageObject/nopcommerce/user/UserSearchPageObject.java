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

	public boolean isProductTitleContainSearchKey(String searchKey) {
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
		return containSearchKey;
	
	}

	public void checkAdvancedSearchCheckbox() {
		waitForElementVisible(SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
		checktoDefaulCheckboxOrRadio(SearchPageUI.ADVANCE_SEARCH_CHECKBOX);
	}

	public void selectCategory(String value) {
		waitForElementVisible(SearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDefautDropdown(SearchPageUI.CATEGORY_DROPDOWN, value);
	}

	public void uncheckSearchSubCategories() {
		waitForElementVisible(SearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
		unChecktoDefaulCheckboxRadio(SearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
	}

	public void checkSearchSubCategories() {
		waitForElementVisible(SearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
		checktoDefaulCheckboxOrRadio(SearchPageUI.SEARCH_SUB_CATEGORIES_CHECKBOX);

		
	}

	public void selectManufacturer(String value) {
		waitForElementVisible(SearchPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefautDropdown(SearchPageUI.MANUFACTURER_DROPDOWN, value);

	}

	public int numberOfProductTitle() {
		waitForElementVisible(SearchPageUI.PRODUCT_TITLE);
		return getElementSize(SearchPageUI.PRODUCT_TITLE);
	}
}