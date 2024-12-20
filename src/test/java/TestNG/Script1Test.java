package TestNG;

import org.testng.annotations.Test;


public class Script1Test {
	
	@Test(priority=1,invocationCount=1)
	public void createProduct() {
		
		System.out.println("Product created");
		
	
		
	}
	
	@Test(priority=0,dependsOnMethods="createProduct")
    public void modifyProduct() {
		
		System.out.println("Product modified");

    	
	}
	
	@Test(priority=2,dependsOnMethods="createProduct",enabled=false)
    public void deleteProduct() {
		
		System.out.println("Product deleted");


	//push00002 ---->updated

//pulling from github
		
	}

}
