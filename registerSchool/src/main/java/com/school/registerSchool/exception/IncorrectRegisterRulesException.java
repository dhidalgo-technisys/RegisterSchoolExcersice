package com.school.registerSchool.exception;

@SuppressWarnings("serial")
public class IncorrectRegisterRulesException extends RuntimeException {
	public IncorrectRegisterRulesException(String messager, Throwable error) {
		super(messager, error);
	}
}
