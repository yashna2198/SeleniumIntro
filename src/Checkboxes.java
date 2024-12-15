import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=StudentDiscount")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*=StudentDiscount")).isSelected());
		
		
		driver.findElement(By.cssSelector("input[id*=StudentDiscount")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id*=StudentDiscount")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=StudentDiscount")).isSelected());
		
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(),6);
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

	}

}
