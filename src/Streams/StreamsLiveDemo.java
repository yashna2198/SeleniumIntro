package Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsLiveDemo {
 // @Test
  public void f() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//th[contains(@aria-label,'Veg/fruit name')]")).click();
		List<WebElement> elementLists = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> itemsOriginal = elementLists.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> itemsSorted = itemsOriginal.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(itemsOriginal.equals(itemsSorted));
		driver.quit();
  }
  
 // @Test
  public void getPrice() {
	  
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		List<String> price;
		
		do {
			List<WebElement> elementLists = driver.findElements(By.xpath("//tr/td[1]"));
			price = elementLists.stream().filter(s->s.getText().equalsIgnoreCase("chocolate"))
				.map(s->getVeggiePrice(s))
				.collect(Collectors.toList());
		
		if(price.size()<1) {
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
		driver.quit();
		
  }

  @Test
  public void searchItem() {
	  	String word = "an";
	    WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys(word);
		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> finalList = items.stream()
				.filter(s->s.getText().contains(word))
				.collect(Collectors.toList());
		
		Assert.assertEquals(items.size(),finalList.size());
		driver.quit();
		
  }
  private static String getVeggiePrice(WebElement s) {
	  	String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	  	System.out.println(price);
	  	return price;
	  
  }
}
