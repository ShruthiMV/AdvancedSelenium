package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utilities;
import Generic_Utilities.Java_Utilities;

public class DataProviderEx_02 {
	
	@Test(dataProvider = "readData")
	public void createOrganization(String name, String phnNum, String mailId) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

		Java_Utilities jlib = new Java_Utilities();
		int ranNum = jlib.getRanNum();
		driver.findElement(By.name("accountname")).sendKeys(name+ranNum);
		driver.findElement(By.name("phone")).sendKeys(phnNum);
		driver.findElement(By.name("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
  }
	
	/*@DataProvider
	public Object[][] readData() throws Throwable
	{
	Excel_Utilities elib = new Excel_Utilities();	
	Object[][] values = elib.readExcelDataForDataProvider("DataProvider");
		return values;
		
	}*/

	
		
	
		@DataProvider
	public Object[][] readData() {

		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		Object[][] obj = new Object[3][3];

		obj[0][0] = "AAA" + ranNum;
		obj[0][1] = "986546455";
		obj[0][2] = "mailto:hgd@gmail.com";

		obj[1][0] = "BBB" + ranNum;
		obj[1][1] = "986546455";
		obj[1][2] = "mailto:hgd@gmail.com";

		obj[2][0] = "CCC" + ranNum;
		obj[2][1] = "986546455";
		obj[2][2] = "mailto:hgd@gmail.com";

		return obj;

	} 
	
	
	
	
}
