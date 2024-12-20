package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertingDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String path="../Advanced_Selenium/src/test/resources/WriteData.xlsx";
        FileInputStream fis=new FileInputStream(path);
        
        Workbook book=WorkbookFactory.create(fis);
        
		org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Testing");
        Row r = sheet.createRow(5);
        Cell c = r.createCell(5);
        c.setCellValue("Manual");
        
		FileOutputStream out = new FileOutputStream(path);
        book.write(out);
                 
                
        
        
        
	}

}
