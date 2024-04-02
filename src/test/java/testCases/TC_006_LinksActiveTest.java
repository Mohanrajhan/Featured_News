package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_006_LinksActiveTest extends BaseClass{
	
	@Test
	public void checkingLinks()
	{
		logger.info("**** Starting TC_006_LinksActiveTest ****");
		try {
			np.isLinksActive();
			hp.clickBeCognizant();
			}
			catch(Exception e)
			{
				logger.error("test failed");
				Assert.fail("An exception occured:"+ e.getMessage());
			}
		logger.info("**** Finished TC_006_LinksActiveTest ****");
	}
	
}
