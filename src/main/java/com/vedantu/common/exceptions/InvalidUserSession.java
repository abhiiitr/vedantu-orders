package com.vedantu.common.exceptions;

public class InvalidUserSession extends Exception {

	private static final long serialVersionUID = 1L;
//	private String exceptionMessage;

	public InvalidUserSession() {
	}
//
//	public String getExceptionMessage() {
//		return exceptionMessage;
//	}
//
//	public void setExceptionMessage(String exceptionMessage) {
//		this.exceptionMessage = exceptionMessage;
//	}

	public InvalidUserSession(String exceptionMessage) {
		super(exceptionMessage);
	}

}
