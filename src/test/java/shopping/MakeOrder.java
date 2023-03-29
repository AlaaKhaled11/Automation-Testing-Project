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

public class MakeOrder {
	
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
		WebElement element = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));
		Actions mouseover = new Actions(driver);
		mouseover.moveToElement(element).perform();
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]"));
		Actions mouseover2 = new Actions(driver);
		mouseover2.moveToElement(element2).perform();
		driver.findElement(By.id("ui-id-12")).click();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[10]/div/a")).click();
		driver.findElement(By.id("option-label-size-143-item-166")).click();
		driver.findElement(By.id("option-label-color-93-item-53")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		
	}

}
