package com.tujietg.gradpro.exception;

/**
 * 登陆相关异常
 * 
 * Created by tujietg on Apr 15, 2019.
 */
public class LoginException extends Exception {
	private String errorMessage;

	public LoginException(String message) {
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
