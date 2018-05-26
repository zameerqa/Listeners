package retrylogic.tesLevel;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Implementing Retry Logic at test level i.e., 
 * by passing class name where retry logic code is available as a parameter for each test
 * In this package our retry logic code is available in RetryLogic.class

 */public class BasicTest {
	 @Test(retryAnalyzer=retrylogic.tesLevel.RetryLogic.class)
	 public void m1(){
		 Assert.assertEquals(true, true);
	 }
	 @Test(retryAnalyzer=RetryLogic.class)
	 public void m2(){
		 //		Assert.assertEquals(false, true);
		 
		 System.out.println(2/0);
	 }



 }
