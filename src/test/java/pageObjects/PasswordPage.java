package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.HelperFunctions;

public class PasswordPage {
	private static WebElement element = null;

	public static WebElement input(WebDriver driver) {
		element = HelperFunctions.getInput(driver, "//*[@name='password']");
		return element;
	}

	public static WebElement nextButton(WebDriver driver) {
		element = HelperFunctions.getButton(driver, "//span[text()='Next']");
		return element;
	}
}
