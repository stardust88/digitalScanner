package com.sc.digitalScanner.util;

import java.util.List;

public enum SymbolDefEnum {

	ONE(1, ScannerConstants.ONE), TWO(2, ScannerConstants.TWO), THREE(3, ScannerConstants.THREE),
	FOUR(4, ScannerConstants.FOUR),FIVE(5, ScannerConstants.FIVE),SIX(6, ScannerConstants.SIX),
	SEVEN(4, ScannerConstants.SEVEN),EIGHT(4, ScannerConstants.EIGHT),NINE(9, ScannerConstants.NINE),
	ZERO(0, ScannerConstants.ZERO)
	;

	Integer num;
	List<String> def;

	SymbolDefEnum(Integer num, List<String> def) {
		this.def = def;
		this.num = num;
	}
	
	public Integer getValue() {
		return this.num;
	}
	
	public List<String> getDef(){
		return this.def;
	}

}
