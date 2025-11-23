package Grouping;

import org.testng.annotations.Test;

public class LogoutTest {
	
	@Test(groups = {"Regression","Sanity","Functional"})
	void LogoutByFacebook() {
		System.out.println("this method is Logout by Facebook");
	}
	
	@Test(groups = {"Regression","Sanity","Functional"})
	void LogoutByInstgram() {
		System.out.println("this method is Logout by Instagram");
	}
}
