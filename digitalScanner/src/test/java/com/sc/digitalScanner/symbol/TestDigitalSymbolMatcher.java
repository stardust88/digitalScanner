package com.sc.digitalScanner.symbol;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDigitalSymbolMatcher {
	
	private static DigitalSymbolMatcher symbolMatcher;
	
	@BeforeClass
	public static void init() {
		symbolMatcher = new DigitalSymbolMatcher();
	}
	
	@Test
	public void testMatch() {
		List<String> symbolData =new ArrayList<>();
		symbolData.add("   ");
		symbolData.add("  |");
		symbolData.add("  |");
		
		
		Integer symbol = symbolMatcher.match(symbolData);
		assertNotNull(symbol);
		
		assertEquals(1l, symbol.longValue());
		
		symbolData.add("__");
		
		symbol = symbolMatcher.match(symbolData);
		
		assertNull(symbol);
	}

}
