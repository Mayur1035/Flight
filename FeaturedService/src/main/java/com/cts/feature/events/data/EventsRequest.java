package com.cts.feature.events.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventsRequest {
	
	/*The search keywords */
	@JsonProperty("keywords")
	private String keywords;
	/*A location name to use in filtering the search results. Locations in the form "San Diego", 
	 * "San Diego, TX", "London, United Kingdom", and "Calgary, Alberta, Canada" are accepted*/
	@JsonProperty("location")
	private String location;
	/*Limit this list of results to a date range, specified by label or exact range. Currently supported labels include: 
	 "All", "Future", "Past", "Today", "Last Week", "This Week", "Next week", and months by name, e.g. "October".
	Exact ranges can be specified the form 'YYYYMMDD00-YYYYMMDD00', for example '2012042500-2012042700 */
	@JsonProperty("date")
	private String date;
	/*If within is set and the "location" parameter resolves to a specific geolocation, 
	 * the search will be restricted to the specified radius.*/
	@JsonProperty("within")
	private String within ;
	/* Sets within longitude and latitude 32.746682,-117.162741 */
	@JsonProperty("where")
	private String where;
	
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWithin() {
		return within;
	}
	public void setWithin(String within) {
		this.within = within;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
}
