package ListenerReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/*
"Two ways using Listener"
1. ITestListener interface implements
2. TestListenerAdapter class extends
*/
public class DemoListener implements ITestListener{
//public class MainReport extends TestListenerAdapter{
	
	
	public void onStart(ITestContext context) {
		System.out.println("Test execution is started......");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test method execution is started......");
	  }
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test method execution is passed......");
	  }
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test method execution is failed......");
	  }
	
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test method execution is skipped......");
	  }
	
	public void onFinish(ITestContext context) {
		System.out.println("Test execution is finished......");
	 }
	

}
