package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Classes_01 {
	
	@BeforeClass
	void Login() {
		System.out.println("Login @BeforeClass methods.......");	
	}
	@Test(priority = 1)	//priority is optional
	void Search() {
		System.out.println("Search methods.......");	
	}
	@Test(priority = 2)	//priority is optional
	void Profile() {
		System.out.println("Profile methods.......");	
	}
	@AfterClass
	void Logout() {
		System.out.println("Logout @AfterClass methods.......");
	}
}
