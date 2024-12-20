package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateProductPage;
import ObjectRepo.DeleteProductName;
import ObjectRepo.HomepageVtiger;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductLookUp;
import ObjectRepo.ValidatePrdName;

public class Product_and_DeleteProduct extends Base_Class{
	
	@Test(groups="sanity")
	public void Product_and_DeleteProduzzct() throws Throwable {
		File_Utilities flib = new File_Utilities();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utilities jlib = new Java_Utilities();
		Excel_Utilities elib = new Excel_Utilities();

		// Reading data from file_utility

		

		wlib.maximizeWindow(driver);
		wlib.waitForPageToload(driver);

		HomepageVtiger home = new HomepageVtiger(driver);
		home.clickPrdLink();

		ProductLookUp prdImg = new ProductLookUp(driver);
		prdImg.clickOnPlusSign();

		int ranNum = jlib.getRanNum();

		String PrdName = elib.readExcelData("Sheet1", 0, 0) + ranNum;

		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

		ValidatePrdName validate = new ValidatePrdName(driver);
		 validate.validatePrd(driver, PrdName);
		

		// -------------------------------------------------------------------------------------------------------------------------
		// Navigating to product table
		home.clickPrdLink();

		DeleteProductName delete = new DeleteProductName(driver);
		delete.selectProdName(driver, PrdName);
		delete.selectDeletButton();

		wlib.alertAccept(driver);

		delete.validatePrdDeleted(driver, PrdName);

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public static void main(String[] args) throws Throwable {

        WebDriver driver;
		
        File_Utilities flib=new File_Utilities();
		
		String BROWSER= flib.getKeyAndValuePair("browser");
		String URL=flib.getKeyAndValuePair("url");
		String USERNAME=flib.getKeyAndValuePair("username");
		String PASSWORD=flib.getKeyAndValuePair("password");
		
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
			
		}else {
		
			driver=new EdgeDriver();
          }
			
		driver.get(URL);
		LoginVtigerPage login=new LoginVtigerPage(driver);
	    login.loginIntoVtiger(USERNAME, PASSWORD);
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

//-----------------------------------------------------------------------------------------------------------------------
		
		Java_Utilities ju=new Java_Utilities();
		int ranNum=ju.getRanNum();
		  
		Excel_Utilities data=new Excel_Utilities();
	    String productname=data.readExcelData("Product_Name", 0, 0)+ranNum;
	    
	    
	    
		
		/*FileInputStream fis2=new FileInputStream("../Advanced_Selenium/src/test/resources/Product_Name_List.xlsx");
		
		Workbook book=WorkbookFactory.create(fis2);
		
		Sheet sheet = book.getSheet("Product_Name");
		
	    Row row1 = sheet.getRow(0);
	                      
	    Cell cell1 = row1.getCell(0);
	             
	    String productname= cell1.getStringCellValue()+ranNum;
	    System.out.println(productname);*/
	    
	    
	    
	    
//-------------------------------------------------------------------------------------------------------------------	               
	
	/*    driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    
	    String act_data=driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	    System.out.println(act_data);
	    
	    if(act_data.equals(productname)) {
	    	
	    	System.out.println("Product is created");

	    }
	
	    
	    else {
	    	
	    	System.out.println("Product is not created");

	    	
	    }
	   Thread.sleep(3000);
	   
	  driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();

	   WebElement ele= driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
	    
	   
	   Select s=new Select(ele);
	   s.selectByVisibleText("Product Name");
	   Thread.sleep(3000); 
 
	    driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(productname);
	

	    driver.findElement(By.xpath("//input[@name='submit']")).click();
		   Thread.sleep(3000); 

	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		   
		   Thread.sleep(3000); 

	    driver.findElement(By.xpath("//input[@value='Delete']")).click();
		   Thread.sleep(3000); 

	    


	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    
	    
	    List<WebElement> prdlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
	    
	    boolean flag=false;
	    
	    for(WebElement prd : prdlist) {
	    
	    String actData=prd.getText();
	    
	    if(actData.contains(productname)) {
	    	
	    	flag=true;
	    	break;
	    }
 
	  }
	    
	   if(flag) {
		   
		   System.out.println("Product deleted");
	   }
	   
	   else {
		  
		   System.out.println("Product is not deleted");

	   } */
	    
	    
	    
	    
	    
	    
	   

}
