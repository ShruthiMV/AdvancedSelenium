package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrgValidatePage {

	public OrgValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param OrgName
	 * @return
	 */
	public String validateOrganization(WebDriver driver,String orgName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
        System.out.println(actData);
		
		/*if (actData.contains(orgName)) {
			System.out.println("Organization is Created");
		} else {
			System.out.println("Organization is not Created");
		}*/
        
        Assert.assertEquals(actData, orgName);
		return actData;

	}
}
