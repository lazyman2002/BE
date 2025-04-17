package org.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Companies {
	private Integer companiesID;
	private String companyName;
	private String imagePath;
	private String specialty;
	private String size;
	private String introduction;
	private String address;
	private String website;
	private String email;

//	Ngoài CSDL
	private HashSet<Integer> activeBranchs;

	public Companies() {}

	public Integer getCompaniesID() {
		return companiesID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getSpecialty() {
		return specialty;
	}
	public String getSize() {
		return size;
	}
	public String getIntroduction() {
		return introduction;
	}
	public String getAddress() {
		return address;
	}
	public String getWebsite() {
		return website;
	}
	public String getEmail() {
		return email;
	}
	public HashSet<Integer> getActiveBranchs() {
		return activeBranchs;
	}

	public void setCompaniesID(Integer companiesID) {
		this.companiesID = companiesID;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setActiveBranchs(HashSet<Integer> activeBranchs) {
		this.activeBranchs = activeBranchs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Companies)) return false;
		Companies companies = (Companies) o;
		return Objects.equals(companiesID, companies.companiesID) && Objects.equals(companyName, companies.companyName) && Objects.equals(imagePath, companies.imagePath) && Objects.equals(specialty, companies.specialty) && Objects.equals(size, companies.size) && Objects.equals(introduction, companies.introduction) && Objects.equals(address, companies.address) && Objects.equals(website, companies.website) && Objects.equals(email, companies.email) && Objects.equals(activeBranchs, companies.activeBranchs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(companiesID, companyName, imagePath, specialty, size, introduction, address, website, email, activeBranchs);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Companies{");
		sb.append("companiesID=").append(companiesID);
		sb.append(", companyName='").append(companyName).append('\'');
		sb.append(", imagePath='").append(imagePath).append('\'');
		sb.append(", specialty='").append(specialty).append('\'');
		sb.append(", size='").append(size).append('\'');
		sb.append(", introduction='").append(introduction).append('\'');
		sb.append(", address='").append(address).append('\'');
		sb.append(", website='").append(website).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", activeBranchs=").append(activeBranchs);
		sb.append('}');
		return sb.toString();
	}
}
