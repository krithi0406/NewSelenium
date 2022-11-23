package Test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	//implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("Sachin Tendulkar" + Keys.ENTER);
   
	//explicit wait
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement myLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sachin Tendulkar | Biography, Stats, & Facts | Britannica")));
	myLink.click();
	
	//fluent wait
	Wait<WebDriver>fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1)).ignoring(org.openqa.selenium.NoSuchElementException.class);
	fluentwait.until(ExpectedConditions.elementToBeSelected(By.xpath("")));
	
	driver.close();
	driver.quit();
}
	
}
