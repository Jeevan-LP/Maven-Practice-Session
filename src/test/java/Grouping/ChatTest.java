package Grouping;

import org.testng.annotations.Test;

public class ChatTest {
	@Test(groups = "Regression")
	void ChatByEmail() {
		System.out.println("this method is Chat by email");
	}
	
	@Test(groups = "Regression")
	void ChatByFacebook() {
		System.out.println("this method is Chat by Facebook");
	}
	
	@Test(groups = "Regression")
	void ChatByInstgram() {
		System.out.println("this method is Chat by Instagram");
	}
}
