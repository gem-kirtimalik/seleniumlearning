import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class orderconfirmation {
    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        
        WebDriver driver = new ChromeDriver();

     
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productElement = driver.findElement(By.className("inventory_item"));
        productElement.findElement(By.className("btn_inventory")).click();

        // Go to the cart page
        driver.findElement(By.className("shopping_cart_link")).click();

        // Click the "Checkout" button
        driver.findElement(By.id("checkout")).click();

        // Enter valid shipping information
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        // Enter valid payment information
        driver.findElement(By.id("card-number")).sendKeys("4111111111111111");
        driver.findElement(By.id("expiration-date")).sendKeys("1225");
        driver.findElement(By.id("cvv")).sendKeys("123");
        driver.findElement(By.id("finish")).click(); //finish button not working

        // Verify that the user receives an order confirmation
        WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(text(), 'THANK YOU FOR YOUR ORDER')]"));
        if (confirmationMessage.isDisplayed()) {
            System.out.println("User receives an order confirmation after successful checkout.");
        } else {
            System.out.println("Failed to display the order confirmation message.");
        }

        // Close the browser
        driver.quit();
    }
}
