package com.sc.digitalScanner.chunker;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sc.digitalScanner.processor.DigitalNumberProcessor;
import com.sc.digitalScanner.processor.NumberProcessor;
import com.sc.digitalScanner.util.ScannerConstants;

public class NumberDataChunker implements DataChunker {
	private Integer numOfSeparators = 0;
	
	//default values
	private Integer maxNumOfSeparatorChar = 2;
	private Integer chunkLineSize = 3;
	private Integer maxCharacterPerLine = ScannerConstants.MAX_CHAR_PER_LINE ;

	private NumberProcessor<List<String>> processor = new DigitalNumberProcessor();
	private static final Logger logger = LogManager.getLogger(NumberDataChunker.class);

	private List<String> chunk = new ArrayList<String>();
	
	private char[] chunkChars ;
	
	private int chunkDataTopIndex = 0;

	private char EOF = (char) -1;

	private boolean isChunkValid = true;

	@Override
	public void chunk(Character data) {
		if(chunkChars==null) {
			chunkChars = new char[maxCharacterPerLine];
		}
		
		
		if(data==null) {
			logger.warn("chunk data is null. Returning without processing");
			return;
		}
			
		boolean isNewLine = !String.valueOf(data).matches(".");

		processChunkRows(isNewLine,data);

		// increment num of separator count
		if (isNewLine) {
			numOfSeparators++;
		}

		// check to call next step
		if (data == EOF || ((numOfSeparators >= maxNumOfSeparatorChar) && isChunkValid )) {
			if (validateChunk()) {
				processor.setChunk(chunk).process();
			}
			chunk.clear();
			reset();
		}

	}

	private void processChunkRows(boolean isNewLine, Character data) {
		// if new line is encountered
		if ((isNewLine || data == EOF) && chunkDataTopIndex != 0) {
			if (validateChunkRows()) {
				String chunkRow = new String(chunkChars);
				chunk.add(chunkRow);
			} else {
				isChunkValid = false;
			}
			reset();
		}

		// add data only if it not new line char or EOF
		if (!isNewLine && chunkDataTopIndex < maxCharacterPerLine) {
			numOfSeparators = 0;
			chunkChars[chunkDataTopIndex++] = data;
		}

	}

	protected void reset() {
		numOfSeparators = 0;
		chunkChars = new char[maxCharacterPerLine];
		chunkDataTopIndex = 0;

	}

	private boolean validateChunk() {
		boolean isValid = true;
		if (CollectionUtils.isEmpty(chunk)) {
			logger.error("empty chunk");
			isValid = false;
		}

		if (chunk.size() != chunkLineSize) {
			logger.error("chunk size not equal to allowed size of " + chunkLineSize);
			isValid = false;
		}

		return isValid;
	}

	private boolean validateChunkRows() {

		if ((chunkDataTopIndex) != maxCharacterPerLine) {
			logger.error("line contains more or less than allowed characters");
			return false;
		}

		return true;

	}
	
	public List<String> getChunk() {
		return new ArrayList<>(this.chunk);
	}
	
	public NumberDataChunker setSeparatorSize(Integer maxNumOfSeparatorChar) {
		this.maxNumOfSeparatorChar = maxNumOfSeparatorChar;
		return this;
	}
	
	public NumberDataChunker setchunkLineSize(Integer chunkLineSize) {
		this.chunkLineSize = chunkLineSize;
		return this;
	}
	
	public NumberDataChunker setMaxCharacterPerLine(Integer maxCharacterPerLine) {
		this.maxCharacterPerLine = maxCharacterPerLine;
		return this;
	}

}
