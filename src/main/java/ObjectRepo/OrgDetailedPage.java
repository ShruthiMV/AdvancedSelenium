package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgDetailedPage {

	public OrgDetailedPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "[alt=\"Create Organization...\"]")
	private WebElement lookImg;

	public WebElement getLookImg() {
		return lookImg;
	}
	
	
	public void clickOrgLookUpImg()
	{
		lookImg.click();
	}
}
