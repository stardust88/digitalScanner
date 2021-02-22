package com.sc.digitalScanner.chunker;

public interface DataChunker {
	
	public void chunk(Character data);
	
	public DataChunker setSeparatorSize(Integer maxNumOfSeparatorChar) ;
	
	public DataChunker setchunkLineSize(Integer chunkLineSize) ;
	
	public DataChunker setMaxCharacterPerLine(Integer maxCharacterPerLine) ;

}
