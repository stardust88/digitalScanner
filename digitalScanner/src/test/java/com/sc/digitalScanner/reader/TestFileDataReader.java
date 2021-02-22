package com.sc.digitalScanner.reader;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestFileDataReader {
	
	private static FileDataReader reader;
	
	@BeforeClass
	public static void init() {
		reader = new FileDataReader();
	}
	
	@Test(expected = Exception.class)
	public void read() throws Exception {
		reader.setDataLocation(null).read();
	}
	
	@Test
	public void read_1() throws Exception {
		reader.setDataLocation("./src/main/resources/input").read();
	}

}
