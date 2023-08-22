import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forgotpwdlink {
    public static void main(String[] args) {
        
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");

        
        WebDriver driver = new ChromeDriver();

      
        driver.get("https://www.saucedemo.com/");

        // Click on the "Forgot Password" link
        driver.findElement(By.linkText("Forgot Password?")).click();

        // Verify that the user is redirected to the password recovery page
        String recoveryPageUrl = "https://www.saucedemo.com/reset-password.html";
        if (driver.getCurrentUrl().equals(recoveryPageUrl)) {
            System.out.println("The 'Forgot Password' link redirects the user to the password recovery page.");
        } else {
            System.out.println("The 'Forgot Password' link does not redirect the user to the password recovery page.");
        }

       
        driver.quit();
    }
}
