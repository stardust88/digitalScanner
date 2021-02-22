package com.sc.digitalScanner.symbol;

import java.util.List;

import com.sc.digitalScanner.util.SymbolDefEnum;

public class DigitalSymbolMatcher implements SymbolMatcher<List<String>,Integer>{
	
	@Override
	public Integer match(List<String> data) {
		
		SymbolDefEnum[] symbolDefs = SymbolDefEnum.values();
		List<String> defList = null;
		
		for (SymbolDefEnum def: symbolDefs) {
			defList = def.getDef();
			if(data.equals(defList)) {
				return def.getValue();
			}
		}
		
		return null;
	}
}
