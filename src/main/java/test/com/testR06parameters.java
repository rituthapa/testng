package test.com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testR06parameters {
 @Test
 @Parameters({"username","password"})
 public void testcaseA(String un ,String pw) {
	 System.out.println(un);
	 System.out.println(pw);
	 System.out.println("testcase A");
 }
 
 @Test
 @Parameters({"brother","sister"})
	public void testcaseB(String bro, String sis) {
		System.out.println(bro);
		System.out.println(sis);
		System.out.println("testcase B");
}
}
