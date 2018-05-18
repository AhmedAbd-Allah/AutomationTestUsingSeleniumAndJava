package modules;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import pageObjects.HomePage;
import utility.Constants;
import utility.ExcelUtility;
import utility.HelperFunctions;

public class SendEmail {
	private static String to = null;
	private static String subject = null;
	private static String body = null;
	public static String attachmentFilePath = null;

	public static void updateData() throws Exception {
			SendEmail.to = ExcelUtility.getRecipientEmail();
			SendEmail.subject = ExcelUtility.getEmailSubject();
			SendEmail.body = ExcelUtility.getEmailBody();
			SendEmail.attachmentFilePath = ExcelUtility.getAttachmentPath();
	}
	
	public static void newEmail(WebDriver driver) {
		HomePage.composeButton(driver).click();
	}

	public static void composeEmail(WebDriver driver) {
		HomePage.toInput(driver).sendKeys(SendEmail.to);
		HomePage.subjectInput(driver).sendKeys(SendEmail.subject);
		HomePage.bodyInput(driver).sendKeys(SendEmail.body);
	}

	public static void attachFile(WebDriver driver) throws FindFailed {
		Screen s = new Screen();
		Pattern fileInputTextBox = new Pattern(Constants.pathImages + Constants.fileInput);
		Pattern openButton = new Pattern(Constants.pathImages + Constants.openButton);
		HomePage.attachButton(driver).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			s.type(fileInputTextBox, SendEmail.attachmentFilePath);
			s.click(openButton);
	}

	public static void sendEmail(WebDriver driver) {
		HomePage.sendButton(driver).click();
	}

	public static void execute(WebDriver driver) throws Exception {
		SendEmail.updateData();
		SendEmail.newEmail(driver);
		SendEmail.composeEmail(driver);
		SendEmail.attachFile(driver);
		HelperFunctions.waitUntilUploaded(driver);
		SendEmail.sendEmail(driver);
		HelperFunctions.waitUntilSent(driver);
	}
}
