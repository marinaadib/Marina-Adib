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

public class LockedUser extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);

		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		/*Get username for: locked user*/
		String UserName = GetUsername(driver,UsernameIndex.LockedUserIndex);
		
		/*Get password*/
		String Password = GetPassword(driver);
		
		/*Login*/
		Login(driver,UserName,Password);
		
		/*Check account is locked, and an error message appeared*/
		String ErrorMessage="locked";
		String ActualMessage = driver.findElement(By.cssSelector("div[class='error-message-container error']")).getText();
		
		ActualMessage.contains(ErrorMessage);
		
		/*Check URL didn't change*/
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, UsersConfig.WebsiteURL);
		
		driver.close();
	}

}
