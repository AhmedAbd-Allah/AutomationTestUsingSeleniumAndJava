package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.HelperFunctions;

public class EmailPage {
	private static WebElement element = null;

	public static WebElement input(WebDriver driver) {
		element = HelperFunctions.getInput(driver, "//input[@type='email']");
		return element;
	}

	public static WebElement nextButton(WebDriver driver) {
		element = HelperFunctions.getButton(driver, "//*[@class='CwaK9']//span[text()='Next']");
		return element;

	}
}
