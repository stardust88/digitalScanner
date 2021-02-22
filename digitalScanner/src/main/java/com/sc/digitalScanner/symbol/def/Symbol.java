package com.sc.digitalScanner.symbol.def;

public interface Symbol<T,S> {
	
	S getSymbolValue();
	T getSymbolDef();

}
