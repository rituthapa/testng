package test.com;

import org.testng.annotations.Test;

public class testR05groups {
	
	//let says you working on 5 differnet apps
	// Actual environment 
		// order pad
		// portfolio
		// investment tool 
	    // market
		// widget 

	@Test(groups ="login")
	public void testcase1() {
		System.out.println("testcase 1 executed");
	}
	
	@Test(groups ="login")
	public void testcase2() {
		System.out.println("testcase 2 executed");
	}
	
	@Test(groups ="invest")
	public void testcase3() {
		System.out.println("testcase 3 executed");
	}
	
	@Test(groups ="invest")
	public void testcase4() {
		System.out.println("testcase 4 executed");
	}
	
	@Test(groups ="portfolio")
	public void testcase5() {
		System.out.println("testcase 5 executed");
	}
	
	@Test(groups ="portfolio")
	public void testcase6() {
		System.out.println("testcase 6 executed");
	}
	
	//in xml file // the content inside test method should contain other methods in exact order as follows
	//method-selectors --- parameters ---- groups ---- packages --- classes
	//inside groups --- run  --- include or exclude --include or excludes
}
