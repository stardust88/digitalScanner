package com.sc.digitalScanner.exceptions;

public class BadDataException extends Exception {

	String message;

	BadDataException(String message) {
		super(message);
		this.message = message;
	}

	public String toString() {
		return ("BadDataException occurred: " + message);
	}

}
