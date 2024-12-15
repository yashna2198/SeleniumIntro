package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ScrollTest {
	
	@Test
	public void test() throws InterruptedException {
		
		String userName = "hiromsa@EnbridgeSB21";
		String password = "Click@123";
		WebDriver driver = new ChromeDriver();
		driver.get("https://fse-na-sb.cloud.clicksoftware.com/#/welcome");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("signIn")).click();
		By visibility =By.xpath("//div[@style='display: block;']");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(visibility));
		
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(Duration.ofSeconds(3));
		driver.findElement(By.cssSelector("#signIn")).click();
		By hamburger = By.id("framework_HeaderMenuBar");
		wait.until(ExpectedConditions.visibilityOfElementLocated(hamburger));
		
		driver.findElement(hamburger).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='menuitem']")));
		driver.findElement(By.xpath("//div[@role='menuitem']")).click();
		driver.findElement(By.xpath("//a[text()='Work Order']")).click();
		List<WebElement> columns = driver.findElements(By.tagName("th"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0; i<columns.size();i++) {
			System.out.println(columns.get(i).getText());
			//js.executeScript("document.querySelector('.k-grid-content.k-auto-scrollable').scrollLeft="+i*200);
			js.executeScript("arguments[0].scrollIntoView(true);",columns.get(i));
		}
		
		
		driver.quit();
		}

}
