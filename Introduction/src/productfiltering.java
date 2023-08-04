import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class productfiltering {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Find the filter dropdown and select the desired category (e.g., "Sauce Labs Backpack")
        Select filterDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        filterDropdown.selectByVisibleText("Name (Z to A)");
        // Get the product elements after filtering
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));

        // Verify that the products displayed match the selected category
        boolean categoryFound = false;
        String desiredCategory = "Sauce Labs Backpack"; 
        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            if (productName.equals(desiredCategory)) {
                categoryFound = true;
                break;
            }
        }

        if (categoryFound) {
            System.out.println("Products filtered by category: " + desiredCategory);
        } else {
            System.out.println("Products not filtered by category: " + desiredCategory);
        }

        
        //driver.quit();
    }
}

