package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {
	
	/*
	 * This is used to maximize the window
	 * 
	 * 
	 */
	
	
	/*
	 * This is used to wait for page to load
	 * 
	 * 
	 */
	
   public void waitForPageToload(WebDriver driver) {
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
   }

   /*
	 * This is used to wait for page to load
	 * 
	 * 
	 */
   
   public void windowSwitching(WebDriver driver,String partialTitle) {
	   
	    Set<String> allWins = driver.getWindowHandles();
	    Iterator<String> id = allWins.iterator();
	    
	    while(id.hasNext()) {
	    	
	    	 String win=id.next();
	    	 driver.switchTo().window(win);
	    	 String title=driver.getTitle();
	    	 System.out.println();
	    }
	    
	   
   }

public void maximizeWindow(WebDriver driver) {
	
	driver.manage().window().maximize();
	
}
   
public void select(WebElement element , int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * used to select the value from the dropDwon  based on value / option avlaible in GUI
 * @param element
 * @param value
 */
public void select(WebElement element , String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
  
/**
 * this method is used to accept the alert popup
 * @param driver
 */


/** this method is used to dismiss the alert popup
 * 
 * @param driver
 */
public void alertDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public void alertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();	
}



public void screenShot() {
	TakesScreenshot ts = (TakesScreenshot) Base_Class.sdriver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File("./ScreenShots/image.png");
	try {
		FileUtils.copyFile(src, dst);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
	
	TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
	File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
	File dst = new File("./ScreenShots/" + screenShotName +".png");
	FileUtils.copyFile(src, dst);
	return dst.getAbsolutePath();
}
	
	
}
