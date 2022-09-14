package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class configManager {
	
	public static Properties configProperties(String filename) throws Exception{
		filename = filename.trim();
		
		Properties PROPS = new Properties();
		InputStream Stream = new FileInputStream(filename);
		PROPS.load(Stream);
		return PROPS;
		
		 
	}

}
