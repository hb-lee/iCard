package com.easypay.icard.entity;

public class BusinessInfo {
	
	private int id;
	private String name;
	private String pic;
	private String intro;
	private int type;
	private int userId;
	/**
	 * @author lihbbruce
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @author lihbbruce
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @author lihbbruce
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @author lihbbruce
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	private String latitude;
	private String longitude;
	/**
	 * @author lihbbruce
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @author lihbbruce
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @author lihbbruce
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @author lihbbruce
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @author lihbbruce
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * @author lihbbruce
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * @author lihbbruce
	 * @return the intro
	 */
	public String getIntro() {
		return intro;
	}
	/**
	 * @author lihbbruce
	 * @param intro the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}
	/**
	 * @author lihbbruce
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @author lihbbruce
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @author lihbbruce
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @author lihbbruce
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
