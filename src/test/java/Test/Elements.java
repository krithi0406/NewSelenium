package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://google.com");
		
		//WebElement searchBox = driver.findElement(By.name("q"));
		//searchBox.sendKeys("CRICKET T20 2022",Keys.ENTER);
		/*
		driver.navigate().to("https://trytestingthis.netlify.app/");
		List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));
		for(WebElement element : options)
		{
			System.out.println(element.getText());
		}
		driver.findElement(By.cssSelector("#fname")).sendKeys("Adithya");
		*/
		
		driver.navigate().to("https://www.saucedemo.com/");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(loginButton)).sendKeys("1234");
		WebElement Password = driver.findElement(By.id("password"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(Password)).sendKeys("Sharukhan");
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
