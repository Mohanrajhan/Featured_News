package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_003_AuthorInfoTest extends BaseClass{

	@Test
	public void validateAuthorInfoDisplay()
	{
		logger.info("**** Starting TC_003_AuthorInfoTest ****");
		try {
			Thread.sleep(5000);
			np.hoverAuthorDetails();
			System.out.println("Is the Personal card displayed: "+np.isPersonalCardDisplayed());
			System.out.println();
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_003_AuthorInfoTest ****");
	}
}
