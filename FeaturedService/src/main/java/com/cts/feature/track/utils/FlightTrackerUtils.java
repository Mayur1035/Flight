package com.cts.feature.track.utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cts.feature.events.api.ApiClientUtil;
import com.cts.feature.events.config.EventSearchConfiguration;
import com.cts.feature.track.data.Coordinates;
import com.cts.feature.track.data.RadarRequest;
import com.cts.feature.track.data.RadarResponse;

public class FlightTrackerUtils {

	public static RadarResponse getRadarResponse(RadarRequest radarRequest, EventSearchConfiguration eventConfig) {
		RadarResponse radarResponse = null;

		Coordinates originCoordinates = getRequestCoordinates(radarRequest);
		radarResponse = getRadarResponse(originCoordinates);

		return radarResponse;
	}

	private static RadarResponse getRadarResponse(Coordinates originCoordinates) {
		RadarResponse radarResponse = new RadarResponse();

		List<Coordinates> coordinatesList = new ArrayList<>();
		Coordinates coordinates = null;
		String url = "http://public-api.adsbexchange.com/VirtualRadar/AircraftList.json?lat="
				+ originCoordinates.getLatitude() + "&lng=" + originCoordinates.getLongitude() + "&fDstL=0&fDstU=20";

		String radarResponseString = ApiClientUtil.getRestServiceDataByGET(url);
		JSONObject jsonObject = new JSONObject(radarResponseString);
		JSONArray acList = jsonObject.getJSONArray("acList");
		int count = 0;
		for (int i = 0; i < acList.length(); i++) {
			coordinates = new Coordinates();
			JSONObject tempjsonObject = acList.getJSONObject(i);
			coordinates.setLatitude(tempjsonObject.getDouble("Lat"));
			coordinates.setLongitude(tempjsonObject.getDouble("Long"));
			coordinatesList.add(coordinates);
			count++;
			if(count == 10) {
				break;
			}
		}
		radarResponse.setPositionInfoList(coordinatesList);
		//google api key AIzaSyDG7uwhDYTqq22RLlAXnTZZvAOZlszLVBk
		return radarResponse;
	}

	private static Coordinates getRequestCoordinates(RadarRequest radarRequest) {
		Coordinates coordinates = new Coordinates();
		String origin = radarRequest.getOrigin().replaceAll(" ", "%20");
		String url = "http://maps.googleapis.com/maps/api/geocode/json?address=" + origin;

		String cordinateString = ApiClientUtil.getRestServiceDataByGET(url);
		JSONObject jsonObject = new JSONObject(cordinateString);
		JSONArray results = jsonObject.getJSONArray("results");
		
		JSONObject tempjsonObject = results.getJSONObject(0);
		JSONObject geometry =  tempjsonObject.getJSONObject("geometry");
		JSONObject location = geometry.getJSONObject("location");
		coordinates.setLatitude(location.getDouble("lat"));
		coordinates.setLongitude(location.getDouble("lng"));
		
		return coordinates;
	}

}
