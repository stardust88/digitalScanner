package com.sc.digitalScanner.reader;

public interface DataReader<T> {
	public T read() throws Exception;
	
	public DataReader<T> setDataLocation(String location) ;
}
