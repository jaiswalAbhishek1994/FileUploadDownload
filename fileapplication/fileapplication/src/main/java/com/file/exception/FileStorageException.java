package com.file.exception;

public class FileStorageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5086109411487931535L;

	public FileStorageException(String message) {
		super(message);
	}

	public FileStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	
}
