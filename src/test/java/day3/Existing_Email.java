package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Existing_Email {

		public static void main(String[] args) {
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://automationexercise.com/");
			driver.manage().window().maximize();
			
			//Verify the home page title
			String Home_Page_Title = driver.getTitle();
			Assert.assertEquals(Home_Page_Title, "Automation Exercise");
			
			WebElement SignUp_Login_Button = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]/li[4]"));
			SignUp_Login_Button.click();
			
			// verify the sign up heading 
			WebElement Signup_text_heading = driver.findElement(By.xpath("//div[@class=\"signup-form\"]/h2"));
			Signup_text_heading.isDisplayed();
			String Signup_Page_Title  = Signup_text_heading.getText();
			Assert.assertEquals(Signup_Page_Title, "New User Signup!");
			
			WebElement nameField = driver.findElement(By.name("name"));
			nameField.sendKeys("Sakthi");
			
			WebElement emailField = driver.findElement(By.xpath("//div[@class=\"signup-form\"]/form/input[@name=\"email\"]"));
			emailField.sendKeys("Sakthi01@gmail.com");
			
			WebElement signUpButton = driver.findElement(By.xpath("//div[@class=\"signup-form\"]/form/button[@class=\"btn btn-default\"]"));
			signUpButton.click();
			
			WebElement existsEmail = driver.findElement(By.xpath("//div[@class=\"signup-form\"]/form/p"));
			existsEmail.isDisplayed();
			String existsText =	existsEmail.getText() ;
//			System.out.println(existsText);
			Assert.assertEquals(existsText, "Email Address already exist!");
			
			driver.quit();
			
		}
	
	
}
