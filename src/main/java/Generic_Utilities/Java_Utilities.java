package Generic_Utilities;

import java.util.Random;

public class Java_Utilities {

	/*
	** This method is used to avoid duplicates
	*@Author-Shruthi	
	*return
	*/
	
	
	public int getRanNum() {
		
		Random ran=new Random();
		int value=ran.nextInt(1000);
		return value;
	}
	
	
	
	
}
