package com.product.exception;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = -1138514193184006799L;

	public DAOException() {
		super();
	}

	public DAOException(String messege, Throwable cause) {
		super(messege, cause);
	}

	public DAOException(String messege) {
		super(messege);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

}
