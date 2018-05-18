package utility;

import org.testng.annotations.Test;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Test
public class ExcelUtility {
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWSheet;
	private static XSSFCell cell;

	public static void setExcelFile() throws Exception {
		try {
			// Open the Excel file
			FileInputStream excelFile = new FileInputStream(Constants.testDataPath + Constants.testDataFile);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(excelFile);
			excelWSheet = excelWBook.getSheet(Constants.testDataSheet);
		} catch (Exception e) {
			throw (e);
		}

	}

	public static String getWebDriver() throws Exception {
		String WebDriver = readExcelData(1, 0);
		return WebDriver;
	}

	public static String getWebDriverPath() throws Exception {
		String WebDriverPath = readExcelData(1, 1);
		return WebDriverPath;
	}

	public static String getEmail() throws Exception {
		String email = readExcelData(1, 2);
		return email;
	}

	public static String getPassword() throws Exception {
		String passWord = readExcelData(1, 3);
		return passWord;
	}

	public static String getRecipientEmail() throws Exception {
		String recipientEmail = readExcelData(1, 4);
		return recipientEmail;
	}

	public static String getRecipientPassword() throws Exception {
		String recipientPassword = readExcelData(1, 5);
		return recipientPassword;
	}

	public static String getEmailSubject() throws Exception {
		String emailSubject = readExcelData(1, 6);
		return emailSubject;
	}

	public static String getEmailBody() throws Exception {
		String emailBody = readExcelData(1, 7);
		return emailBody;
	}

	public static String getAttachmentPath() throws Exception {
		String attachmentPath = readExcelData(1, 8);
		return attachmentPath;
	}

	public static String getAttachmentDownloadPath() throws Exception {
		String attachmentDownloadPath = readExcelData(1, 9);
		return attachmentDownloadPath;
	}

	public static String readExcelData(int RowNum, int ColNum) throws Exception {
		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			return "";
		}

	}
}
