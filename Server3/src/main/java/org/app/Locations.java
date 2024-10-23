package org.app;

public class Locations {
	private String country;
	private String state;
	private String address;
	private String contactNumber;
	private JobRequests currentJobRequest;

	public Locations(String country, String state, String address, String contactNumber, JobRequests currentJobRequest) {
		this.country = country;
		this.state = state;
		this.address = address;
		this.contactNumber = contactNumber;
		this.currentJobRequest = currentJobRequest;
	}

	public String getCountry() {
		return country;
	}
	public String getState() {
		return state;
	}
	public String getAddress() {
		return address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public JobRequests getCurrentJobRequest() {
		return currentJobRequest;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setCurrentJobRequest(JobRequests currentJobRequest) {
		this.currentJobRequest = currentJobRequest;
	}
}
