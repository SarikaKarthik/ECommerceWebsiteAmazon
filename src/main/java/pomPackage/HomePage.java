package pomPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{
			private WebDriver driver;
			Actions actions;
			@FindBy(xpath="(//span[contains(text(),'Shop by')])[2]")//input[contains(@id,'multiform')]
			private WebElement showByButton;
			@FindBy(xpath="(//a[contains(text(),'Electronics')])[2]")
			private WebElement electronicsOption;
			@FindBy(xpath="(//a[contains(text(),'Beauty & Grooming')])[2]")
			private WebElement beautyOption;
			@FindBy(xpath="//a[contains(text(),'Epilators & Trimmers')]")
			private WebElement epilatorsOption;
		public HomePage( WebDriver driver)
			{	
				PageFactory.initElements(driver, this);
				actions=new Actions(driver);
				this.driver=driver;
				
			}
		public void clickOnShowByButton() throws InterruptedException
		{
			showByButton.click();
			//Thread.sleep(1000);
			WebDriverWait  wait= new WebDriverWait(driver,Duration.ofMillis(1000));
			wait.until(ExpectedConditions.visibilityOf(electronicsOption));
			actions.moveToElement(electronicsOption).moveToElement(beautyOption).build().perform();
			Thread.sleep(2000);
			actions.moveToElement(epilatorsOption).click().perform();
		}

}
