package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utilities {

	/*
	** This method is used to fetch data from external resources
	*@Author-Shruthi	
	*return
	*/
	
	public String getKeyAndValuePair(String Key) throws Throwable {
		
		
        FileInputStream fis=new FileInputStream("./src/test/resources/DataProperty.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(Key);
		System.out.println(value);

		return value;
	}




}
