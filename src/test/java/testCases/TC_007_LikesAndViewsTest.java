package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TC_007_LikesAndViewsTest extends BaseClass{

	@Test
	public void getTotalLikesAndViews() throws InterruptedException
	{
		logger.info("**** Starting TC_007_LikesAndViewsTest ****");
		try {
		System.out.println("\nTotal Likes: "+np.getTotalLikes());
		System.out.println("\nTotal Views: "+np.getTotalViews());
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail("An exception occured:"+ e.getMessage());
		}
		logger.info("**** Finished TC_007_LikesAndViewsTest ****");
	}
}
