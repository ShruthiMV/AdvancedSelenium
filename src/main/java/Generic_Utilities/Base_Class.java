package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



import ObjectRepo.HomepageVtiger;
import ObjectRepo.LoginVtigerPage;



import Generic_Utilities.File_Utilities;

//Base class update1
//pulling from github_01
public class Base_Class {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups= {"smoke","regression","sanity"})
	public void bs() {
		
		System.out.println("Database Connection");
		
		
	}
	
	@BeforeTest(groups= {"smoke","regression","sanity"})
	public void bt() {
		
		System.out.println("parallel exection");
		
		
	}
//	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression","sanity"})
	public void bc() throws Throwable {
		
		  File_Utilities flib=new File_Utilities();
		
		 String BROWSER1= flib.getKeyAndValuePair("browser");
		
 //   String BROWSER1=System.getProperty("browser"); 
      
          if(BROWSER1.equalsIgnoreCase("chrome")) {
        	  
        	  driver=new ChromeDriver();
          }
          else if(BROWSER1.equalsIgnoreCase("edge")) {
        	  driver=new EdgeDriver();
        	 
          }else {
        	  
        	  driver=new FirefoxDriver();          }
		
          System.out.println("launching browser");
          sdriver=driver;
	}

//	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups= {"smoke","regression","sanity"})
	public void bm() throws Throwable {
		
		
		File_Utilities flib=new File_Utilities();
		
	//	File_Utilities flib=new File_Utilities();
		//not importing mam 
		
	//	String URL=System.getProperty("url");
	//	String USERNAME=System.getProperty("username");
    //		String PASSWORD=System.getProperty("password");
		
	    String URL=flib.getKeyAndValuePair("url");
		String USERNAME=flib.getKeyAndValuePair("username");
		String PASSWORD=flib.getKeyAndValuePair("password"); 
        
		
		driver.get(URL); 
		
		
        

     
				
      LoginVtigerPage login=new LoginVtigerPage(driver);
      login.loginIntoVtiger(USERNAME, PASSWORD);	
      
	}

	@AfterMethod(groups= {"smoke","regression","sanity"})
	public void am() {
		HomepageVtiger home = new HomepageVtiger(driver);	
     	home.logoutApp();
	}
	
	
	@AfterClass(groups= {"smoke","regression","sanity"})
	public void ac() {
		System.out.println("close the browser");
		driver.quit();
	}

	@AfterTest(groups= {"smoke","regression","sanity"})
	public void at() {
		System.out.println("close parallel execution");
	}

	@AfterSuite(groups= {"smoke","regression","sanity"})
	public void as() {
		System.out.println("Database connection close");
	}
}
