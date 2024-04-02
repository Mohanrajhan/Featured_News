package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//div[@data-automation-id='HeroPatternElement']")
	List<WebElement> featuredNews;
	
	@FindBy(xpath="//span[text()='be.cognizant']")
	WebElement beCognizant;
	
	@FindBy(xpath="//button[@id='O365_MainLink_Me']")
	WebElement UserButton;
	
	@FindBy(xpath="//div[@data-automation-id='HeroPatternElement']")
	List<WebElement> featuredTitle; 
	
	@FindBy(xpath="//div[@class='mectrl_accountDetails']/div[1]")
	WebElement UserInfo1;
	@FindBy(xpath="//div[@class='mectrl_accountDetails']/div[2]")
	WebElement UserInfo2;
	
	public List<WebElement> featuredNews()
	{
		return featuredNews;
	}
	public String getToolTipTitle(int no)
	{
		int newsnum = no-1;
		return featuredTitle.get(newsnum).getText();
	}
	public void clickEveryNews(int id) 
	{	
		int newsnum = id-1;
		featuredNews.get(newsnum).click();
	}
	
	public void clickBeCognizant()
	{
		beCognizant.click();
	}
	public WebElement UserButton()
	{
		return UserButton;
		
	}
	public WebElement UserInfo1()
	{
		return UserInfo1;
	}
	public WebElement UserInfo2()
	{
		return UserInfo2;
	}

}
