package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ProValidatePage {
	
  public ProValidatePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

public String validateProduct(WebDriver driver, String productname) {
	String act_data=driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
    System.out.println(act_data);

  /*   if(act_data.equals(productname)) {
	
	     System.out.println("Product is created");
       }
        else {
	          System.out.println("Product is not created");
          }*/
    
    SoftAssert soft=new SoftAssert();
    soft.assertEquals(act_data, productname);
    
    
	return act_data;	
}
}