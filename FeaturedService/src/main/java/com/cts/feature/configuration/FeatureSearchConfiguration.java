package com.cts.feature.configuration;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

@Component
public class FeatureSearchConfiguration {

	private Configuration restConfig;

	/**
	 * Initializes configuration objects with values read from the properties
	 * files.
	 * 
	 * @throws ConfigurationException
	 */
	public FeatureSearchConfiguration() throws ConfigurationException {
		restConfig = new PropertiesConfiguration("SACSRestConfig.properties");
	}

	/**
	 * Returns a value for the REST configuration key.
	 * 
	 * @param key
	 *            key.
	 * @return value stored under given key.
	 */
	public String getRestProperty(String key) {
		return restConfig.getString(key);
	}

}
