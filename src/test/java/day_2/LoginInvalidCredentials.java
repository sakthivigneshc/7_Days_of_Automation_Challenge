package day_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginInvalidCredentials {
	public static void main(String[] args)  {
		
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
		
		WebElement Errormsg = driver.findElement(By.xpath("//div[@class=\"login-form\"]/form/p"));
		String  errorMsgText = Errormsg.getText();
		
		// Got the error message for invalid Credentials

		try {
	
		if(Errormsg.isDisplayed()) {
			throw new RuntimeException("Invalid Credentials "+ errorMsgText);
		}
		}
		
		
		finally {
	
		driver.quit();
		}
			
	} }


/*
  											Console Output
  											
    Exception in thread "main" java.lang.RuntimeException: Invalid CredentialsYour email or password is incorrect!
	at day1.LoginInvalidCredentials.main(LoginInvalidCredentials.java:43)
  										
  
 */

