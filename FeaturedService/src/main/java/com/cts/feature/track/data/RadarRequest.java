package com.cts.feature.track.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RadarRequest {
	
	@JsonProperty("origin")
	private String origin;
	
	@JsonProperty("destination")
	private String destination;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
