package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageVtiger {

	// initialization
	
	
	
		
	public HomepageVtiger(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}

		// Declaration
		@FindBy(linkText = "More")
		private WebElement moreLink;

		@FindBy(linkText = "Campaigns")
		private WebElement campLink;
		
		@FindBy(linkText = "Organizations")
		private WebElement orgLink;
		
		@FindBy(linkText = "Products")
		private WebElement prdLink;

		@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
		private WebElement admLink;

		@FindBy(linkText = "Sign Out")
		private WebElement signOut;

		// getter method
		public WebElement getMoreLink() {
			return moreLink;
		}

		public WebElement getCampLink() {
			return campLink;
		}

	
		public void clickMoreLink() {
			moreLink.click();
		}

	
		public void clickCampLink() {

			campLink.click();
		}

		
		public void logoutApp() {
			admLink.click();
			signOut.click();
		}
	
		public void clickOrgLink()
		{
			orgLink.click();
		}
		
		public void clickPrdLink()
		{
			prdLink.click();
		}
}
