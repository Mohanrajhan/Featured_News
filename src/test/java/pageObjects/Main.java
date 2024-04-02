package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
		static WebDriver driver;
		public static WebDriver DriverSetup()
		{
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
			driver.manage().window().maximize();
			return driver;
		}
	public static void main(String[] args) throws InterruptedException {
		
		driver = DriverSetup();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		HomePage hp = new HomePage(driver);
		NewsPage np = new NewsPage(driver);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(hp.UserButton()));
		while(true)
		{
		      try
			   {
		    	  element.click();
			    if(hp.UserInfo1().isDisplayed() && hp.UserInfo2().isDisplayed() )
			    {
			    	System.out.println(hp.UserInfo1().getText());
			    	System.out.println(hp.UserInfo2().getText());
				  break;
			     }
			   }
			   catch(Exception e)
			    {
			    }
		 }
		for(int i=1;i<=hp.featuredNews().size()-1;i++)
		{
			String toolTitle =hp.getToolTipTitle(i);
			hp.clickEveryNews(i);
			
			String headerTitle= np.getNewsTitle();
			if(toolTitle.equals(headerTitle))
			{
				System.out.println("News Header and Tooltip displayed are same ");
			}
			else
			{
				System.out.println("News Header and Tooltip displayed are not same ");
			}
			
			Thread.sleep(5000);
			np.hoverAuthorDetails();
			Thread.sleep(5000);
			System.out.println();
			System.out.println("Is the Personal card displayed: "+np.isPersonalCardDisplayed());
			
			System.out.println();
			
			np.clickShareButton();
			System.out.println("The Share Options are \n"+np.getShareOptions());
			np.clickShareButton();
			System.out.println("\nThe News Contents are \n"+np.getParagraph());
			try {
			System.out.println("\nTotal Likes: "+np.getTotalLikes());
			System.out.println("\nTotal Views: "+np.getTotalViews());
			}
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}
			
			try {
				np.isLinksActive();
			} catch (IOException e) {
				e.printStackTrace();
			}
			hp.clickBeCognizant();
		}
		
		driver.quit();
		
		
		
	}

}
