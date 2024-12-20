package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utilities {
	
	public String readExcelData(String sheetName,int RowNum,int CellNum) throws EncryptedDocumentException, IOException {
		
FileInputStream fis2=new FileInputStream("../Advanced_Selenium/src/test/resources/TestData.xlsx");
		
		Workbook book=WorkbookFactory.create(fis2);
		
		Sheet sheet = book.getSheet(sheetName);
		
	    Row row1 = sheet.getRow(RowNum);
	                      
	    Cell cell1 = row1.getCell(CellNum);
	    
	    String excelData = cell1.getStringCellValue();
		System.out.println(excelData);
		return excelData;
		
	}

	public String readExcelDataUsingDataFormatter(String sheetName,int RowNum,int CellNum) throws EncryptedDocumentException, IOException {
		
        FileInputStream fis2=new FileInputStream("../Advanced_Selenium/src/test/resources/TestData.xlsx");
		
		Workbook book=WorkbookFactory.create(fis2);
		
		Sheet sheet = book.getSheet(sheetName);
		
	    Row row1 = sheet.getRow(RowNum);
	                      
	    Cell cell1 = row1.getCell(CellNum);
	    
	    DataFormatter format1=new DataFormatter();
	    String excelData=format1.formatCellValue(cell1);
		System.out.println(excelData);
		return excelData;
		
		
	}
	
	
	public Object[][] readExcelDataForDataProvider(String sheetName) throws Throwable

	{
		FileInputStream fis1 = new FileInputStream("../Advanced_Selenium/src/test/resources/TestData.xlsx");

		Workbook book = WorkbookFactory.create(fis1);

		Sheet sheet = book.getSheet(sheetName);

		int lastRow = sheet.getLastRowNum() + 1;
		int lastCell = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRow][lastCell];

		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return obj; 
	
	}
	
}
