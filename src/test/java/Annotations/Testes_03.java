package Annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testes_03 {

	@BeforeTest
	void Login_01() {
		System.out.println("@BeforeTest methods.......");	
	}
	@Test(priority = 1)	//priority is optional
	void Search_01() {
		System.out.println("Search methods.......");	
	}
	@Test(priority = 2)	//priority is optional
	void Profile_01() {
		System.out.println("Profile methods.......");	
	}
	@AfterTest
	void Logout_01() {
		System.out.println("@AfterTest methods.......");
	}
}
