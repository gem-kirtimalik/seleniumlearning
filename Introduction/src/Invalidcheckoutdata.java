import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invalidcheckoutdata {
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

        // Enter invalid shipping information
        driver.findElement(By.id("first-name")).sendKeys("Kirti");
        driver.findElement(By.id("last-name")).sendKeys("Malik");
        driver.findElement(By.id("postal-code")).sendKeys("");
        driver.findElement(By.id("continue")).click();

        // Verify that the appropriate error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//h3[contains(text(), 'Error:')]"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Appropriate error message is displayed for invalid checkout information.");
        } else {
            System.out.println("Failed to display the appropriate error message for invalid checkout information.");
        }

        // Close the browser
        //driver.quit();
    }
}
