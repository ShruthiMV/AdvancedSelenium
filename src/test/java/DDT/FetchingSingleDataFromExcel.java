package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

             // WebDriver driver=new ChromeDriver();
              //driver.manage().window().maximize();
              
              String file="../Advanced_Selenium/src/test/resources/TestData.xlsx";
              FileInputStream fis=new FileInputStream(file);
              Workbook w=WorkbookFactory.create(fis);
              Sheet s = w.getSheet("Sheet1");
              int lastrow = s.getLastRowNum();
              System.out.println(lastrow);
   
              Row r = s.getRow(0);
              short lastcell = r.getLastCellNum();
               System.out.println(lastcell);
              Cell c = r.getCell(0);
              
              
              CellType datatype = c.getCellType();
              if(datatype==CellType.STRING)
              {
              String data = c.getStringCellValue();
              System.out.println(data);
              }
              else
              {
              double data = c.getNumericCellValue();
              System.out.println(data);
              }
              
              
              
              
              
		
		
	}

}
