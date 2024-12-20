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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.RetryAnalyser;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.HomepageVtiger;
import ObjectRepo.LoginVtigerPage;
//@Listeners(Generic_Utilities.ListenerImp.class)


@Listeners(Generic_Utilities.ExtentReport.class)
public class Create_Campaign  extends Base_Class{
	
//	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyser.class)
	@Test
	public void Create_Campaign() throws Throwable {

	
		Excel_Utilities elib = new Excel_Utilities();
	        
        HomepageVtiger home = new HomepageVtiger(driver);
		home.clickMoreLink();
		home.clickCampLink();    
    
		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();
        
//---------------------------------------------------------------------------------------------------------------------  		
  		Java_Utilities ju=new Java_Utilities();
  	    int ranNum=ju.getRanNum();
		
  	    
  	    Excel_Utilities data=new Excel_Utilities();
  	    String camapihn_name=data.readExcelData("Sheet1", 0, 0)+ranNum;
  	    
  	    
  	    CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(camapihn_name);
		createPage.clickSaveButton();
	//	Assert.fail();
		
		
		CampValidatePage validate = new CampValidatePage(driver);
	    String actData = validate.validateCampaign(driver, camapihn_name);
		Assert.assertEquals(actData, camapihn_name);
	    System.out.println("Validated");
	}
	
	

}
