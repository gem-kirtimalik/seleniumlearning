import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class removefromcart {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

       
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

 
        WebElement productElement = driver.findElement(By.className("inventory_item"));
        String productName = productElement.findElement(By.className("inventory_item_name")).getText();
        productElement.findElement(By.className("btn_inventory")).click();

        // Go to the cart page
        driver.findElement(By.className("shopping_cart_link")).click();

        // Click the "Remove" button for the added product
        driver.findElement(By.className("cart_item_label")).findElement(By.className("btn_secondary")).click();

        // Verify that the product is removed from the cart
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        int cartItemCount = Integer.parseInt(cartBadge.getText());

        if (cartItemCount == 0) {
            System.out.println(productName + " has been successfully removed from the cart.");
        } else {
            System.out.println("Failed to remove " + productName + " from the cart.");
        }

        // Close the browser
        driver.quit();
    }
}
