package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	//create config.properties files in configfolder
	//read the config file
	//to get the baseurl
	//to get the browser of whatever value is given in config file
	//to get to launch the browser 
	//setup browser //do with @beforeTest
	//close the broswer //do with @afterTest
	public static WebDriver driver;
	public static Properties prop = new Properties();

	@BeforeTest
	public void SetUp() throws IOException {
		if(driver == null) {
			//to read a file
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"//src/test/resources/configFiles/config.properties");
			prop.load(input);
			//System.out.println(prop.getProperty("browser")); //firefox //this is the value for browser from config.properties file
		}
		
		if(prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("baseUrl"));
		}
		else if(prop.getProperty("browser")=="firefox") {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("baseUrl"));
		}
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
