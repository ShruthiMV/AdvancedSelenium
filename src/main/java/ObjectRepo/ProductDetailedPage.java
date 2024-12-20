package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailedPage {

	public ProductDetailedPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement lookImg;
	

	public WebElement getLookImg() {
		return lookImg;
	}

  
	public void clickProLookUpImg()
	{
		lookImg.click();
	}
}
