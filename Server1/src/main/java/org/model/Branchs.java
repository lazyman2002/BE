package org.model;

import java.util.HashSet;
import java.util.Objects;

public class Branchs {
    private Integer branchID;
    private Integer companyID;
    private String branchName;
    private String address;
    private String contact;
    private String imagePath;

//    Ngoài CSDL
    private HashSet<Integer> activeJobs;
    private HashSet<Integer> activeRecruiters;

    public Branchs() {}

    public Integer getBranchID() {
        return branchID;
    }
    public Integer getCompanyID() {
        return companyID;
    }
    public String getBranchName() {
        return branchName;
    }
    public String getAddress() {
        return address;
    }
    public String getContact() {
        return contact;
    }
    public String getImagePath() {
        return imagePath;
    }
    public HashSet<Integer> getActiveJobs() {
        return activeJobs;
    }
    public HashSet<Integer> getActiveRecruiters() {
        return activeRecruiters;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }
    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public void setActiveJobs(HashSet<Integer> activeJobs) {
        this.activeJobs = activeJobs;
    }
    public void setActiveRecruiters(HashSet<Integer> activeRecruiters) {
        this.activeRecruiters = activeRecruiters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branchs)) return false;
        Branchs branchs = (Branchs) o;
        return Objects.equals(branchID, branchs.branchID) && Objects.equals(companyID, branchs.companyID) && Objects.equals(branchName, branchs.branchName) && Objects.equals(address, branchs.address) && Objects.equals(contact, branchs.contact) && Objects.equals(imagePath, branchs.imagePath) && Objects.equals(activeJobs, branchs.activeJobs) && Objects.equals(activeRecruiters, branchs.activeRecruiters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchID, companyID, branchName, address, contact, imagePath, activeJobs, activeRecruiters);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Branchs{");
        sb.append("branchID=").append(branchID);
        sb.append(", companyID=").append(companyID);
        sb.append(", branchName='").append(branchName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", contact='").append(contact).append('\'');
        sb.append(", imagePath='").append(imagePath).append('\'');
        sb.append(", activeJobs=").append(activeJobs);
        sb.append(", activeRecruiters=").append(activeRecruiters);
        sb.append('}');
        return sb.toString();
    }
}
