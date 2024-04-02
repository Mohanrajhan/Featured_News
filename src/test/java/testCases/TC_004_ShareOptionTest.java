package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_004_ShareOptionTest extends BaseClass {

	@Test
	public void validateShareOption()
	{
		logger.info("**** Starting TC_004_ShareOptionTest ****");
		try {
		np.clickShareButton();
		System.out.println("The Share Options are \n"+np.getShareOptions());
		np.clickShareButton();
		
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Starting TC_004_ShareOptionTest ****");
	}
}
