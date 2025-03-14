package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;







public class UtilityClass {
	public static File getScreenshot(WebDriver driver,String fileName) throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
//		SimpleDateFormat timestamp=new SimpleDateFormat("dd_mm_yyyy_HH_MM_SS");
//		Date date=new Date();
//		String t=timestamp.format(date);
		String timestamp=new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss").format(new Date());
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\"+fileName+"_"+timestamp+".png");
		FileHandler.copy(Source, dest);
		return dest;
	}

	public static String getproperties(String Url) throws IOException {
		Properties prop=new Properties();
		FileInputStream filepath = new FileInputStream("D:\\Maven and Cucumber Projects\\amazon1\\src\\test\\resources\\propertiesFile\\config.properties");
		prop.load(filepath);
		String Url3=prop.getProperty("Url1");
		return Url3;
		
		
	}
	public static String getbrowser(String browserName) throws IOException {
		Properties prop=new Properties();
		FileInputStream filepath = new FileInputStream("D:\\Maven and Cucumber Projects\\amazon1\\src\\test\\resources\\propertiesFile\\config.properties");
		prop.load(filepath);
		String browserName1=prop.getProperty("browserName");
		return browserName1 ;
			
			
		};
		
		
	}
