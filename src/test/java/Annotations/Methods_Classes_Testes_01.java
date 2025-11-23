package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Methods_Classes_Testes_01 {

	@BeforeTest
	void BeforeTest() {
		System.out.println("@BeforeTest methods.......");	
	}
	@BeforeClass
	void BeforeClass() {
		System.out.println("@BeforeClass methods.......");	
	}
	@BeforeMethod
	void Login() {
		System.out.println("@BeforeMethod methods.......");	
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
		System.out.println("@AfterMethod methods.......");	
	}
	@AfterClass
	void AfterClass() {
		System.out.println("@AfterClass methods.......");	
	}
	@AfterTest
	void AfterTest() {
		System.out.println("@AfterTest methods.......");
	}
}
