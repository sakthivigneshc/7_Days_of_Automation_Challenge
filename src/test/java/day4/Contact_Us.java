package day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Contact_Us {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		
		String path = System.getProperty("user.dir");
		
		//Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");
		
		WebElement contact_Us = driver.findElement(By.xpath("//a[normalize-space()='Contact us']"));
		contact_Us.click();
		
		WebElement  contactUsPage_text = driver.findElement(By.xpath("//div[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
		String  contactUsPage_text_verification = contactUsPage_text.getText();
		Assert.assertEquals(contactUsPage_text_verification, "GET IN TOUCH");
		
		/*
		   Perform Contact us validation 
		   -Enter Name
		   -Enter Email id
		   -Enter Subject 
		   -Enter Message
		   
		 */
		WebElement Name = driver.findElement(By.xpath("//form[@id=\"contact-us-form\"]/div[1]/input"));
		Name.sendKeys("Rohit");
		
		WebElement emailId = driver.findElement(By.xpath("//form[@id=\"contact-us-form\"]/div[2]/input"));
		emailId.sendKeys("asdf@gmail.com");
		
		WebElement subject = driver.findElement(By.xpath("//form[@id=\"contact-us-form\"]/div[3]/input"));
		subject.sendKeys("Subject!!");
		
		WebElement msg = driver.findElement(By.xpath("//textarea[@id=\"message\"]"));
		msg.sendKeys("If you have any suggestion areas or improvements, do let us know. We will definitely work on it.");
		
		WebElement file =  driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
		file.sendKeys(path+".\\files\\SampleDocument.txt");
		
	    WebElement submitButton = driver.findElement(By.name("submit"));
		submitButton.click();
		
		// Handling the Alert
        Alert alert = driver.switchTo().alert();		
        alert.accept();		
        
        //Confirmation message verification
        WebElement textVerification = driver.findElement(By.xpath("//div[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
        String submitTextVerification = textVerification.getText();
      	Assert.assertEquals(submitTextVerification, "Success! Your details have been submitted successfully.");
        
      	//Home page link
        WebElement homePageLink = driver.findElement(By.xpath("//div[@id=\"form-section\"]/a"));
        homePageLink.click();
        
        //Verify whether in the home page 
      	Assert.assertEquals(Home_Page_Title, "Automation Exercise");
      	
      	//Verify the home page heading 
        WebElement HeadingTitle = driver.findElement(By.xpath("//div[@id=\"slider-carousel\"]/div/div[2]/div[1]/h1"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(HeadingTitle));
        String homePageHeadingText = HeadingTitle.getText();
//      System.out.println("Text is : "+ HeadingTitle.getText());
        Assert.assertEquals(homePageHeadingText, "AutomationExercise");
       
        driver.quit();
        
	}

}
