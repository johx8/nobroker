package com.parameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class PropertyReader {
	Properties property;
	FileInputStream fis;
	public PropertyReader() {
		File file = new File("src\\test\\resource\\PropertyFiles\\loginData.properties");
		try {
			fis = new FileInputStream(file);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String getProperty(String key) {
		return property.getProperty(key);
	}
}
