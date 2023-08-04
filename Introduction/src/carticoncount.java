import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class carticoncount {
    public static void main(String[] args) {
        
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        // Add some products to the cart
        addProductToCart(driver, "Sauce Labs Backpack");
        addProductToCart(driver, "Sauce Labs Bike Light");
        

        // Verify that the cart icon displays the correct number of items added to the cart
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        int cartItemCount = Integer.parseInt(cartBadge.getText());

        
        int expectedCartItemCount = 2;

        if (cartItemCount == expectedCartItemCount) {
            System.out.println("The cart icon displays the correct number of items: " + expectedCartItemCount);
        } else {
            System.out.println("The cart icon displays the incorrect number of items.");
            System.out.println("Expected: " + expectedCartItemCount);
            System.out.println("Actual: " + cartItemCount);
        }

        // Close the browser
        driver.quit();
    }

    private static void addProductToCart(WebDriver driver, String productName) {
        WebElement productElement = driver.findElement(By.xpath("//div[@class='inventory_item' and .//div[contains(text(), '" + productName + "')]]"));
        productElement.click();

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();

        
    }
}

