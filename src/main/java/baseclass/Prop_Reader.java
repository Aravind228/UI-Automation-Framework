package baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Prop_Reader {
	
	public static String getproperty(String input) throws IOException {
		
			Properties prop = new Properties();
			
			String path ="D:\\My project Workspace\\Automation_Framework\\src\\main\\java\\TestData\\Data.Properties";
			
			try {
			
				FileInputStream fis = new FileInputStream(path);
				prop.load(fis);
				}
			catch(FileNotFoundException e) {
				e.getMessage();
			}
			String value =prop.getProperty(input);
			
			return value;
	}

}

