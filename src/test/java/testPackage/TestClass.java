package testPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pomPackage.HomePage;
import pomPackage.ProductPage;
import utilityPackage.UtilityClass;
@Listeners(listenerPackage.ListenerClass.class)


public class TestClass extends BaseClass {
	
	//public static WebDriver driver;
	ProductPage productpage;
	HomePage homepage;
	public static Logger logger;
	
@Parameters("browserName")
@BeforeClass

			public WebDriver beforeclassopenBrowser(String browserName) throws InterruptedException, IOException
			{
				logger=Logger.getLogger("amazo1");
				PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Log4jFile\\log4j.properties");
//				driver =new ChromeDriver();
//				driver.manage().window().maximize();
//				//driver.get("https://www.bigbasket.com/");
				logger.info("launching the Application");
				//driver.get(UtilityClass.getproperties("Url1"));
//				Thread.sleep(2000);
				launchBrowser(browserName);
				//launchBrowser("firefox");
				//launchBrowser("edge");
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
				return driver;
			
			}
@BeforeMethod
			public void objectCreationOfPomClasses() throws InterruptedException
			{
				homepage=new HomePage(driver);
				Thread.sleep(1000);
				//homepage.clickOnShowByButton(); 
				//Thread.sleep(1000);
				productpage=new ProductPage(driver);
				Thread.sleep(1000);
			}					
@Test
	public void verifTtextOnProductpage() throws InterruptedException
		{	homepage.clickOnShowByButton(); 
		    Thread.sleep(2000);
			String actual1 =productpage.getPageTitle();
			String expected1=driver.findElement(By.xpath("//h2[contains(text(),'Epilators & Trimmers')]")).getText();
			System.out.println("Expected1: "+expected1);
			Assert.assertEquals(actual1,expected1,"Testcase got Failed ");
		}
@Test(dependsOnMethods= {"verifTtextOnProductpage"},timeOut=5000) 
	public void a()
	{
		System.out.println("Hello method a is running");
	}
@Test(priority=2,invocationCount=2)
	public void b()
		{
			System.out.println("Hello method b is running");
		}
@Test(priority=3)
	public void c()
		{
			System.out.println("Hello method c is running");
			//Assert.fail();
		}
@AfterMethod
	public void closTheApplication() throws IOException {
		
		productpage=null;
		homepage=null;
		closeBrowser();
	}

@AfterClass
	public void quitBrowser() throws InterruptedException
	{
		logger.info("test completed on one browser");
//		Thread.sleep(1000);
//		closeBrowser();
		//driver.quit();
	}

}









