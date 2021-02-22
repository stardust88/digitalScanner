package com.sc.digitalScanner.exceptions;

public class IllegalChunkException extends Exception{
	
	private String message;

	public IllegalChunkException(String message) {
		super(message);
		this.message = message;
	}

	public String toString() {
		return ("IllegelaChunkException occurred: " + message);
	}

}
