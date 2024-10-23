package org.app;

import java.util.List;
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
		this.currentPersonalities = new ConcurrentHashMap<>()
	}
}
