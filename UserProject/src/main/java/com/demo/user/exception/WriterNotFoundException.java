package com.demo.user.exception;

public class WriterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7331601113731100761L;

	public WriterNotFoundException() {
		super();
	}

	public WriterNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}