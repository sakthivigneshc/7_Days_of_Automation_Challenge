package day_7;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ProductQuantityInCart {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://automationexercise.com/");
		
		String productquantityvalue = "4";
		String product ="Blue Top";
		
		// Verify the home page title
		String Home_Page_Title = driver.getTitle();
		Assert.assertEquals(Home_Page_Title, "Automation Exercise");
		
		//First - view product
		WebElement firstViewProduct = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
		firstViewProduct.click();
		
		// verify the URL of the product details page URL
		String productURL = driver.getCurrentUrl();
		Assert.assertEquals(productURL, "https://automationexercise.com/product_details/1");
		
		//Enter the value in the quantity text box
		WebElement quantityTextBox = driver.findElement(By.id("quantity"));
		quantityTextBox.clear();
		quantityTextBox.sendKeys(productquantityvalue);
		
		//Click the Add to cart button
		WebElement addToCartButton = driver.findElement(By.xpath("//div[@class=\"product-information\"]/span/button[@class=\"btn btn-default cart\"]"));
		addToCartButton.click();
		
		//Click the view cart 
		WebElement viewCart = driver.findElement(By.xpath("//div[@class=\"modal-body\"]/p/a"));
		viewCart.click();
		
		//Verify the view cart page URL
		String viewCartPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(viewCartPageUrl, "https://automationexercise.com/view_cart");
		
		//Verify the product Name
		WebElement productName = driver.findElement(By.xpath("//tr[@id=\"product-1\"]/td[@class=\"cart_description\"]/h4"));
		String actualProduct = productName.getText();
		Assert.assertEquals(actualProduct, product);

		// verify the quantity of the product 
		WebElement quantity = driver.findElement(By.xpath("//tr[@id=\"product-1\"]/td[@class=\"cart_quantity\"]/button"));
		String  actualproductQuantity =  quantity.getText();
		Assert.assertEquals(actualproductQuantity, productquantityvalue);
		
		driver.quit();
		
	}
}
