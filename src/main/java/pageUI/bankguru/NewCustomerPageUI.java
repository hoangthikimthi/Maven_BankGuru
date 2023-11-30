package pageUI.bankguru;

public class NewCustomerPageUI {
	public static final String IFRAME = "xpath=//iframe[contains(@id,'google_ads_iframe_')]";
	public static final String ADD_NEW_CUSTOMER_TEXT = "XPATH=//p[text()='Add New Customer']";
	public static final String DYNAMIC_TEXTBOX_NAME = "xpath=//td[text()='%s']//following-sibling::td/input";
	public static final String DYNAMIC_TEXTAREA_NAME = "xpath=//td[text()='%s']//following-sibling::td/textarea";
	public static final String DATE_OF_BIRTH = "xpath=//td[text()='Date of Birth']//following-sibling::td/input";
	public static final String POPUP = "id=google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0";
	public static final String CLOSE_POPUP_BUTTON = "css=div.dismiss-button";
	public static final String DYNAMIC_TEXTBOX_ERROR_MESSAGE = "xpath=//td[text()='%s']//following-sibling::td/label";
	public static final String MALE_GENDER = "css=input[type='radio'][value='m']";
	public static final String FEMALE_GENDER = "css=input[type='radio'][value='f']";
	public static final String SUBMIT_BUTTON = "css=input[type='submit']";

}
