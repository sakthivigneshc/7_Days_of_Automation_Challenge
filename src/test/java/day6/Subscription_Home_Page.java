package day6;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Subscription_Home_Page {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");

		// Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//      js.executeScript("window.scrollBy(0,100)");

		// Verify the text 'SUBSCRIPTION'
		WebElement subscription = driver.findElement(By.xpath("//div[@class=\"single-widget\"]/h2"));
		String subscriptionText = subscription.getText();
		Assert.assertEquals(subscriptionText, "SUBSCRIPTION");
		
		/*
		 Enter Email id and click arrow button
		 */
		WebElement subscriptionEmailId = driver.findElement(By.id("susbscribe_email"));
		subscriptionEmailId.sendKeys("asdf@gmail.com");
		
		WebElement Button = driver.findElement(By.xpath("//button[@id=\"subscribe\"]"));
		Button.click();

		// verify the success message
		WebElement subscriptionMsg = driver.findElement(By.xpath("//div[@id=\"success-subscribe\"]/div"));
		String subscriptionMsgText = subscriptionMsg.getText();
		Assert.assertEquals(subscriptionMsgText, "You have been successfully subscribed!");
		driver.quit();

	}

}
