import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class logoutredirect {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.className("bm-burger-button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        //driver.findElement(By.id("logout_sidebar_link")).click();

     // Verify that the user is logged out and redirected to the login page
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("https://www.saucedemo.com/") && driver.findElements(By.id("user-name")).size() > 0) {
            System.out.println("Logout successful. User is redirected to the login page.");
        } else {
            System.out.println("Logout failed.");
        }
        //driver.quit();
    }                                                                                                                                                                                                                                           
}
