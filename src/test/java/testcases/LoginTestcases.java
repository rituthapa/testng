package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login;

public class LoginTestcases extends TestBase {
	static Login login = new Login(driver);
	@Test
	public static void validLogin() {
		login.ValidLogin();
	}
	@Test
	public static void InvalidLogin() {
		Boolean errMsg = login.InvalidLogin();
		Assert.assertTrue(errMsg);
	}
	@Test
	public static void validateLogo() {
		boolean logo = login.LogoVisible();
		Assert.assertTrue(logo);
	}
	
	@Test
	public static void validateTitle() {
	String title=login.validateTitle();
	Assert.assertEquals(title,"Swag Labs");
	}
}
