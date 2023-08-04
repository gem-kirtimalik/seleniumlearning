import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifycheckoutprocess {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

      
        WebDriver driver = new ChromeDriver();

     
        driver.get("https://www.saucedemo.com/");

        
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        // Add a product to the cart
        addProductToCart(driver, "Sauce Labs Backpack");

        // Go to the cart page
        driver.findElement(By.className("shopping_cart_link")).click();

        // Click on the "Checkout" button
        driver.findElement(By.id("checkout")).click();

        // Fill out the shipping information
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        // Fill out the payment information
        driver.findElement(By.id("card-number")).sendKeys("4111111111111111");
        driver.findElement(By.id("expiration-date")).sendKeys("1225");
        driver.findElement(By.id("cvv")).sendKeys("123");
        driver.findElement(By.id("continue")).click();

        // Verify that the order summary is displayed
        WebElement orderSummary = driver.findElement(By.className("summary_info"));
        if (orderSummary.isDisplayed()) {
            System.out.println("Order summary is displayed. Shipping and payment information entered successfully.");
        } else {
            System.out.println("Failed to enter valid shipping and payment information.");
        }

        // Close the browser
        driver.quit();
    }

    private static void addProductToCart(WebDriver driver, String productName) {
        
        WebElement productElement = driver.findElement(By.xpath("//div[@class='inventory_item' and .//div[contains(text(), '" + productName + "')]]"));
        productElement.click();

        // Click on the "Add to Cart" button on the product details page
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        // Wait for the cart icon to update (assuming there's a loading delay)
        // You may use explicit or implicit waits here.
    }
}

