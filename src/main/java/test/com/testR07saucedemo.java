package test.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testR07saucedemo {
ChromeDriver driver;
   // testcase to validate total no of products in the page
	@Test
	public void validatetotalproducts() {
		System.out.println("Login");
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions(); 
		  options.addArguments("--remote-allow-origins=*"); 
		  driver = new ChromeDriver(options); 
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		
			List <WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
			System.out.println(products.get(1).getText());
			System.out.println(products.size());
			Assert.assertEquals(products.size(),6);
			//System.out.println("TotalProducts=6");
			driver.quit();
	}
	}
