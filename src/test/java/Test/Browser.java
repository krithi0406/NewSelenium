package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser
{
public static void main(String[] args) throws InterruptedException, IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.get("https://google.com");
	String originalWindow=driver.getWindowHandle();
	
	//driver.navigate().to("https://www.britannica.com/biography/Sachin-Tendulkar");
	/*
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	
	driver.navigate().back();
	Thread.sleep(1000);
	driver.navigate().forward();
	Thread.sleep(1000);
	driver.navigate().refresh();
	
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.switchTo().newWindow(WindowType.TAB);
	driver.switchTo().window(originalWindow);
	
	driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
	driver.switchTo().frame("packageFrame");
	driver.findElement(By.linkText("Alert")).click();
	driver.switchTo().defaultContent();
	
	driver.manage().window().getSize().getWidth();
	driver.manage().window().getSize().getHeight();
	
	Dimension size = driver.manage().window().getSize();
	System.out.println(size.getWidth());
	System.out.println(size.getHeight());
	
	driver.manage().window().setSize(new Dimension(800,600));
	
	driver.manage().window().getPosition().getX();
	driver.manage().window().getPosition().getY();
	
	Point position = driver.manage().window().getPosition();
	System.out.println(position.getX());
	System.out.println(position.getY());
	
	driver.manage().window().setPosition(new Point(400,200));
	
	driver.manage().window().maximize();
    Thread.sleep(2000);
    driver.manage().window().minimize();
    Thread.sleep(2000);
    driver.manage().window().fullscreen();
    
	
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("./image1.png"));
	
	WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
	File srcFile1 = element.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile1, new File("./image2.png"));
	*/
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebElement button = driver.findElement(By.name("btnI"));
	js.executeScript("arguments[0].click();",button);
	js.executeScript("console.log(' Hello My Dear Sachuu..')");
	
	Thread.sleep(3000);
	//driver.close();
	//driver.quit();
	
}
}
