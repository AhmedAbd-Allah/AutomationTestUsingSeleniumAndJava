package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.*;
import utility.ExcelUtility;
import utility.HelperFunctions;

public class AssertEmail {
	private static String expectedFrom = null;
	private static String expectedSubject = null;
	private static String expectedBody = null;

	private static String actualFrom = null;
	private static String actualBody = null;

	private static String attachmentFileDownloadPath = null;
	private static String attachmentFileDownloadLink = null;

	public static void getExpectedValues(WebDriver driver) {
		try {
			AssertEmail.expectedFrom = ExcelUtility.getEmail();
			AssertEmail.expectedSubject = ExcelUtility.getEmailSubject();
			AssertEmail.expectedBody = ExcelUtility.getEmailBody();
			AssertEmail.attachmentFileDownloadPath = ExcelUtility.getAttachmentDownloadPath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Boolean assertBody(WebDriver driver) {
		actualBody = HelperFunctions.getTextNode(ReceivedEmailPage.EmailBody(driver));
		return expectedBody.trim().startsWith(actualBody.trim());
	}
	
	public static Boolean assertFrom(WebDriver driver) {
		System.out.println(expectedFrom);
		actualFrom = HelperFunctions.getTextNode(ReceivedEmailPage.emailSender(driver));
		System.out.println(actualFrom);
		return actualFrom.trim().contains(expectedFrom.trim());
	}

	public static void downloadAttachment(WebDriver driver) {
		ReceivedEmailPage.AttachmentDownload(driver).click();
	}

}