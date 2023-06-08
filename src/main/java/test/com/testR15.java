package test.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class testR15 {
	//How to take screenshot in Selenium
	//firstly, there is an interface TakeScreenshotAs which has to be Upcast with the driver and there's a method on it which is getScreenshotAs;
	//this method clicks the screenshot and convert this output to the file format
	//this is our source
	//second, we need to copy file from source to destination
	//for this, we need to create destination instance of File class where we need to dump this file in order to store it in our system/local machine
	@Test
	public void getScreenshot() throws IOException {
		ChromeDriver driver;
		 System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		 ChromeOptions options = new ChromeOptions(); 
		  options.addArguments("--remote-allow-origins=*"); 
		  driver = new ChromeDriver(options); 
		driver.get("https://www.saucedemo.com/");
		
		 //taking the screenshot and converting to file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 //this is not save to our local machine
		//so we need to create another File instance (lest's say des) where we store it to our system (destination where we dump/store our screenshot img-file)
		 File des= new File(".//screenshot/page.png"); // .// means preceding to our current folder, it'll create new one that we give it now, for creating folder give name screenshot and file inside it /page ; extension .png because image file
		 //now, we can copy file from src to dest
		 FileUtils.copyFile(src, des);
		 
		 driver.quit();
	 }
}
