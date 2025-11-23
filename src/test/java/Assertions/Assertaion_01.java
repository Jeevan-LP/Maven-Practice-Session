package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertaion_01 {
	
	@Test
	void AssertMethod_01() {
		String Name1="Jeevan";
		String Name2="Jeevan";
		
		///Approach 1 most of the time we will use this
		///Note: Most of the time we will assertions last statement of the test cases for validation 
		/*
		  Assert.assertEquals(Name1, Name2);// to compare to value
		 */
		
		///Approach 2 
		if(Name1==Name2) {
			System.out.println("Given name is matching");
			Assert.assertTrue(true);
		}
			
		else{
			System.out.println("Given name is not matching");
			Assert.assertTrue(false);
		}
		
		
		
	}

}
