package pageObject.nopcommerce.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.nopcommerce.user.NoteBookPageUI;

public class NoteBookPageObject extends BasePage {
	WebDriver driver;

	public NoteBookPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isPageTitleDisplay(String value) {
		waitForElementVisible(NoteBookPageUI.NOTEBOOK_PAGE_TITLE, value);
		return isElementDisplayed(NoteBookPageUI.NOTEBOOK_PAGE_TITLE, value);
	}

	public void selectDropdownSortBy(String value) {
		waitForElementVisible(NoteBookPageUI.PRODUCT_ORDER_BY_DROPDOWN);
		selectItemInDefautDropdown(NoteBookPageUI.PRODUCT_ORDER_BY_DROPDOWN, value);
	}

	public String getFistSelectOptionInProductOder() {
		waitForElementVisible(NoteBookPageUI.PRODUCT_ORDER_BY_DROPDOWN);
		return getSelectedItemInDefaultDropdown(NoteBookPageUI.PRODUCT_ORDER_BY_DROPDOWN);
	}

	public boolean isProductNameSortCorrectly(boolean desc) {
		refreshPage();
		ArrayList<String> array1 = new ArrayList<>();
		waitForAllElementVisible(NoteBookPageUI.PRODUCT_TITLE);
		List<WebElement> elements = getListElement(NoteBookPageUI.PRODUCT_TITLE);
		for (WebElement element : elements) {
			array1.add(element.getText());
		}

		ArrayList<String> array2 = new ArrayList<>();
		for (String i : array1) {
			array2.add(i);
		}
		// Collections.copy(array2, array1);
		Collections.sort(array2);
		if (desc) {
			Collections.reverse(array2);
		}

		return array2.equals(array1);
	}

	public boolean isPriceSortCorrectly(boolean desc) {
		refreshPage();
		ArrayList<Float> arrayList = new ArrayList<>();
		waitForAllElementVisible(NoteBookPageUI.PRODUCT_PRICE);
		List<WebElement> elements = getListElement(NoteBookPageUI.PRODUCT_PRICE);
		for (WebElement element : elements) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
		}

		ArrayList<Float> arrayList2 = new ArrayList<>();
		for (Float i : arrayList) {
			arrayList2.add(i);
		}

		Collections.sort(arrayList2);
		if (desc == true) {
			Collections.reverse(arrayList2);
		}

		return arrayList2.equals(arrayList);
	}

	public void selectPageSizeDropDown(String pageSize) {
		waitForElementVisible(NoteBookPageUI.PRODUCT_PAGE_SIZE_DROPDOWN);
		selectItemInDefautDropdown(NoteBookPageUI.PRODUCT_PAGE_SIZE_DROPDOWN, pageSize);

	}

	public boolean isNumberOfProductDisplayCorrectly(int pageNumber) {
		List<WebElement> elements = getListElement(NoteBookPageUI.PRODUCT_TITLE);
		if (elements.size() <= pageNumber) {
			return true;
		} else return false;
	}

	public String getFistSelectOptionInPageSize() {
		waitForElementVisible(NoteBookPageUI.PRODUCT_PAGE_SIZE_DROPDOWN);
		return getSelectedItemInDefaultDropdown(NoteBookPageUI.PRODUCT_PAGE_SIZE_DROPDOWN);

	}

	public boolean isPagingDisplayCorrectly(String pageNumber, String pagingName) {
		if (!getElementText(NoteBookPageUI.CURRENT_PAGER).equals(pageNumber)) {
			waitForElementVisible(NoteBookPageUI.PRODUCT_PAGE_SIZE_DROPDOWN);
			clickToElement(NoteBookPageUI.PREVIOUS_NEXT_PAGER, pagingName);
		}
		return isElementDisplayed(NoteBookPageUI.PREVIOUS_NEXT_PAGER, pagingName);
	}

	public boolean isPagingFound(String nextPage, String previousPage) {
		if (isElementDisplayed(NoteBookPageUI.PREVIOUS_NEXT_PAGER, nextPage)
				| isElementDisplayed(NoteBookPageUI.PREVIOUS_NEXT_PAGER, nextPage)) {
			return true;
		} else return false;
	}
}
