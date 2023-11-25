package commons;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUI.bankguru.CommonPageUI;

public class BasePage {

	private WebDriver driver;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	// Get(Url)-openPageUrl
	public void openPageUrl(String pageURL) {
		driver.get(pageURL);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void setCookies(Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();

	}

	// Alert
	public Alert waitForAlertPresent() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert() {
		waitForAlertPresent().accept();
	}

	public void cancelAlert() {
		waitForAlertPresent().dismiss();
	}

	public String getTextAlert() {
		return waitForAlertPresent().getText();
	}

	public void senkeyTotAlert(String textValue) {
		waitForAlertPresent().sendKeys(textValue);
	}

	// Windows
	public void switchToWindowByID(String windowID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void switchToWindowByTitle(String tabTitle) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(tabTitle)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	public void closeAllTabWithoutParent(String parentID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		for (String id : allWindownIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}

	// Element

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... dynamicValue) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("XPath=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValue);
		}
		return locatorType;
	}

	public WebElement getWebElement(String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	public WebElement getWebElement(String locatorType, String... dynamicValue) {
		return driver.findElement(getByLocator(locatorType));
	}

	public void clickToElement(String locatorType) {
		getWebElement(locatorType).click();
	}

	public void clickToElement(String locatorType, String... dynamicValue) {
		getWebElement(getDynamicXpath(locatorType, dynamicValue)).click();
	}

	/**
	 * Click to Dynamic Button By Text
	 * 
	 * @param driver
	 * @param buttonText
	 */
	// public void clickToButtonByText(String buttonText) {
	// waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_BUTTON_TEXT, buttonText);
	// clickToElement(BasePageNopCommerceUI.DYNAMIC_BUTTON_TEXT, buttonText);
	// }

	public void sendkeysToElement(String locatorType, String textValue) {
		WebElement element = getWebElement(locatorType);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeysToElement(String locatorType, String textValue, String... dynamicValue) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValue));
		element.clear();
		element.sendKeys(textValue);
	}

	/**
	 * Enter to dynamic Textbox By ID
	 * 
	 * @author thi.hoangthikim
	 * @param driver
	 * @param textboxID
	 * @param textValue
	 */
	// public void sendkeysToTextboxByID(String textboxID, String textValue) {
	// waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_TEXBOX_ID, textboxID);
	// sendkeysToElement(BasePageNopCommerceUI.DYNAMIC_TEXBOX_ID, textValue, textboxID);
	// }

	/**
	 * Enter to dynamic TextArea
	 * 
	 * @param driver
	 * @param textboxID
	 * @param textValue
	 */
	// public void sendkeysToTextareaByID(String textboxID, String textValue) {
	// waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_AREA_ID, textboxID);
	// sendkeysToElement(BasePageNopCommerceUI.DYNAMIC_AREA_ID, textValue, textboxID);
	// }

	public String getElementText(String locatorType) {
		return driver.findElement(getByLocator(locatorType)).getText();
	}

	public String getElementText(String locatorType, String... dynamicValue) {
		return driver.findElement(getByLocator(getDynamicXpath(locatorType, dynamicValue))).getText();
	}

	/**
	 * get value in textbox by textboxID
	 * 
	 * @param driver
	 * @param textboxID
	 * @return
	 */
	// public String getTextboxValueByID(String textboxID) {
	// waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_TEXTBOX_VALUE, textboxID);
	// return getElementAtribute(BasePageNopCommerceUI.DYNAMIC_TEXTBOX_VALUE, "value", textboxID);
	//
	// }
	//
	// public String getRadioButtonValueByID(String textboxID) {
	// waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_RADIO_ID, textboxID);
	// return getElementAtribute(BasePageNopCommerceUI.DYNAMIC_RADIO_ID, "value", textboxID);
	//
	// }

	public void selectItemInDefautDropdown(String locatorType, String textValue) {
		Select select = new Select(getWebElement(locatorType));
		select.selectByVisibleText(textValue);
	}

	public void selectItemInDefautDropdown(String locatorType, String textValue, String... dynamicValue) {
		Select select = new Select(getWebElement(getDynamicXpath(locatorType, dynamicValue)));
		select.selectByVisibleText(textValue);
	}

	public void getSelectedItemInDefaultDropdown(String locatorType, String textValue) {
		Select select = new Select(getWebElement(locatorType));
		select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(String locatorType) {
		Select select = new Select(getWebElement(locatorType));
		return select.isMultiple();
	}

	public String getElementValueByJsXpath(String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue).val()");
	}

	// upload file
	// public void uploadMultipleFiles(String... fileNames) {
	// String filePath = GlobalConstants.UPLOAD_FILE;
	// String fullFileName = "";
	// for (String file : fileNames) {
	// fullFileName = fullFileName + filePath + file + "\n";
	// }
	// fullFileName = fullFileName.trim();
	// getWebElement(BasePageJQueryUI.UPLOAD_FILE).sendKeys(fullFileName);
	// }

	// Dropdown
	public void selectItemInCustomDropdown(String parentXpath, String childXpath, String expectedTextItem) {
		getWebElement(parentXpath).click();
		sleepInSecond(1);
		WebDriverWait expliciteWait = new WebDriverWait(driver, 30);
		List<WebElement> allItems = expliciteWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;

			}

		}

	}

	public String getElementAtribute(String locatorType, String atributeName) {
		return getWebElement(locatorType).getAttribute(atributeName);
	}

	public String getElementAtribute(String locatorType, String atributeName, String... dynamicValue) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValue)).getAttribute(atributeName);
	}

	public String getElementCSSValue(String locatorType, String propertyName) {
		return getWebElement(locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex().toUpperCase();
	}

	public List<WebElement> getListElement(String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	public int getElementSize(String locatorType) {
		return getListElement(locatorType).size();
	}

	public int getElementSize(String locatorType, String... dynamicValue) {
		return getListElement(getDynamicXpath(locatorType, dynamicValue)).size();
	}

	public void checktoDefaulCheckboxOrRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checktoDefaulCheckboxOrRadio(String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValue));
		if (!element.isSelected()) {
			element.click();
		}
	}

	/**
	 * Click to Radio button
	 * 
	 * @param driver
	 * @param radioButtonID
	 */
	// public void clickToRadioButtonByID(String radioButtonID) {
	// waitForElementVisible(BasePageNopCommerceUI.DYNAMIC_RADIO_ID, radioButtonID);
	// checktoDefaulCheckboxOrRadio(BasePageNopCommerceUI.DYNAMIC_RADIO_ID, radioButtonID);
	// }

	public void unChecktoDefaulCheckboxRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void unChecktoDefaulCheckboxRadio(String locatorType, String... dynamicValue) {
		WebElement element = getWebElement(getDynamicXpath(locatorType, dynamicValue));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locatorType) {
		return getWebElement(locatorType).isDisplayed();
	}

	public boolean isElementDisplayed(String locatorType, String... dynamicValue) {
		return getWebElement(getDynamicXpath(locatorType, dynamicValue)).isDisplayed();
	}

	/**
	 * Check success meassage is display
	 * 
	 * @param driver
	 * @param dynamicValue
	 * @return
	 */
	// public boolean isSuccessMessageDisplayed(String dynamicValue) {
	// waitForElementClickable(BasePageNopCommerceUI.MESSAGE_TEXT, dynamicValue);
	// return isElementDisplayed(BasePageNopCommerceUI.MESSAGE_TEXT, dynamicValue);
	// }

	public boolean isElementEnable(String locatorType) {
		return getWebElement(locatorType).isEnabled();
	}

	public boolean isElementSelected(String locatorType) {
		return getWebElement(locatorType).isSelected();
	}

	public WebDriver switchToFrameIframe(String locatorType) {
		return driver.switchTo().frame(getWebElement(locatorType));
	}

	public WebDriver switchToDefaultContent() {
		return driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locatorType)).perform();
	}

	public void pressKeyToElement(String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(locatorType), key).perform();
	}

	public void pressKeyToElement(String locatorType, Keys key, String... dynamicValue) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(getDynamicXpath(locatorType, dynamicValue)), key).perform();
	}
	// JsExecutor

	public void scrollToBottomPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getListElement(locator));
	}

	public void scrollToElement(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getListElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getListElement(locator));
	}

	public boolean areJQueryAndJSLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getListElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getListElement(locator));
		return status;
	}

	public boolean isImageLoaded(String locatorType, String... dynamicValue) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(getDynamicXpath(locatorType, dynamicValue)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Wait
	public boolean isElementUndisplayed(String locator) {
		overrideGlobalTimeout(5);
		List<WebElement> elements = getListElement(locator);
		overrideGlobalTimeout(30);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void overrideGlobalTimeout(long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public void waitForElementVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementVisible(String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForAllElementVisible(String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public void waitForAllElementVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}

	public void waitForElementInVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForAllElementInVisible(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListElement(locator)));
	}

	public void waitForElementClickable(String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}

	public void waitForElementClickable(String locatorType, String... dynamicValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValue))));
	}

	public BasePage openBankGuruByPageName(String pageName) {
		waitForElementClickable(CommonPageUI.DYNAMIC_PAGE_IN_SIDEBAR, pageName);
		clickToElement(CommonPageUI.DYNAMIC_PAGE_IN_SIDEBAR, pageName);
		switch (pageName) {
		case "Manager":
			return PageGeneratorManager.getManagerPage(driver);
		case "Edit Customer":
			return PageGeneratorManager.getEditCustomerPage(driver);
		case "Delete Customer":
			return PageGeneratorManager.getDeleteCustomerPage(driver);
		case "New Account":
			return PageGeneratorManager.getNewAccountPage(driver);
		case "Edit Account":
			return PageGeneratorManager.getEditAccountPage(driver);
		case "Delete Account":
			return PageGeneratorManager.getDeleteAccountPage(driver);
		case "Deposit":
			return PageGeneratorManager.getDepositPage(driver);
		case "Withdrawal":
			return PageGeneratorManager.getWithfrawallPage(driver);
		case "Fund Transfer":
			return PageGeneratorManager.getFundTransferPage(driver);
		case "Change Password":
			return PageGeneratorManager.getChangePasswordPage(driver);
		case "Balance Enquiry":
			return PageGeneratorManager.getBalanceEnquiryPage(driver);
		case "Mini Statement":
			return PageGeneratorManager.getMiniStatementPage(driver);
		case "Log out":
			return PageGeneratorManager.getLogOutPageObject(driver);
		case "Customised Statement":
			return PageGeneratorManager.getCustomisedStatementPage(driver);
		case "New Customer":
			return PageGeneratorManager.getNewCustomerPage(driver);

		default:
			throw new RuntimeException("Invalid page name at Side Bar area.");
		}
	}

	// public BasePage clickToProductPicture(String indexNumber) {
	// waitForElementClickable(UserProductDetailPageUI.DYNAMIC_PRODUCT_BY_INDEX, indexNumber);
	// clickToElement(UserProductDetailPageUI.DYNAMIC_PRODUCT_BY_INDEX, indexNumber);
	// return PageGeneratorManager.getUserProductDetailPage(driver);
	// }
	//
	// public UserAddressPageObject openAddressPage() {
	// waitForElementClickable(BasePageNopCommerceUI.ADDRESSES_LINK);
	// clickToElement(BasePageNopCommerceUI.ADDRESSES_LINK);
	// return PageGeneratorManager.getUserAddressPage(driver);
	// }
	//
	// public UserMyProductReviewPageObject openMyProductReviewPage() {
	// waitForElementClickable(BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
	// clickToElement(BasePageNopCommerceUI.MY_PRODUCT_REVIEW_LINK);
	// return PageGeneratorManager.getUserMyProductReviewPage(driver);
	// }
	//
	// public UserRewardPointPageObject openRewardPointPage() {
	// waitForElementClickable(BasePageNopCommerceUI.REWARD_LINK);
	// clickToElement(BasePageNopCommerceUI.REWARD_LINK);
	// return PageGeneratorManager.getUserRewardPointPage(driver);
	// }
	//
	// public UserHomePageObject clickToLogoutLinkAtUserPage() {
	// waitForElementClickable(BasePageNopCommerceUI.LOGOUT_LINK_AS_USER);
	// sleepInSecond(2);
	// clickToElement(BasePageNopCommerceUI.LOGOUT_LINK_AS_USER);
	// return PageGeneratorManager.getUserHomePage(driver);
	// }
	//
	// public UserLoginPageObject clickToLoginLinkAtUserPage() {
	// waitForElementClickable(BasePageNopCommerceUI.LOGIN_LINK_AS_USER);
	// clickToElement(BasePageNopCommerceUI.LOGIN_LINK_AS_USER);
	// return PageGeneratorManager.getUserLoginPage(driver);
	// }
	//
	// public AdminLoginPageObjects clickToLogoutLinkAtAdminPage() {
	// waitForElementClickable(BasePageNopCommerceUI.LOGOUT_LINK_AS_ADMIN);
	// clickToElement(BasePageNopCommerceUI.LOGOUT_LINK_AS_ADMIN);
	// return PageGeneratorManager.getAdminLoginPage(driver);
	// }
	//
	// public UserHomePO openEndUserPageURL(String userUrl) {
	// openPageUrl(userUrl);
	// return pageObject.wordpress.PageGeneratorManager.getUserHomePage(driver);
	// }
}
