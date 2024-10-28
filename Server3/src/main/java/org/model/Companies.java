package org.app;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Companies {
	private int companiesID;
	private String companyName;
	private String companyAvatarURL;
	private String website;
	private String email;
	private ConcurrentHashMap<Integer, Boolean> activeRecruiters;
	private ConcurrentHashMap<Locations, Boolean> activeLocations;

	private static int currentID = 1;

	public Companies(String companyName, String companyAvatarURL, String website, String email) {
		this.companyName = companyName;
		this.companyAvatarURL = companyAvatarURL;
		this.website = website;
		this.email = email;
		this.companiesID = currentID;
		companiesID+=1;
		this.activeRecruiters = new ConcurrentHashMap<>();
		this.activeLocations = new ConcurrentHashMap<>();
	}

	public int getCompaniesID() {
		return companiesID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getCompanyAvatarURL() {
		return companyAvatarURL;
	}
	public String getWebsite() {
		return website;
	}
	public String getEmail() {
		return email;
	}
	public ConcurrentHashMap<Integer, Boolean> getActiveRecruiters() {
		return activeRecruiters;
	}
	public ConcurrentHashMap<Locations, Boolean> getActiveLocations() {
		return activeLocations;
	}

	public void setCompaniesID(int companiesID) {
		this.companiesID = companiesID;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setCompanyAvatarURL(String companyAvatarURL) {
		this.companyAvatarURL = companyAvatarURL;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setActiveRecruiters(ConcurrentHashMap<Integer, Boolean> activeRecruiters) {
		this.activeRecruiters = activeRecruiters;
	}
	public void setActiveLocations(ConcurrentHashMap<Locations, Boolean> activeLocations) {
		this.activeLocations = activeLocations;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Companies companies = (Companies) o;
		return companiesID == companies.companiesID && Objects.equals(companyName, companies.companyName) && Objects.equals(companyAvatarURL, companies.companyAvatarURL) && Objects.equals(website, companies.website) && Objects.equals(email, companies.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(companiesID, companyName, companyAvatarURL, website, email);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Companies{");
		sb.append("companiesID=").append(companiesID);
		sb.append(", companyName='").append(companyName).append('\'');
		sb.append(", companyAvatarURL='").append(companyAvatarURL).append('\'');
		sb.append(", website='").append(website).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", activeRecruiters=").append(activeRecruiters);
		sb.append(", activeLocations=").append(activeLocations);
		sb.append('}');
		return sb.toString();
	}
}
