package com.sc.digitalScanner.reader;

import java.io.FileInputStream;

import com.sc.digitalScanner.chunker.DataChunker;
import com.sc.digitalScanner.chunker.NumberDataChunker;

public class FileDataReader implements DataReader<String> {

	private String location;

	private DataChunker chunker = new NumberDataChunker();

	public String read() throws Exception {

		FileInputStream fileInput = new FileInputStream(location);
		int r = -1;

		while ((r = fileInput.read()) != -1) {
			char c = (char) r;
			chunker.chunk(c);

		}
		chunker.chunk((char) -1);

		return null;
	}

	public DataReader<String> setDataLocation(String location) {
		this.location = location;
		return this;
	}

}
