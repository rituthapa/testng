package test.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testR08 {
	static ChromeDriver driver;
	// scenario: in saucedemo website: 4 valid usernames and password given
	// does it require 4 test cases to be written or 1 testcase only for login
	// functionality
	// answer: in automation, you write 1 testcase only: but needs to be executed 4
	// times
	// so how you do that
	// 1 approach: writing a method/funtion and calling the function 4 times (on classname, that's why static syntax)
	// what's wrong with this approach:
	// a) for 1 testcase, it runs 1 time only ie, execution happens 1 time only
	// b) if any of the 4 fails, whole testcase fails; so you dont know which of the
	// 4 datas failed the testcase

	// approach 2: using @DataProvider annotation of TestNG where you provider
	// array/set of data to @dataprovider(give a name to this annotation)
	// then, use that dataset in your @test testcases
	// you have to write 1 testcase only; but it will run the code 4 times ie,
	// testcase executes 4 times with single testcase but different datas each time
	// this will tell you exactly which execution failed

	// 1st approach
	
	public static void loginUser(String username, String password) {
	System.out.println("Login");
	System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
	 ChromeOptions options = new ChromeOptions(); 
	 options.addArguments("--remote-allow-origins=*"); 
	driver = new ChromeDriver(options); 
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
	driver.findElement(By.cssSelector("#password")).sendKeys(password);
	driver.findElement(By.cssSelector("#login-button")).click();
	List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item_name"));
	Assert.assertEquals(products.size(), 6);
	}		

	@Test
	public void loginTestcase() {
	System.out.println("Login");
//	System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
//	 ChromeOptions options = new ChromeOptions(); 
//	  options.addArguments("--remote-allow-origins=*"); 
//	  driver = new ChromeDriver(options); 
//	driver.get("https://www.saucedemo.com/");
//	
//	driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
//	driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
//	driver.findElement(By.cssSelector("#login-button")).click();
//	List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item_name"));
//	Assert.assertEquals(products.size(), 6);
	
	testR08.loginUser("standard_user","secret_sauce");
	testR08.loginUser("locked_out_user","secret_sauce");
	testR08.loginUser("problem_user","secret_sauce");
	testR08.loginUser("performance_glitch_user","secret_sauce");
	driver.quit();
	
	//with this approach
	//it said testcase fail for logintestcase even though login was unsuccessful for second username only; entire testcase failed
	//execution happened once only and which one of the 4 datas caused failed testcase is unknown
	}		
}