import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class productinformationverification {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

  
        driver.get("https://www.saucedemo.com/");

        
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        
        List<WebElement> productElements = driver.findElements(By.className("inventory_item"));

        // Verify that each product has the correct name, price, and description
        for (WebElement productElement : productElements) {
            String productName = productElement.findElement(By.className("inventory_item_name")).getText();
            String productPrice = productElement.findElement(By.className("inventory_item_price")).getText();
            String productDescription = productElement.findElement(By.className("inventory_item_desc")).getText();

           
            switch (productName) {
                case "Sauce Labs Backpack":
                    verifyProductDetails(productName, productPrice, productDescription, "29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
                    break;
                case "Sauce Labs Bike Light":
                    verifyProductDetails(productName, productPrice, productDescription, "9.99", "A red light isn't the desired state in testing but it sure helps when navigating through an apocalypse.");
                    break;
                case "Sauce Labs Bolt T-Shirt":
                    verifyProductDetails(productName, productPrice, productDescription, "15.99", "The Bolt T-Shirt with the classic Sauce Labs logo.");
                    break;
                // Add more cases for other products if needed
                default:
                    System.out.println("Product not recognized: " + productName);
            }
        }

        // Close the browser
        driver.quit();
    }

    private static void verifyProductDetails(String productName, String productPrice, String productDescription, String expectedPrice, String expectedDescription) {
        if (productPrice.equals(expectedPrice) && productDescription.equals(expectedDescription)) {
            System.out.println(productName + " has the correct price and description.");
        } else {
            System.out.println(productName + " has incorrect price or description.");
            System.out.println("Expected Price: " + expectedPrice);
            System.out.println("Actual Price: " + productPrice);
            System.out.println("Expected Description: " + expectedDescription);
            System.out.println("Actual Description: " + productDescription);
        }
    }
}
