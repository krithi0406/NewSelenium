package Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Newtest
{
	
public static void main(String[] args) throws InterruptedException, IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.get("http://website.multiformis.com/");
	
	System.out.println(driver.getTitle());
	
	//Test popup alert
	driver.findElement(By.xpath("//button[@class=\"pum-close popmake-close\"]")).click();
	Alert popup = driver.switchTo().alert();
	System.out.println(popup.getText());
	popup.accept();
	if(driver.getPageSource().contains("MY BLOG"))
	   System.out.println("MY BLOG");	
	System.out.println("====================");
	
	//sort and tables
	WebElement SortandTables = driver.findElement(By.id("SortandTables"));
	SortandTables.sendKeys("TestSortandTables");
	driver.findElement(By.xpath("//body[@class=\"page-template-default page page-id-13 wp-embed-responsive is-light-theme singular has-main-navigation is-dark-theme\"")).click();
	
	WebElement Age = driver.findElement(By.id("Age"));
	Age.sendKeys("TestAge");
	driver.findElement(By.xpath("//th[@aria-label=\"Age: activate to sort column ascending\"]")).click();
	
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	WebElement element = driver.findElement(By.cssSelector(".site-header has-title-and-tagline has-menu"));
	File srcFile1 = element.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile1, new File("./image3.png"));
	driver.close();
	driver.quit();
	


}
}
