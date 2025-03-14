package testPackage;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomPackage.HomePage;
import pomPackage.ProductPage;
import utilityPackage.UtilityClass;

public class Test3  {
	WebDriver driver;
	ProductPage productpage;
	HomePage homepage;
@BeforeClass
			public void before() throws InterruptedException, IOException
			{
			
				driver =new ChromeDriver();
				driver.manage().window().maximize();
				//driver.get("https://www.bigbasket.com/");
				driver.get(UtilityClass.getproperties("Url1"));
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
			}
@BeforeMethod
			public void beforemethod() throws InterruptedException
			{
				homepage=new HomePage(driver);
				Thread.sleep(1000);
				homepage.clickOnShowByButton(); 
				Thread.sleep(1000);
				productpage=new ProductPage(driver);
				Thread.sleep(1000);
			}					
@Test
	public void verifTtextOnProductpage()
		{
			//Assert.fail();
			String actual1 =productpage.getPageTitle();
			String expected1=driver.findElement(By.xpath("//h2[contains(text(),'Epilators & Trimmers')]")).getText();
			System.out.println("Expected1: "+expected1);
			Assert.assertEquals(actual1,expected1,"Testcase got Failed ");
		
		}
@AfterMethod
public void closeapp() {
	productpage=null;
	homepage=null;
}

@AfterClass
public void closebrowser()
{
	driver.quit();
}

}


