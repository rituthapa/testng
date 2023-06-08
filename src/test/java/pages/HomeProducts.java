package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeProducts extends Login{

	public HomeProducts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By productsAll= By.cssSelector("#inventory_container");
	By navButton= By.cssSelector("#react-burger-menu-btn");
	By addTocartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");
	By productAdded= By.cssSelector(".shopping_cart_badge");
	
	//Login.   ???
	public int productlist() {
		List<WebElement> allproducts = driver.findElements(productsAll);
		return allproducts.size();
	}
	
	
}
