import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addtocart {
    public static void main(String[] args) {
        
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Log in (You may need to replace these with actual credentials)
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement productElement = driver.findElement(By.xpath("//div[@class='inventory_item'][1]"));
        String productName = productElement.findElement(By.className("inventory_item_name")).getText();
        productElement.click();

        // Click on the "Add to Cart" button on the product details page
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        // Verify that the product has been added to the cart
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        int cartItemCount = Integer.parseInt(cartBadge.getText());

        if (cartItemCount == 1) {
            System.out.println(productName + " has been added to the cart.");
        } else {
            System.out.println(productName + " was NOT added to the cart.");
        }

        // Close the browser
        driver.quit();
    }
}

