package utility;

import java.io.File;

public class Constants {
	 
    public static final String URL = "https://www.google.com/gmail/";
    public static final String projectPath = new File("").getAbsolutePath();
    
    public static final String pathImages = projectPath.concat("\\src\\test\\java\\sikuliImages\\");
    public static final String fileInput = "FileTextBox.PNG";
    public static final String openButton = "OpenButton.PNG";
    
    public static final String testDataPath = projectPath.concat("\\src\\test\\java\\testData\\");
    public static final String testDataFile = "EmailTest.xlsx";
    public static final String testDataSheet = "EmailTest";
}
