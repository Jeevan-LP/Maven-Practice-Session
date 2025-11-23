package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testes_Suits {
	
	@BeforeSuite
	void Launching() {
		System.out.println("@BeforeSuite methods.......");	
	}
	
	@BeforeClass
	void Login() {
		System.out.println("@BeforeClass methods.......");	
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
		System.out.println("@AfterClass methods.......");
	}
	
	@AfterSuite
	void Closed() {
		System.out.println("@AfterSuite methods.......");	
	}
}
