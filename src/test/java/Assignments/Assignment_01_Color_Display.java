package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_01_Color_Display {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone15");
		Thread.sleep(3000);
		
		
		List<WebElement> iphone_elements = driver.findElements(By.xpath("//div[@class='left-pane-results-container']//div"));
		
		for(int i=0;i<iphone_elements.size();i++) {
			
			WebElement ele=iphone_elements.get(i);
			ele.click();
			
		}
		
		


		
		
	}

}
