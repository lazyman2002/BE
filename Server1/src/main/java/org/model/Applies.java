package org.model;

import java.util.Objects;

public class Applies {
    private Integer jobID;
    private Integer CVID;
    private Status status;

    public Integer getJobID() {
        return jobID;
    }
    public Integer getCVID() {
        return CVID;
    }
    public Status getStatus() {
        return status;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }
    public void setCVID(Integer CVID) {
        this.CVID = CVID;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Applies)) return false;
        Applies applies = (Applies) o;
        return Objects.equals(jobID, applies.jobID) && Objects.equals(CVID, applies.CVID) && status == applies.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobID, CVID, status);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Applies{");
        sb.append("jobID=").append(jobID);
        sb.append(", CVID=").append(CVID);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
