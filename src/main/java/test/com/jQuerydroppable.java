package test.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class jQuerydroppable {
ChromeDriver driver;
	@Test (priority=1)
	public void getTitle() {
		System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://jqueryui.com/droppable/");
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Droppable | jQuery UI");
	}
	@Test (priority=2)
	public void currentUrl() {
		String url= driver.getCurrentUrl();
		String urlExp = "https://jqueryui.com/droppable/";
		Assert.assertEquals(urlExp, url);
	}
	
	@Test (priority=3)
	public void dragNdrop() throws InterruptedException{
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
		WebElement droppable = driver.findElement(By.cssSelector("#droppable"));
		Actions ac= new Actions(driver);
		ac.dragAndDrop(draggable, droppable).build().perform();
		Thread.sleep(2000);
		
		WebElement dropped = driver.findElement(By.cssSelector("#droppable"));
		Assert.assertEquals("nor dropped to target","Dropped!",dropped.getText());
		driver.quit();
	}
}
