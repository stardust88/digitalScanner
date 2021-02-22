package com.sc.digitalScanner.symbol;

public interface SymbolMatcher<T,S> {
	
	public S match(T data);

}
