package test.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testR09aDataProvider {
	ChromeDriver driver;
	
	//approach 2
	//running single testcase for multiple inputdata, write testcase one time but run it multiple times with different datas
	//for this, write single testcase first  ie; @Test
	//then create dataset using @DataProvider annotation
	//this annotation returns you a multidimensional object
	//first give a name to it
	//then write a method that return multidimensional object ie, mostly two-dimensional array
	//in the method, you also give a reference variable name together ie; Object[][] return new Object[][]

	@DataProvider(name = "data")
	public Object[][] datasetone() { //here datasetone is method name and Object is reference variable
		return new Object[][] {
			{ "username1", "password1" },
			{ "username2", "password2" },
			{ "username3", "password3" }
			};
	}

	@DataProvider(name="loginData")
	public Object[][] datasettwo() {
		return new Object [][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
	};
	@Test(dataProvider = "data", enabled=false)
	public void testcase1(String un, String pw) {
		System.out.println("login with " + un + pw);
	}

	@Test(dataProvider = "loginData")
	public void testcaseLogin(String usernm, String pwd) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.cssSelector("#user-name")).sendKeys(usernm);
		driver.findElement(By.cssSelector("#password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("#login-button")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item_name"));
		Assert.assertEquals(products.size(), 6);
		driver.quit();
		
		//advantage of dataprovider approach
		//with dataprovider approach, even with 1 testcase, you can run as many times as the data provided, 
		//and you can exactly see which execution is failed
	}
}
