package test.com;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class testR14Listeners implements ITestListener{
	//Listeners watch over events and when that event occurs; listeners perform the particular action that we have implemented inside the methodname for that event
	//ITestListener is an interface you implement in your class; and you provide Listeners utilities inside xml file
	//setting up the utilities, usually already done in our project
	//all we have to know is how to use theListeners available to us
	//this is by passing the Listeners in xml file between <suite> and <test> and giving class-name in it ie, if inside src, you write packagename/classname
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case is starting");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase pass");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Testcase failed");
		//you can write a utility here that on testcase failure, to capture a screenshot of the result
		//so if a testcase fails, Listeners watch over the events and when testcase-fail event occurs, it will perform the action that we have setup for that event; which here is to take screenshot of failed result
		//if you want to perform a particular function based on a particular event, you want to have Listener around it, which Listener? a Listener that watches if that event occurs
		//in this example, you want to have a LIstener that watch over failedtestcase event, so when that happens, it will perform implemented method for that event; which here is to take screenshot of result
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Skip of test cases and its details are : " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Failure of test cases and its details are : " + result.getName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

	
	




}
