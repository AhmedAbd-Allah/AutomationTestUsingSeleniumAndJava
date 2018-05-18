package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.EmailPage;
import pageObjects.PasswordPage;
import utility.ExcelUtility;

public class LogIn {
	private static String email = null;
	private static String password = null;

	public static void updateData(String role) throws Exception {
		if (role == "sender") {
			email = ExcelUtility.getEmail();
			Assert.assertTrue(LogIn.email != "" || LogIn.email != null, "Invalid Email");
			password = ExcelUtility.getPassword();
			Assert.assertTrue(LogIn.password != "" || LogIn.password != null, "Invalid Password");
		} else if (role == "receiver") {
			email = ExcelUtility.getRecipientEmail();
			Assert.assertTrue(LogIn.email != "" || LogIn.email != null, "Invalid Email");
			password = ExcelUtility.getRecipientPassword();
			Assert.assertTrue(LogIn.password != "" || LogIn.password != null, "Invalid Password");
		}
	}

	public static void enterEmail(WebDriver driver) {
		EmailPage.input(driver).sendKeys(LogIn.email);
		EmailPage.nextButton(driver).click();
	}

	public static void enterPassword(WebDriver driver) {
		PasswordPage.input(driver).sendKeys(LogIn.password);
	}

	public static void logIn(WebDriver driver) {
		PasswordPage.nextButton(driver).click();
	}
}
