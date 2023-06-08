package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class Login extends TestBase{
//creating constructor
//adding the By locators
//creating action/methods and dumping the collected locators in methods as needed
	
	//creating a constructor
	public Login(WebDriver driver) {
		TestBase.driver= driver; //?? //just like this.driver=driver
	}
	
	//defining the locators needed for this page //using By class //name given like username,password,logo,etc. are the selector
	By username = By.cssSelector("#user-name"); //by selectorname= By.locator("") //this is returning a WebELement
	By password = By.cssSelector("#password");
	By loginButton = By.cssSelector("#login-button");
	By errorMsg= By.cssSelector(".error-button");
	By logo= By.cssSelector(".login_logo");
	//defining the actions by creating methods
	//login
	public void ValidLogin() {
		driver.findElement(username).sendKeys("standar_user");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(loginButton).click();
		
	}
	
	//invalid login
	public boolean InvalidLogin() {
		driver.findElement(username).sendKeys("standar_u");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(loginButton).click();
		return driver.findElement(errorMsg).isDisplayed();
	}
	
	//LogoPresent
	public boolean LogoVisible() {
		return driver.findElement(logo).isDisplayed();
	}
	
	//validateTitle
	public String validateTitle() {
		return driver.getTitle();
	}
}
