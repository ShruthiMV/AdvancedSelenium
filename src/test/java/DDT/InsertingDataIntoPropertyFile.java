package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertingDataIntoPropertyFile {

	public static void main(String[] args) throws IOException {
		//Inserting data to Properties_File
				FileInputStream fis = new FileInputStream("./src/test/resources/CommonDatas.properties");

				Properties pro = new Properties();
			
				pro.setProperty("browser", "firefox");
				pro.setProperty("url", "http://localhost:8888");
				pro.setProperty("username", "admin");
				pro.setProperty("password", "admin");
			
			FileOutputStream fos = new FileOutputStream("./src/test/resources/CommonDatas.properties");
			pro.store(fos, "CommonData");
			System.out.println("sucessfully inserted the data into PropertiesFile");

	}

}
