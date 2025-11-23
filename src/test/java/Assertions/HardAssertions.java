package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	void HardAssertion() {
		/*
		 1. We can access from Assert Class directly
		 2. All methods are static
		 3. If Hard assertion failed then rest of statements will not execute
		 */
		
		System.out.println("Welcome to");
		System.out.println("Java Selenium");
		
		Assert.assertEquals(27, 28);//hard assertion
		
		System.out.println("Welcome to");
		System.out.println("Python Selenium");
	}
}
