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
import org.testng.annotations.Test;

import InstabugTests.UsersConfig.UsernameIndex;

public class InvalidLogins extends BaseClass{
		
	public static void main(String[] args) throws InterruptedException {
		
	}
	@Test
	public void InvalidUsernameValidPassword()
	{
		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);

		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		/*Set Username to invalid value*/
		String UserName = "random_user";
		
		/*Set Password to valid value*/
		String Password = GetPassword(driver);

		/*Login*/
		Login(driver,UserName,Password);
		
		/*Print Error Message*/
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		/*Check URL didn't change*/
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, UsersConfig.WebsiteURL);
		
		/*Close Driver*/
		driver.close();
	}
	@Test
	public void ValidUsernameInvalidPassword()
	{
		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);

		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		/*Set Username to valid value*/
		String UserName = GetUsername(driver,UsernameIndex.StandardUserIndex);
		
		/*Set Password to invalid value*/
		String Password = GetPassword(driver);
		Password = Password.concat("_invalid");
		
		/*Login*/
		Login(driver,UserName,Password);
		
		/*Print Error Message*/
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		/*Check URL didn't change*/
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, UsersConfig.WebsiteURL);
		
		/*Close Driver*/
		driver.close();
	}
	@Test
	public void EmptyUsernameValidPassword()
	{
		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);

		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			
		/*Set Username to Empty String*/
		String UserName = "";
		
		/*Set Password to valid value*/
		String Password = GetPassword(driver);
		
		/*Login*/
		Login(driver,UserName,Password);
		
		/*Print Error Message*/
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		/*Check URL didn't change*/
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, UsersConfig.WebsiteURL);
		
		/*Close Driver*/
		driver.close();
	}
	
	@Test
	public void ValidUsernameEmptyPassword()
	{
		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);

		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
		/*Set Username to valid value*/
		String UserName = GetUsername(driver,UsernameIndex.StandardUserIndex);
	
		/*Set Password to Empty String*/
		String Password = "";
		
		/*Login*/
		Login(driver,UserName,Password);
		
		/*Print Error Message*/
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		/*Check URL didn't change*/
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, UsersConfig.WebsiteURL);
		
		/*Close Driver*/
		driver.close();
	}
	
	@Test
	public void PasswordEqualsValidUsername()
	{
		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);

		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		/*Set Username to valid value*/
		String UserName = GetUsername(driver,UsernameIndex.StandardUserIndex);
		
		/*Set Password to Username*/
		String Password = UserName;
		
		/*Login*/
		Login(driver,UserName,Password);
		
		/*Print Error Message*/
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		/*Check URL didn't change*/
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, UsersConfig.WebsiteURL);
		
		/*Close Driver*/
		driver.close();
}
	@Test
	public void UsernameEqualsValidPassword()
	{
		WebDriver driver = new ChromeDriver();
		
		/*Go to website*/
		driver.get(UsersConfig.WebsiteURL);

		/*Set implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		/*Set Password to valid value*/
		String Password = GetPassword(driver);
		
		/*Set Username to Password*/
		String UserName = Password;

		/*Login*/
		Login(driver,UserName,Password);
		
		/*Print Error Message*/
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		/*Check URL didn't change*/
		String ActualURL = driver.getCurrentUrl();
		
		Assert.assertEquals(ActualURL, UsersConfig.WebsiteURL);
		
		/*Close Driver*/
		driver.close();
	}
	
}
