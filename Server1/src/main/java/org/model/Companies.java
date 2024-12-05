package org.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Companies {
	private Integer  companiesID;
	private String companyName;
	private String companyAvatarURL;
	private String website;
	private String email;

//	Ngoài CSDL
	private HashSet<Integer> activeRecruiters;
	private HashSet<Integer> activeLocations;

	public Companies(Integer companiesID, String companyName, String companyAvatarURL, String website, String email) {
		this.companiesID = companiesID;
		this.companyName = companyName;
		this.companyAvatarURL = companyAvatarURL;
		this.website = website;
		this.email = email;
	}

	public Companies() {}

	public Companies(HashSet<Integer> activeRecruiters, HashSet<Integer> activeLocations) {
		this.activeRecruiters = activeRecruiters;
		this.activeLocations = activeLocations;
	}

	public Companies(String companyName,
					 String companyAvatarURL,
					 String website,
					 String email) {
		this.companyName = companyName;
		this.companyAvatarURL = companyAvatarURL;
		this.website = website;
		this.email = email;
		this.activeRecruiters = new HashSet<>();
		this.activeLocations = new HashSet<>();
	}

	public Integer  getCompaniesID() {
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
	public Set<Integer> getActiveRecruiters() {
		return activeRecruiters;
	}
	public Set<Integer> getActiveLocations() {
		return activeLocations;
	}

	public void setCompaniesID(Integer  companiesID) {
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
	public void setActiveRecruiters(HashSet<Integer> activeRecruiters) {
		this.activeRecruiters = activeRecruiters;
	}
	public void setActiveLocations(HashSet<Integer> activeLocations) {
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
	public int  hashCode() {
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
