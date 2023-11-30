package utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;

public class RegisterStudentTest extends BaseTest {
	WebDriver driver;

	@Parameters({ "browserName", "loginURL", "envName" })
	@BeforeClass
	public void beforeClass(String browserName, String loginURL, String envName) {
		driver = getBrowserDriver(browserName, loginURL, envName);

	}
}
// @Test
// public static void main(String args[]) throws IOException {
// // creating object of ExcelUtils class
// ExcelUtils excelUtils = new ExcelUtils();
//
// // using the Constants class values for excel file path
// String excelFilePath = GlobalConstants.Path_TestData + GlobalConstants.File_TestData;
//
// // calling the ExcelUtils class method to initialise the workbook and sheet
// excelUtils.setExcelFile(excelFilePath, "STUDENT_DATA");
//
// // iterate over all the row to print the data present in each cell.
// for (int i = 1; i <= excelUtils.getRowCountInSheet(); i++) {
// // Enter the values read from Excel in firstname,lastname,mobile,email,address
// firstName.sendKeys(excelUtils.getCellData(i, 0));
// lastName.sendKeys(excelUtils.getCellData(i, 1));
// email.sendKeys(excelUtils.getCellData(i, 2));
// mobile.sendKeys(excelUtils.getCellData(i, 3));
// address.sendKeys(excelUtils.getCellData(i, 4));
//
// // Click on the gender radio button using javascript
// JavascriptExecutor js = (JavascriptExecutor) driver;
// js.executeScript("arguments[0].click();", genderMale);
//
// // Click on submit button
// submitBtn.click();
//
// // Verify the confirmation message
// WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
//
// // check if confirmation message is displayed
// if (confirmationMessage.isDisplayed()) {
// // if the message is displayed , write PASS in the excel sheet using the method of ExcelUtils
// excelUtils.setCellValue(i, 6, "PASS", excelFilePath);
// } else {
// // if the message is not displayed , write FAIL in the excel sheet using the method of ExcelUtils
// excelUtils.setCellValue(i, 6, "FAIL", excelFilePath);
// }
//
// // close the confirmation popup
// WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
// closebtn.click();
//
// // wait for page to come back to registration page after close button is clicked
// driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
// }
// // closing the driver
// driver.quit();
// }
// }
// }
