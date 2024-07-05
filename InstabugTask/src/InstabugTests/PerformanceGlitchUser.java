package InstabugTests;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import InstabugTests.UsersConfig.UsernameIndex;

public class PerformanceGlitchUser extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);
		
		/*Set Login and Logout Accepted Times*/
		WebDriverWait LoginWait=new WebDriverWait(driver,Duration.ofSeconds(UsersConfig.AcceptedLoginTime));
		WebDriverWait LogoutWait=new WebDriverWait(driver,Duration.ofSeconds(UsersConfig.AcceptedLogoutTime));
		
		/*Get username for: Performance Glitch user*/
		String UserName = GetUsername(driver,UsernameIndex.PerformanceGlitchUserIndex);
		
		/*Get password*/
		String Password = GetPassword(driver);
		
		int NoOfTrials= 5;
		
		for (int i=0;i<NoOfTrials;i++)
		{
			/*Login*/
			Login(driver,UserName,Password);
				
			/*Check Login is successful during accepted time*/
			String CurrentURL = driver.getCurrentUrl();
			LoginWait.until(ExpectedConditions.urlContains(UsersConfig.SuccessfulLoginURL));
			Assert.assertEquals(CurrentURL, UsersConfig.SuccessfulLoginURL);
			
			/*Logout*/
			Logout(driver);

			/*Check Logout is successful during accepted time*/
			CurrentURL = driver.getCurrentUrl();
			LogoutWait.until(ExpectedConditions.urlContains(UsersConfig.WebsiteURL));
			Assert.assertEquals(CurrentURL, UsersConfig.WebsiteURL);
		}
		driver.close();
	}

}
