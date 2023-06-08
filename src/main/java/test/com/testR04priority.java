package test.com;

import org.testng.annotations.Test;

public class testR04priority {
 @Test(priority=1)
 public void alpha() {
	 System.out.println("alpha printed");
 }
 
 @Test(priority=2)
 public void beta() {
	 System.out.println("beta printed");
 }
 
 @Test
 public void nopriority() {
	 System.out.println("nothingmentioned printed");
 }
 //out of priority 1 and 2 and no priority mentioned , default priority is 1 
 // so priority1 executed first --> then with nth mentioned ---> then withpriority2 //this is false??
 
 @Test(priority=0)
 public void ca() {
	 System.out.println("ca printed");
 }
 
 @Test(priority=-1)
 public void da() {
	 System.out.println("da printed");
 }
 
 //order of execution
 //priority -1 ---> priority 0 --->priority nth mentioned ---> priority1 ----> priority2
}
