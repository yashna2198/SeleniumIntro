import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoSuggestiveDropdownAssignment {

	public static void main(String[] args) {
		
		String country = "United States (USA)";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(3));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
		
		driver.findElement(By.xpath("//div[text()='"+country+"']")).click();
		String selectedValue = driver.findElement(By.id("autocomplete")).getAttribute("value");
		System.out.println(selectedValue);
		Assert.assertEquals(country, selectedValue);
		

	}

}
