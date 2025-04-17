package org.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CVs {
	private Integer CVID;
	private Integer candidatesID;

    private String CVname;
    private String imagePath;
    private String jobPositions;
    private String introduce;

	private String email;
	private String phoneNumber;
    private String socialMedia;

    //	Không có trong CSDL
	private HashSet<Integer> currentProjects;
	private HashSet<Integer> currentPersonalities;
	private HashSet<Integer> currentSkills;
	private HashSet<Integer> currentWorkExperiences;
	private HashSet<Integer> currentEducations;
    private HashSet<Integer> currentCertifications;
    private HashSet<Integer> currentAwards;

    public CVs() {}

    public Integer getCVID() {
        return CVID;
    }
    public Integer getCandidatesID() {
        return candidatesID;
    }
    public String getCVname() {
        return CVname;
    }
    public String getImagePath() {
        return imagePath;
    }
    public String getJobPositions() {
        return jobPositions;
    }
    public String getIntroduce() {
        return introduce;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getSocialMedia() {
        return socialMedia;
    }
    public HashSet<Integer> getCurrentProjects() {
        return currentProjects;
    }
    public HashSet<Integer> getCurrentPersonalities() {
        return currentPersonalities;
    }
    public HashSet<Integer> getCurrentSkills() {
        return currentSkills;
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
    public HashSet<Integer> getCurrentAwards() {
        return currentAwards;
    }

    public void setCVID(Integer CVID) {
        this.CVID = CVID;
    }
    public void setCandidatesID(Integer candidatesID) {
        this.candidatesID = candidatesID;
    }
    public void setCVname(String CVname) {
        this.CVname = CVname;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public void setJobPositions(String jobPositions) {
        this.jobPositions = jobPositions;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setSocialMedia(String socialMedia) {
        this.socialMedia = socialMedia;
    }
    public void setCurrentProjects(HashSet<Integer> currentProjects) {
        this.currentProjects = currentProjects;
    }
    public void setCurrentPersonalities(HashSet<Integer> currentPersonalities) {
        this.currentPersonalities = currentPersonalities;
    }
    public void setCurrentSkills(HashSet<Integer> currentSkills) {
        this.currentSkills = currentSkills;
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
    public void setCurrentAwards(HashSet<Integer> currentAwards) {
        this.currentAwards = currentAwards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVs)) return false;
        CVs cVs = (CVs) o;
        return Objects.equals(CVID, cVs.CVID) && Objects.equals(candidatesID, cVs.candidatesID) && Objects.equals(CVname, cVs.CVname) && Objects.equals(imagePath, cVs.imagePath) && Objects.equals(jobPositions, cVs.jobPositions) && Objects.equals(introduce, cVs.introduce) && Objects.equals(email, cVs.email) && Objects.equals(phoneNumber, cVs.phoneNumber) && Objects.equals(socialMedia, cVs.socialMedia) && Objects.equals(currentProjects, cVs.currentProjects) && Objects.equals(currentPersonalities, cVs.currentPersonalities) && Objects.equals(currentSkills, cVs.currentSkills) && Objects.equals(currentWorkExperiences, cVs.currentWorkExperiences) && Objects.equals(currentEducations, cVs.currentEducations) && Objects.equals(currentCertifications, cVs.currentCertifications) && Objects.equals(currentAwards, cVs.currentAwards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CVID, candidatesID, CVname, imagePath, jobPositions, introduce, email, phoneNumber, socialMedia, currentProjects, currentPersonalities, currentSkills, currentWorkExperiences, currentEducations, currentCertifications, currentAwards);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CVs{");
        sb.append("CVID=").append(CVID);
        sb.append(", candidatesID=").append(candidatesID);
        sb.append(", CVname='").append(CVname).append('\'');
        sb.append(", imagePath='").append(imagePath).append('\'');
        sb.append(", jobPositions='").append(jobPositions).append('\'');
        sb.append(", introduce='").append(introduce).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", socialMedia='").append(socialMedia).append('\'');
        sb.append(", currentProjects=").append(currentProjects);
        sb.append(", currentPersonalities=").append(currentPersonalities);
        sb.append(", currentSkills=").append(currentSkills);
        sb.append(", currentWorkExperiences=").append(currentWorkExperiences);
        sb.append(", currentEducations=").append(currentEducations);
        sb.append(", currentCertifications=").append(currentCertifications);
        sb.append(", currentAwards=").append(currentAwards);
        sb.append('}');
        return sb.toString();
    }
}
