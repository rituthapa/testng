package test.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class testR16ExcelDataprovider {
	
// instead of providing hard-coded static data inside Dataproviders inside class files;
	//it is preferred to keep data separte in external files like txt file,xml,csv,excelfile,databases,etc.
	//so any change in data can be done just by going to that particular file instead of going inside the code
	//Dataproviders helps connect those external files (here excel) and so we can use the dynamic data from outside inside our code easily
	//this is using excel to get data which then connects to our testcases using dataprovider
	
	// Create a testcase for login  
	 // Create a excel data sheet for same 
	 // create a function to open and read excel file  
	 // create a testNg testcase for reading data via excel using dataprovider 
	 // run the testcase 
WebDriver driver;
	
	@DataProvider(name = "loginData")
	public Object[][] excellogindata() throws IOException{
		Object[][] exceldata = getexcelData("C:\\Users\\Thapa\\eclipse-Rituworkspace\\sauceUsers.xlsx","Sheet1");
			return exceldata;
	}
	public String[][] getexcelData(String filepath,String sheetname) throws IOException{
		String[][] logindata=null;
		try {
			FileInputStream fis= new FileInputStream(filepath);
			XSSFWorkbook wb= new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheetname);
			XSSFRow row= sheet.getRow(0);
			Cell cell;
			
			int rowstotal = sheet.getPhysicalNumberOfRows();
			System.out.println(rowstotal); //5
			int totalrows=sheet.getLastRowNum();
			System.out.println(totalrows); //4 (because zero-based, counts from 0)
			int totalcols = row.getLastCellNum();
			System.out.println(totalcols); //2 (because zero-based+1; or you can also say it's 1-based)
			
			
			logindata = new String [totalrows][totalcols];
			for (int i=1;i<=totalrows;i++) {
				for(int j=0;j<totalcols;j++) {
					row=sheet.getRow(i);
					cell=row.getCell(j);
					//cell.getStringCellValue();
					System.out.println(cell.getStringCellValue());
					logindata[i-1][j] =cell.getStringCellValue();
				}
			}
		} catch (Exception e) {
			System.out.println("hello");
			e.printStackTrace();
		}
		return logindata;
		
	}


@Test(dataProvider = "loginData")
public void testcaseLogin(String usernm, String pwd) {
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.cssSelector("#user-name")).sendKeys(usernm);
	driver.findElement(By.cssSelector("#password")).sendKeys(pwd);
	driver.findElement(By.cssSelector("#login-button")).click();
	List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item_name"));
	Assert.assertEquals(products.size(), 6);
}

@BeforeMethod
public void SetUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Browsers\\lib\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
}

@AfterMethod
public void TearDown() {
	driver.quit();
}
}
