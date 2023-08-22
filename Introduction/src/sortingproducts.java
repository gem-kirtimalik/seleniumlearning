import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortingproducts {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

       
        driver.get("https://www.saucedemo.com/");

        // Log in (You may need to replace these with actual credentials)
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
        sortDropdown.selectByVisibleText("Price (low to high)");

        List<WebElement> productPriceElements = driver.findElements(By.className("inventory_item_price"));
        List<Double> sortedPrices = new ArrayList<>();

        for (WebElement priceElement : productPriceElements) {
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            sortedPrices.add(price);
        }

        List<Double> originalPrices = new ArrayList<>(sortedPrices);
        Collections.sort(sortedPrices);

        // Verify that the products displayed are sorted by price (low to high)
        if (sortedPrices.equals(originalPrices)) {
            System.out.println("Products are sorted by price (low to high).");
        } else {
            System.out.println("Products are not sorted by price (low to high).");
        }

        // Close the browser
        //driver.quit();
    }
}
