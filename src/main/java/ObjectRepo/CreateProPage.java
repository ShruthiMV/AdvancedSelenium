package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProPage {
	
public CreateProPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(name="productname")
	private WebElement proName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getProName() {
		return proName;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createProd(String name) {
		
		proName.sendKeys(name);
		
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}

}
