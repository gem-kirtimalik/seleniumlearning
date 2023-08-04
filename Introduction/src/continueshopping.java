import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class continueshopping {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");  
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement productElement = driver.findElement(By.xpath("//div[@class='inventory_item'][1]"));
        productElement.click();

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        String cartPageUrl = "https://www.saucedemo.com/cart.html";
        if (driver.getCurrentUrl().equals(cartPageUrl)) {
            System.out.println("User is on the cart page.");
        } else {
            System.out.println("User is not on the cart page.");
        }

        driver.findElement(By.id("continue-shopping")).click();

        String homepageUrl = "https://www.saucedemo.com/inventory.html";
        if (driver.getCurrentUrl().equals(homepageUrl)) {
            System.out.println("User is back on the homepage. Continue shopping is working.");
        } else {
            System.out.println("User is not back on the homepage. Continue shopping is not working.");
        }

        driver.quit();
    }
}
