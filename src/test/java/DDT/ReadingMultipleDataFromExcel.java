package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

public class ReadingMultipleDataFromExcel {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		String path="../Advanced_Selenium/src/test/resources/WriteData.xlsx";
        FileInputStream fis=new FileInputStream(path);
        
        Workbook book=WorkbookFactory.create(fis);
        Sheet sheet=book.getSheet("Testing");
        WebDriver driver=new ChromeDriver();
		
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(int i=0;i<allLinks.size();i++) {
			
			Row row =sheet.getRow(i);
			Cell cell=row.getCell(0);
			String str=cell.getStringCellValue();
			System.out.println(str);
			}
		
		
		FileOutputStream out = new FileOutputStream(path);
        book.write(out);
	}

}
