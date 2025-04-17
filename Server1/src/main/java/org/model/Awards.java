package org.model;

import java.sql.Date;
import java.util.Objects;

public class Awards {
    private Integer awardID;
    private Integer CVID;
    private String awardName;
    private Date provideDate;

    public Awards() {}

    public Integer getAwardID() {
        return awardID;
    }
    public Integer getCVID() {
        return CVID;
    }
    public String getAwardName() {
        return awardName;
    }
    public Date getProvideDate() {
        return provideDate;
    }

    public void setAwardID(Integer awardID) {
        this.awardID = awardID;
    }
    public void setCVID(Integer CVID) {
        this.CVID = CVID;
    }
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
    public void setProvideDate(Date provideDate) {
        this.provideDate = provideDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Awards)) return false;
        Awards awards = (Awards) o;
        return Objects.equals(awardID, awards.awardID) && Objects.equals(CVID, awards.CVID) && Objects.equals(awardName, awards.awardName) && Objects.equals(provideDate, awards.provideDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(awardID, CVID, awardName, provideDate);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Awards{");
        sb.append("awardID=").append(awardID);
        sb.append(", CVID=").append(CVID);
        sb.append(", awardName='").append(awardName).append('\'');
        sb.append(", provideDate=").append(provideDate);
        sb.append('}');
        return sb.toString();
    }
}
