
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> Options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		for (WebElement option : Options) {
			if (option.getText().equalsIgnoreCase("india")) {
				System.out.println(option.getText());
				option.click();
				break;
			}
		}

	}

}
