package com.sc.digitalScanner.symbol.def;

import java.util.List;

import com.sc.digitalScanner.util.ScannerConstants;

public class OneSymbol implements Symbol<List<String>, Integer>{
	
	private final Integer value = 1;
	private final List<String> def = ScannerConstants.ONE;

	@Override
	public Integer getSymbolValue() {
		return value;
	}

	@Override
	public List<String> getSymbolDef() {
		return def;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((def == null) ? 0 : def.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OneSymbol other = (OneSymbol) obj;
		if (def == null) {
			if (other.def != null)
				return false;
		} else if (!def.equals(other.def))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	

}
