package com.sc.digitalScanner.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sc.digitalScanner.exceptions.IllegalChunkException;
import com.sc.digitalScanner.symbol.DigitalSymbolMatcher;
import com.sc.digitalScanner.symbol.SymbolMatcher;
import com.sc.digitalScanner.writers.ConsoleWriter;
import com.sc.digitalScanner.writers.NumberWriter;

/**
 * Processes data chunks to match with corresponding Symbols
 * 
 * @author debrup
 *
 */
public class DigitalNumberProcessor implements NumberProcessor<List<String>> {

	private List<String> chunk;
	
	//dependent objects can be inserted using DI like Spring DI or J2ee CDI. 
	private SymbolMatcher<List<String>, Integer> symbolMatcher = new DigitalSymbolMatcher();

	private NumberWriter<List<Integer>> writer = new ConsoleWriter();

	private static final Logger logger = LogManager.getLogger(DigitalNumberProcessor.class);

	private Integer tokenSize = 3;

	public void process() {
		validate();

		List<String[]> symbolTokens = new ArrayList<>();
		String[] tokenArray;

		int minTokenSizePerRow = 0;

		// break each line of the symbol as per token size
		for (String chunkRow : chunk) {
			tokenArray = chunkRow.split("(?<=\\G.{" + tokenSize + "})");
			minTokenSizePerRow = (minTokenSizePerRow < tokenArray.length) ? tokenArray.length : minTokenSizePerRow;
			symbolTokens.add(tokenArray);
		}

		List<Integer> symbolValues = new ArrayList<>();
		List<String> symbolRawData = new ArrayList<>();
		int i = 0;

		while (i < minTokenSizePerRow) {
			for (String[] symbolRawDataArray : symbolTokens) {
				symbolRawData.add(symbolRawDataArray[i]);
			}
			symbolValues.add(symbolMatcher.match(symbolRawData));
			
			symbolRawData.clear();
			i++;
		}
		writer.write(symbolValues);
	}

	@Override
	public NumberProcessor<List<String>> setChunk(List<String> chunk) {
		this.chunk = chunk;
		return this;
	}

	private void validate() {
		if (CollectionUtils.isEmpty(chunk)) {
			logger.error("empty chunk");
		}
	}
	
	public void setTokenSize(Integer tokenSize) {
		this.tokenSize = tokenSize;
	}

}
