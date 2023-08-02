import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginFailed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kirti.malik\\\\Desktop\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("test_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.className("btn_action")).click();
		String afterloginurl = driver.getCurrentUrl();
		if(afterloginurl.contains("inventory.html")) {
			System.out.println("Login is successful");
		}else {
			System.out.println("Login is failed");
			WebElement errorMessageElement = driver.findElement(By.xpath("//h3[@data-test='error']"));
			String actualErrorMessage = errorMessageElement.getText();
			
			String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
			
			if (expectedErrorMessage.equals(actualErrorMessage)) {
				System.out.println("Actual error message in UI :"+actualErrorMessage);
				System.out.println("Error message validation is successful");
				} else {
				System.out.println("Error message validation has Failed");	
				}
			
		}

	}

}
