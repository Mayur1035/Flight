package com.cts.feature.events.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cts.feature.events.api.EventsAPIHelper;
import com.cts.feature.events.config.EventSearchConfiguration;
import com.cts.feature.events.data.EventsRequest;
import com.cts.feature.events.data.EventsResponse;
import com.cts.feature.events.data.EventsVO;

public class EventsAPIUtil {
	

	public static EventsResponse getEventList(EventsRequest eventRequest, EventSearchConfiguration config) throws ParserConfigurationException {
		EventsResponse eventsResponse = null;
		String baseURL = config.getProperty(EventsAPIConstants.EVENT_SEARCH_API_URL);
		StringBuilder builder = new StringBuilder();
		builder.append(baseURL).append(EventsAPIConstants.QUERY_SYMBOL);
		builder.append("app_key").append(EventsAPIConstants.EQUAL_SYMBOL)
				.append( config.getProperty(EventsAPIConstants.EVENT_SEARCH_APP_KEY));
		if (null != eventRequest.getKeywords()) {
			builder.append(EventsAPIConstants.AMPERSTAND_SYMBOL).append("keywords").append(EventsAPIConstants.EQUAL_SYMBOL)
					.append(eventRequest.getKeywords());
		}
		if (null != eventRequest.getLocation()) {
			String location = eventRequest.getLocation();
			if(location.contains(" ")){
				location =location.replaceAll(" ", "+");
			}
			builder.append(EventsAPIConstants.AMPERSTAND_SYMBOL).append("location").append(EventsAPIConstants.EQUAL_SYMBOL)
					.append(location);
		}
		if (null != eventRequest.getDate()) {
			builder.append(EventsAPIConstants.AMPERSTAND_SYMBOL).append("date").append(EventsAPIConstants.EQUAL_SYMBOL)
					.append(eventRequest.getDate());
		}
		
		String urlStr = builder.toString();
		eventsResponse = EventsAPIHelper.getRestServiceDataByGET(urlStr);
		return eventsResponse;
	}

	public static EventsResponse processResponse(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException {
		EventsResponse eventsResponse = new EventsResponse();
		List<EventsVO> eventsVOs = new ArrayList<>();
		EventsVO eventsVO = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringComments(true);
		dbf.setCoalescing(true); // Convert CDATA to Text nodes
		dbf.setNamespaceAware(false); // No namespaces: this is default
		dbf.setValidating(false); // Don't validate DTD: also default

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(inputStream);
		NodeList pl = dom.getElementsByTagName("events");
		int numSections = pl.getLength();
		for (int i = 0; i < numSections; i++) {
			Element docEle = (Element) pl.item(i);
			NodeList nl = docEle.getChildNodes();
			if (nl != null) {
				int length = nl.getLength();
				for (int j = 0; j < length; j++) {
					if (nl.item(j).getNodeType() == Node.ELEMENT_NODE) {
						Element el = (Element) nl.item(j);
						if (el.getNodeName().equalsIgnoreCase("event")) {
							eventsVO = new EventsVO();
							String id = null;
							String title = null;
							String start_time = null;
							String stop_time = null;
							String venue_name = null;
							String venue_address = null;
							String city_name = null;
							String region_abbr = null;
							String country_abbr = null;
							String country_abbr2 = null;
							
							if (null != el.getAttributes().getNamedItem("id").getNodeValue()) {
								id = el.getAttributes().getNamedItem("id").getNodeValue();
							}

							if (null != el.getElementsByTagName("title").item(0)) {
								title = el.getElementsByTagName("title").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("start_time").item(0)) {
								start_time = el.getElementsByTagName("start_time").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("stop_time").item(0)) {
								stop_time = el.getElementsByTagName("stop_time").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("venue_name").item(0)) {
								venue_name = el.getElementsByTagName("venue_name").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("city_name").item(0)) {
								city_name = el.getElementsByTagName("city_name").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("region_abbr").item(0)) {
								region_abbr = el.getElementsByTagName("region_abbr").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("country_abbr").item(0)) {
								country_abbr = el.getElementsByTagName("country_abbr").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("country_abbr2").item(0)) {
								country_abbr2 = el.getElementsByTagName("country_abbr2").item(0).getTextContent();
							}
							if (null != el.getElementsByTagName("venue_address").item(0)) {
								venue_address = el.getElementsByTagName("venue_address").item(0).getTextContent();
							}
							eventsVO.setCity_name(city_name);
							eventsVO.setCountry_abbr(country_abbr);
							eventsVO.setCountry_abbr2(country_abbr2);
							eventsVO.setRegion_abbr(region_abbr);
							eventsVO.setStart_time(start_time);
							eventsVO.setStop_time(stop_time);
							eventsVO.setTitle(title);
							eventsVO.setVenue_address(venue_address);
							eventsVO.setVenue_name(venue_name);
							eventsVO.setId(id);

							eventsVOs.add(eventsVO);

						}
					}
				}
			}

		}
		if(!eventsVOs.isEmpty()){
			eventsResponse.setEmptyList(false);
		}
		eventsResponse.setEventsList(eventsVOs);
		return eventsResponse;
	}

}
