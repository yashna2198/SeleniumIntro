import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> amountList = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int finalAmount = 0;
		for(int i=0;i<amountList.size();i++) {
			String a = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")).get(i).getText();
			finalAmount += Integer.parseInt(a);
		}
		System.out.println("Final Amount= "+finalAmount);
		String[] amount = driver.findElement(By.className("totalAmount")).getText().split(" ");
		int sumAmount = Integer.parseInt(amount[3]);
		System.out.println("sumAmount= "+sumAmount);
		if(finalAmount == sumAmount)
			System.out.println("Value matched");
		else
			System.out.println("Value not matched");
		
		driver.quit();
	}

}
