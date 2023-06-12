package com.cases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.listeners.AllureListener;
import com.pageObjects.*;
import com.base.Base;

@Listeners({ AllureListener.class })
public class Login extends Base {
	public static Logger log = LogManager.getLogger(Login.class.getName());

	@BeforeMethod
	public void intialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is intialized");

		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String Password) throws IOException, InterruptedException {

		Login_main login = new Login_main(driver);
		login.getUsername().sendKeys(userName);
		login.getPassword().sendKeys(Password);
		login.clickLogin();
		login.clickPopup();
		login.clickLogin2();
		login.clickPopup2();
		checkLoginStatus();
		login.clickdropdown_UserProfile();
		login.clickoption_Logout();
	}

	private static void checkLoginStatus() {

		// Check if the login was successful
		if (driver.getCurrentUrl().equals("https://ecm.writercorporation.com/InfoDocsV1/Home/Index")) {
			log.info("Login successful.");
		} else {
			log.fatal("login is Failed !!!!!!");
			Assert.assertTrue(false);
		}
		driver.navigate().back();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "testdemo";
		data[0][1] = "Writer@456";

		

		return data;
	}
}
