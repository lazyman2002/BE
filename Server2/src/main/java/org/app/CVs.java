package org.app;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CVs {
	private Integer CVID;
	private Integer candidatesID;
	private String email;
	private String phoneNumber;
	private String jobTitle;

//	Không có trong CSDL
	private ConcurrentHashMap<Skills, Boolean> currentSkills;
	private ConcurrentHashMap<Personalities, Boolean> currentPersonalities;
	private ConcurrentHashMap<WorkExperiences, Boolean> currentWorkExperiences;
	private ConcurrentHashMap<Educations, Boolean> currentEducations;
	private ConcurrentHashMap<Certifications, Boolean> currentCertifications;

    public Integer getCVID() {
        return CVID;
    }
    public Integer getCandidatesID() {
        return candidatesID;
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

    public void setCVID(Integer CVID) {
        this.CVID = CVID;
    }
    public void setCandidatesID(Integer candidatesID) {
        this.candidatesID = candidatesID;
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
    public void setCurrentSkills(ConcurrentHashMap<Skills, Boolean> currentSkills) {
        this.currentSkills = currentSkills;
    }
    public void setCurrentPersonalities(ConcurrentHashMap<Personalities, Boolean> currentPersonalities) {
        this.currentPersonalities = currentPersonalities;
    }
    public void setCurrentWorkExperiences(ConcurrentHashMap<WorkExperiences, Boolean> currentWorkExperiences) {
        this.currentWorkExperiences = currentWorkExperiences;
    }
    public void setCurrentEducations(ConcurrentHashMap<Educations, Boolean> currentEducations) {
        this.currentEducations = currentEducations;
    }
    public void setCurrentCertifications(ConcurrentHashMap<Certifications, Boolean> currentCertifications) {
        this.currentCertifications = currentCertifications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVs cVs)) return false;
        return Objects.equals(CVID, cVs.CVID) && Objects.equals(candidatesID, cVs.candidatesID) && Objects.equals(email, cVs.email) && Objects.equals(phoneNumber, cVs.phoneNumber) && Objects.equals(jobTitle, cVs.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CVID, candidatesID, email, phoneNumber, jobTitle);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CVs{");
        sb.append("CVID=").append(CVID);
        sb.append(", candidatesID=").append(candidatesID);
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
