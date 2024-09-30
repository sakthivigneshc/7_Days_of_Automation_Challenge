package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LogoutUser {

	public static void main(String[] args) {
		
		String expectedLogInText =  "Logged in as Sakthi";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		//Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");
		
		// Click the SignUp/Login Button
		WebElement SignUp_Login_Button = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]/li[4]"));
		SignUp_Login_Button.click();
		
		WebElement Login_text_heading = driver.findElement(By.xpath("//div[@class=\"login-form\"]/h2"));
		Login_text_heading.isDisplayed();
		String Login_Page_Title  = Login_text_heading.getText();
		Assert.assertEquals(Login_Page_Title, "Login to your account");
		
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys("Sakthi01@gmail.com");
		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("98Iam@pwd");
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		LoginButton.click();
		
		// verify the Logged in user text
		WebElement Logged_in = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]/li[10]"));
		Assert.assertTrue(Logged_in.isDisplayed());
		String Logged_in_Text =	Logged_in.getText();
		Assert.assertEquals(Logged_in_Text, expectedLogInText);
		
		// Logout the user
		WebElement logoutButton = driver.findElement(By.xpath("//div[@class=\"shop-menu pull-right\"]/ul/li[4]"));
		logoutButton.click();
		
		//Verify that user is navigated to login page
		String signUp_logIn_title =  driver.getTitle();
		Assert.assertEquals(signUp_logIn_title, "Automation Exercise - Signup / Login");
				
		driver.quit();
		

	}
	
}
