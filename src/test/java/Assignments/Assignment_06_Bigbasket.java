package Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_06_Bigbasket {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//input[@type='text' and @placeholder='Search for Products...'])[2]")).sendKeys("Grapes");
	
	     List<WebElement> apple_list = driver.findElements(By.xpath("//ul[@class='overscroll-contain']//li//div[@class='flex-1 flex items-center mr-2.5 overflow-hidden']//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU']"));
	
	       int size=apple_list.size();
	       System.out.println(size);
	       for(int i=0;i<apple_list.size();i++) {
	    	   
	    	      WebElement ele=apple_list.get(i);
	    	      String str= ele.getText();
	    	       System.out.println(str);
	       }      
	    //	String expected="//ul[@class='overscroll-contain']//li//div[@class='flex-1 flex items-center mr-2.5 overflow-hidden']//following-sibling::div[2]//span[1]";	    			
	    	 
	   // 	int actual=25;
	   // 	String str1=String.valueOf(actual);
	    	
	          
	       }
	    	       
	    	       
	    	       
	    	       
	       
	       
	           
	       
	
	
	}


