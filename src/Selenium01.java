import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium01 {

	public static void main(String[] args) {
		
		//Manual invoking of Chrome driver without using Selenium Manager
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\majet\\OneDrive\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
		
		//invoke browser using driver class
		//Firefox driver --> gecko driver "webdriver.gecko.driver"
		//WebDriver driver = new FirefoxDriver();
		
		//Edge driver --> edge driver "webdriver.edge.driver"
		//WebDriver driver = new EdgeDriver();
		
		//Chrome driver - ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println("Title is:"+ driver.getTitle());
		System.out.println("Current URL is:"+ driver.getCurrentUrl());
		driver.close();

	}

}
