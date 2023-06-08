package test.com;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testR03annotations {

	
	// in xml file //execution order will be as follows  //you can write code in any order though
	//    suite
	//           test
	//                 classes
	//                         methods
	
	//annotations
	
	@Test()
	public void testcase1() {
		System.out.println("this is testcase1");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite method called");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite method called");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test method called");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test method called");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class method called");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class method called");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method called");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method called");
	}
}
