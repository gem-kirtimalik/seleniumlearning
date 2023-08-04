import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkoutbutton {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        addProductToCart(driver, "Sauce Labs Backpack");

        // Click on the "Checkout" button
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();

        // Verify that the user is redirected to the checkout page
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("checkout-step-one")) {
            System.out.println("The 'Checkout' button redirects the user to the checkout page.");
        } else {
            System.out.println("The 'Checkout' button does not redirect the user to the checkout page.");
        }

        
        //driver.close();
    }

    private static void addProductToCart(WebDriver driver, String productName) {
        
        WebElement productElement = driver.findElement(By.xpath("//div[@class='inventory_item' and .//div[contains(text(), '" + productName + "')]]"));
        productElement.click();

        
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        
    }
}

