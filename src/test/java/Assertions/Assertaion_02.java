package Assertions;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertaion_02 {

	@Test
	void AssertMethod_02() {
		
		//.assertEquals("jeevan", 123);//Failed
		//Assert.assertEquals('J', 'J');//Passed
		
		//Assert.assertNotEquals("jeevan", 123);//Passed
		//Assert.assertNotEquals('J', 'J');//Failed
		
		//Assert.assertTrue(true);//Passed
		//Assert.assertTrue(false);//Failed
		
		//Assert.assertFalse(false);//Passed
		//Assert.assertFalse(true);//Failed
		
		Assert.fail();//Failed
		
	}
}
