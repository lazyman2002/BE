package org.app;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class JobRequests {

	private int jobID;

	private JobType jobType;

	private int salaryLeast;

	private int salaryGreatest;

	private char currency;

	private String jobTitle;

	private JobLevel jobLevel;

	private String jobDescription;

	private Date deadlineDate;

	private Timestamp createdAt;

	private Timestamp updatedAt;

	private List<Integer> currentCVs;

}
