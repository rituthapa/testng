package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomeProducts;
import pages.Login;

public class homepageTestcases extends Login {

	public homepageTestcases(WebDriver driver) {
		super(driver);
	}

	HomeProducts products= new HomeProducts(driver);
	 @Test
	 public void validateproductsize() {
		 Assert.assertEquals(products.productlist(), 6);
	 }
	 
}
