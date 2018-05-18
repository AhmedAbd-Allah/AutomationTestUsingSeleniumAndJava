package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.ExcelUtility;
import utility.HelperFunctions;

public class HomePage {
	private static WebElement element = null;

	public static WebElement composeButton(WebDriver driver) {
		element = HelperFunctions.getButton(driver, "//*[contains(text(), 'COMPOSE')]");
		return element;
	}

	public static WebElement accountMenu(WebDriver driver) {
		element = HelperFunctions.getButton(driver, "//a[starts-with(@href, 'https://accounts.google.com/SignOutOptions')]");
		return element;
	}

	public static WebElement signOutButton(WebDriver driver) {
		element = HelperFunctions.getButton(driver, "//a[starts-with(@href, 'https://accounts.google.com/Logout')]");
		return element;
	}

	public static WebElement toInput(WebDriver driver) {
		element = HelperFunctions.getInput(driver, "//textarea[@name='to']");
		return element;
	}

	public static WebElement subjectInput(WebDriver driver) {
		element = HelperFunctions.getInput(driver, "//input[@name='subjectbox']");
		return element;
	}

	public static WebElement bodyInput(WebDriver driver) {
		element = HelperFunctions.getInput(driver, "//div[@role='textbox']");
		return element;
	}

	public static WebElement sendButton(WebDriver driver) {
		element = HelperFunctions.getButton(driver, "//*[text()='Send']");
		return element;
	}

	public static WebElement attachButton(WebDriver driver) {
		element = HelperFunctions.getButton(driver, "//div[@data-tooltip='Attach files']/div/div/div");
		return element;
	}

	public static WebElement emailFromList(WebDriver driver) {
		String Subject = null;
		try {
			Subject = ExcelUtility.getEmailSubject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpath = "//span/b[text()='" + Subject + "']";
		element = HelperFunctions.getButton(driver, xpath);
		return element;
	}
}
