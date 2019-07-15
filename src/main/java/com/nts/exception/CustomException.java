package com.nts.exception;

import javax.servlet.ServletException;

public class CustomException extends ServletException {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public CustomException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
