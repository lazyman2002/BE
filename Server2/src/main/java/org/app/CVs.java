package org.app;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CVs {
	private int CVID;
	private String email;
	private String phoneNumber;
	private String jobTitle;
	private ConcurrentHashMap<Skills, Boolean> currentSkills;
	private ConcurrentHashMap<Personalities, Boolean> currentPersonalities;
	private ConcurrentHashMap<WorkExperiences, Boolean> currentWorkExperiences;
	private ConcurrentHashMap<Educations, Boolean> currentEducations;
	private ConcurrentHashMap<Certifications, Boolean> currentCertifications;

	private static int currentID = 1;

	public CVs(String email, String phoneNumber, String jobTitle) {
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.jobTitle = jobTitle;
		this.CVID = currentID;
		currentID+=1;
		this.currentSkills = new ConcurrentHashMap<>();
		this.currentPersonalities = new ConcurrentHashMap<>();
		this.currentWorkExperiences = new ConcurrentHashMap<>();
		this.currentEducations = new ConcurrentHashMap<>();
		this.currentCertifications = new ConcurrentHashMap<>();
	}

	public int getCVID() {
		return CVID;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public ConcurrentHashMap<Skills, Boolean> getCurrentSkills() {
		return currentSkills;
	}
	public ConcurrentHashMap<Personalities, Boolean> getCurrentPersonalities() {
		return currentPersonalities;
	}
	public ConcurrentHashMap<WorkExperiences, Boolean> getCurrentWorkExperiences() {
		return currentWorkExperiences;
	}
	public ConcurrentHashMap<Educations, Boolean> getCurrentEducations() {
		return currentEducations;
	}
	public ConcurrentHashMap<Certifications, Boolean> getCurrentCertifications() {
		return currentCertifications;
	}
	public static int getCurrentID() {
		return currentID;
	}

	public void setCVID(int CVID) {
		this.CVID = CVID;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CVs cVs = (CVs) o;
		return CVID == cVs.CVID && Objects.equals(email, cVs.email) && Objects.equals(phoneNumber, cVs.phoneNumber) && Objects.equals(jobTitle, cVs.jobTitle) && Objects.equals(currentSkills, cVs.currentSkills) && Objects.equals(currentPersonalities, cVs.currentPersonalities) && Objects.equals(currentWorkExperiences, cVs.currentWorkExperiences) && Objects.equals(currentEducations, cVs.currentEducations) && Objects.equals(currentCertifications, cVs.currentCertifications);
	}

	@Override
	public int hashCode() {
		return Objects.hash(CVID, email, phoneNumber, jobTitle, currentSkills, currentPersonalities, currentWorkExperiences, currentEducations, currentCertifications);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("CVs{");
		sb.append("CVID=").append(CVID);
		sb.append(", email='").append(email).append('\'');
		sb.append(", phoneNumber='").append(phoneNumber).append('\'');
		sb.append(", jobTitle='").append(jobTitle).append('\'');
		sb.append(", currentSkills=").append(currentSkills);
		sb.append(", currentPersonalities=").append(currentPersonalities);
		sb.append(", currentWorkExperiences=").append(currentWorkExperiences);
		sb.append(", currentEducations=").append(currentEducations);
		sb.append(", currentCertifications=").append(currentCertifications);
		sb.append('}');
		return sb.toString();
	}
}
