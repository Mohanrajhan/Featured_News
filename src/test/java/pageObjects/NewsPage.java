package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage extends BasePage{

	public NewsPage(WebDriver driver) {
		super(driver);
		
	}
	WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
	Actions act = new Actions(driver);
	JavascriptExecutor jse =(JavascriptExecutor)driver;
	@FindBy(xpath="//div[@data-automation-id='TitleTextId']")
	WebElement title;
	
	@FindBy(xpath="//div[@data-automation-id='textBox']//p")
	List<WebElement> paragraphs;
	
	@FindBy(xpath="//div[@data-automation-id='textBox']//a")
	List<WebElement> links;
	
	@FindBy(xpath="//div[@class='lo_ae_9f38462c nn_at_9f38462c']")
	WebElement author;
	
	@FindBy(xpath="//div[@id='LivePersonaCardRootElement']")
	WebElement personalCard;
	
	@FindBy(xpath="//button[@data-automation-id='shareButton']")
	WebElement shareButton;
	
	@FindBy(xpath="//span[text()='Share page']/ancestor::ul")
	WebElement shareOptions;
	
	@FindBy(xpath="//span[contains(text(),'people liked this')]")
	WebElement totalLikes;
	
	@FindBy(xpath="//span[contains(text(),'Views')]")
	WebElement totalViews;
	
	@FindBy(xpath="//div[@class='g_b_f71b5f03']")
	WebElement scrollBody;
	
	public void isLinksActive() throws IOException
	{
		System.out.println("total links: "+ links.size());
		int brokenLinksCount=0;
		int activeLinksCount=0;
		for(WebElement link: links)
		{
			String hrefAttVal=link.getAttribute("href");
			System.setProperty("javax.net.ssl.trustStore", "C:/.keystore");
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			if(hrefAttVal==null || hrefAttVal.isEmpty())
			{
				System.out.println("Href Attribute Value is empty");
				continue;
				
			}
			URL urlLink = new URL(hrefAttVal);
			HttpURLConnection conn = (HttpURLConnection)urlLink.openConnection();
			conn.connect();
			
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefAttVal+"    is a Broken Link");
				++brokenLinksCount;
			}
			else
			{
				System.out.println(hrefAttVal+"    is Not a Broken Link");
				++activeLinksCount;
			}
		}
		System.out.println("Total Broken Links:"+brokenLinksCount);
		System.out.println("Total Active Links:"+activeLinksCount);

	}
	
	public String getTotalLikes() throws InterruptedException
	{
		title.click();
		act.sendKeys(Keys.END).perform();
		jse.executeScript("arguments[0].scrollIntoView();",totalLikes);
		Thread.sleep(3000);
		String likes[] = totalLikes.getText().split(" ");
		return likes[0];
	}
	
	public String getTotalViews()
	{
		jse.executeScript("arguments[0].scrollIntoView()",totalViews);
		String views[]= totalViews.getText().split(" ");
		return views[0];
	}
	
	public String getShareOptions()
	{
		return shareOptions.getText();
		
	}
	public void clickShareButton()
	{
		shareButton.click();
	}
	
	public String getNewsTitle()
	{
		return title.getText();
	}
	
	public String getParagraph()
	{

		String paragraph = "";
		for(WebElement para:paragraphs)
		{
			paragraph+=para.getText()+"\n";
		}
		return paragraph;
	}
	public void hoverAuthorDetails()
	{
		try {
			if(author.isDisplayed())
			{
				act.moveToElement(author).perform();
//				myWait.until(ExpectedConditions.element);
				Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Author not found");
		}
	}
	public boolean isPersonalCardDisplayed()
	{
		try {
			if(personalCard.isDisplayed())
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("No Personal Card Displayed");
		}
		return false;
	}
}
