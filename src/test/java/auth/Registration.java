package auth;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {

	public static String browser = "Chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
		} else if(browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		String url = "https://magento.softwaretestingboard.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a")).click();
		
		//personal info
		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.sendKeys("name1");
		WebElement lastname = driver.findElement(By.id("lastname"));
		lastname.sendKeys("name2");
		driver.findElement(By.id("is_subscribed")).click();
		
		//sign-in info
		WebElement email = driver.findElement(By.id("email_address"));
		email.sendKeys("k@gmail.com");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Zx123456c");
		WebElement passconfirm = driver.findElement(By.name("password_confirmation"));
		passconfirm.sendKeys("Zx123456c");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();

	}
}
