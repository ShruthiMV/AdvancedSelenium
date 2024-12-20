package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_05 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone 15",Keys.ENTER);
		Thread.sleep(3000);
		
		String xpath_exp="//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-size-medium a-color-base a-text-normal']/../../../..//div[@class='a-row a-size-base a-color-base']//span[@class='a-price']";
		
		List<WebElement> eles = driver.findElements(By.xpath(xpath_exp));
		
		for(int i=0;i<20;i++) {
			
			
		WebElement ele=eles.get(i);
		String str1=ele.getText();
		int str2=60000;
		System.out.println(str1);
		
	
		}
		
	}

}
