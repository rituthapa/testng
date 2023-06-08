package test.com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testR13 {
	@Test(groups= {"login"})
	public void TestcaseOne() {
		System.out.println("TestCaseOne executed");
	}
	@Test(groups={"login"})
	public void TestcaseTwo() {
		System.out.println("TestCaseTwo executed");
		Assert.assertEquals(true, false);
	}
	@Test(dependsOnGroups= {"login"}, groups= {"logout"})
	public void TestcaseThree() {
		System.out.println("TestCaseThree executed");
	}
	
	//here logout group depends on login group, so if any testcase within group=login fails, testcase with logout group will be skipped
}
