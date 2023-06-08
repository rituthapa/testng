package test.com;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class testR09b {
	ChromeDriver driver;
	//validate login functionality
	@DataProvider(name="loginCredentials")
	public Object [][] dataset1(){
		return new Object [][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
	}
	
	@Test(dataProvider="loginCredentials", enabled = false)
	public void testcaseLogin(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/"); ////put these few setUp lines in @BeforeMethod //so don't have to write in each testcase
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#login-button")).click();
		
		boolean logo = driver.findElement(By.cssSelector(".app_logo")).isDisplayed();
		Assert.assertEquals(logo, true);
		driver.quit(); //put this in @AfterMethod //so dont have to write in each testcase
	}
	
	//validate dashboard logo
	@Test(enabled = false)
	public void testcaseLogo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String logo = driver.findElement(By.cssSelector(".app_logo")).getText();
		Assert.assertEquals(logo,"Swag Labs");
		driver.quit();
	}
	
	
	//verify number of items in navigation bar 
	@Test(enabled=true)
	public void verifynavoptions() {
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String[] expNavoptions= {"All Items","About","Logout","Reset App State"};
		
		driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
		List <WebElement> navoptions = driver.findElements(By.cssSelector("a[class='bm-item menu-item']"));
		System.out.println(navoptions.size()); //4
		System.out.println(navoptions.get(1).getText()); //this doesn't work too //not printing anything
		for (int i=0;i<navoptions.size();i++) {
			String navops= navoptions.get(i).getText();
			System.out.println(navops); //?? doesnt work//why not printing text for navops
			String expnavops= expNavoptions[i];
			System.out.println(expnavops);
			//Assert.assertEquals(navops, expnavops);
		
		}
	//	Assert.assertEquals("total no. of options doesn't match", navoptions.size(),4); //the message you include here is the failedError message; and occurs only when testcase fails
		//Assert.assertEquals(navoptions.size(),4);
		//ComparisonFailure: expected:<[]> but was:<[All Items]>
		driver.quit();
	}
	
	// verify the add to card functionality 
	@Test(enabled=false)
	public void verifyAddtoCart() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		WebElement addButton = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
		addButton.click();
//		for(int i=0;i<addButton.size;i++) {
//			addButton.get(i).click;
//		}
		Thread.sleep(1000);
		WebElement addedNum = driver.findElement(By.cssSelector(".shopping_cart_badge"));
		//
//		for(int i=0; i< addedNum;i++) {
//			addedNum.get(i).getText;
//		}
		//System.out.println(removeButton.getText()); //Remove
		Assert.assertEquals(addedNum.getText(),"1");
		driver.quit();
	}
	
	// verify the complete order flow
	
	@Test(enabled=false)
	public void fullOrderFlow() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		WebElement addButton1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
		addButton1.click();
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#checkout")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#first-name")).sendKeys("Ritu");
		driver.findElement(By.cssSelector("#last-name")).sendKeys("Thapa");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("76005");
		driver.findElement(By.cssSelector("#continue")).submit();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#finish")).click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(3000);
		//Assert
		String OrdercompleteMsg = driver.findElement(By.cssSelector("#checkout_complete_container > h2")).getText();
		Assert.assertEquals("Thank you for your order!", OrdercompleteMsg);
	}
	
	// verify the calculation of price on checkout page
	@Test(enabled=false)
	public void priceatChkoutCalc() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("#login-button")).click();
		WebElement addButton1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
		addButton1.click();
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#checkout")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("#first-name")).sendKeys("Ritu");
		driver.findElement(By.cssSelector("#last-name")).sendKeys("Thapa");
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("76005");
		driver.findElement(By.cssSelector("#continue")).submit();
		System.out.println(driver.getCurrentUrl());
		
		String itemprice= driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]")).getText().replace("Item total: $","");
		System.out.println(itemprice);

		String taxprice= driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]")).getText().replace("Tax: $","");
		System.out.println(taxprice);
		String totalprice= driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]")).getText().replace("Total: $","");
		System.out.println(totalprice);
		
		double itmprice = Double.parseDouble(itemprice);
		DecimalFormat df= new DecimalFormat("0.00");
		double tax= itmprice*0.08;
		System.out.println(tax);
		System.out.format("%.2f",tax);
		double total= itmprice+tax;
		//System.out.format("%.2f",total);
		String totalP = df.format(total);
		System.out.println(totalP);
		
		Assert.assertEquals(totalprice,totalP);
	}
	
	
}
