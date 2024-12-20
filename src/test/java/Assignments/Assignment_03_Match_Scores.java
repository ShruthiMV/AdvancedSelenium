package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_03_Match_Scores {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.google.com/search?q=pro+kabaddi+schedule&oq");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//span[@class='U8v51e S3PB2d'])[1]")).click();
		Thread.sleep(3000);
		List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='tsp-w tsp-dib tsp-kds']//div[@class='tsp-dib tsp-w50 tsp-lm']"));
		int size=elements1.size();
		List<WebElement> elements2 = driver.findElements(By.xpath("//div[@class='tsp-w tsp-dib tsp-kds']//div[@class='tsp-dib tsp-w50 tsp-rm']"));

        for(int i=0;i<size;i++) {
        	
        	String str1=elements1.get(i).getText();
        	String str2=elements2.get(i).getText();
        	System.out.println(str1+ " - " +str2);
        	
        	
        }
	
	
	
	}
}