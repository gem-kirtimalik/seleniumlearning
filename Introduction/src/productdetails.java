import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class productdetails {
    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://www.saucedemo.com/");

       
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        //WebElement productsContainer = driver.findElement(By.className("inventory_list"));
        //List<WebElement> productElements = productsContainer.findElements(By.className("inventory_item"));

        WebElement productElement = driver.findElement(By.className("inventory_item"));
        String productName = productElement.findElement(By.className("inventory_item_name")).getText();
        productElement.click();
        String currenturl = driver.getCurrentUrl();
        System.out.println(currenturl);
        System.out.println(productName);

        // Verify that the user is redirected to the product details page
        String productDetailsPageTitle = productName + " - Swag Labs";
        if (driver.getTitle().equals(productDetailsPageTitle)) {
            System.out.println("User is on the product details page for " + productName);
        } else {
            System.out.println("User is not on the product details page for " + productName);
        }

        // Close the browser
        //not working
        driver.quit();
    }
}
