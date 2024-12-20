package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgaPage {
	
	public CreateOrgaPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
			
	}
	
	@FindBy(name="accountname")
	private WebElement orgname;
	
	
	@FindBy(id="phone")
	private WebElement phoneNum;

	@FindBy(name ="email1")
	private WebElement email_id;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getPhoneNum() {
		return phoneNum;
	}

	public WebElement getEmail() {
		return email_id;
	}
	
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	public void createOrgName(String orgName,String phNum,String mail) {
		
		orgname.sendKeys(orgName);
		phoneNum.sendKeys(phNum);
		email_id.sendKeys(mail);
		
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}

}
