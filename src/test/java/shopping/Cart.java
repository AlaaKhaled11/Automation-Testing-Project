package shopping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cart {
	
	public static String browser = "Chrome";
	public static WebDriver driver;
	
	public static void main(String[] args) {
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
		
		//Add to cart
		WebElement element = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/div/div[1]"));
		Actions mouseover = new Actions(driver);
		mouseover.moveToElement(element).perform();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/div/strong/a")).click();
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-52")).click();
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		//Remove from cart
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a")).click();
	}

}
