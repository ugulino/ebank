package io.app.ebank.exceptions;

public class RegisterTransactionException extends Exception {
	private static final long serialVersionUID = 1L;
    public RegisterTransactionException(String errorMessage) {
        super(errorMessage);
    }
}
