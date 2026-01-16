package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	public Properties getProperties() {
		Properties obj = new Properties();
		FileInputStream objfile;
		try {
			objfile = new FileInputStream("./config\\browser.properties");
			obj.load(objfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
