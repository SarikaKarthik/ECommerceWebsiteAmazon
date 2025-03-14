package basePackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import utilityPackage.UtilityClass;

public class BaseClass {
public static WebDriver driver;

//@Parameters("browserName")
public void launchBrowser(String browser) throws IOException, InterruptedException
{	

if(browser.equals("chrome"))
{
	driver=new ChromeDriver();
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver.get(UtilityClass.getproperties("Url1"));
	Thread.sleep(1000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
}
else if(browser.equals("firefox")) {
	driver=new FirefoxDriver();
	driver.get(UtilityClass.getproperties("Url1"));
	Thread.sleep(1000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
}
else if(browser.equals("edge")) {
	driver=new EdgeDriver();
	driver.get(UtilityClass.getproperties("Url1"));
	Thread.sleep(1000);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
}
 
}

public void closeBrowser()
{
	driver.quit();
}
	
	
}
