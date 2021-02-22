package com.sc.digitalScanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sc.digitalScanner.reader.FileDataReader;

/**
 * Driver class to start digital scanning processing
 * 
 * @author debrup
 *
 */
public class DigitalScannerDriver {

	private static final Logger logger = LogManager.getLogger(DigitalScannerDriver.class);
	Properties prop;

	public DigitalScannerDriver init() {
		BasicConfigurator.configure();
		prop = loadConfigProperties();
		return this;
	}

	public void startProcessing() {

		try {
			String fileLocation = (String) prop.get("fileLocation");
			FileDataReader reader = new FileDataReader();
			reader.setDataLocation(fileLocation).read();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private Properties loadConfigProperties() {
		Properties prop = new Properties();
		String fileName = "./src/main/resources/config.properties";
		InputStream is = null;
		try {
			is = new FileInputStream(fileName);
		} catch (FileNotFoundException ex) {
			logger.error(ex);
		}
		try {
			prop.load(is);
		} catch (IOException ex) {
			logger.error(ex);
		}

		return prop;
	}

}
