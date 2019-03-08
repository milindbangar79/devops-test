package com.aws.resources.main;

public class AWSResourceCustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AWSResourceCustomException() {
		super();
	}

	/**
	 * @param e
	 *
	 */

	public AWSResourceCustomException(Exception e) {
		super(e);
	}

	/**
	 *
	 * @param message
	 *
	 */
	public AWSResourceCustomException(String message) {
		super(message);
	}

	/**
	 *
	 * @param cause
	 */

	public AWSResourceCustomException(Throwable cause){
		super(cause);
	}

	/**
	 *
	 * @param message
	 * @param cause
	 */
	public AWSResourceCustomException(String message, Throwable cause){
		super(message,cause);
	}


}
