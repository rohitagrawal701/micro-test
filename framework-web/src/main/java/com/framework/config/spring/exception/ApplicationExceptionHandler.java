package com.framework.config.spring.exception;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.framework.contants.AppConstants;
import com.framework.exception.BaseException;
import com.framework.response.RESTResponse;
import com.framework.util.AppProperties;

/**
 * Spring AOP based class to handle exception generated in application.
 * This class used spring AOP configuration for exception handling.
 *
 * @author Rohit
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(ApplicationExceptionHandler.class);

	@Autowired
	private MessageSource errorMessageSource;

	@Autowired
	private AppProperties appProperties;

	/**
	 * Handle the exception throws from the controller, service and dao classes.
	 * Catch BaseException and their child exception.
	 *
	 * @param ex
	 *            message.
	 * @return RESTResponse which contains error code and error message.
	 */
	@ExceptionHandler(BaseException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public RESTResponse handleBaseException(final BaseException ex) {
		final String mesageForCode = ex.getLocalizedMessage();
		final String mesageForDescription = getApplicationError(appProperties.getCountryLocaleKey(), ex.getLocalizedMessage());
		final String errorType = getApplicationError(appProperties.getCountryLocaleKey(), AppConstants.ERROR_TYPE_SERVICE);
		LOGGER.error(mesageForCode + " : " + mesageForDescription, ex);
		return RESTResponse.ok(mesageForCode, mesageForDescription, ex.toString() + " : " + ex.getStackTrace()[0].toString(), errorType);
	}

	/**
	 * Handle all Runtime exception for every layers.
	 *
	 * @param ex
	 *            message.
	 * @return RESTResponse which contains error code and error message.
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public RESTResponse handleRuntimeException(final RuntimeException ex) {
		final String mesageForDescription = getApplicationError(appProperties.getCountryLocaleKey(), AppConstants.ERROR_APPLICATION_CODE);
		final String errorType = getApplicationError(appProperties.getCountryLocaleKey(), AppConstants.ERROR_APPLICATION_TYPE);
		LOGGER.error(mesageForDescription, ex);
		return RESTResponse.ok(AppConstants.ERROR_APPLICATION_CODE, mesageForDescription, ex.toString() + " : " + ex.getStackTrace()[0].toString(), errorType);
	}

	/**
	 * Handle HttpMessageConversionException for every layers.
	 *
	 * @param ex
	 *            message.
	 * @return RESTResponse which contains error code and error message.
	 */
	@ExceptionHandler(HttpMessageConversionException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public RESTResponse handleHException(final HttpMessageConversionException ex) {
		final String mesageForDescription = getApplicationError(appProperties.getCountryLocaleKey(), AppConstants.ERROR_SYNTAX_CODE);
		final String errorType = getApplicationError(appProperties.getCountryLocaleKey(), AppConstants.ERROR_SYNTAX_TYPE);
		LOGGER.error(mesageForDescription, ex);
		return RESTResponse.ok(AppConstants.ERROR_SYNTAX_CODE, mesageForDescription, ex.toString() + " : " + ex.getStackTrace()[0].toString(), errorType);
	}

	private String getApplicationError(final String locale, final String key) {
		return errorMessageSource.getMessage(key, null, "", new Locale(locale));
	}

	/**
	 * Handle ServletRequestBindingException for every layers.
	 *
	 * @param ex
	 *            message.
	 * @return RESTResponse which contains error code and error message.
	 */
	@ExceptionHandler(ServletRequestBindingException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RESTResponse handleParameterException(final ServletRequestBindingException ex) {
		final String mesageForDescription = getApplicationError(appProperties.getCountryLocaleKey(), ex.getMessage());
		LOGGER.error(mesageForDescription, ex);
		return RESTResponse.ok(AppConstants.ERROR_SYNTAX_CODE, ex.getMessage(), ex.getStackTrace()[0].toString(), AppConstants.ERROR_SYNTAX_TYPE);
	}

	/**
	 * Handle HttpRequestMethodNotSupportedException for every layers.
	 *
	 * @param ex
	 *            message.
	 * @return RESTResponse which contains error code and error message.
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public RESTResponse handleParameterException(final HttpRequestMethodNotSupportedException ex) {
		final String mesageForDescription = getApplicationError(appProperties.getCountryLocaleKey(), ex.getMessage());
		LOGGER.error(mesageForDescription, ex);
		return RESTResponse.ok(AppConstants.ERROR_SYNTAX_CODE, ex.getMessage(), ex.getStackTrace()[0].toString(), AppConstants.ERROR_SYNTAX_TYPE);
	}
}
