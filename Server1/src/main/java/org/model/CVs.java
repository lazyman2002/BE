package org.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CVs {
	private Integer CVID;
	private Integer candidatesID;
	private String email;
	private String phoneNumber;
	private String jobTitle;

    //	Không có trong CSDL
	private HashSet<Integer> currentSkills;
	private HashSet<Integer> currentPersonalities;
	private HashSet<Integer> currentWorkExperiences;
	private HashSet<Integer> currentEducations;
	private HashSet<Integer> currentCertifications;

    public CVs() {}

    public CVs(Integer CVID, Integer candidatesID, String email, String phoneNumber, String jobTitle) {
        this.CVID = CVID;
        this.candidatesID = candidatesID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobTitle = jobTitle;
    }

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
    public HashSet<Integer> getCurrentSkills() {
        return currentSkills;
    }
    public HashSet<Integer> getCurrentPersonalities() {
        return currentPersonalities;
    }
    public HashSet<Integer> getCurrentWorkExperiences() {
        return currentWorkExperiences;
    }
    public HashSet<Integer> getCurrentEducations() {
        return currentEducations;
    }
    public HashSet<Integer> getCurrentCertifications() {
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
    public void setCurrentSkills(HashSet<Integer> currentSkills) {
        this.currentSkills = currentSkills;
    }
    public void setCurrentPersonalities(HashSet<Integer> currentPersonalities) {
        this.currentPersonalities = currentPersonalities;
    }
    public void setCurrentWorkExperiences(HashSet<Integer> currentWorkExperiences) {
        this.currentWorkExperiences = currentWorkExperiences;
    }
    public void setCurrentEducations(HashSet<Integer> currentEducations) {
        this.currentEducations = currentEducations;
    }
    public void setCurrentCertifications(HashSet<Integer> currentCertifications) {
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
