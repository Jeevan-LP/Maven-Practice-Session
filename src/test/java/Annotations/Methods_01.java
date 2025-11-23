package Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Methods_01 {
	
	@BeforeMethod
	void Login() {
		System.out.println("Login @BeforeMethod methods.......");	
	}
	@Test(priority = 1)	//priority is optional
	void Search() {
		System.out.println("Search methods.......");	
	}
	@Test(priority = 2)	//priority is optional
	void MyInfo() {
		System.out.println("MyInfo methods.......");	
	}
	@AfterMethod
	void Logout() {
		System.out.println("Logout @AfterMethod methods.......");
	}
}
