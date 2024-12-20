package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Ex {

	
	
	@Test(dataProvider="getData")
	public void bookTickets(String src, String dest, int people) {
		
	System.out.println("Book tickets from " +src+ " to " +dest+  "number of people travelling are " +people);	
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] obj=new Object[3][3];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		obj[0][2]=60;
		
		obj[1][0]="Bangalore";
		obj[1][1]="Mysore";
		obj[1][2]=75;
		
		
		obj[2][0]="Bangalore";
		obj[2][1]="Chennai";
		obj[2][2]=30;
		
		
		
		return obj;
		
		
		
	}
}
