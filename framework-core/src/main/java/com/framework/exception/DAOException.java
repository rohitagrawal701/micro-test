package com.framework.exception;

/**
 * It is designed to handle all Exception on DAO layer operations.
 *
 * @author Rohit
 */
public class DAOException extends ServiceException {

	private static final long serialVersionUID = -3068271122911679640L;

	/**
	 * The default constructor
	 */
	public DAOException() {
		super();
	}

	/**
	 * @param message
	 *            The error message for this exception
	 */
	public DAOException(final String message) {
		super(message);
	}

	/**
	 * constructor Which construct object with variables and messages.
	 *
	 * @param message
	 *            The error message for this exception
	 */
	public DAOException(final String message, final Object... args) {
		super(message, args);
	}

	/**
	 * constructor which construct object with messages and Actual exception.
	 *
	 * @param message
	 *            The error message for this exception.
	 * @param exception
	 *            The root exception that was triggered originally .
	 */
	public DAOException(final String message, final Throwable exception) {
		super(message, exception);
	}

	/**
	 * constructor which construct object with messages and Actual exception.
	 *
	 * @param message
	 *            The error message for this exception.
	 * @param exception
	 *            The root exception that was triggered originally .
	 * @param Object
	 *            Object array of arguments for message.
	 */
	public DAOException(final String message, final Throwable exception, final Object... args) {
		super(message, exception, args);
	}
}