package commons;

import java.io.File;

public class GlobalConstants {
	public static final String REGISTER_PAGE_URL = "https://demo.guru99.com/";
	public static final String lOGIN_PAGE_URL = "https://demo.guru99.com/v4/";
	public static final String NOPCOMMERCE_USER_URL = "https://demo.nopcommerce.com/";
	public static final String DEMOQA_URL = "https://demoqa.com/automation-practice-form";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 10;

	public static final String BROWSER_LOG_PATH = PROJECT_PATH + File.separator + "browserLogs";;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROW_STACK_URL = null;

	public static final String Path_TestData = PROJECT_PATH + File.separator + "DataDriven";
	public static final String File_TestData = "TestData.xls";
}
