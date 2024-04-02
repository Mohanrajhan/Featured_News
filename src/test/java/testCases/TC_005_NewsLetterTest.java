package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_005_NewsLetterTest extends BaseClass{

	@Test
	public void getNewsLetter() throws InterruptedException
	{
		logger.info("**** Starting TC_005_NewsLetterTest ****");
		try {
			System.out.println("\nThe News Contents are \n"+np.getParagraph());
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_005_NewsLetterTest ****");
	}
}
