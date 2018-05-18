package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperFunctions {
	private static WebElement element = null;
	private static WebDriverWait wait = null;

	public static WebElement getInput(WebDriver driver, String xPath) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))));
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement getButton(WebDriver driver, String xPath) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(xPath))));
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement getEmailSubject(WebDriver driver, String xPath) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(xPath))));
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement getEmailSender(WebDriver driver, String xPath) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(xPath))));
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement getEmailBody(WebDriver driver, String xPath) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(xPath))));
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement getEmailAttachment(WebDriver driver, String xPath) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(xPath))));
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement downloadEmailAttachment(WebDriver driver, String xPath) {
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(xPath))));
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static void waitUntilSent(WebDriver driver) {
		String xPath = "//span[contains(text(), 'View message')]";
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.elementToBeClickable(By.xpath(xPath))));
	}

	public static void waitUntilUploaded(WebDriver driver) {
		String xPath = "//div[starts-with(@aria-label, 'Attachment:')]";
		wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)),
				ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))));
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	public static String getTextNode(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true; // Success!
		} catch (NoSuchElementException ignored) {
			return false;
		}
	}
}
