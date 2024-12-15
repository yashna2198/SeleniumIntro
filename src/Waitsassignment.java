import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitsassignment {

	public static void main(String[] args) throws InterruptedException {
		String username = "rahulshettyacademy";
		String password = "learning";
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.xpath("//label[@class='customradio']/input[@value='user']/following-sibling::span[@class='checkmark']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		WebElement option = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select profile = new Select(option);
		profile.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'btn-info')]")));
		addItems(driver);
		driver.findElement(By.xpath("//a[contains(@class,'btn-primary')]")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).click();
		driver.quit();
	}
	public static void addItems(WebDriver driver) {
		int size=driver.findElements(By.xpath("//button[contains(@class,'btn-info')]")).size();
		for(int i=0;i<size;i++) {
			driver.findElements(By.xpath("//button[contains(@class,'btn-info')]")).get(i).click();
			System.out.println(i);
		}
	}

}
