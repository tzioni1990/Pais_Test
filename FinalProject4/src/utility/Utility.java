package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Utility {
	
	public static String getProperty(String key) throws IOException {
		Properties prop=new Properties();
		String dataFile="properties";
		InputStream input=null;
		input=new FileInputStream((System.getProperty("user.dir"))+"//"+dataFile);
		prop.load(input);
		return prop.getProperty(key);
	}
	
	public static File printScreen(WebDriver driver) throws IOException {
		File snap=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateFormat timeStamp=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String strTimeStamp=timeStamp.format(new Date());
		String imgPath="C:\\Users\\tzion\\OneDrive\\שולחן העבודה\\NewWorkspace\\FinalProject4\\"+strTimeStamp+"_image.png";
		File fImage= new File(imgPath);
		FileUtils.copyFile(snap, fImage);
		return fImage;
	}
	
	public static void addSnapShotToReport(File file) {
		Reporter.log("<br/><p><img width='612' src='"+file.getAbsolutePath()+"'></p>");
	}

}
