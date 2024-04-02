package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Skeleton {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(StaleElementReferenceException.class);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		Actions act = new Actions(driver);
		List<WebElement> Featurednews = driver.findElements(By.xpath("//div[@data-automation-id='HeroPatternElement']"));

			Featurednews.get(1).click();		
			
			WebElement title= driver.findElement(By.xpath("//div[@data-automation-id='TitleTextId']"));
			System.out.println(title.getText());
//			Thread.sleep(5000);
			WebElement author = driver.findElement(By.xpath("//div[@class='jc_z_9f38462c jj_z_9f38462c']"));
			act.moveToElement(author).build().perform();
			
			List<WebElement> paras = driver.findElements(By.xpath("//div[@data-automation-id='CanvasSection']"));
			for(WebElement para : paras)
			{
				System.out.println(para.getText());
				
			}
			
			System.out.println(driver.findElement(By.xpath("//span[contains(text(),'liked this')]")).getText());
		}
		
//	
	}

