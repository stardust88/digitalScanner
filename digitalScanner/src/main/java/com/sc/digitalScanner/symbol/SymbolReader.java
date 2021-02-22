package com.sc.digitalScanner.symbol;

public interface SymbolReader<S,T> {
	
	public T read(S rawData);

}
