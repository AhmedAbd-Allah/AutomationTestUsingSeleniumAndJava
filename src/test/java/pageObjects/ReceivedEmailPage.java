package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.*;

public class ReceivedEmailPage {

	private static WebElement element = null;

	public static WebElement emailSender(WebDriver driver) {
		String Sender = null;
		try {
			Sender = ExcelUtility.getEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpath = "//h3[@class='iw']//span[text()= '" + Sender + "']";
		element = HelperFunctions.getEmailSender(driver, xpath);
		return element;
	}

	public static WebElement EmailBody(WebDriver driver) {
		String xPath = "//div[@class='gs']//div[@dir='ltr']";
		element = HelperFunctions.getEmailBody(driver, xPath);
		return element;
	}

	public static WebElement Attachment(WebDriver driver) {
		String xpath = "//a[@role='link']";
		element = HelperFunctions.getEmailAttachment(driver, xpath);
		return element;
	}

	public static WebElement AttachmentDownload(WebDriver driver) {
		String xpath = "//*[@data-tooltip='Download']";
		element = HelperFunctions.downloadEmailAttachment(driver, xpath);
		return element;
	}

}