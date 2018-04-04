package com.framework.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Util-Method for ResourceBundle.
 *
 * @author Rohit
 */
public class ResourceBundleUtil {

	/**
	 * Added Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(ResourceBundleUtil.class);

	private ResourceBundleUtil() {

	}

	/**
	 * Get the internationalization Name for the given key
	 *
	 * @param clazz
	 * @param key
	 *
	 * @param locale
	 * @return value
	 */
	public static String getLocalizedMessage(final Class<?> clazz, final String key, final Locale locale) {
		Locale localeToUse = locale;
		if (localeToUse == null) {
			localeToUse = Locale.getDefault();
		}

		final ResourceBundle bundle = ResourceBundle.getBundle(clazz.getName(), localeToUse);

		if (bundle.containsKey(key)) {
			return bundle.getString(key);
		}

		return key;
	}

	/**
	 * Get the internationalization Name for the given key
	 *
	 * @param clazz
	 * @param key
	 * @param locale
	 * @return value
	 */
	public static String getLocalizedMessage(final String properties, final String key, final Locale locale) {
		Locale localeToUse = locale;
		if (localeToUse == null) {
			localeToUse = Locale.ENGLISH;
		}
		Locale.setDefault(Locale.ENGLISH);
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(properties, localeToUse);
		} catch (final Exception e) {
			LOGGER.error(e);
			bundle = ResourceBundle.getBundle(properties, Locale.ENGLISH);
		}

		if (bundle.containsKey(key)) {
			return bundle.getString(key);
		}

		return key;
	}

	/**
	 * Get the key on basis of internationalization Name
	 *
	 * @param clazz
	 * @param message
	 * @param locale
	 * @return
	 */
	public static String getKey(final Class<?> clazz, final String message, final Locale locale) {
		Locale localeToUse = locale;
		if (localeToUse == null) {
			localeToUse = Locale.getDefault();
		}

		final ResourceBundle bundle = ResourceBundle.getBundle(clazz.getName(), localeToUse);

		for (final String key : bundle.keySet()) {
			if (message.equalsIgnoreCase(bundle.getString(key))) {
				return key;
			}
		}

		return null;
	}

	/**
	 *
	 * @param clazz
	 * @param message
	 * @param locale
	 * @return
	 */
	public static List<String> getKeys(final Class<?> clazz, final String message, final Locale locale) {
		final List<String> keys = new ArrayList<>();

		Locale localeToUse = locale;
		if (localeToUse == null) {
			localeToUse = Locale.getDefault();
		}

		final ResourceBundle bundle = ResourceBundle.getBundle(clazz.getName(), localeToUse);

		for (final String key : bundle.keySet()) {
			if (message.equalsIgnoreCase(bundle.getString(key))) {
				keys.add(key);
			}
		}

		return keys;
	}

}
