package io.app.ebank.exceptions;

public class CreateAccountException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CreateAccountException() {
	}
	
    public CreateAccountException(String errorMessage) {
        super(errorMessage);
    }

	public CreateAccountException(String errorMessage, Throwable cause){
		super(errorMessage, cause);
	}    
}
