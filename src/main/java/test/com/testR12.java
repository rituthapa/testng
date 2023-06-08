package test.com;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class testR12 {

	//dependsOnMethods //onetesstcasedepending on next
	//point1)whichever testcase it depends on if fails, it will be skipped then
	//example: saucedemo if testcase for addtocart fails, then there's no point executing completing order flow, because testcase for orderflow fails too
	//in this case, if we use dependsonMethods for orderflow testcase and write dependonMethod="addtocart",
	//then if addtocart fails, the order flow testcase wont be executed,will be skipped, saves time to run it
	@Test
	public void A() {
		System.out.println("testcase A Executed");
		//Assert.assertEquals(true, false); A fails; so rest three skipped becuase b depend on A, but D depends on C which inturn depends on B and B on A, so if A fails, all the rest 3 fails
	}
	@Test(dependsOnMethods= {"A"})
	public void B() {
		System.out.println("testcase B Executed");
		//Assert.assertEquals(true, false); //A passed, B failed, C and D skipped
	}
	@Test(dependsOnMethods= {"B"})
	public void C() {
		System.out.println("testcase C Executed");
		Assert.assertEquals(true, false);
	}
	@Test(dependsOnMethods= {"C"})
	public void D() {
		System.out.println("testcase D Executed");
		
	}
	//above,d depends on C, C on B and B on A but A dependonD makesit Cyclicdependency which is not possible 
	//because ontestcaseA if you write dependsOnMethod="D", it will give Error; none of the testcase runs..
	//point2) Thus, Cyclic dependency is not possible
	//point3)one testcase can depend on more than one testcase
	@Test(dependsOnMethods= {"C","D"})
	public void E() {
		System.out.println("testcase E Executed"); //E (and D too)skipped if C fails //if Either of the dependOn case (either C or D)  fails, then E will be skipped
	}
	//point4) dependency can happen in group level as well //see in next file
}
