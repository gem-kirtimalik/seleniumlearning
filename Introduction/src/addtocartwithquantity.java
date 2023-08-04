import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addtocartwithquantity {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement productElement = driver.findElement(By.xpath("//div[@class='inventory_item'][1]"));
        String productName = productElement.findElement(By.className("inventory_item_name")).getText();
        productElement.click();

        // Enter the desired quantity of the product
        WebElement quantityInput = driver.findElement(By.className("input_quantity"));
        quantityInput.clear();
        quantityInput.sendKeys("2");

        // Click on the "Add to Cart" button
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        // Verify that the correct product and quantity are added to the cart
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        int cartItemCount = Integer.parseInt(cartBadge.getText());

        if (cartItemCount == 2) { // Change this value to the desired quantity
            System.out.println(productName + " (Quantity: " + cartItemCount + ") has been added to the cart.");
        } else {
            System.out.println("Failed to add the correct product and quantity to the cart.");
        }

        // Close the browser
        driver.quit();
    }
}
