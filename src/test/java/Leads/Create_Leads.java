package Leads;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Java_Utilities;

public class Create_Leads {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
WebDriver driver;
		
		FileInputStream fis=new FileInputStream("./src/test/resources/DataProperty.properties");
		
		Properties p=new Properties();
		
		p.load(fis);
		
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");

		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
			
		}else {
		
			driver=new EdgeDriver();
       }

	   driver.get(URL);
	   driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	   driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	   driver.findElement(By.id("submitButton")).click();
	   
	   driver.findElement(By.linkText("Leads")).click();
	   driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
//----------------------------------------------------------------------------------------------------------------------
	   Java_Utilities ju=new Java_Utilities();
		  int ranNum=ju.getRanNum();
//------------------------------------------------------------------------------------------------------------------
	   FileInputStream fis2=new FileInputStream("./src/test/resources/Leads.xlsx");
       Workbook w=WorkbookFactory.create(fis2);
       Sheet sheet = w.getSheet("Sheet1");
       
       Row row1=sheet.getRow(0);
       
       org.apache.poi.ss.usermodel.Cell cell1=row1.getCell(0);
       
       String first_name=cell1.getStringCellValue() + ranNum;
       System.out.println(first_name);
//     ---------------------------------------------------------------------------------------------------------------
       
       Row row2=sheet.getRow(1);
       org.apache.poi.ss.usermodel.Cell cell2=row2.getCell(0);
       
       DataFormatter format1=new DataFormatter();
      String last_name=format1.formatCellValue(cell2);
      System.out.println(last_name);
      
  //----------------------------------------------------------------------------------------------------------------------------------
      Row row3=sheet.getRow(2);
      org.apache.poi.ss.usermodel.Cell cell3=row3.getCell(0);
      
      DataFormatter format2=new DataFormatter();
     String company_name=format2.formatCellValue(cell3);
     System.out.println(company_name);
     
     
     driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(first_name);
     driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(last_name);
     driver.findElement(By.xpath("//input[@name='company']")).sendKeys(company_name);
     
     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
     
   
     
    String actData_firstname= driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
     if(actData_firstname.equals(first_name)) {
    	 
    	 System.out.println("Leads's first name is validated");
    	 
     } else
     {
    	    	 	 
        	 System.out.println("Leads's first name is not validated");
        	 
         
     }
     
     
	}

}
