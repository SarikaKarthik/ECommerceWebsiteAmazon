package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	private WebDriver driver;
	@FindBy(xpath="//h2[contains(text(),'Epilators & Trimmers')]")
	private WebElement pageText;
	
public ProductPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	this.driver=driver;
}

public String getPageTitle()
{
	String actual1=pageText.getText();
	System.out.println("Actual1: " +actual1);
	return actual1;
}

}