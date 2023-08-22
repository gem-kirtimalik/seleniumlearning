import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortingandfiltering {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    
        Select filterDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        filterDropdown.selectByVisibleText("Name (Z to A)");

      
        List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
        List<String> productNames = new ArrayList<>();

        for (WebElement productElement : productElements) {
            String productName = productElement.getText();
            productNames.add(productName);
        }

        List<String> originalNames = new ArrayList<>(productNames);
        Collections.sort(productNames, Collections.reverseOrder());

        // Verify that the products displayed match the selected category and are sorted (Name Z to A)
        if (productNames.equals(originalNames)) {
            System.out.println("Products are filtered by category and sorted (Name Z to A).");
        } else {
            System.out.println("Products are not filtered by category and sorted (Name Z to A).");
        }

        // Close the browser
        driver.quit();
    }
}
