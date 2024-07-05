package InstabugTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	/* 
	 * Method to Get Valid Username from website login page
	 * @param
	 * index: index of user
	 * */
	public static String GetUsername(WebDriver driver, UsersConfig.UsernameIndex index)
	{
		String AcceptedUserNames= driver.findElement(By.xpath("//div[@id='login_credentials']")).getText();
		
		String[] SplittedAcceptedUserNames = AcceptedUserNames.split(":")[1].trim().split("\n");

		String UserName = SplittedAcceptedUserNames[index.getNumVal()];
		
		return UserName;
	}
	/* 
	 * Method to Get Valid Password from website login page
	 * */
	public static String GetPassword(WebDriver driver)
	{
		String Password = driver.findElements(By.xpath("//div[@class='login_password']")).get(0).getText().split(":")[1].trim();
		
		return Password;
	}
	/* 
	 * Method to Login to website
	 * @param
	 * Username: username used to login
	 * Password: password used to login
	 * */
	public static void Login(WebDriver driver, String Username, String Password)
	{
		driver.findElement(By.id("user-name")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		
		driver.findElement(By.id("login-button")).click();
	}
	/* 
	 * Method to Logout from website
	 * */
	public static void Logout(WebDriver driver)
	{
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
