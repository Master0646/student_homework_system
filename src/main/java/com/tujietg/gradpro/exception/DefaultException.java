package com.tujietg.gradpro.exception;

/**
 * 默认异常
 * 
 * Created by tujietg on Apr 2019.
 */
public class DefaultException extends Exception {
	private String errorMessage;

	public DefaultException(String message) {
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
