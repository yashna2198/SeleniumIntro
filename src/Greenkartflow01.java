import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Greenkartflow01 {

	public static void main(String[] args) throws InterruptedException {
		String[] names = { "Cashews", "Onion", "Corn" };
		String code = "rahulshettyacademy";
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		
		addGroceries(driver,names);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys(code);
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.quit();

	}
	public static void addGroceries(WebDriver driver, String[] names) {
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < names.length; i++) {
			int size = 0;
			for (WebElement product : products) {
				if (product.getText().contains(names[i])) {
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(size).click();
					System.out.println(product.getText() + " & " + names[i]);
					break;
				}
				size++;
			}
		}
	}
}
