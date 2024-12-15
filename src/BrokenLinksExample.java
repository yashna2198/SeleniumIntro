import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksExample {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();
		
		List<WebElement> links =  driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			URL u = new URI(url).toURL();
			HttpURLConnection con = (HttpURLConnection) u.openConnection();
			con.getRequestProperty("HEAD");
			int code = con.getResponseCode();
			
			a.assertTrue(code<400, url+" link is broken");
					
		}
		a.assertAll();
		driver.quit();
	}

}
