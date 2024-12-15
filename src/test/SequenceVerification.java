package test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SequenceVerification {
	
	
	@Test
	public void test() {
		String[] actualHeader = {"Instructor","Course","Price"};
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> headers = driver.findElements(By.cssSelector("table[name='courses'] th"));
		for(int i=0;i<headers.size();i++) 
				Assert.assertTrue(headers.get(i).getText().equalsIgnoreCase(actualHeader[i]));	
		
		driver.quit();
		}

	}

