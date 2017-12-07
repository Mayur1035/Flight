package com.cts.feature.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationsResponse {

	@JsonProperty("OriginLocation")
	private String originLocation;
	
	@JsonProperty("Theme")
	private String theme;
	
	@JsonProperty("Destinations")
	private List<DestinationsVO> destinations;

	public String getOriginLocation() {
		return originLocation;
	}

	public void setOriginLocation(String originLocation) {
		this.originLocation = originLocation;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<DestinationsVO> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<DestinationsVO> destinations) {
		this.destinations = destinations;
	}
}
