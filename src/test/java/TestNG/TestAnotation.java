package TestNG;

import org.testng.annotations.Test;

//Navigate browser
//Login application
//Logout application

public class TestAnotation {
	/*
	 1. if methods declared with Test annotations will be execute defaultly alphabetical order
	 2. if methods declared with Test annotations and priority will be execute based on given number
	   a. Number can be anything but should be order
	 */
	
	@Test(priority = 3)
	void Logout() {
		System.out.println("Logout to application");
	}
	@Test(priority = 1)
	void Browser() {
		System.out.println("Lanching to browser");
	}
	@Test(priority = 2)
	void Login() {
		System.out.println("Login to application");
	}


}
