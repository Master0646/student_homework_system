package com.tujietg.gradpro.exception;

/**
 * 文件相关异常
 * 
 * Created by tujietg on Apr 2019.
 */
public class FileException extends Exception {
	private String errorMessage;

	public FileException(String message) {
		super(message);
		this.errorMessage = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
