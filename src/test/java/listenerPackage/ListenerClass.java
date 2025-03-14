package listenerPackage;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import basePackage.BaseClass;

import utilityPackage.UtilityClass;

public class ListenerClass extends BaseClass implements ITestListener
	{

	public void onTestSuccess(ITestResult result)
		{
		
			System.out.println("Testcase " +result.getName()+" is passed");
		}
	public void onTestFailure(ITestResult result) 
	{
		try {
				UtilityClass.getScreenshot(driver,result.getName());
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Testcase " +result.getName()+" is failed");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase "+result.getName()+" is skipped");
	}
	
}
