package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_04 {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().window().maximize();
		
		String xpath_exp="//div[@class='table-body']//div[@class='table-row']//div[@class='row-head']";
        List<WebElement> ele = driver.findElements(By.xpath(xpath_exp));
 		 
		 for(int i=0;i<ele.size();i++) {   
	         
	         WebElement ss=ele.get(i);
	       //  String str = ss.getText();
	         System.out.print(ss.getText()+"\t");
		 
	 }
	
	}

}
