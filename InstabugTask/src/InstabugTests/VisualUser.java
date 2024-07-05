package InstabugTests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import InstabugTests.UsersConfig.UsernameIndex;

public class VisualUser extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);
		
		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		SoftAssert SoftAssertion = new SoftAssert();
		
		/*Get username for: Visual user*/
		String UserName = GetUsername(driver,UsernameIndex.VisualUserIndex);
		
		/*Get password*/
		String Password = GetPassword(driver);
		
		/*Login*/
		Login(driver,UserName,Password);
			
		/*Check user successfully logged in*/
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, UsersConfig.SuccessfulLoginURL);

		/*Get price of 1st item from Main Page*/
		String ItemPriceMainPage = driver.findElements(By.cssSelector("div[class='inventory_item_price']")).get(0).getText();
		
		/*Click on 1st Item*/
		driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
		
		/*Get price of item from item Page*/
		String ItemPriceItemPage = driver.findElement(By.cssSelector("div[class='inventory_details_price']")).getText();
		
		/*Check they are both the same*/
		SoftAssertion.assertEquals(ItemPriceItemPage,ItemPriceMainPage);
		
		/*Go back to Main Page*/
		driver.findElement(By.id("back-to-products")).click();
		
		/*Get price of 1st item from Main Page*/
		String ItemPriceMainPage2 = driver.findElements(By.cssSelector("div[class='inventory_item_price']")).get(0).getText();
		
		/*Check it's equal to price on Item page, and to price on Main Page(saved at beginning)*/
		SoftAssertion.assertEquals(ItemPriceMainPage2,ItemPriceMainPage);
		SoftAssertion.assertEquals(ItemPriceMainPage2,ItemPriceItemPage);
		
		SoftAssertion.assertAll();
		
		driver.close();
	}

}
