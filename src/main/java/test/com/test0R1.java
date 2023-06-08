package test.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test0R1 {
	
	//Hierarchy of annotations //Execution of codes run in following order
	//Suites
	//Tests
	//Classes
	//Methods
	//@Test //ie, actual testcase
	
	@BeforeMethod
	public void beforemethod() {
		System.out.println("This occurs before testcase");
	}
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("This occurs after testcase");
	}

	@Test(priority = 1)
	public void loginTest() {
		System.out.println("Login successful");
	}
	@Test(priority = 2)
	public void logoutTest() {
		System.out.println("Logout successful");
	}
	//here execution occurs as follows: 
	//beforemethod -----> @test case1-----> aftermethod ---->beforemethod ----> @test case2 -----> aftermethod
}
