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

public class ErrorUser extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);
		
		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		SoftAssert SoftAssertion = new SoftAssert();
		
		/*Get username for: Error user*/
		String UserName = GetUsername(driver,UsernameIndex.ErrorUserIndex);
		
		/*Get password*/
		String Password = GetPassword(driver);
		
		/*Login*/
		Login(driver,UserName,Password);
			
		/*Check user successfully logged in*/
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, UsersConfig.SuccessfulLoginURL);
		
		/*Click on all "Add to Cart" buttons*/
		List<WebElement> AddToCartButtons = driver.findElements(By.cssSelector("div#inventory_container button"));
		String buttonTextString="";
		for(int i=0;i<AddToCartButtons.size();i++)
		{
			WebElement CurrentButton= AddToCartButtons.get(i);
			CurrentButton.click();
		}
		
		//Update List since buttons changed
		AddToCartButtons = driver.findElements(By.cssSelector("div#inventory_container button"));
		
		/*Check if all buttons text changed to "Remove" instead of "Add to Cart"*/
		for(int i=0;i<AddToCartButtons.size();i++)
		{
			WebElement CurrentButton= AddToCartButtons.get(i);
			buttonTextString = CurrentButton.getText();
			System.out.println(buttonTextString);
			SoftAssertion.assertEquals(buttonTextString, "Remove");
		}
		SoftAssertion.assertAll();
		
		/*Logout*/
		Logout(driver);
		
		/*Close driver*/
		driver.close();
	}

}
