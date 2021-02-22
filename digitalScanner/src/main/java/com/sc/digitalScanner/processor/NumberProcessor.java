package com.sc.digitalScanner.processor;

public interface NumberProcessor <T>{
	
	public void process();
	public NumberProcessor<T> setChunk(T chunk);

}
