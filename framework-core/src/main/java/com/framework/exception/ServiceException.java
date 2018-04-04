package com.framework.exception;

/**
 * It is used to handle exceptions at service layer .
 *
 * @author Rohit
 *
 */
public class ServiceException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Standard constructor.
	 */
	public ServiceException() {
		super();
	}

	/**
	 * Generates a ServerException with the appropriate error message .
	 *
	 * @param message
	 *            The error message
	 */
	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final String message, final Object... args) {
		super(message, args);
	}

	/**
	 * @param message
	 *            The error message for this exception.
	 * @param exception
	 *            The root exception that was triggered originally .
	 */
	public ServiceException(final String message, final Throwable exception) {
		super(message, exception);
	}
}
