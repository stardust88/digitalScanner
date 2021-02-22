package com.sc.digitalScanner.chunker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.sc.digitalScanner.processor.DigitalNumberProcessor;

@RunWith(MockitoJUnitRunner.class)
public class TestNumberDataChunker {
	
	private static NumberDataChunker chunker;
	
	@Mock DigitalNumberProcessor processor;
	
	@BeforeClass
	public static void init() {
		chunker = new NumberDataChunker();
		
	}
	
	@Test
	public void testChunk() {
		chunker.chunk(null);
		assertEquals(0l,Integer.toUnsignedLong(chunker.getChunk().size()));
	}
	
	@Test
	public void testChunk_1() {
		char[] data = new char[3] ;
		data[0]=' ';
		data[1] ='_';
		data[2] ='\n';
		
		chunker.setMaxCharacterPerLine(2);
		
		for(Character symbolChar:data) {
			chunker.chunk(symbolChar);
		}
		
		List<String> chunkData = chunker.getChunk();
		
		assertTrue(chunkData.size()==1);
	}
	
	@Test
	public void testChunk_2() {
		chunker.reset();
		chunker.setMaxCharacterPerLine(3);
		chunker.setchunkLineSize(3);
		chunker.setSeparatorSize(2);
	
		
		char[] data = new char[5] ;
		data[0]=' ';
		data[1] ='_';
		data[2] ='_';
		data[3] ='\n';
		data[4] ='\n';
		
		for(Character symbolChar:data) {
			chunker.chunk(symbolChar);
		}
		
	
		assertEquals(0l,Integer.toUnsignedLong(chunker.getChunk().size()));
		
		
	}

}
