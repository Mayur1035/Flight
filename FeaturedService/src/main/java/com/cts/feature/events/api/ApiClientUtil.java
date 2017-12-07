package com.cts.feature.events.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClientUtil {

	public static String getRestServiceDataByGET(final String urlStr) {
		InputStreamReader inStreamReader = null;
		HttpURLConnection conn = null;
		BufferedReader inReader = null;
		final StringBuilder responseStr = new StringBuilder();
		try {
			// if (esapiService.isValidUrl(urlStr)) {
			URL url = new URL(urlStr);
			// Proxy proxy = new Proxy(Proxy.Type.HTTP, new
			// InetSocketAddress("proxy.cognizant.com", 6050));
			// conn = new URL(urlString).openConnection(proxy);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			Integer rescode = conn.getResponseCode();
			if (rescode != 200) {
				System.out.println("Call Failed");
			}
			inStreamReader = new InputStreamReader(conn.getInputStream());
			inReader = new BufferedReader(inStreamReader);
			String output;

			while ((output = inReader.readLine()) != null) {
				responseStr.append(output);
			}
			conn.disconnect();

			// }
			/*
			 * LogUtility.logError(LOGGER, "Invalid URL for rest client" + urlStr); throw
			 * new CargoException("Invalid URL for rest client");
			 */

		} catch (IOException ex) {
			ex.printStackTrace();
			/*
			 * LogUtility.logError(LOGGER, "Error occurred while fetching email template",
			 * ex); throw new CargoException(ex);
			 */
		} finally {
			if (inReader != null) {
				try {
					inReader.close();
				} catch (IOException ex) {
					// LogUtility.logError(LOGGER, "Could not close BufferedReader while retrieving
					// html for AEM", ex);
				}
			}
			if (inStreamReader != null) {
				try {
					inStreamReader.close();
				} catch (IOException ex) {
					// LogUtility.logError(LOGGER, "Could not close Input Stream while retrieving
					// html for AEM", ex);
				}
			}
			if (null != conn) {
				conn.disconnect();
			}
		}

		return responseStr.toString();
	}

}
