package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadDataFromJSON {

	public static void main(String[] args) throws IOException {

    FileInputStream fis=new FileInputStream("../Advanced_Selenium/src/test/resources/jaason.json");
    
          ObjectMapper obj=new ObjectMapper();
          JsonNode data = obj.readTree(fis);
    
    
          String BROWSER=data.get("browser").asText();
          String URL=data.get("url").asText();
          String USERNAME=data.get("username").asText();
          String PASSWORD=data.get("password").asText();
          
          WebDriver driver;
          if(BROWSER.equalsIgnoreCase("chrome")) {
        	  driver=new ChromeDriver();
          } else if(BROWSER.equalsIgnoreCase("Firefox")) {
        	  
        	  driver=new FirefoxDriver();
                   	  
          }
          else {
        	  
        	  driver=new EdgeDriver();
          
	}
          
          
          driver.get(URL);
          driver.findElement(By.name("user_name")).sendKeys(USERNAME);
          driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
          driver.findElement(By.id("submitButton")).click();
          
          
		
		
	}

}
