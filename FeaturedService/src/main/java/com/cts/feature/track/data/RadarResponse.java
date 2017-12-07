package com.cts.feature.track.data;

import java.util.List;

public class RadarResponse {

	private String imgSrc;
	private List<Coordinates> positionInfoList;
	private String b64Encode;

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public List<Coordinates> getPositionInfoList() {
		return positionInfoList;
	}

	public void setPositionInfoList(List<Coordinates> positionInfoList) {
		this.positionInfoList = positionInfoList;
	}

	public String getB64Encode() {
		return b64Encode;
	}

	public void setB64Encode(String b64Encode) {
		this.b64Encode = b64Encode;
	}

}
