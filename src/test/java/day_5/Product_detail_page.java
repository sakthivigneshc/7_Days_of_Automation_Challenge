package day_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Product_detail_page {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");

		// Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");
	
		//Click the products link
		WebElement productsLink = driver.findElement(By.xpath("//header[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a"));
		productsLink.click();
		
		//verify the text in the all products page
		WebElement allproductsText = driver.findElement(By.xpath("//div[@class=\"features_items\"]/h2"));
		String allproducts = allproductsText.getText();
		Assert.assertEquals(allproducts, "ALL PRODUCTS");
		
		//verify the Products Page title
		String allProductsPage = driver.getTitle();
		Assert.assertEquals(allProductsPage, "Automation Exercise - All Products");
		
		WebElement productsList =  driver.findElement(By.xpath("//div[@class=\"col-sm-9 padding-right\"]"));
		
		if(productsList.isDisplayed())
		{
			System.out.println("Products lists are there as expected.");
		}
		else 
		{
			System.out.println("Products lists are not there.");
		}
		
		// Actions on firstProduct
		WebElement firstProduct = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
		firstProduct.click();

		// verify the products page title
		String productPageTitle = driver.getTitle();
		Assert.assertEquals(productPageTitle, "Automation Exercise - Product Details");
		
		// Verify the product name, category , availability, condition, brand
		WebElement nameOfTheProduct = driver.findElement(By.xpath("//div[@class=\"product-information\"]/H2"));
		String firstProductName =  nameOfTheProduct.getText();		
//		System.out.println("First product is : "+firstProductName);	
		Assert.assertEquals(firstProductName, "Blue Top");
		
	    WebElement category = driver.findElement(By.xpath("//div[@class=\"product-information\"]/p[1]"));
		String	categoryText = 	category.getText();
		String actualCategoryText = categoryText.replaceAll("Category:", "").replaceAll(">", "").trim();
//		System.out.println("The category of the product is : "+actualCategoryText);
		Assert.assertEquals(actualCategoryText, "Women  Tops");

		WebElement availability = driver.findElement(By.xpath("//div[@class='product-details']//p[2]"));
		String availabilityText = availability.getText();
		String availActualText = availabilityText.replaceAll("Availability:", "").trim();
//		System.out.println("Availability of the product is : "+availActualText);
		Assert.assertEquals(availActualText, "In Stock");

		WebElement condition = driver.findElement(By.xpath("//div[@class='product-details']//p[3]"));
		String conditionText = condition.getText().replaceAll("Condition:", "").trim();
//		System.out.println("Condition of this product is : "+ conditionText);
		Assert.assertEquals(conditionText, "New");

		WebElement brand = driver.findElement(By.xpath("//div[@class='product-details']//p[4]"));
		String brandText = brand.getText().replaceAll("Brand:", "").trim();
//		System.out.println("Brand Name is: "+"Polo");
		Assert.assertEquals(brandText,"Polo");

		driver.quit();
				
	}
}
