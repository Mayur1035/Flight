package com.cts.feature.data;

import com.cts.feature.rest.domain.BaseDomainRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationsRequest extends BaseDomainRequest  {

	@JsonProperty("origin")
	private String origin;
	
	@JsonProperty("origincountry")
	private String origincountry;
	
	@JsonProperty("destinationtype")
	private String destinationtype;
	
	@JsonProperty("theme")
	private String theme;
	
	@JsonProperty("topdestinations")
	private Integer topdestinations;
	
	@JsonProperty("lookbackweeks")
	private String lookbackweeks;
	
	@JsonProperty("destinationcountry")
	private String destinationcountry;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getOrigincountry() {
		return origincountry;
	}
	public void setOrigincountry(String origincountry) {
		this.origincountry = origincountry;
	}
	public String getDestinationtype() {
		return destinationtype;
	}
	public void setDestinationtype(String destinationtype) {
		this.destinationtype = destinationtype;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Integer getTopdestinations() {
		return topdestinations;
	}
	public void setTopdestinations(Integer topdestinations) {
		this.topdestinations = topdestinations;
	}
	public String getLookbackweeks() {
		return lookbackweeks;
	}
	public void setLookbackweeks(String lookbackweeks) {
		this.lookbackweeks = lookbackweeks;
	}
	public String getDestinationcountry() {
		return destinationcountry;
	}
	public void setDestinationcountry(String destinationcountry) {
		this.destinationcountry = destinationcountry;
	}
	
	

}
