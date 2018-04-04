package com.framework.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class contain Util method used in vitricon application.
 *
 * @author Rohit
 *
 */
public class AppUtil {

	private static final Logger LOGGER = Logger.getLogger(AppUtil.class);

	/**
	 * Default constructor
	 */
	private AppUtil() {
		// Default constructor
	}

	/**
	 * This method convert object to json format.
	 *
	 * @param object
	 *          object to convert in json format
	 * @return
	 *          Json format response
	 * @throws IOException
	 */
	public static byte[] convertObjectToJsonBytes(final Object object) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

	/**
	 * This method convert json string to specified object.
	 *
	 * @param jsonValue
	 *              JSON string to convert into object
	 * @param className
	 *              Class name  in which object need to be convert
	 * @return
	 *              Converted Object
	 * @throws IOException
	 */
	public static Object convertJsonToObjec(final String jsonValue, final Class<?> className) throws IOException {
		final ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.readValue(jsonValue, className);
	}

	/**
	 * This method convert String to Calender object.
	 *
	 * @param format
	 *             Date format
	 * @param object
	 *              Date object to be formated
	 * @return
	 * @throws ParseException
	 */
	public static Calendar convertStringToCalender(final String format, final Object object) throws ParseException {
		if (object == null) {
			return Calendar.getInstance();
		} else {
			final DateFormat df = new SimpleDateFormat(format);
			final Calendar cal = Calendar.getInstance();
			cal.setTime(df.parse(String.valueOf(object)));
			return cal;
		}
	}

	/**
	 * This method convert Calender Object to String.
	 *
	 * @param format
	 *           Date format
	 * @param object
	 *             Objcet to be converted
	 * @return
	 * @throws ParseException
	 */
	public static String convertCalenderToString(final String format, final Calendar object) throws ParseException {
		if (object == null) {
			return null;
		} else {
			final DateFormat df = new SimpleDateFormat(format);
			return df.format(object.getTime());
		}
	}

	/**
	 * This method returns true if the collection is null or is empty.
	 *
	 * @param collection
	 *              Collection to be checked for EMPTY
	 * @return true | false
	 */
	public static boolean isEmpty(final Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns true of the map is null or is empty.
	 *
	 * @param map
	 * @return true | false
	 */
	public static boolean isEmpty(final Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns true if the objet is null.
	 *
	 * @param object
	 * @return true | false
	 */
	public static boolean isEmpty(final Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns true if the objet is null.
	 *
	 * @param object
	 * @return true | false
	 */
	public static boolean isNull(final Object object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns true if the input array is null or its length is
	 * zero.
	 *
	 * @param array
	 * @return true | false
	 */
	public static boolean isEmpty(final Object[] array) {
		if (array == null || array.length == 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns true if the input string is null or its length is
	 * zero.
	 *
	 * @param string
	 * @return true | false
	 */
	public static boolean isEmpty(final String string) {
		if (string == null || string.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method checked for empty and null Integer
	 *
	 * @param value
	 *          Integer to be validated
	 * @return
	 *          true|false
	 */
	public static boolean isValidInteger(final Integer value) {
		if (value != null && value > 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method checked for empty and null Double
	 *
	 * @param value
	 *          Double to be validated
	 * @return
	 *          true|false
	 */
	public static boolean isValidDouble(final Double value) {
		if (value != null && value > 0.0) {
			return true;
		}
		return false;
	}

	/**
	 * This method checked for empty and null string
	 *
	 * @param value
	 *          String to be validated
	 * @return
	 *          true|false
	 */
	public static boolean isValidString(final String value) {
		if (value != null && !"".equals(value)) {
			return true;
		}
		return false;
	}

	public static Date convertStringToDate(final String format, final String dateString) {
		Date date = null;
		final DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		try {
			date = df.parse(dateString);
			return date;
		} catch (final Exception ex) {
			LOGGER.error(ex);
		}
		return date;
	}

	/**
	 * This method returns respective "Locale" from String which contains
	 * extensions for a locale like "en" or "de" or anything else.
	 *
	 * @param locale
	 *            Respective Locale of String.
	 * @return
	 */
	public static Locale getLocaleFromString(final String locale) {
		if ("en".equalsIgnoreCase(locale)) {
			return Locale.ENGLISH;
		} else if ("de".equalsIgnoreCase(locale)) {
			return Locale.GERMAN;
		} else {
			return Locale.ENGLISH;
		}
	}

	/**
	 * Return Locale in string form
	 *
	 * @param locale
	 *              Locale to be converted.
	 * @return
	 *              string of locale
	 */
	public static String getStringFromLocale(final Locale locale) {
		if (locale == null) {
			return Locale.ENGLISH.toString();
		} else {
			return locale.toString();
		}
	}

	/**
	 * This method will convert date to string.
	 *
	 * @param string
	 *              Date format
	 * @param time
	 *              Date object To be converted
	 * @return
	 *          Converted string
	 */
	public static String convertDateToString(final String string, final Date time) {
		return new SimpleDateFormat(string).format(time);
	}

	/**Check String value is valid Integer or not
	 * @param s
	 * @return
	 */
	public static boolean checkInteger(final String s) {
		boolean isInteger = true;
		try {
			Integer.parseInt(s);
		} catch (final Exception ex) {
			isInteger = false;
			LOGGER.info(ex);
		}
		return isInteger;
	}
}
