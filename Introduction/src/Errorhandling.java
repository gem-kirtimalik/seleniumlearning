import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

public class Errorhandling {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.saucedemo.com/");

        try {
            // Intentionally trigger a server-side error (click a non-existent element)
            driver.findElement(By.id("nonexistent-element")).click();
        } catch (NoSuchElementException e) {
            // Verify that the appropriate error message is displayed
            String errorMessage = e.getMessage();
            if (errorMessage.contains("no such element")) {
                System.out.println("Appropriate error message is displayed for server-side error.");
            } else {
                System.out.println("Failed to display the appropriate error message for server-side error.");
            }
        }

        // Close the browser
        driver.quit();
    }
}
