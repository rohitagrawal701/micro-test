package com.framework.exception;

/**
 *
 * It is the base class of those exceptions that can be thrown during the normal
 * operation. It is the parent level class for all custom exception created in
 * the application.
 *
 * @author DAMCO
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = -3721465927992618760L;
	public final transient Object[] args;

	/**
	 * Standard constructor.
	 */
	public BaseException() {
		super();
		args = null;
	}

	/**
	 * Generates a BaseException with the appropriate error message .
	 *
	 * @param message
	 *            The error message
	 */
	public BaseException(final String message) {
		super(message);
		args = null;
	}

	/**
	 * Constructor Which construct object with arguments and messages.
	 *
	 * @param message
	 *            The error message
	 * @param args
	 *            Arguments for error messages variable .
	 */
	public BaseException(final String message, final Object... args) {
		super(message);
		this.args = args;
	}

	/**
	 * Generates a BaseException with the corresponding error message and an
	 * exception.
	 *
	 * @param message
	 *            Error message for specific error.
	 * @param exception
	 *            Actual exception Thrown by code.
	 */
	public BaseException(final String message, final Throwable exception) {
		super(message, exception);
		args = null;
	}

	/**
	 * Generates a BaseException.
	 *
	 * @param exception
	 *            Actual exception Thrown by code.
	 */
	public BaseException(final Throwable exception) {
		super(exception);
		args = null;
	}

	public Object[] getArgs() {
		return args;
	}

}
