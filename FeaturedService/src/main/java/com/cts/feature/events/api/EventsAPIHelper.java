package com.cts.feature.events.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import com.cts.feature.events.data.EventsResponse;
import com.cts.feature.events.utils.EventsAPIUtil;

public class EventsAPIHelper {
	
	private final static Logger LOG = LogManager.getLogger(EventsAPIHelper.class);
	
	public static EventsResponse getRestServiceDataByGET(final String urlStr) {
		HttpURLConnection conn = null;
		EventsResponse eventsResponse = null;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			Integer rescode = conn.getResponseCode();
			if (rescode != 200) {
				LOG.debug("Call Failed for API Call "+ urlStr);
			}
			eventsResponse = EventsAPIUtil.processResponse(conn.getInputStream());
			conn.disconnect();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				conn.disconnect();
			}
		}
		return eventsResponse;
	}
}
