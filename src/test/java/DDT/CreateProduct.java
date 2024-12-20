package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateProPage;
import ObjectRepo.HomepageVtiger;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProValidatePage;
import ObjectRepo.ProductDetailedPage;



public class CreateProduct extends Base_Class {

	@Test(groups= "regression")
	public void CreateProduct() throws Throwable {

		WebDriver_Utility wlib=new WebDriver_Utility();
	//	wlib.maximizeWindow(driver);
	//	wlib.waitForPageToload(driver);
		
        File_Utilities flib=new File_Utilities();
		
		
//----------------------------------------------------------------------------------------------------------------------
	     
	     HomepageVtiger home=new HomepageVtiger(driver);
	     home.clickPrdLink();
		

//-----------------------------------------------------------------------------------------------------------------------
	     
	     ProductDetailedPage page=new ProductDetailedPage(driver);
	     page.clickProLookUpImg();
	     
//------------------------------------------------------------------------------------------------------------------------	     
	     
		  Java_Utilities ju=new Java_Utilities();
		  int ranNum=ju.getRanNum();
//-----------------------------------------------------------------------------------------------------------------------		
		  Excel_Utilities data=new Excel_Utilities();
 	      String productname=data.readExcelData("Sheet1", 0, 0)+ranNum;
          System.out.println(productname);

//-------------------------------------------------------------------------------------------------------------------------
	    CreateProPage page1=new CreateProPage(driver);
	    page1.createProd(productname);
	    page1.clickSaveButton();
	    
//-------------------------------------------------------------------------------------------------------------------------	    
	    ProValidatePage validate=new ProValidatePage(driver);
	    validate.validateProduct(driver, productname);
	 	System.out.println("VALIDATED");
	    	
	  }
	
 
		 
		
	}

