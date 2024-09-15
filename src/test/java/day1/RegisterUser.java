package day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterUser {	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		String HomePageTitle = driver.getTitle();

		Assert.assertEquals(HomePageTitle, "Automation Exercise");
		
		WebElement SignUpbutton = driver.findElement(By.xpath("//header[@id='header']//li[4]"));
		SignUpbutton.click();
		
		WebElement VerifySignUptext = driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']"));
	    String	actualVerifySignUptext= VerifySignUptext.getText();
		
		Assert.assertEquals(actualVerifySignUptext, "New User Signup!");
		
		WebElement UserName = driver.findElement(By.name("name"));
		UserName.sendKeys("Sakthi");
		
		WebElement UserEmail = driver.findElement(By.xpath("//div[@class='signup-form']/form/input[@name='email']"));
		UserEmail.sendKeys("Sakthi01@gmail.com");
		
		WebElement SignupButton = driver.findElement(By.xpath("//div[@class=\"signup-form\"]/form/button"));
		SignupButton.click();

		WebElement TitleRadioBtn = driver.findElement(By.id("id_gender1"));
		TitleRadioBtn.click();
		
		WebElement PwdTextBox = driver.findElement(By.id("password"));
		PwdTextBox.sendKeys("98Iam@pwd");
		
		Select selectValue = new Select(driver.findElement(By.id("days")));
		selectValue.selectByVisibleText("12");
				
		Select selectValue1 = new Select(driver.findElement(By.id("months")));
		selectValue1.selectByVisibleText("May");
		
		Select selectValue2 = new Select(driver.findElement(By.id("years")));
		selectValue2.selectByVisibleText("2010");
		
		WebElement newsLetterCheckBox = driver.findElement(By.id("newsletter"));
		newsLetterCheckBox.click();
		
		WebElement offersCheckBox = driver.findElement(By.id("optin"));
		offersCheckBox.click();
		
		WebElement firstName = driver.findElement(By.xpath("//p[@class=\"required form-group\"]/input[@id=\"first_name\"]"));
		firstName.sendKeys("Name");
		
		WebElement lastName = driver.findElement(By.xpath("//p[@class=\"required form-group\"]/input[@id=\"last_name\"]"));
		lastName.sendKeys("last_name");
		
		WebElement companyName = driver.findElement(By.xpath("//p[@class=\"form-group\"]/input[@id=\"company\"]"));
		companyName.sendKeys("CTS");
		
		WebElement Address1 = driver.findElement(By.xpath("//p[@class=\"required form-group\"]/input[@id=\"address1\"]"));
		Address1.sendKeys("3/32");
		
		WebElement Address2 = driver.findElement(By.xpath("//p[@class=\"required form-group\"]/input[@id=\"address2\"]"));
		Address2.sendKeys("Sakthi Street");
		
		Select countryDropdown = new Select( driver.findElement(By.id("country")) );
		countryDropdown.selectByVisibleText("India");
		
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("TamilNadu");
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Salem");
		
		WebElement zipCode = driver.findElement(By.id("zipcode"));
		zipCode.sendKeys("656780");
		
		WebElement mobileNumber = driver.findElement(By.id("mobile_number"));
		mobileNumber.sendKeys("9168767298");
		
		WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
		submitButton.click();
		
		WebElement AccountConfirmMsg = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]/b"));
		String titleHead = AccountConfirmMsg.getText();
		Assert.assertEquals(titleHead, "ACCOUNT CREATED!");
		System.out.println("Account created successfully.");

		WebElement ConfirmButton = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
		ConfirmButton.click();
		
		WebElement UserNameverify = driver.findElement(By.cssSelector("ul[class='nav navbar-nav'] li a b"));
		String UserNameverifytext = UserNameverify.getText();
		
		Assert.assertTrue(UserNameverify.isDisplayed(), "Username should be visible");
		Assert.assertEquals(UserNameverifytext, "Sakthi");
		System.out.println("Username is there as expected.");
		
		WebElement Deletelink =  driver.findElement(By.xpath("//a[normalize-space()='Delete Account']"));
		Deletelink.click();
		
		WebElement DeletionVerify = driver.findElement(By.xpath("//h2[@class='title text-center']/b"));
		DeletionVerify.isDisplayed();
		String Deletionverifytext = DeletionVerify.getText();
		Assert.assertEquals(Deletionverifytext, "ACCOUNT DELETED!");
		System.out.println("Account deleted successfully.");
	
		WebElement continueButton2 = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
		continueButton2.click();

		Assert.assertEquals(HomePageTitle, "Automation Exercise");
		System.out.println("Back to Home page.");
		driver.quit();	
	}
}
