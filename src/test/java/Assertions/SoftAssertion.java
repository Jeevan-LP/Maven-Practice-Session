package Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	@Test
	void SoftAssertion() {
		/*
		 1. We can access from SoftAssert object
		 2. have to create object
		 3. If soft assertion failed then rest of statements will still execute
		 */
		
		System.out.println("Welcome to");
		System.out.println("Java Selenium");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(27, 27);//soft assertion
		
		System.out.println("Welcome to");
		System.out.println("Python Selenium");
		
		sa.assertAll();//must mandatory
		
	}
}
