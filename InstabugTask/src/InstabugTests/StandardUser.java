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

import InstabugTests.UsersConfig.UsernameIndex;

public class StandardUser extends BaseClass{

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);
		
		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		/*Get username for: standard user*/
		String UserName = GetUsername(driver,UsernameIndex.StandardUserIndex);
		
		/*Get password*/
		String Password = GetPassword(driver);
		
		/*Login*/
		Login(driver,UserName,Password);
		
		/*Get current URL*/
		String ActualURL = driver.getCurrentUrl();
		
		/*Check that login is successful using current URL*/
		Assert.assertEquals(ActualURL, UsersConfig.SuccessfulLoginURL);
			
		/*Logout*/
		Logout(driver);
	
		driver.close();
	}

}
