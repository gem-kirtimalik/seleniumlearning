import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class responsivedesign {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

    
        driver.get("https://www.saucedemo.com/");

        

        // Desktop
        verifyResponsiveDesign(driver, "Desktop", 1200, 800);

        // Tablet
        verifyResponsiveDesign(driver, "Tablet", 768, 1024);

        // Mobile
        verifyResponsiveDesign(driver, "Mobile", 360, 640);

        // Close the browser
        driver.quit();
    }

    private static void verifyResponsiveDesign(WebDriver driver, String deviceName, int width, int height) {
        // Resize the browser window to simulate the device size
        driver.manage().window().setSize(new Dimension(width, height));

        // Perform interactions or checks specific to the device

        // Example: Check if a specific element is present
        try {
            WebElement Element = driver.findElement(By.id("your-element-id"));
            System.out.println("Element is present on " + deviceName);
        } catch (Exception e) {
            System.out.println("Element is not present on " + deviceName);
        }
    }
}
