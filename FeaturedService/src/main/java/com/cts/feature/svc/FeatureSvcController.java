package com.cts.feature.svc;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.feature.configuration.FeatureSearchConfiguration;
import com.cts.feature.data.DestinationsRequest;
import com.cts.feature.data.DestinationsResponse;
import com.cts.feature.events.config.EventSearchConfiguration;
import com.cts.feature.events.data.EventsRequest;
import com.cts.feature.events.data.EventsResponse;
import com.cts.feature.events.utils.EventsAPIUtil;
import com.cts.feature.rest.common.GenericRestGetCall;
import com.cts.feature.rest.common.context.SharedContext;
import com.cts.feature.track.data.RadarRequest;
import com.cts.feature.track.data.RadarResponse;
import com.cts.feature.track.utils.FlightTrackerUtils;

@RestController
public class FeatureSvcController {
	
	@Autowired
	private FeatureSearchConfiguration config;
	
	@Autowired
	private EventSearchConfiguration eventConfig;
	
	@Autowired
	private GenericRestGetCall<DestinationsRequest> call;
	
	private final Logger LOG = LogManager.getLogger(FeatureSvcController.class);
	
	@RequestMapping(value = "/featureSearch", method = RequestMethod.POST)
	public DestinationsResponse featureSearch(@RequestBody DestinationsRequest form) {
		final String endpoint = config.getRestProperty("environment") + "/v1/lists/top/destinations";
		LOG.debug("URL: " + endpoint);
		
		call.setUrl(endpoint);
		call.setRequest(form);
		
		SharedContext context = new SharedContext();
		return call.doCall(DestinationsResponse.class, context);
	}
	
	
	@RequestMapping(value = "/getEvents", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public EventsResponse getEvents(@RequestBody EventsRequest eventRequest) throws Exception
	{
		EventsResponse eventsResponse = null;
		if(null != eventRequest){
			eventsResponse = EventsAPIUtil.getEventList(eventRequest, eventConfig);
		}
		return eventsResponse;
	}
	
	@RequestMapping(value = "/flightRadar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RadarResponse flightRadar(@RequestBody RadarRequest radarRequest) throws Exception
	{
		RadarResponse radarResponse = null;
		if(null != radarRequest){
			radarResponse = FlightTrackerUtils.getRadarResponse(radarRequest , eventConfig);
		}
		return radarResponse;
	}

}
