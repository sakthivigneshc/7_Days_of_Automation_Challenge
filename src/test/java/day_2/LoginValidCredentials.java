package day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginValidCredentials {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		//Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");
		System.out.println("Home page title is there as expected.");

		
		WebElement SignUp_Login_Button = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]/li[4]"));
		SignUp_Login_Button.click();
		
		WebElement Login_text_heading = driver.findElement(By.xpath("//div[@class=\"login-form\"]/h2"));
		Login_text_heading.isDisplayed();
		String Login_Page_Title  = Login_text_heading.getText();
		Assert.assertEquals(Login_Page_Title, "Login to your account");
		System.out.println("Login page title is there as expected.");
		
		WebElement emailField = driver.findElement(By.name("email"));
		emailField.sendKeys("Sakthi01@gmail.com");
		
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("98Iam@pwd");
		
		WebElement LoginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		LoginButton.click();
		System.out.println("Login into the account with valid emailId and password as expected.");

		WebElement Login_UserName = driver.findElement(By.cssSelector("ul[class='nav navbar-nav'] li a b"));
		String Login_UserName_Text = Login_UserName.getText();
		Assert.assertEquals(Login_UserName_Text, "Sakthi");
		System.out.println("username is there as expected.");

		
		//Click DeleteButton
		WebElement DeleteButton = driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
		DeleteButton.click();
		
		//Account Deletion Page
		String Deletion_Page_Title = driver.getTitle();
		Assert.assertEquals(Deletion_Page_Title, "Automation Exercise - Account Created");
		
		//Back to Login page
		driver.navigate().back();
		
		driver.quit();
	} }
