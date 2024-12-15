package Streams;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class InvokingMultipleWindows {
 // @Test
  public void f() throws IOException {
	  
	    WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow)
		.get("https://rahulshettyacademy.com/");
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")));
		String text = driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		System.out.println(text);
		
		driver.switchTo().window(parentWindow);
		WebElement name = driver.findElement(By.xpath("//input[@minlength='2']"));
		name.sendKeys(text);
		
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("partialSS.jpeg"));
		
		driver.quit();
		
  }
  @Test
  public void getDimensions() {
	  WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow)
		.get("https://rahulshettyacademy.com/");
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")));
		String text = driver.findElements(By.xpath("//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		System.out.println(text);
		
		driver.switchTo().window(parentWindow);
		WebElement name = driver.findElement(By.xpath("//input[@minlength='2']"));
		name.sendKeys(text);
		
		System.out.println("Height= "+name.getRect().getDimension().getHeight());
		System.out.println("Width= "+name.getRect().getWidth());
		System.out.println(name.getRect().getHeight());
		
		driver.quit();
  }
}
