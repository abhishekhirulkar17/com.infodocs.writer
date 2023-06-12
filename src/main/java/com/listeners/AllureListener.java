package com.listeners;

import java.io.PrintStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.Base;

import io.qameta.allure.Attachment;

public class AllureListener  implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] saveFailureScreenshot(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("I am in onTestSucess"  +getTestMethodName(result));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Object testclass = result.getInstance();
		WebDriver driver = Base.getDriver();
		
		if(driver instanceof WebDriver)
		{
			System.out.println("Screenshot captured for test case :"  +getTestMethodName(result));
			saveFailureScreenshot(driver);
			
		}
		
		saveTextLog(getTestMethodName(result) + "Failed and Screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) 
	{

	
		System.out.println("I am in onStart Method "+ context.getName());
		context.setAttribute("Webdriver", Base.getDriver());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
}
