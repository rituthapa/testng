package utilities;

import java.io.File;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CommonUtils extends TestBase {
	public CommonUtils(WebDriver driver) {
		TestBase.driver = driver;
	}

	//getPageTitle
	public static String getPageTitle() {
		try {
			System.out.println("The title of the page is " + driver.getTitle());
			return driver.getTitle();
		} catch (Exception e) {
			throw new Error("title not found");
		}
	}

	//getElement
	public static WebElement getElement(By selector) {
		try {
			return driver.findElement(selector);
		} catch (NoSuchElementException e) {
			throw new Error("element not found");
		}
		// return null;
	}

	//sendKeys
	public static void SendKeys(String text, By selector) {
		try {
			cleartxt(selector);
			getElement(selector).sendKeys(text);
		} catch (NoSuchElementException e) {
			throw new Error("element not found");
		}
	}

	//cleartxt
	public static void cleartxt(By selector) {
		try {
			getElement(selector).clear();
		} catch (NoSuchElementException e) {
			throw new Error("element not found");
		}
	}

	// switch to Alert()
	public static Alert switchTOAlert(WebDriver driver) {
		try {
			return driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			throw new Error("Alert not popped" + e.getMessage());
		}
	}

	// switch to Iframe()
	public static void switchToiFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (NoSuchFrameException e) {
			throw new Error("iFrame not found" + e.getMessage());
		}
	}

	public static void switchToiFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			throw new Error("Frame not found " + e.getMessage());
		}
	}

	public static void switchToiFrame(WebDriver driver, By selector) {
		try {
			WebElement el = getElement(selector);
			driver.switchTo().frame(el);
		} catch (NoSuchFrameException e) {
			throw new Error("Frame not found " + e.getMessage());
		}
	}

	// wait() //implicitwait //??
	public static void implicitWait(WebDriver driver, long sec) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		} catch (Exception e) {
			throw new Error("waiting for desired time failed" + e.getMessage());
		}
	}

	// explicit wait()
	// waitforElementTObeVisible
	public static void waitforElementVisibility(WebDriver driver, By selector, long sec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (Exception e) {
			throw new Error("waiting for desired time failed" + e.getMessage());
		}
	}

	// waitforElementtobeClickable
	public static void waitforElementToBeClickable(WebDriver driver, By selector, long sec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.elementToBeClickable(selector));
		} catch (Exception e) {
			throw new Error("waiting for desired time failed" + e.getMessage());
		}
	}

	// Scroll Into View //javascript has a method for it
	// arguments[0].scrollIntoView();
	public static void scrollIntoView(WebDriver driver, By selector) {
		try {
			WebElement el = driver.findElement(selector);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String query = "Arguments[0].scrollIntoView();";
			js.executeScript(query, el);
		} catch (Exception e) {
			throw new Error("cant scroll to view " + e.getMessage());
		}
	}

	// wait for Page to load //waituntil.jsreturnsValue where javascript code to
	// return page to load is document.readyState === 'Completed';
	public static void waitforPageToLoad(WebDriver driver, long sec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.jsReturnsValue("return document.ReadyState === 'Completed"));
		} catch (Exception e) {
			throw new Error(e.getMessage());
		}

	}

	// maximum()
	public static void maximize(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new Error("Not able to Maximize " + e.getMessage());
		}
	}

	// findElements
	public static List<WebElement> getElements(By selector) {
		try {
			return driver.findElements(selector);
		} catch (Exception e) {
			throw new Error("elements not found " + e.getMessage());
		}
		// return null;
	}

	// isDisplayed()
	public static boolean isDisplayed(By selector) {
		try {
			return getElement(selector).isDisplayed();
		} catch (Exception e) {
			throw new Error("Element not displayed " + e.toString());
		}
	}

	// isSelected()
	public static boolean isSelected(By selector) {
		try {
			return getElement(selector).isSelected();
		} catch (Exception e) {
			System.out.println("Element not selected " + e.toString());
		}
		return false;
	}

	// isEnabled()
	public static boolean isEnabled(By selector) {
		try {
			return getElement(selector).isEnabled();
		} catch (Exception e) {
			System.out.println("Element not Enabled " + e.toString());
		}
		return false;
	}

	// DropDown() [with <select> tagname]
	public static void selectbytext(WebDriver driver, By selector, String text) {
		try {
			WebElement ele = getElement(selector);
			Select sel = new Select(ele);
			sel.selectByVisibleText(text);
		} catch (Exception e) {
			throw new Error("Unable to select" + e.getMessage());
		}
	}

	// radioButton() //??
	public static void radiobutton(By selector) {
		try {
			getElement(selector).click();
		} catch (Exception e) {
			throw new Error("unable to click radiobutton" + e.getMessage());
		}
	}

	// windowHandles() //not of great use //instead write utility for
	// windowHandle(ie; get id for a tab; you can create Set in actual testcase in this case
	public static Set<String> windowHandles() {
		try {
			return driver.getWindowHandles();
		} catch (Exception e) {
			throw new Error("set of tabs not found" + e.getMessage());
		}
	}
	// write utility for switching to a windowTab ie;windowHandle(ie; get id for a tab as a string)
	public static void switchtoWindow(WebDriver driver, String handleId) {
		try{
			driver.switchTo().window(handleId);
		}
		catch(Exception e) {
			throw new Error(e.getMessage());
		}
	}

	// screenShot()
	public static void takeScreenshot(WebDriver driver, String filepath) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver; // here TakesScreenshot is an interface; we are upcasting
															// this interface to the driver; which is stored in
															// reference variable ts
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(filepath); // example of String filepath: ".//screenshot/page.png"
			FileUtils.copyFile(src, des);
		} catch (Exception e) {
			throw new Error("can't get screenshot" + e.getMessage());
		}

	}

	// Actions //double-click
	public static void doubleclick(WebDriver driver, By selector) {
		try {
			WebElement el = getElement(selector);
			Actions ac = new Actions(driver);
			ac.doubleClick(el).build().perform();
		} catch (Exception e) {
			throw new Error("can't double-click" + e.getMessage());
		}
	}

	// Click()
	public static void click(By selector) {
		try {
			getElement(selector).click();
		} catch (Exception e) {
			throw new Error("not clicked" + e.getMessage());
		}
	}

	// Navigate to pages()
	public static void NavigatetoPages() {
		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			throw new Error("not gone to pages" + e.getMessage());
		}
	}
}
