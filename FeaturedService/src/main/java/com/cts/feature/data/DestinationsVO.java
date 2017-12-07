package com.cts.feature.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationsVO {

	@JsonProperty("Rank")
	private String rank;
	
	@JsonProperty("Destination")
	private DestinationVO destination;

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public DestinationVO getDestination() {
		return destination;
	}

	public void setDestination(DestinationVO destination) {
		this.destination = destination;
	}
	
	
}
