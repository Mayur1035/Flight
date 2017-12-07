package com.cts.feature.events.config;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

@Component
public class EventSearchConfiguration {
	


	private Configuration eventConfig;

	/**
	 * Initializes configuration objects with values read from the properties
	 * files.
	 * 
	 * @throws ConfigurationException
	 */
	public EventSearchConfiguration() throws ConfigurationException {
		eventConfig = new PropertiesConfiguration("EventsAPI.properties");
	}

	/**
	 * Returns a value for the REST configuration key.
	 * 
	 * @param key
	 *            key.
	 * @return value stored under given key.
	 */
	public String getProperty(String key) {
		return eventConfig.getString(key);
	}



}
