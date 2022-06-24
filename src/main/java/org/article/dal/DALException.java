package org.article.dal;

public class DALException extends Exception {

	public DALException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DALException(String message, Throwable cause) {
		super("Erreur DAL "+message, cause);
		// TODO Auto-generated constructor stub
	}

	public DALException(String message) {
		super("Erreur DAL "+message);
		// TODO Auto-generated constructor stub
	}

}
