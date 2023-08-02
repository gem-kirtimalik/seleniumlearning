import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelfIntroduction
{

public static void main(String[] args) {
//System.setProperty("webdriver.chrome.driver","C:\\Users\\kirti.malik\\Desktop\\chromedriver.exe");
System.setProperty("webdriver.chrome.driver","C:\\Users\\kirti.malik\\Desktop\\geckodriver.exe");
//WebDriver driver = new ChromeDriver();
WebDriver driver = new FirefoxDriver();
driver.get("https://www.saucedemo.com/)");
System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());
//driver.close();


		

	}

}
