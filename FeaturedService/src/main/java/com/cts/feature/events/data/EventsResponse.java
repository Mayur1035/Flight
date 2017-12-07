package com.cts.feature.events.data;

import java.util.List;

public class EventsResponse {
	
	private List<EventsVO> eventsList ;
	private boolean emptyList = true;

	public List<EventsVO> getEventsList() {
		return eventsList;
	}

	public void setEventsList(List<EventsVO> eventsList) {
		this.eventsList = eventsList;
	}

	public boolean isEmptyList() {
		return emptyList;
	}

	public void setEmptyList(boolean emptyList) {
		this.emptyList = emptyList;
	}

}
