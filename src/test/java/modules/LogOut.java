package modules;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;

public class LogOut {

	public static void signOut(WebDriver driver) {
		HomePage.accountMenu(driver).click();
		HomePage.signOutButton(driver).click();
	}

	public static void execute(WebDriver driver) {
		LogOut.signOut(driver);
	}
}
