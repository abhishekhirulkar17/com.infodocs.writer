package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class Base {
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver initializeDriver() throws IOException {

		prop = loadConfig();
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("fox")) {
			System.setProperty("\\driver\\geckodriver.exe", " fox");
			driver = new FirefoxDriver();

		} else if (browserName.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equals("IE")) {

		}
		else {
			log.fatal("Failed to launch Browser");
		}

		tdriver.set(driver);

		return getDriver();
	}
	
	public void BaseTestClass() 
	{
	 wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	 
	} 

	public Properties loadConfig() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
		prop.load(fis);
		return prop;
	}

	public static synchronized WebDriver getDriver() 
	{
		return tdriver.get();

	}
	
	public String getPageTitle() 
	{
		return driver.getTitle();
	}

	public String getPageHeader(By locator) 
	{
		return getElement(locator).getText();
	}

	public WebElement getElement(By locator) {
		WebElement element= null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		}
		catch(Exception e) {
			System.out.println("some error occured while creating element" + locator.toString());
			e.printStackTrace();
		}
		
		return element;
	}


	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e) {
			System.out.println("some error occured while waiting for the element" + locator.toString());
		}
		 
		
	}
}
