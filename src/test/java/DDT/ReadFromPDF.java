package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadFromPDF {

	public static void main(String[] args) throws Throwable {
    
		 File fis=new File("../Advanced_Selenium/src/test/resources/multipage-pdf.pdf");
         PDDocument doc= new PDDocument();
         doc.load(fis);
         
         
         int pages=doc.getNumberOfPages();
         System.out.println(pages);
         
         PDFTextStripper pdfdata=new PDFTextStripper();
         String readdata1=pdfdata.getText(doc);
         System.out.println(readdata1);
         
         pdfdata.setStartPage(3);
         String readData2=pdfdata.getText(doc);
         System.out.println(readData2);


         
         
         
	
	
	
	
	}

}
