package scenarios;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import modules.AssertEmail;
import modules.LogIn;
import modules.LogOut;
import modules.SendEmail;
import pageObjects.HomePage;
import utility.Constants;
import utility.ExcelUtility;
import utility.HelperFunctions;

public class EmailAutomation {
	public static WebDriver driver = null;
	public static String driverName = null;
	public static String driverPath = null;

	@BeforeClass
	public void setUp() {
		try {
			ExcelUtility.setExcelFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driverName = ExcelUtility.getWebDriver().toLowerCase();
			driverPath = ExcelUtility.getWebDriverPath();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("Can not read the driver data from the Excel file.");
		}
		System.setProperty("webdriver." + driverName + ".driver", driverPath);
		switch (driverName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			Assert.fail("Invalid Driver");
		}
		driver.navigate().to(Constants.URL);
	}

	@Test(description = "Read the email and password of the sender and store them in variables")
	public void readAuthData() {
		try {
			LogIn.updateData("sender");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail("Failed getting the data from the excel file.");
			e.printStackTrace();
		}
		Reporter.log("Read the email and password");
	}

	@Test(dependsOnMethods = "readAuthData", description = "Enter the email and press next.")
	public void enterEmail() {
		LogIn.enterEmail(driver);
		Assert.assertFalse(
				HelperFunctions.isElementPresent(driver,
						By.xpath("//div[contains(text(), 'Enter a valid email or phone number')]")),
				"The email is invalid.");
		Assert.assertFalse(HelperFunctions.isElementPresent(driver,
				By.xpath("//div[contains(text(), 'Enter an email or phone number')]")), "The email is empty.");
		Reporter.log("The email is Valid");
	}

	@Test(dependsOnMethods = "enterEmail", description = "enter the password")
	public void enterPasword() {
		LogIn.enterPassword(driver);
	}

	@Test(dependsOnMethods = "enterPasword", description = "Send Login Request")
	public void logIn() throws InterruptedException {
		LogIn.logIn(driver);
		Thread.sleep(2000);
		Assert.assertFalse(
				HelperFunctions.isElementPresent(driver, By.xpath(
						"//div[contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]")),
				"The password is invalid.");
		Assert.assertFalse(
				HelperFunctions.isElementPresent(driver, By.xpath("//div[contains(text(), 'Enter a password')]")),
				"The password is empty.");
		Reporter.log("send login request");
	}

	@Test(dependsOnMethods = "logIn", description = "Read the email reciever, subject and body.")
	public void getEmailData() throws Exception {
		SendEmail.updateData();
		File f = new File(SendEmail.attachmentFilePath);
		Assert.assertTrue(f.exists(), "the attachment path is invalid.");
		Reporter.log("Read the receiver data, subject and body");
	}

	@Test(dependsOnMethods = "getEmailData", description = "Open new email window and fill the text inputs")
	public void composeEmail() {
		SendEmail.newEmail(driver);
		Reporter.log("Loggedin successfully");
		SendEmail.composeEmail(driver);
		Reporter.log("Composed the email");
	}

	@Test(dependsOnMethods = "composeEmail", description = "Attach the file to the email.")
	public void addAttachment() throws FindFailed {
		SendEmail.attachFile(driver);
		Reporter.log("Added the attachment successfully");
	}

	@Test(dependsOnMethods = "addAttachment", description = "Send the email")
	public void sendEmail() {
		HelperFunctions.waitUntilUploaded(driver);
		SendEmail.sendEmail(driver);
		HelperFunctions.waitUntilSent(driver);
		Reporter.log("EMAIL SENT.");
	}

	@Test(dependsOnMethods = "sendEmail", description = "Logging out")
	public void Logout() {
		LogOut.execute(driver);
		Reporter.log("Loggedout Successfully.");
		driver.quit();
		switch (driverName) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			Assert.fail("Invalid Driver");
		}
		driver.navigate().to(Constants.URL);
	}

	@Test(dependsOnMethods = "Logout", description = "Read the email and password of the sender and store them in variables")
	public void readRecepientAuthData() throws InterruptedException {
		try {
			LogIn.updateData("receiver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail("Failed getting the receiver data from the excel file.");
			e.printStackTrace();
		}
		Reporter.log("Read the email and password of the receiver.");
	}

	@Test(dependsOnMethods = "readRecepientAuthData", description = "Enter the recepient email and press next.")
	public void enterRecepientEmail() {
		LogIn.enterEmail(driver);
		Assert.assertFalse(
				HelperFunctions.isElementPresent(driver,
						By.xpath("//div[contains(text(), 'Enter a valid email or phone number')]")),
				"The email is invalid.");
		Assert.assertFalse(HelperFunctions.isElementPresent(driver,
				By.xpath("//div[contains(text(), 'Enter an email or phone number')]")), "The recepient email is empty.");
		Reporter.log("The recepient email is Valid");
	}

	@Test(dependsOnMethods = "enterRecepientEmail", description = "enter the recepient password")
	public void enterRecepientPasword() {
		LogIn.enterPassword(driver);
	}

	@Test(dependsOnMethods = "enterRecepientPasword", description = "Send recepient Login Request")
	public void logInRecepient() throws InterruptedException {
		LogIn.logIn(driver);
		Thread.sleep(2000);
		Assert.assertFalse(
				HelperFunctions.isElementPresent(driver, By.xpath(
						"//div[contains(text(), 'Wrong password. Try again or click Forgot password to reset it.')]")),
				"The recepient password is invalid.");
		Assert.assertFalse(
				HelperFunctions.isElementPresent(driver, By.xpath("//div[contains(text(), 'Enter a password')]")),
				"The password is empty.");
		Reporter.log("send recepient login request");
	}
	
	@Test(dependsOnMethods = "logInRecepient", description = "Get the email data from the excel file.")
	public void getRecepientEmailData() {
		AssertEmail.getExpectedValues(driver);
	}
	
	@Test(dependsOnMethods = "getEmailData", description = "Open the specified email. and assert the subject")
	public void openEmail() {
		HomePage.emailFromList(driver).click();
	}
	
	@Test(dependsOnMethods = "openEmail", description = "Validate the Body.")
	public void validateBody() throws InterruptedException {
		Thread.sleep(4000);
		if (HelperFunctions.isElementPresent(driver, By.xpath("(//div[@data-tooltip='Show trimmed content']/img)[last()]"))) {
			HelperFunctions.getButton(driver, "(//div[@data-tooltip='Show trimmed content']/img)[last()]").click();
		}
		Assert.assertTrue(AssertEmail.assertBody(driver), "The Body doesn't match");;
	}
	
	@Test(dependsOnMethods = "validateBody", description = "Validate the email of the sender.")
	public void validateFrom() throws InterruptedException {
		
		Assert.assertTrue(AssertEmail.assertFrom(driver), "The email doesn't match");
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
