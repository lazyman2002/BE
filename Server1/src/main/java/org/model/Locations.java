package org.model;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Locations {
	private Integer locationID;
	private Integer companyID;
	private String city;
	private String state;
	private String country;
	private String address;
	private String contactNumber;

	//Không có trong CSDL
	private ConcurrentHashMap<Integer, Boolean> currentJobRequest;

	public Locations() {}

	public Locations(String country, String state, String address, String contactNumber) {
		this.country = country;
		this.state = state;
		this.address = address;
		this.contactNumber = contactNumber;
		this.currentJobRequest = new ConcurrentHashMap<>();
	}

	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getAddress() {
		return address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public ConcurrentHashMap<Integer, Boolean> getCurrentJobRequest() {
		return currentJobRequest;
	}
	public Integer getLocationID() {
		return locationID;
	}
	public Integer getCompanyID() {
		return companyID;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setCurrentJobRequest(ConcurrentHashMap<Integer, Boolean> currentJobRequest) {
		this.currentJobRequest = currentJobRequest;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Locations locations)) return false;
        return Objects.equals(city, locations.city) && Objects.equals(state, locations.state) && Objects.equals(country, locations.country) && Objects.equals(address, locations.address) && Objects.equals(contactNumber, locations.contactNumber) && Objects.equals(locationID, locations.locationID) && Objects.equals(companyID, locations.companyID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, state, country, address, contactNumber, locationID, companyID);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Locations{");
		sb.append("city='").append(city).append('\'');
		sb.append(", state='").append(state).append('\'');
		sb.append(", country='").append(country).append('\'');
		sb.append(", address='").append(address).append('\'');
		sb.append(", contactNumber='").append(contactNumber).append('\'');
		sb.append(", locationID=").append(locationID);
		sb.append(", companyID=").append(companyID);
		sb.append('}');
		return sb.toString();
	}
}
