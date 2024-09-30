package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Test_Cases_Page {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		
		String expectedText  = "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:";
		String title = "Automation Practice Website for UI Testing - Test Cases";
		
		// Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");

		//Click the Test cases button
		WebElement testCasesButton = driver.findElement(By.xpath("//div[@id=\"slider-carousel\"]/div/div[1]/div[1]/a[1]/button"));
		testCasesButton.click();

		String testCasesTitle = driver.getTitle();
		Assert.assertEquals(testCasesTitle, title );
		
		//Verify the text in the TestCases page
		WebElement testCaseText = driver.findElement(By.xpath("//div[@class=\"panel-group\"]/h5"));
		String testCaseValidationText = testCaseText.getText();
		Assert.assertEquals(testCaseValidationText, expectedText);

		driver.quit();
		
	}

}
