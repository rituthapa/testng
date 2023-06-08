package test.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test0R2 {

	@BeforeMethod
	public void beforemethod() {
		System.out.println("This occurs before testcase");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("This occurs after testcase");
	}
	
	@Test(priority=1)
	public void login() {
		System.out.println("successful login");
	}
	
	@Test(priority=1)
	public void logout() {
		System.out.println("successful logout");
	}
}
