package com.merc.blog.exception;

public class BlogNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BlogNotFoundException() {
		super();
	}
	
	public BlogNotFoundException(String msg) {
		super(msg);
	}
	

}
