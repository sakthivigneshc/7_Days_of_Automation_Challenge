package day_5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Search_Product {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");

		// Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");

		WebElement productsLink = driver.findElement(By.xpath("//header[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
		productsLink.click();
		
		//verify navigated to All products page
		String allProductsPage = driver.getTitle();
		Assert.assertEquals(allProductsPage, "Automation Exercise - All Products");

		//Enter the product name
		WebElement searchBox = driver.findElement(By.id("search_product"));
		searchBox.sendKeys("shirt");
		
		//Click the search logo
		WebElement searchLogo = driver.findElement(By.id("submit_search"));
		searchLogo.click();
		
		// Verify 'SEARCHED PRODUCTS' is visible
		WebElement searchedList = driver.findElement(By.cssSelector(".features_items"));
		if(	searchedList.isDisplayed()) {
			System.out.println("Products lists are visible");
		}
		else {
			System.out.println("Products lists are not visible");	
		}
		
		
		// Verify all the products related to search are visible (Here I used shirt product )
		
		  List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"productinfo text-center\"]/p"));
		  int products = elements.size();
	      int count = 0;
	 
	        for (WebElement element : elements) {
	            String text = element.getText().toLowerCase(); // Convert to lower case
	            // verify if the text contains "shirt" or "top" 
	            if (text.contains("shirt") || text.contains("top")) {
	                count++; 
	            }
	        }
	        
	        System.out.println("Total count is : " + count);
		
	        if(products == count) {
	        	System.out.println("All products are related to the search.");
	        }
	        else {
	        	System.out.println("Some mismatch");
	        }

	        driver.quit();
		
	}

}
