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

public class ProblemUser extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);
		
		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		SoftAssert SoftAssertion = new SoftAssert();
		
		/*Get username for: Problem user*/
		String UserName = GetUsername(driver,UsernameIndex.ProblemUserIndex);
		
		/*Get password*/
		String Password = GetPassword(driver);
		
		/*Login*/
		Login(driver,UserName,Password);
	
		/*Check user successfully logged in*/
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, UsersConfig.SuccessfulLoginURL);
		
		/*Get Name and Price of 1st item on cart*/
		String ItemText = driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();
		String ItemPrice = driver.findElements(By.cssSelector("div[class='inventory_item_price']")).get(0).getText();
	   
		/*Click on Item*/
		driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
		
		/*Get Name and Price of item from current window*/
		String ItemTextInside = driver.findElement(By.className("inventory_details_name")).getText();
		String ItemPriceInside = driver.findElement(By.cssSelector("div[class='inventory_details_price']")).getText();
		
		/*Check if both are the same*/
		SoftAssertion.assertEquals(ItemTextInside, ItemText);
		SoftAssertion.assertEquals(ItemPriceInside, ItemPrice);
		SoftAssertion.assertAll();
		
		/*Logout*/
		Logout(driver);
		
		/*Close driver*/
		driver.close();
	}

}
