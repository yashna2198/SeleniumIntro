import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		String name = "Sherlock";
		String email = "holmes@gmail.comxxx";
		 
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//input[@minlength='2']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("#exampleInputPassword1")).sendKeys("SH221B");
		
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		
		Select options = new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
		options.selectByVisibleText("Female");
		
		driver.findElement(By.xpath("//input[contains(@id,'inlineRadio1')]")).click();
		
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("02111998");
		
		driver.findElement(By.cssSelector(".btn-success")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
				
		
	}

}
