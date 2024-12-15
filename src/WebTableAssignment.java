import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");
		
		
		System.out.println("No of Rows= "+ driver.findElements(By.cssSelector("table[name='courses'] tr")).size());
		System.out.println("No of Columns= "+ driver.findElements(By.cssSelector("table[name='courses'] th")).size());
		
		String tableContent = driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)")).getText();
		System.out.println(tableContent);		
	}

}
