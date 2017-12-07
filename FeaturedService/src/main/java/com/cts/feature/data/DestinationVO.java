package com.cts.feature.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationVO {
	
	@JsonProperty("DestinationLocation")
	private String destinationLocation;
	
	@JsonProperty("CountryCode")
	private String countryCode;
	
	@JsonProperty("CountryName")
	private String countryName;
	
	@JsonProperty("RegionName")
	private String regionName;
	
	@JsonProperty("MetropolitanAreaName")
	private String metropolitanAreaName;
	
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("AirportName")
	private String airportName;
	
	@JsonProperty("CityName")
	private String cityName;
	
	 /*@JsonProperty("Links")
	 private List<Link> links;
*/
	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getMetropolitanAreaName() {
		return metropolitanAreaName;
	}

	public void setMetropolitanAreaName(String metropolitanAreaName) {
		this.metropolitanAreaName = metropolitanAreaName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/*public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}*/
	
	

}
