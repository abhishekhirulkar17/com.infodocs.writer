package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.base.Base;

public class Login_main extends Base{

	public WebDriver driver;

	public Login_main(WebDriver driver) {
		this.driver = driver;
	}

	By input_UserName = By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/fieldset/div[1]/span/input");
	By input_Password = By.cssSelector(".password");
	By button_Login = By.cssSelector("#btnLogin");
	By popup_Ok = By.xpath("//button[@class='confirm']");
	By button_Login2 = By.id("btnLogin");
	By popup2_Ok = By.xpath("//button[@class='confirm']");
	By option_Logout = By.xpath("//a[normalize-space()='Logout']");
	By menu_UserProfile = By.cssSelector("li.dropdown.current-user.pull-right");
    By dropdown_UserProfile = By.xpath("(//a[@class='dropdown-toggle'])[1]");
    By sidemenu_TestDemo = By.xpath("//li[@class='liSideMenu fademenu closed']//i[@class='icon-arrow']");
	By sidemenu_InfodocsDepartment = By.cssSelector("li[id='MLi_infodocs'] span[class='title']");
	
	
	public WebElement getUsername() {
		return getElement(input_UserName);
	}

	public String clickUsername() {
		getUsername().click();
		return getPageTitle();
	}

	public WebElement getPassword() {
		return getElement(input_Password);
	}

	public String clickPassword() {
		getPassword().click();
		return getPageTitle();
	}

	

	public WebElement getLogin() {
		return getElement(button_Login);
	}

	public String clickLogin() {
		getLogin().click();
		return getPageTitle();
	}

	
	public WebElement getPopup() {
		return getElement(popup_Ok);
	}

	public String clickPopup() {
		getPopup().click();
		return getPageTitle();
	}

	

	public WebElement getLogin2() {
		return getElement(button_Login2);
	}

	public String clickLogin2() {
		getLogin2().click();
		return getPageTitle();
	}

	

	public WebElement getPopup2() {
		return getElement(popup2_Ok);
	}

	public String clickPopup2() {
		getPopup2().click();
		return getPageTitle();
	}
	


	public WebElement getdropdown_UserProfile() {
		return getElement(dropdown_UserProfile);
	}

	public String clickdropdown_UserProfile() {
		getdropdown_UserProfile().click();
		return getPageTitle();
	}
	
	public WebElement getoption_Logout() {
		return getElement(option_Logout);
	}

	public String clickoption_Logout() {
		getoption_Logout().click();
		return getPageTitle();
	}

}
