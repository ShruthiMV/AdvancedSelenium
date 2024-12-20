package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

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
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import ObjectRepo.CreateOrgaPage;
import ObjectRepo.HomepageVtiger;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.OrgDetailedPage;
import ObjectRepo.OrgValidatePage;

public class CreateOrganization extends Base_Class{

	@Test(groups= "smoke")
	public void CreateOrganization() throws Throwable {

		
		File_Utilities flib=new File_Utilities();
       
       HomepageVtiger home = new HomepageVtiger(driver);
       home.clickOrgLink();
       
       OrgDetailedPage img=new OrgDetailedPage(driver);
       img.clickOrgLookUpImg();
	   
//----------------------------------------------------------------------------------------------------------------------
	  Java_Utilities ju=new Java_Utilities();
	  int ranNum=ju.getRanNum();
//------------------------------------------------------------------------------------------------------------------
	  Excel_Utilities data=new Excel_Utilities();
       String orgName=data.readExcelData("Sheet1", 0, 0)+ranNum;
       
       
        System.out.println(orgName);
//     ---------------------------------------------------------------------------------------------------------------
       
   //    Row row2=sheet.getRow(1);
   //    org.apache.poi.ss.usermodel.Cell cell2=row2.getCell(0);
       
   //    DataFormatter format1=new DataFormatter();
   //   String phNum=format1.formatCellValue(cExcel_Utilitiesell2);
   //   System.out.println(phNum);
       
       
       String phNum=data.readExcelDataUsingDataFormatter("Sheet1",1,0);
       
      
  //----------------------------------------------------------------------------------------------------------------------------------
   //   Row row3=sheet.getRow(2);
     // org.apache.poi.ss.usermodel.Cell cell3=row3.getCell(0);
      
    //  DataFormatter format2=new DataFormatter();
    // String emailId=format2.formatCellValue(cell3);
    // System.out.println(emailId);
      
      
       String emailId=data.readExcelDataUsingDataFormatter("Sheet1",2,0);
       
       CreateOrgaPage createPage=new CreateOrgaPage(driver);
       createPage.createOrgName(orgName, phNum, emailId);
       createPage.clickSaveButton();
       
      
      
  //-----------------------------------------------------------------------------------------------
     
 //    driver.findElement(By.name("accountname")).sendKeys(orgName);
  //   driver.findElement(By.id("phone")).sendKeys(phNum);
  //   driver.findElement(By.name("email1")).sendKeys(emailId);
     
     
  //   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 //    -----------------------------------------------------------------------------------------------------------------
     
   /*  Thread.sleep(2000);
     String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		
		if(actData.contains(orgName))
		{
			System.out.println("Organization Name is Created");
		}
		else
		{
			System.out.println("Organization name not created");
		}*/
     
 //    -------------------------------------------------------------------------------------------------
     
  //  driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
       Thread.sleep(2000);
       OrgValidatePage validate=new OrgValidatePage(driver);
       validate.validateOrganization(driver, orgName);
     System.out.println("VALIDATED");
      
	   
	   
}
	
}
