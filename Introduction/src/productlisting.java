import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class productlisting {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Find the product elements on the page
        WebElement productsContainer = driver.findElement(By.className("inventory_list"));
        List<WebElement> productElements = productsContainer.findElements(By.className("inventory_item"));

        // Define the expected product names that should be displayed
        List<String> expectedProductNames = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");

        // Verify that the expected products are present on the page
        for (String expectedProductName : expectedProductNames) {
            boolean found = false;
            for (WebElement productElement : productElements) {
                String productName = productElement.findElement(By.className("inventory_item_name")).getText();
                if (productName.equals(expectedProductName)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println(expectedProductName + " is displayed.");
            } else {
                System.out.println(expectedProductName + " is NOT displayed.");
            }
        }

       driver.quit();
    }
}
