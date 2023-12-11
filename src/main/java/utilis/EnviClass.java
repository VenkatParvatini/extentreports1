package utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnviClass {
	public static Properties prop = new Properties();
	public static Map<String, String> envimap = new HashMap<String, String>();
	public static FileInputStream fis;

	public static Map<String, String> produri(String Environment) throws IOException {

		

		if (Environment.equalsIgnoreCase("prod")) {
			fis = new FileInputStream(System.getProperty("user.dir") + "/prod.properties");
		} else {
			fis = new FileInputStream(System.getProperty("user.dir") + "/uat.properties");
		}
		prop.load(fis);
		envimap.put("uri", prop.getProperty("uri"));

		return envimap;

	}

}
