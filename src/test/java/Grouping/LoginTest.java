package Grouping;

import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(groups = "Sanity", priority = 1)
	void LoginByEmail() {
		System.out.println("this method is login by email");
	}
	
	@Test(groups = "Sanity")
	void LoginByFacebook() {
		System.out.println("this method is login by Facebook");
	}
	
	@Test(groups = "Sanity")
	void LoginByInstgram() {
		System.out.println("this method is login by Instagram");
	}

}
