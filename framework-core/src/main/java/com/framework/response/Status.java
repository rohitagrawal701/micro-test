package com.framework.response;

/**
 * This class contains the status report, whether there was a success or failure
 *
 * @author DAMCO
 *
 */
public class Status {

	/** code property of Status */
	private String code;

	/** description property of Status */
	private String description;

	/** devMessage property of Status */
	private String devMessage;

	/** type property of Status */
	private String type;

	/**
	 * Default constructor
	 */
	public Status() {
		// Default Constructor
	}

	/**
	 *
	 * @param code
	 *            the code to set
	 * @param description
	 *            the description to set
	 */
	public Status(final String code, final String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 *
	 * @param code
	 *            the code to set
	 * @param description
	 *            the description to set
	 * @param devMessage
	 *            the devMessage to set
	 */
	public Status(final String code, final String description, final String devMessage) {
		this.code = code;
		this.description = description;
		this.devMessage = devMessage;
	}

	/**
	 *
	 * @param code
	 *            the code to set
	 * @param description
	 *            the description to set
	 * @param devMessage
	 *            the devMessage to set
	 * @param type
	 *            the type to set
	 */
	public Status(final String code, final String description, final String devMessage, final String type) {
		this.code = code;
		this.description = description;
		this.devMessage = devMessage;
		this.type = type;
	}

	/**
	 * This method is used to get existing value for status code
	 *
	 * @return code, the status code of result
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method sets new value to the status code
	 *
	 * @param code
	 *            the value to be set to status code
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * This method is used to get existing value for status description
	 *
	 * @return description, the status description of result
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method sets new value to the status description
	 *
	 * @param description
	 *            the value to be set to status description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @return the devMessage
	 */
	public String getDevMessage() {
		return devMessage;
	}

	/**
	 * @param devMessage
	 *            the devMessage to set
	 */
	public void setDevMessage(final String devMessage) {
		this.devMessage = devMessage;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final String type) {
		this.type = type;
	}
}
