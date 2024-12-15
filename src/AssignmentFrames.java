import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentFrames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.partialLinkText("Nested")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("div#content"))).build().perform();
		String text = driver.findElement(By.cssSelector("div#content")).getText();
		System.out.println(text);
		

	}

}
