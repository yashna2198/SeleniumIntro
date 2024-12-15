package Streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.*;
import org.testng.annotations.Test;

public class RelativeLocatorsExample {
  @Test
  public void f() {
	    WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameEditBox)).getText());
		
		WebElement employeeText = driver.findElement(By.xpath("//label[text()='Employment Status: ']"));
		driver.findElement(RelativeLocator.with(By.cssSelector("input[type='radio']")).toRightOf(employeeText)).click();
		
		driver.findElement(RelativeLocator.with(By.id("exampleCheck1"))
				.toLeftOf(By.xpath("//label[text()='Check me out if you Love IceCreams!']"))).click();
		
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("input"))
				.below(By.xpath("//label[text()='Date of Birth']"))).getAttribute("type"));
		
		driver.quit();
  }
}
