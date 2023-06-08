package test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class testR11 {
ChromeDriver driver;	
	//Arrange
	//action
	//assertion
	
	//what is soft assertion
	//what is hard assertion
	
	//hard assertion: if assertion fails, doesnt move/execute to next testcase
	//soft assertion, even if assertion fails, it'll still move on to next testcase to execute
//after using softassert tovalidate, always do s.AssertAll() method as well to see which testcases failed during the whole execution cycle
	@Test
	public void ContactUs() {
		SoftAssert s= new SoftAssert();
		System.setProperty("webdriver.chrome.driver","C:\\Browsers\\lib\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		
		String title = driver.getTitle();
		String exptitle= "WebDriver | Contact U";
		s.assertEquals(title, exptitle, "assertion fail"); 
		
		String logo= driver.findElement(By.tagName("h2")).getText();
		s.assertEquals(logo, "CONTACT US", "assertion fail 2");
		
		s.assertAll(); //this method shows you list of all failed testcases in the complete execution cycle
		
		driver.quit();
	}
}
