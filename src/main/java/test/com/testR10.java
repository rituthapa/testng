package test.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testR10 {
	ChromeDriver driver;
	
	 // verify the Sorting filter  
	//for this:
	//capture list of productname/price before choosing the sorting filter
	//then apply sort function to create an expected sorted list (and reverse function too for descending)
	//perform action of actually selecting filter you want from dropdown
	//to Assert if sorted ascending or descending based on the testcase accordingly
	//capture after using Sorting-filter to get actual priceHighto Low list that appears in UI
	//assert by comparing expected sorted list and actual sorted list is matched or not
	 
	 @Test(priority = 1, enabled=true)
	public void verifySortAtoZ() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
			driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
			driver.findElement(By.cssSelector("#login-button")).click();
			
			//before selecting filter
			List<WebElement> productsBeforeSort = driver.findElements(By.cssSelector(".inventory_item_name"));
			List<String> productName = new ArrayList<String>();
			for(int i=0; i<productsBeforeSort.size();i++) {
				productName.add(productsBeforeSort.get(i).getText());
			}
//			for(String productName: productsBeforeSort) {
//				productName.add((productName).getText()); //how to use for each???
//			}
			Collections.sort(productName);
			System.out.println("ExpectedSortAtoZ: " + productName);
			
			//select filter
			WebElement sortaz = driver.findElement(By.cssSelector(".product_sort_container"));
			Select sel= new Select(sortaz);
			Thread.sleep(1000);
			sel.selectByIndex(0);
			Thread.sleep(1000);
			
			//after selecting filter
				List<WebElement> productsAfter = driver.findElements(By.cssSelector(".inventory_item_name"));
				List<String> productName2 = new ArrayList<String>();
				for(int i=0; i<productsAfter.size();i++) {
					productName2.add(productsAfter.get(i).getText());
				}
				System.out.println("ActualSortAtoZ: " + productName2);
				
				//assertion
				Assert.assertEquals("Not Sorted correctly", productName, productName2);
	 }
	 
	 @Test(priority = 2, enabled=true)
		public void verifySortZtoA() throws InterruptedException {
			 System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.get("https://www.saucedemo.com/");
				driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
				driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
				driver.findElement(By.cssSelector("#login-button")).click();
				
				//before selecting filter
				List<WebElement> productsBeforeSort = driver.findElements(By.cssSelector(".inventory_item_name"));
				productsBeforeSort.stream().sorted(); //Sort to alphabetical order from random order
				Collections.reverse(productsBeforeSort); //then reverse the order for descending order of alphabets
				List <String> NameSorted = new ArrayList<String>();
				for(int i=0; i<productsBeforeSort.size();i++) {
					NameSorted.add(productsBeforeSort.get(i).getText());
				}
				System.out.println("productSortedZtoA: " + NameSorted);
				
				//select the filter
				WebElement sortaz = driver.findElement(By.cssSelector(".product_sort_container"));
				Select sel= new Select(sortaz);
				Thread.sleep(1000);
				sel.selectByIndex(1);
				Thread.sleep(1000);
				
				//after selecting filter
				
					List<WebElement> productsAfter = driver.findElements(By.cssSelector(".inventory_item_name"));
					List <String> productsAfterfilter = new ArrayList<String>();
					for(int i=0; i<productsAfter.size();i++) {
						productsAfterfilter.add(productsAfter.get(i).getText());
					}
					System.out.println("ActualSortZtoA: " + productsAfterfilter);
					
				//assertion	
				Assert.assertEquals(NameSorted,productsAfterfilter);
	 }
	
	@Test(priority=3, enabled=true)
		public void verifyPriceLowtoHigh() throws InterruptedException {
			 System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.get("https://www.saucedemo.com/");
				driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
				driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
				driver.findElement(By.cssSelector("#login-button")).click();
				
				//before selecting filter
				List<WebElement> priceBefore = driver.findElements(By.cssSelector(".inventory_item_price"));
				List <Double> priceList = new ArrayList<Double>();
				for(int i=0; i<priceBefore.size();i++) {
					String price = priceBefore.get(i).getText().replace("$","");
					priceList.add(Double.parseDouble(price));
				}
				Collections.sort(priceList);
				System.out.println("ExpectedpriceSorted " + priceList);
				
				//selecting filter
				WebElement sortaz = driver.findElement(By.cssSelector(".product_sort_container"));
				Select sel= new Select(sortaz);
				Thread.sleep(1000);
				sel.selectByIndex(2);
				Thread.sleep(1000);
				
				//After selecting filter
				
					List<WebElement> priceAfter = driver.findElements(By.cssSelector(".inventory_item_price"));
					List <Double> priceList2 = new ArrayList<Double>();
					for(int i=0; i<priceAfter.size();i++) {
						String price2 = priceAfter.get(i).getText().replace("$","");
						priceList2.add(Double.parseDouble(price2));
					}
					System.out.println("ActualPriceLowtoHigh " + priceList2);
			//assertion
				Assert.assertEquals(priceList, priceList2);
	 }
	 
	 @Test(priority=4, enabled=true)
		public void verifyPriceHightoLow() throws InterruptedException {
			 System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				driver.get("https://www.saucedemo.com/");
				driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
				driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
				driver.findElement(By.cssSelector("#login-button")).click();
				
				//before selecting filter
				List<WebElement> priceBefore = driver.findElements(By.cssSelector(".inventory_item_price"));
				List <Double> priceList = new ArrayList<Double>();
				for(int i=0; i<priceBefore.size();i++) {
					String price = priceBefore.get(i).getText().replace("$","");
					priceList.add(Double.parseDouble(price));
				}
				Collections.sort(priceList);
				Collections.reverse(priceList); //in order to reverse it, first sort the random order by lowtohighprice (or alphabeticalproductname for name testcase)
				System.out.println("ExpectedpriceSorted " + priceList);
				
				//selecting filter
				WebElement sortaz = driver.findElement(By.cssSelector(".product_sort_container"));
				Select sel= new Select(sortaz);
				Thread.sleep(1000);
				sel.selectByIndex(3);
				Thread.sleep(1000);
				
				//after selecting filter
					List<WebElement> priceAfter = driver.findElements(By.cssSelector(".inventory_item_price"));
					List <Double> priceList2= new ArrayList<Double>();
					for(int i=0; i<priceAfter.size();i++) {
						String price2 = priceAfter.get(i).getText().replace("$","");
						priceList2.add(Double.parseDouble(price2));
					}
					System.out.println("ActualPriceHightoLow" + priceList2);
				//assertion
				Assert.assertEquals(priceList, priceList2);
	 }
}
