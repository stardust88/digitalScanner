package com.sc.digitalScanner.writers;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConsoleWriter implements NumberWriter<List<Integer>>{
	
	private static final String SYMBOL_NOT_FOUND_STR="?";
	private static final String SYMBOL_NOT_FOUND_INDICATOR="ILL";
	private static final Logger logger = LogManager.getLogger(ConsoleWriter.class);


	@Override
	public void write(List<Integer> data) {
		
		StringBuilder str = new StringBuilder();
		
		data.forEach(dataItem->{
			if(dataItem==null) {
				str.append(SYMBOL_NOT_FOUND_STR);
			}else {
				str.append(dataItem);
			}
		});
		if(data.contains(null)) {
			str.append(SYMBOL_NOT_FOUND_INDICATOR);
		}
		logger.info(str.toString());
		
		
	}
}
