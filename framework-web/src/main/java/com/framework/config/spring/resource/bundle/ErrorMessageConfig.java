package com.framework.config.spring.resource.bundle;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Configures Resource Bundle to be used for Exception handling, messages etc
 * for Locale based processing.
 *
 * @author Rohit.
 *
 */
@Configuration
public class ErrorMessageConfig {

	/**
	 *
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("com/framework/messages/error");
		return messageSource;
	}
}
