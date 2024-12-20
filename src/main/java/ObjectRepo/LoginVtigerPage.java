package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginVtigerPage {

	
	//initialization
	public LoginVtigerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Element Declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name = "user_password")
	private WebElement PassWordTextField;
	
	
	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	//getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

//Bussiness Logics
	/**
	 * This method is used to login into Vtiger application
	 * @author Shruthi
	 */


	public void loginIntoVtiger(String username, String password) {
		UserTextField.sendKeys(username);
		PassWordTextField.sendKeys(password);
		LoginButton.click();		
	}
	
	
	

		

	

}
