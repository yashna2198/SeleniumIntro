import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. count all links on the web page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. count links on footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3. count links on the first cloumn of the footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table[@class = 'gf-t']/tbody/tr/td[1]"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//4. Click on each link and grab the title
		List<WebElement> links = columnDriver.findElements(By.tagName("a"));
		for(int i=1; i<links.size();i++) {
			String openLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(openLinks);
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		Thread.sleep(5000);
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

}
