package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Methods_Classes_01 {

	@BeforeClass
	void Launching() {
		System.out.println("Launching @BeforeClass methods.......");	
	}
	
	@BeforeMethod
	void Login() {
		System.out.println("Login @BeforeMethod methods.......");	
	}
	
	@Test(priority = 1)	//priority is optional
	void Search() {
		System.out.println("Search methods.......");	
	}
	
	@Test(priority = 2)	//priority is optional
	void Profile() {
		System.out.println("Profile methods.......");	
	}
	
	@AfterMethod
	void Logout() {
		System.out.println("Logout @AfterMethod methods.......");
	}
	
	@AfterClass
	void Closed() {
		System.out.println("Closed @AfterClass methods.......");	
	}
}
