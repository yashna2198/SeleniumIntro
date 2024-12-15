import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment02 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String label = driver.findElement(By.xpath("//label[@for='honda']")).getText();
		driver.findElement(By.id("checkBoxOption3")).click();
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select options = new Select(dropdown);
		options.selectByVisibleText(label);
		
		driver.findElement(By.id("name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(label))
			System.out.println(label+" is present");
		
		driver.quit();
	}

}
