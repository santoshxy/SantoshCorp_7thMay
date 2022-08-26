package SequenceOfTestCasese;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ChekingTestCaseSequence {
	
	@Test(priority=1,dependsOnMethods="atestcase2",alwaysRun=true)
	public void testcase1() {
		System.out.println("1st case");
	}
	
	@Test(priority=-1)
	public void atestcase2() {
		System.out.println("2nd case");
		Assert.assertEquals(false, true);
	}
	
	@Test(priority=2,invocationCount=10) 
	public void checkReporter() {
		Reporter.log("chekingLogSantosh",true);
	}
	


}
