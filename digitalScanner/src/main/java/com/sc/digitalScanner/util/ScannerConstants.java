package com.sc.digitalScanner.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScannerConstants {
	
	public static final List<String> ONE = Collections.unmodifiableList(Arrays.asList("   ","  |","  |"));
	
	public static final List<String> TWO = Collections.unmodifiableList(Arrays.asList(" _ "," _|","|_ "));

	public static final List<String> THREE = Collections.unmodifiableList(Arrays.asList(" _ "," _|"," _|"));

	public static final List<String> FOUR = Collections.unmodifiableList(Arrays.asList("   ","|_|","  |"));
	
	public static final List<String> FIVE = Collections.unmodifiableList(Arrays.asList(" _ ","|_ "," _|"));
	
	public static final List<String> SIX = Collections.unmodifiableList(Arrays.asList(" _ ","|_ ","|_|"));

	public static final List<String> SEVEN = Collections.unmodifiableList(Arrays.asList(" _ ","  |","  |"));

	public static final List<String> EIGHT = Collections.unmodifiableList(Arrays.asList(" _ ","|_|","|_|"));
	
	public static final List<String> NINE = Collections.unmodifiableList(Arrays.asList(" _ ","|_|"," _|"));

	public static final List<String> ZERO = Collections.unmodifiableList(Arrays.asList(" _ ","| |","|_|"));
	
	public static final Integer MAX_CHAR_PER_LINE = 27;
	
	
}
