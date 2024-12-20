package DDT;

import java.io.FileInputStream;
import java.util.Iterator;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;



import org.apache.poi.EncryptedDocumentException;
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

import Generic_Utilities.File_Utilities;
import Generic_Utilities.Java_Utilities;

public class Campaign_Product_Integration {

	public static void main(String[] args) throws Throwable {
		WebDriver driver;
        
		File_Utilities flib=new File_Utilities();
		
		String BROWSER= flib.getKeyAndValuePair("browser");
		String URL=flib.getKeyAndValuePair("url");
		String USERNAME=flib.getKeyAndValuePair("username");
		String PASSWORD=flib.getKeyAndValuePair("password");
        
        if(BROWSER.equalsIgnoreCase("chrome")) {
      	  
      	  driver=new ChromeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("firefox")) {
      	  
      	  driver=new FirefoxDriver();
        }else {
      	  
      	  driver=new EdgeDriver();
        }

      driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();		
		
		
		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		// To Avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		// Step1:-get the connection of physical file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/TestData7am.xlsx");

		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet("Product");

		// step4:-get control of the row
		Row row = sheet.getRow(0);

		// step5:-get control of the cell
		Cell cel = row.getCell(0);

		// //step6:-read cell value
		String PrdName = cel.getStringCellValue() + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//-----------------------------------------------------------------------------------------------------------
		// Navigating to campaign Module
		WebElement moreLink = driver.findElement(By.linkText("More"));

		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();

		FileInputStream fes = new FileInputStream(
				"C:\\Users\\Shobha\\eclipse-BasicSelenium\\AdvanceSelenium_QCO-SOEAJD-M19\\target\\test-classes\\TestData7am.xlsx");
		// step2:- open workbook in read mode
		Workbook book1 = WorkbookFactory.create(fes);

		// step3:-get control of the Sheet
		Sheet sheet1 = book1.getSheet("Campaigns");

		// step4:-get control of the row
		Row row1 = sheet1.getRow(0);

		// step5:-get control of the cell
		Cell cel1 = row1.getCell(0);

		// //step6:-read cell value
		String CampName = cel1.getStringCellValue() + ranNum;
		System.out.println(CampName);

		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		
		//Click on + sign To Navigate Product Table
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		Set<String> allWins1 = driver.getWindowHandles();//win1//win2
		
		Iterator<String> it1 = allWins1.iterator();

	
		while (it1.hasNext())
		{
			String win = it1.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
		if(title.contains("Products&action"))
		{
			break;
		}
		}
	driver.findElement(By.name("search_text")).sendKeys(PrdName);
	driver.findElement(By.cssSelector("[name=\"search\"]")).click();
	
	//Dynamic Xpath
	driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
	
	Set<String> allWins2 = driver.getWindowHandles();
	Iterator<String> it2 = allWins2.iterator();

	while (it2.hasNext())
	{
		String win1 = it2.next();
		driver.switchTo().window(win1);
		String title1 = driver.getTitle();
	if(title1.contains("Campaigns&action"))
	{
		break;
	}
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if(actData.contains(CampName))
		{
			System.out.println("Campaigns Name is Created");
		}
		else
		{
			System.out.println("Campaigns name not created");
		}


		String actData1 = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
		if (actData1.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		//Logout
		act.moveToElement(AmdLink).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	
	}

}
