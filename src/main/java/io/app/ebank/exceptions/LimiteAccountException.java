package io.app.ebank.exceptions;

public class LimiteAccountException extends Exception {
	private static final long serialVersionUID = 1L;
		
	public LimiteAccountException() {
	}
		
	public LimiteAccountException(String errorMessage) {
	   super(errorMessage);
	}

	public LimiteAccountException(String errorMessage, Throwable cause){
		super(errorMessage, cause);
	}    
}

