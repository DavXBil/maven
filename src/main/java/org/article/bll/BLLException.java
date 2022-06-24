package org.article.bll;

public class BLLException extends Exception {

	public BLLException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BLLException(String message, Throwable cause) {
		super("Erreur de la BLL "+message, cause);
		// TODO Auto-generated constructor stub
	}

	public BLLException(String message) {
		super("Erreur de la BLL "+message);
		// TODO Auto-generated constructor stub
	}

}
